package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.core.data.Basket;
import com.example.qikservechallenge.usecase.GetBasketUseCase;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GetBasketService implements GetBasketUseCase {

  @Cacheable(value = "basket", key = "#userId")
  public Basket getBasket(Integer userId) {
    return null;
  }
}
