package com.zeyadaboushanab.inventoryservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonProperty("id")
    private String skuCode;
    private String name;
    private String description;
    private BigDecimal price;
}