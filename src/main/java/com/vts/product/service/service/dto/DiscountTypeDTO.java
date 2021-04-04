package com.vts.product.service.service.dto;
import com.vts.product.service.domain.DiscountType;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link DiscountType} entity.
 */
public class DiscountTypeDTO implements Serializable {

    private Long id;

    private String title;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DiscountTypeDTO discountTypeDTO = (DiscountTypeDTO) o;
        if (discountTypeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), discountTypeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DiscountTypeDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            "}";
    }
}
