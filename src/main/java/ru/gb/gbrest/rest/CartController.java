package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.CartDto;
import ru.gb.gbrest.service.feign.CartDtoApi;
import ru.gb.gbrest.service.resttemplate.ManufacturerDtoApiV2;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
//    private final CartService cartService;

    private final CartDtoApi cartDtoApi;


    @PostMapping
    public CartDto handlePost(@RequestBody CartDto cartDto) {
        return cartDtoApi.handlePost(cartDto);
    }

    @GetMapping
    public List<CartDto> getProductList() {
        return cartDtoApi.getProductList();
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("cartId") Long id) {
        cartDtoApi.deleteById(id);
    }

//    @GetMapping
//    public List<CartDto> getProductList() {
//        return cartService.findAll();
//    }

//    @PostMapping
//    public ResponseEntity<?> handlePost(@RequestBody CartDto cartDto) {
//        CartDto savedCart = cartService.save(cartDto);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/cart/" + savedCart.getId()));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
//    }

//    @DeleteMapping("/{cartId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable("cartId") Long id) {
//        cartService.deleteById(id);
//    }

}
