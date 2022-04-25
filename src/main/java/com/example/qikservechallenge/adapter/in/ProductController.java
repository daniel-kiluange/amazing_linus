package com.example.qikservechallenge.adapter.in;

import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.core.service.ProductService;
import com.example.qikservechallenge.usecase.AddBasketItemUseCase;
import com.example.qikservechallenge.usecase.CreateBasketUseCase;
import com.example.qikservechallenge.usecase.GetBasketUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public List<Product> getProducts() {
    return productService.findAll();
  }

  @GetMapping("/{productId}")
  public Product getProductById(@PathVariable String productId) {
    return productService.findById(productId);
  }

}
