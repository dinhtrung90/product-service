package com.vts.product.service.repository;

import com.vts.product.service.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Cart entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select cart from Cart cart where cart.cartState.id=:stateId and cart.user.login = ?#{principal.username}")
    Optional<Cart> findByUserIsCurrentUser(@Param("stateId") Long stateId);

}
