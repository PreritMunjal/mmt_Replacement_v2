package com.mmt.ProductService.controller;

import com.mmt.ProductService.entity.Product;
import com.mmt.ProductService.model.ProductRequest;
import com.mmt.ProductService.model.ProductResponse;
import com.mmt.ProductService.repository.ProductRepository;
import com.mmt.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
            long productID = productService.addProduct(productRequest);
            return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        ProductResponse productResponse= productService.getProductById(productId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

}
