package hu.uni.eku.tzs.model;

import hu.uni.eku.tzs.dao.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationModel {
    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int guests;

    private String roomNumber;

    public static ReservationModel fromEntity(Reservation reservation) {
        return new ReservationModel(
                reservation.getArriveDate(),
                reservation.getLeaveDate(),
                reservation.getGuestCount(),
                reservation.getRoom().getRoomNumber()
        );
    }
}
