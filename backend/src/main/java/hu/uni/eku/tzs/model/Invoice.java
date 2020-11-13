package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private double sumPrice;

    private Set<InvoiceItem> items;
}
