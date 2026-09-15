package com.re.productservice.service;

import com.re.productservice.client.CategoryFeignClient;
import com.re.productservice.dto.ProductResponse;
import com.re.productservice.entity.Category;
import com.re.productservice.entity.Product;
import com.re.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryFeignClient categoryFeignClient;

    public Optional<List<Product>> getProducts() {
        return Optional.of(productRepository.findAll());
    }

    public Optional<Product> postProduct(ProductResponse productResponse) {
        Optional<Category> findCategory = Optional.ofNullable(categoryFeignClient.getCategoryById(productResponse.getCategoryId()));
        if (findCategory.isPresent()) {
            Product newPro = new Product();
            newPro.setName(productResponse.getName());
            newPro.setCategoryId(productResponse.getCategoryId());
            System.out.println(productResponse.getCategoryId());
            return Optional.of(productRepository.save(newPro));
        }
        return Optional.empty();
    }
}
