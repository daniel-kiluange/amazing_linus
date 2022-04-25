package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.core.data.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final GetProductComponent getProductComponent;
  private final GetProductByIdComponent getProductByIdComponent;

  @CachePut(value = "products")
  public List<Product> findAll() {
    return getProductComponent.getProducts();
  }

  @CachePut(value = "product", key = "#productId")
  public Product findById(String productId) {
    return getProductByIdComponent.getProductByCode(productId);
  }


}
