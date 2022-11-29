package com.catalog.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderModel {

    private Long orderId;

    private Double totalCost;

    private List<ProductModel> products;
}
