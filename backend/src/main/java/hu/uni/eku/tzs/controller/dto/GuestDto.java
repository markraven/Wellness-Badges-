package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {
    private UUID guestId;
    private String guestName;
    private LocalDate bornAt;
}
