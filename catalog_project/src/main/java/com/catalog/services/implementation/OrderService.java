package com.catalog.services.implementation;

import com.catalog.entities.Order;
import com.catalog.entities.Product;
import com.catalog.mappers.OrderMapper;
import com.catalog.models.OrderModel;
import com.catalog.models.ProductModel;
import com.catalog.repositries.OrderRepo;
import com.catalog.repositries.ProductRepo;
import com.catalog.services.OrderServiceInterface;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderServiceInterface {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    public Product getProduct(Long id){
        return productRepo
                .findById(id)
                .get();
    }

    public Product bayProduct(ProductModel product) {

        Product getProduct = getProduct(product.getProductId());

        Integer quantityUpdate = getProduct.getQuantity() - product.getQuantityOrdered();

        if (quantityUpdate < 0) {
            return null;
        } else {

            Integer popurityUpdate = getProduct.getPopurity() + 1;

            getProduct.setQuantity(quantityUpdate);
            getProduct.setPopurity(popurityUpdate);
            getProduct.setLastQuantityOrdered(product.getQuantityOrdered());
//            productRepo.updateQuantity(quantityUpdate
//                    , popurityUpdate
//                    , product.getQuantityOrdered()
//                    , getProduct.getId());
            return productRepo.save(getProduct) ;
        }

    }


    @Override
    public Order insertOrder(OrderModel orderModel) {


        List<Product> getProducts = orderModel
            .getProducts()
            .stream()
            .map(this::bayProduct)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        double calcTotal = getProducts
                .stream()
                .mapToDouble(product -> product.getPrice() * product.getLastQuantityOrdered())
                .sum();

        Order currantOrder = orderMapper.toEntityOrder(orderModel);

        currantOrder.setTotal(calcTotal);

        currantOrder.setProducts(getProducts);


        return orderRepo.save(currantOrder);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo
                .findById(orderId)
                .get();
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return orderRepo
                .findAll()
                .stream()
                .map(order -> orderMapper.toModelOrder(order))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepo
                .deleteById(orderId);
    }


}
