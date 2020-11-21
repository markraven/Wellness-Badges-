package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyDto {
    private Long productId;
    private UUID guestId;
    private int amount;
}
