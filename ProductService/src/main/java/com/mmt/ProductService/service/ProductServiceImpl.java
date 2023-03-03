package com.mmt.ProductService.service;

import com.mmt.ProductService.entity.Product;
import com.mmt.ProductService.model.ProductRequest;
import com.mmt.ProductService.model.ProductResponse;
import com.mmt.ProductService.repository.ProductRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Add Product");
        Product product= Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Product found for id:" + productId);
        Product product= productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with Id not found"+"Not_FOUND"));
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;

    }
}
