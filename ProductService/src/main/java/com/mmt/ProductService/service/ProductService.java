package com.mmt.ProductService.service;

import com.mmt.ProductService.model.ProductRequest;
import com.mmt.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
