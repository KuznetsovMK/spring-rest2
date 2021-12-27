package ru.gb.gbrest.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.CartDto;

import java.util.List;

@FeignClient(url = "localhost:8457/cart", value = "cartDtoApi")
public interface CartDtoApi {


    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    List<CartDto> getProductList();

    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    ResponseEntity<?> handlePost(@RequestBody CartDto cartDto);

    @DeleteMapping("/{cartId}")
    void deleteById(@PathVariable("cartId") Long id);

}
