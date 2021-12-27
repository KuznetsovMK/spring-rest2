package ru.gb.gbrest.dto.mapper;

import org.mapstruct.Mapper;
import ru.gb.gbrest.dto.CartDto;
import ru.gb.gbrest.entity.Cart;

@Mapper
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);
}
