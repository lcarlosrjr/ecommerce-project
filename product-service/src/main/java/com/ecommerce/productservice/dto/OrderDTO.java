package com.ecommerce.productservice.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Long productId;
    private int quantity;

}
