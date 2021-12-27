package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.CartDto;
import ru.gb.gbrest.service.CartService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartDto> getProductList() {
        return cartService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@RequestBody CartDto cartDto) {
        CartDto savedCart = cartService.save(cartDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/cart/" + savedCart.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("cartId") Long id) {
        cartService.deleteById(id);
    }

}
