package com.vts.product.service.service;

import com.vts.product.service.domain.CartProduct;
import com.vts.product.service.service.dto.CartProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CartProduct}.
 */
public interface CartProductService {

    /**
     * Save a cartProduct.
     *
     * @param cartProductDTO the entity to save.
     * @return the persisted entity.
     */
    CartProductDTO save(CartProductDTO cartProductDTO);

    /**
     * Get all the cartProducts.
     *
     * @return the list of entities.
     */
    List<CartProductDTO> findAll();


    /**
     * Get the "id" cartProduct.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CartProductDTO> findOne(Long id);

    /**
     * Delete the "id" cartProduct.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<CartProductDTO> findAllByCartId(Long cartId);
}
