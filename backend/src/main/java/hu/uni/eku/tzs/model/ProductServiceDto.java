package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceDto {
    private String productName;
    private int price;
    private String restrictionDescription;
    private int minimumAge;
    private String errorMessage;
}
