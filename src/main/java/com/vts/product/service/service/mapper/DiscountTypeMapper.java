package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.DiscountType;
import com.vts.product.service.service.dto.DiscountTypeDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link DiscountType} and its DTO {@link DiscountTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DiscountTypeMapper extends EntityMapper<DiscountTypeDTO, DiscountType> {



    default DiscountType fromId(Long id) {
        if (id == null) {
            return null;
        }
        DiscountType discountType = new DiscountType();
        discountType.setId(id);
        return discountType;
    }
}
