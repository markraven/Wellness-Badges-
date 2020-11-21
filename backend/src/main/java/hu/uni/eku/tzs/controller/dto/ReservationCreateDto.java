package hu.uni.eku.tzs.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCreateDto {
    @ApiModelProperty(required = true, example = "2020-10-18")
    private LocalDate arrival;
    @ApiModelProperty(required = true, example = "2020-10-25")
    private LocalDate leave;
    @ApiModelProperty(required = true)
    private int guests;
}
