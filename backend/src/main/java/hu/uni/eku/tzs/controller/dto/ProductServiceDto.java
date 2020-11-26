package hu.uni.eku.tzs.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceDto {

    @ApiModelProperty(required = true, example = "Vodka")
    private String productName;

    @ApiModelProperty(required = true, example = "720")
    private int price;

    @ApiModelProperty(required = true, example = "Alkohol életkor szabály")
    private String restDesc;

    @ApiModelProperty(required = true, example = "18")
    private int minAge;

    @ApiModelProperty(required = true, example = "Fiatalkorúak nem ihatnak alkoholt!!!4")
    private String errorMessage;
}
