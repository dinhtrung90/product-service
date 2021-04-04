package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.CartProduct;
import com.vts.product.service.service.dto.CartProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link CartProduct} and its DTO {@link CartProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {CartMapper.class, ProductMapper.class})
public interface CartProductMapper extends EntityMapper<CartProductDTO, CartProduct> {

    @Mapping(source = "cart.id", target = "cartId")
    @Mapping(source = "product.id", target = "productId")
    CartProductDTO toDto(CartProduct cartProduct);

    @Mapping(source = "cartId", target = "cart")
    @Mapping(source = "productId", target = "product")
    CartProduct toEntity(CartProductDTO cartProductDTO);

    default CartProduct fromId(Long id) {
        if (id == null) {
            return null;
        }
        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(id);
        return cartProduct;
    }
}
