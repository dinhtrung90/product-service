package com.vts.product.service.service.dto;
import com.vts.product.service.domain.Campaign;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Campaign} entity.
 */
public class CampaignDTO implements Serializable {

    private Long id;

    private String title;

    private Integer baseProductQuantity;

    private Double discount;

    private Long discountTypeId;

    private DiscountTypeDTO discountType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBaseProductQuantity() {
        return baseProductQuantity;
    }

    public void setBaseProductQuantity(Integer baseProductQuantity) {
        this.baseProductQuantity = baseProductQuantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getDiscountTypeId() {
        return discountTypeId;
    }

    public void setDiscountTypeId(Long discountTypeId) {
        this.discountTypeId = discountTypeId;
    }

    public DiscountTypeDTO getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountTypeDTO discountType) {
        this.discountType = discountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CampaignDTO campaignDTO = (CampaignDTO) o;
        if (campaignDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), campaignDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CampaignDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", baseProductQuantity=" + getBaseProductQuantity() +
            ", discount=" + getDiscount() +
            ", discountType=" + getDiscountTypeId() +
            "}";
    }
}
