package com.vts.product.service.service.helper;

import com.vts.product.service.config.ApplicationProperties;
import com.vts.product.service.service.dto.CartProductDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DeliveryCostCalculator {

    private final ApplicationProperties applicationProperties;

    private double fixedCost = 2.99d;

    public DeliveryCostCalculator(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public double calculateFor(List<CartProductDTO> products) {
        Set<Long> distinctCategorySet = new HashSet<>();
        int numberOfProducts = products.size();
        for (CartProductDTO cartProductDTO : products) {
            distinctCategorySet.add(cartProductDTO.getProduct().getCategory().getId());
        }
        int numberOfDeliveries = distinctCategorySet.size();
        ApplicationProperties.Delivery delivery = applicationProperties.getDelivery();
        return (delivery.getCostPerDelivery() * numberOfDeliveries) + (delivery.getCostPerProduct() * numberOfProducts);
    }
}
