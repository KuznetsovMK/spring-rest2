package ru.gb.gbrest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    @JsonProperty(value = "cartId")
    private Long id;
    private Long product_id;
    private String title;
    private BigDecimal cost;
}
