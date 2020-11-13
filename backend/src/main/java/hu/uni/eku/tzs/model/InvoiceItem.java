package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    private String  guestName;

    private String  itemName;

    private int itemPrice;

    private Date purchaseDate;
}
