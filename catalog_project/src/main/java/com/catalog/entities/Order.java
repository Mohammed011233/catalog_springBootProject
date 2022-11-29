package com.catalog.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders_table")
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private Double total;

//    @Column(name = "quantity_order")
//    private Integer quantityOrder;

    @ManyToMany()
    @JoinTable(
            name = "product_order_relation"
            , joinColumns= @JoinColumn(name = "order_id")
            , inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


}
