package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.Coupon;
import com.vts.product.service.service.dto.CouponDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Coupon} and its DTO {@link CouponDTO}.
 */
@Mapper(componentModel = "spring", uses = {DiscountTypeMapper.class})
public interface CouponMapper extends EntityMapper<CouponDTO, Coupon> {

    @Mapping(source = "discountType.id", target = "discountTypeId")
    CouponDTO toDto(Coupon coupon);

    @Mapping(source = "discountTypeId", target = "discountType")
    Coupon toEntity(CouponDTO couponDTO);

    default Coupon fromId(Long id) {
        if (id == null) {
            return null;
        }
        Coupon coupon = new Coupon();
        coupon.setId(id);
        return coupon;
    }
}
