package com.mmt.ProductService.exception;

import lombok.Data;

@Data
public class ProductServiceCustomException {
    private String errorCode;
    public ProductServiceCustomException(String message,String errorCode)
    {
        super(message);
        this.errorCode=errorCode;
    }
}
