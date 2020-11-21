package hu.uni.eku.tzs.controller.dto;

import hu.uni.eku.tzs.model.CheckInGuest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCheckInDto {
    @ApiModelProperty(required = true, example = "2020-10-18")
    private LocalDate arrival;
    @ApiModelProperty(required = true, example = "2020-10-25")
    private LocalDate leave;
    @ApiModelProperty(required = true, example = "202")
    private String roomNumber;

    private Set<CheckInGuest> guests;
}
