package hu.uni.eku.tzs.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class ProductsServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Restriction restriction;
}
