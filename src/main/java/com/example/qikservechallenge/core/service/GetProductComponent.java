package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.adapter.out.sql.model.ProductEntity;
import com.example.qikservechallenge.adapter.out.sql.repository.ProductRepository;
import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.usecase.GetAllProductsUseCase;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetProductComponent implements GetAllProductsUseCase {

  private final ProductRepository productRepository;

  @Override
  public List<Product> getProducts() {
    var productsPage = productRepository.findAll();

    if (!productsPage.isEmpty()) {
      return mapList(productsPage, (p) -> Product.builder()
          .id(p.getCode())
          .name(p.getName())
          .price(p.getPrice())
          .build());
    }
    return List.of();
  }

  public <T> List<T> mapList(List<ProductEntity> products, Function<ProductEntity, T> callback) {
    return products.stream().map(callback).collect(Collectors.toList());
  }

}
