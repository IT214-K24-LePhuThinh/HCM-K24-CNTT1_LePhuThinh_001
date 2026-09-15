package com.re.productservice.controller;

import com.re.productservice.dto.ProductResponse;
import com.re.productservice.entity.Product;
import com.re.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<Optional<List<Product>>> getCategory() {
        Optional<List<Product>> productResponse = productService.getProducts();
        if (productResponse.isPresent()) {
            return ResponseEntity.ok(productResponse);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping()
    public ResponseEntity<Optional<Product>> postCategory(@RequestBody ProductResponse productResponse) {
        Optional<Product> proRes = productService.postProduct(productResponse);
        if (proRes.isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(proRes);
    }
 }
