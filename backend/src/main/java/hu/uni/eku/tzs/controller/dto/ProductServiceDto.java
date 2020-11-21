package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceDto {
    private String productName;
    private int price;
    private String restDesc;
    private int minAge;
    private String errorMessage;
}
