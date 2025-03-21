package com.sotogito.coffeeshop.dto;

public record PaymentDetailsDTO(String productName
                                 , int amount
                                , int quantity) {
}
