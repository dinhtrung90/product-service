package com.vts.product.service.service;

import com.vts.product.service.domain.Coupon;
import com.vts.product.service.service.dto.CouponDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Coupon}.
 */
public interface CouponService {

    /**
     * Save a coupon.
     *
     * @param couponDTO the entity to save.
     * @return the persisted entity.
     */
    CouponDTO save(CouponDTO couponDTO);

    /**
     * Get all the coupons.
     *
     * @return the list of entities.
     */
    List<CouponDTO> findAll();


    /**
     * Get the "id" coupon.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CouponDTO> findOne(Long id);

    /**
     * Delete the "id" coupon.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<CouponDTO> findCouponByCode(String code);
}
