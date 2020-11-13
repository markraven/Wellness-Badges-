package hu.uni.eku.tzs.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table
@NoArgsConstructor
@EqualsAndHashCode(exclude = "purchases")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    @Column
    private int guestCount;

    private LocalDate arriveDate;

    private LocalDate leaveDate;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Guest> guests;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Purchase> purchases;

    public Reservation(Room room, int guestCount, LocalDate arriveDate, LocalDate leaveDate) {
        this.room = room;
        this.guestCount = guestCount;
        this.arriveDate = arriveDate;
        this.leaveDate = leaveDate;
    }
}
