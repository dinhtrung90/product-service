package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.CartState;
import com.vts.product.service.service.dto.CartStateDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link CartState} and its DTO {@link CartStateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CartStateMapper extends EntityMapper<CartStateDTO, CartState> {



    default CartState fromId(Long id) {
        if (id == null) {
            return null;
        }
        CartState cartState = new CartState();
        cartState.setId(id);
        return cartState;
    }
}
