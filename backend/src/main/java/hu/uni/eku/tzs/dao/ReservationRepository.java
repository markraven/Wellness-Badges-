package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Reservation;
import hu.uni.eku.tzs.dao.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "select res from Reservation res where res.arriveDate <= ?2 and res.leaveDate >= ?1")
    List<Reservation> findReservedAtTime(LocalDate arrival, LocalDate leave);

    @Query("select res from Reservation res where res.arriveDate = ?1 and res.leaveDate = ?2 and res.room = ?3")
    Optional<Reservation> findByArriveDateAndLeaveDateAndRoom(LocalDate arriveDate, LocalDate leaveDate, Room roomNumber);

}
