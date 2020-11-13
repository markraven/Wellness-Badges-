package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
@NoArgsConstructor
@EqualsAndHashCode(exclude = "reservations")
@ToString(exclude = "reservations")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomNumber;

    private int maxGuests;

    public Room(String roomNumber, int maxGuests) {
        this.roomNumber = roomNumber;
        this.maxGuests = maxGuests;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
