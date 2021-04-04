package com.vts.product.service.service;

import com.vts.product.service.domain.Cart;
import com.vts.product.service.service.dto.CartDTO;
import com.vts.product.service.service.dto.ProductDTO;
import com.vts.product.service.web.rest.vm.CartDetailVM;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Cart}.
 */
public interface CartService {

    /**
     * Save a cart.
     *
     * @param cartDTO the entity to save.
     * @return the persisted entity.
     */
    CartDTO save(CartDTO cartDTO);

    /**
     * Get all the carts.
     *
     * @return the list of entities.
     */
    List<CartDTO> findAll();


    /**
     * Get the "id" cart.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CartDTO> findOne(Long id);

    /**
     * Delete the "id" cart.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    CartDetailVM addItem(ProductDTO product);

    CartDetailVM getTotalAmountAfterDiscounts(CartDetailVM cartDetailVM, String campaignCode);

    CartDetailVM getCampaignDiscount(CartDTO cartDTO, CartDetailVM cartDetailVM);

    CartDetailVM getCouponDiscount(String code, CartDetailVM cartDetailVM);

    double getDeliveryCost(CartDTO cartDTO);
}
