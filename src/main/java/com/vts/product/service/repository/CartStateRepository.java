package com.vts.product.service.repository;

import com.vts.product.service.domain.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CartState entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartStateRepository extends JpaRepository<CartState, Long> {

}
