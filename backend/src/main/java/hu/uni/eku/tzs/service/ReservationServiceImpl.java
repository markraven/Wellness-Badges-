package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ReservationRepository;
import hu.uni.eku.tzs.dao.entity.Guest;
import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.dao.entity.Room;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.controller.dto.ReservationCheckInDto;
import hu.uni.eku.tzs.model.ReservationModel;
import hu.uni.eku.tzs.service.exceptions.NoFreeRoomException;
import hu.uni.eku.tzs.service.exceptions.ReservationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final GuestService guestService;

    @Override
    public ReservationModel bookRoom(LocalDate startDate, LocalDate endDate, int guests) {
        if(startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException();
        }

        List<Room> allRoom = roomService.getAllRooms();
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
        ).map(ReservationModel::fromEntity).orElseThrow(NoFreeRoomException::new);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Set<GuestDto> checkIn(ReservationCheckInDto reservation) {
        Room room = roomService.findRoomByRoomNumber(reservation.getRoomNumber()).orElseThrow(ReservationNotFoundException::new);
        Reservation checkInReservation = reservationRepository.findByArriveDateAndLeaveDateAndRoom(reservation.getArrival(), reservation.getLeave(), room).orElseThrow((ReservationNotFoundException::new));

        Set<Guest> guestEntities = reservation.getGuests().stream().map(guestService::addGuest).collect(Collectors.toSet());
        guestEntities.stream().forEach(g -> g.setReservation(checkInReservation));
        checkInReservation.setGuests(guestEntities);
        reservationRepository.save(checkInReservation);
        return guestEntities.stream().map(Guest::toGuestDto).collect(Collectors.toSet());
    }

    @Override
    public Optional<Reservation> findbyReservationId(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }
}
