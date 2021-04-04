package com.vts.product.service.repository;

import com.vts.product.service.domain.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the DiscountType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiscountTypeRepository extends JpaRepository<DiscountType, Long> {

}
