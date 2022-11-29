package com.catalog.entities;

//import jdk.incubator.vector.VectorOperators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productNameAr;


    @Column
    private String productNameEn;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "last_quantity_ordered")
    private Integer lastQuantityOrdered;

    @Column(name = "popurity")
    private Integer popurity;


//    @Column(name = "image")
//    private VectorOperators.Binary image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
