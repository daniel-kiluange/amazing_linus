package com.example.qikservechallenge.usecase;

import com.example.qikservechallenge.core.data.Basket;

public interface GetBasketUseCase {
  Basket getBasket(Integer userId);
}
