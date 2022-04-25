package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.core.data.Basket;
import com.example.qikservechallenge.usecase.CreateBasketUseCase;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class CreateBasketService implements CreateBasketUseCase {

  @Override
  @CachePut(value = "basket", key = "#userId")
  public Basket createBasket(Integer userId) {
    return Basket.builder().userId(userId).build();
  }
}
