package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.controller.dto.ReservationCheckInDto;
import hu.uni.eku.tzs.model.ReservationModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ReservationService {

    ReservationModel bookRoom(LocalDate startDate, LocalDate endDate, int guests);

    List<Reservation> getAllReservations();

    Set<GuestDto> checkIn(ReservationCheckInDto reservation);

    Optional<Reservation> findbyReservationId(Long reservationId);
}
