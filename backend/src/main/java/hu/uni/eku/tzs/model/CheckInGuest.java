package hu.uni.eku.tzs.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInGuest {

    @ApiModelProperty(required = true, example = "[\"Sayi\", \"Béla\"]")
    private List<String> name;

    @ApiModelProperty(required = true, example = "[\"2020-10-18\", \"2010-10-18\"]")
    private List<LocalDate> bornAt;
}
