package ru.gb.gbrest.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.CartDto;

import java.util.List;

@FeignClient(url = "localhost:8457/cart", value = "cartDtoApi")
public interface CartDtoApi {

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    CartDto handlePost(@RequestBody CartDto cartDto);

    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    List<CartDto> getProductList();

    @DeleteMapping(value = "/{cartId}", produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("cartId") Long id);

}
