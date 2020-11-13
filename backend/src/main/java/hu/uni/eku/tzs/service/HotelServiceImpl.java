package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.*;
import hu.uni.eku.tzs.dao.entity.*;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final GuestRepository guestRepository;
    private final ProductServicesRepository productServicesRepository;
    private final PurchaseRespository purchaseRespository;
    private final ReservationRepository reservationRepository;
    private final RestrictionRepository restrictionRepository;
    private final RoomRepository roomRepository;

    @Override
    public Reservation bookRoom(LocalDate startDate, LocalDate endDate, int guests) {
        if(startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException();
        }

        List<Room> allRoom = roomRepository.findAll();
        List<Reservation> reservationsThisTime = reservationRepository.findReservedAtTime(startDate, endDate);
        List<Room> reservedRooms = reservationsThisTime.stream().map(Reservation::getRoom).collect(Collectors.toList());
        Optional<Room> unoccupiedRoom = allRoom.stream()
                .filter(room -> room.getMaxGuests() >= guests)
                .filter(room -> !reservedRooms.contains(room))
                .findFirst();
        return unoccupiedRoom.map(room ->
                reservationRepository.save(
                        new Reservation(room, guests, startDate, endDate)
                )
        ).orElseThrow(NoFreeRoomException::new);
    }

    @Override
    public Set<GuestDto> checkIn(ReservationCheckInDto reservation) {
        Room room = roomRepository.findByRoomNumber(reservation.getRoomNumber());
        Reservation checkInReservation = reservationRepository.findByArriveDateAndLeaveDateAndRoom(reservation.getArrival(), reservation.getLeave(), room).orElseThrow((ReservationNotFoundException::new));

        Set<Guest> guestEntities = reservation.getGuests().stream().map(this::createGuestFromDto).collect(Collectors.toSet());
        guestEntities.stream().forEach(g -> g.setReservation(checkInReservation));
        checkInReservation.setGuests(guestEntities);
        reservationRepository.save(checkInReservation);
        return guestEntities.stream().map(Guest::toGuestDto).collect(Collectors.toSet());
    }

    @Override
    public Purchase buyProductOrService(BuyDto buyDto) {
        ProductsServices productsService = productServicesRepository.findById(buyDto.getProductId()).orElseThrow(ProductNotFoundException::new);
        Guest guest = guestRepository.findById(buyDto.getGuestId()).orElseThrow(GuestNotFoundException::new);
        int guestAge = Period.between(guest.getBornAt(), LocalDate.now()).getYears();
        if (guestAge < productsService.getRestriction().getMinimumAge()) {
            throw new InsufficientAgeToBuyException(productsService.getRestriction().getErrorMessage());
        }
        return purchaseRespository.save(createPurchaseEntity(productsService, guest, buyDto.getAmount()));
    }

    @Override
    public Invoice getInvoiceForRoom(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationNotFoundException::new);
        Set<Guest> guests = guestRepository.findAllByReservationId(reservationId);
        Set<Purchase> purchases = purchaseRespository.findAllByGuestIsIn(guests);
        Set<InvoiceItem> items = purchases.stream().map(Purchase::toInvoiceItem).collect(Collectors.toSet());
        int totalAmount = items.stream().mapToInt(InvoiceItem::getItemPrice).sum();
        return new Invoice(totalAmount, items);
    }

    @Override
    public ProductsServices addNewBillable(ProductServiceDto productServiceDto) {
        Restriction restriction = restrictionRepository.findAll().stream()
                .filter(restr -> restr.getDescription().equals(productServiceDto.getRestrictionDescription()))
                .findFirst()
                .orElseGet(() -> restrictionRepository.save(
                        new Restriction(0,
                                productServiceDto.getRestrictionDescription(),
                                productServiceDto.getMinimumAge(),
                                productServiceDto.getErrorMessage()
                        )
                ));
        ProductsServices productsServices = new ProductsServices();
        productsServices.setName(productServiceDto.getProductName());
        productsServices.setPrice(productServiceDto.getPrice());
        productsServices.setRestriction(restriction);
        return productServicesRepository.save(productsServices);
    }

    private Guest createGuestFromDto(CheckInGuest checkInGuest) {
        Guest guest = new Guest();
        guest.setName(checkInGuest.getName());
        guest.setBornAt(checkInGuest.getBornAt());
        return guestRepository.save(guest);
    }

    private Purchase createPurchaseEntity(ProductsServices productsServices, Guest guest, int amount) {
        Purchase purchase = new Purchase();
        purchase.setAmount(amount);
        purchase.setGuest(guest);
        purchase.setItem(productsServices);
        purchase.setPurchaseDate(new Date());
        return purchaseRespository.save(purchase);
    }
}
