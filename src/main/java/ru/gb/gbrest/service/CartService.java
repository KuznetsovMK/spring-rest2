package ru.gb.gbrest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbrest.dao.CartDao;
import ru.gb.gbrest.dto.CartDto;
import ru.gb.gbrest.dto.mapper.CartMapper;
import ru.gb.gbrest.entity.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartDao cartDao;
    private final CartMapper cartMapper;

    public List<CartDto> findAll() {
        return cartDao.findAll().stream().map(cartMapper::toCartDto).collect(Collectors.toList());
    }

    @Transactional
    public CartDto save(CartDto cartDto) {
        Cart cart = cartMapper.toCart(cartDto);
        return  cartMapper.toCartDto(cartDao.save(cart));
    }

    public void deleteById(Long id) {
        try {
            cartDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No such id in DB: " + e.getMessage());
        }
    }
}
