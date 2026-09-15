package com.re.productservice.client;

import com.re.productservice.entity.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service")
public interface CategoryFeignClient {
    @GetMapping("/api/categories/{id}")
    public Category getCategoryById(@PathVariable Long id);

}
