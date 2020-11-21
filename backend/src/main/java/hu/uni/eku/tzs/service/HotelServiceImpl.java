package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.BuyDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.controller.dto.ProductServiceDto;
import hu.uni.eku.tzs.controller.dto.ReservationCheckInDto;
import hu.uni.eku.tzs.dao.PurchaseRespository;
import hu.uni.eku.tzs.dao.entity.Guest;
import hu.uni.eku.tzs.dao.entity.ProductsServices;
import hu.uni.eku.tzs.dao.entity.Purchase;
import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundException;
import hu.uni.eku.tzs.service.exceptions.InsufficientAgeToBuyException;
import hu.uni.eku.tzs.service.exceptions.ProductNotFoundException;
import hu.uni.eku.tzs.service.exceptions.ReservationNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final PurchaseRespository purchaseRespository;
    private final ProductService productService;
    private final GuestService guestService;
    private final ReservationService reservationService;
    @Value("${hotel.room.person.price}")
    private int roomPricePersonNight;

    @Override
    public ReservationModel bookRoom(LocalDate startDate, LocalDate endDate, int guests) {
        return reservationService.bookRoom(startDate, endDate, guests);
    }

    @Override
    public Set<GuestDto> checkIn(ReservationCheckInDto reservation) {
        return reservationService.checkIn(reservation);
    }

    @Override
    public InvoiceItem buyProductOrService(BuyDto buyDto) {
        ProductsServices productsService = productService.findById(buyDto.getProductId()).orElseThrow(ProductNotFoundException::new);
        Guest guest = guestService.findById(buyDto.getGuestId()).orElseThrow(GuestNotFoundException::new);
        int guestAge = Period.between(guest.getBornAt(), LocalDate.now()).getYears();
        if (guestAge < productsService.getRestriction().getMinimumAge()) {
            throw new InsufficientAgeToBuyException(productsService.getRestriction().getErrorMessage());
        }
        return purchaseRespository.save(createPurchaseEntity(productsService, guest, buyDto.getAmount())).toInvoiceItem();
    }

    @Override
    public Invoice getInvoiceForRoom(Long reservationId) {
        Reservation reservation = reservationService.findbyReservationId(reservationId).orElseThrow(ReservationNotFoundException::new);
        Set<Guest> guests = guestService.findAllByReservationId(reservationId);
        Set<Purchase> purchases = purchaseRespository.findAllByGuestIsIn(guests);
        Set<InvoiceItem> items = purchases.stream().map(Purchase::toInvoiceItem).collect(Collectors.toSet());
        items.add(new InvoiceItem("Room price", "Room", (int) ChronoUnit.DAYS.between(reservation.getArriveDate(), reservation.getLeaveDate()) * roomPricePersonNight * reservation.getGuestCount(), new Date()));
        int totalAmount = items.stream().mapToInt(InvoiceItem::getItemPrice).sum();
        return new Invoice(totalAmount, items);
    }

    @Override
    public ProductsServices addNewBillable(ProductServiceDto productServiceDto) {
        return productService.addNewBillable(productServiceDto);
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
