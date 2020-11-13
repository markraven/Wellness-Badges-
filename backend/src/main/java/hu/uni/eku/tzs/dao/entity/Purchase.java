package hu.uni.eku.tzs.dao.entity;

import hu.uni.eku.tzs.model.InvoiceItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductsServices item;

    private Date purchaseDate;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    private Reservation reservation;
     */

    @ManyToOne(cascade = CascadeType.ALL)
    private Guest guest;

    public InvoiceItem toInvoiceItem() {
        return new InvoiceItem(guest.getName(), item.getName(), amount * item.getPrice(), purchaseDate);
    }
}
