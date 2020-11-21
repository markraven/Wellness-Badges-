package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.GuestRepository;
import hu.uni.eku.tzs.dao.entity.Guest;
import hu.uni.eku.tzs.model.CheckInGuest;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    @Override
    public Guest addGuest(CheckInGuest guest) {
        return this.createGuestFromDto(guest);
    }

    @Override
    public List<GuestDto> getGeusts() {
        return repository.findAll().stream().map(Guest::toGuestDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Guest> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Set<Guest> findAllByReservationId(Long reservationId) {
        return repository.findAllByReservationId(reservationId);
    }

    private Guest createGuestFromDto(CheckInGuest checkInGuest) {
        Guest guest = new Guest();
        guest.setName(checkInGuest.getName());
        guest.setBornAt(checkInGuest.getBornAt());
        return repository.save(guest);
    }
}
