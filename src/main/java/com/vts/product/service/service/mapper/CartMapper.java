package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.*;
import com.vts.product.service.service.dto.CartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring", uses = {CartStateMapper.class, UserMapper.class})
public interface CartMapper extends EntityMapper<CartDTO, Cart> {

    @Mapping(source = "cartState.id", target = "cartStateId")
    @Mapping(source = "user.id", target = "userId")
    CartDTO toDto(Cart cart);

    @Mapping(source = "cartStateId", target = "cartState")
    @Mapping(source = "userId", target = "user")
    Cart toEntity(CartDTO cartDTO);

    default Cart fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cart cart = new Cart();
        cart.setId(id);
        return cart;
    }
}
