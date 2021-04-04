package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.Product;
import com.vts.product.service.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CartMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "cart.id", target = "cartId")
    ProductDTO toDto(Product product);

    @Mapping(source = "cartId", target = "cart")
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
