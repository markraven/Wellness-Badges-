package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.entity.Guest;
import hu.uni.eku.tzs.model.CheckInGuest;
import hu.uni.eku.tzs.controller.dto.GuestDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface GuestService {

//    Guest addGuest(CheckInGuest guest);

    List<GuestDto> getGeusts();

    Optional<Guest> findById(UUID uuid);

    Set<Guest> findAllByReservationId(Long reservationId);
}
