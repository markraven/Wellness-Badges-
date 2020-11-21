package hu.uni.eku.tzs.dao.entity;

import hu.uni.eku.tzs.controller.dto.GuestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table
@ToString(exclude = "reservation")
@EqualsAndHashCode(exclude = "reservation")
public class Guest {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    private String name;

    private LocalDate bornAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    public GuestDto toGuestDto() {
        return new GuestDto(id, name, bornAt);
    }
}
