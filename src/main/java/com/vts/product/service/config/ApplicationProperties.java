package com.vts.product.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Product.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link tech.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private Delivery delivery;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public static class Delivery{
        private Double costPerDelivery;
        private Double costPerProduct;

        public Double getCostPerDelivery() {
            return costPerDelivery;
        }

        public void setCostPerDelivery(Double costPerDelivery) {
            this.costPerDelivery = costPerDelivery;
        }

        public Double getCostPerProduct() {
            return costPerProduct;
        }

        public void setCostPerProduct(Double costPerProduct) {
            this.costPerProduct = costPerProduct;
        }
    }
}
