package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.adapter.out.sql.repository.ProductRepository;
import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.usecase.GetProductByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetProductByIdComponent implements GetProductByIdUseCase {

  private final ProductRepository productRepository;
  private final GetPromotionsComponent getPromotionsComponent;

  @Override
  public Product getProductByCode(String productCode) {
    var productEntity = this.productRepository.findByCode(productCode).orElseThrow();

    return productEntity.mapTo(entity -> Product.builder()
        .id(entity.getCode())
        .name(entity.getName())
        .price(entity.getPrice())
        .promotions(getPromotionsComponent.getProductsPromotionsByCode(productEntity.getId()))
        .build());
  }
}
