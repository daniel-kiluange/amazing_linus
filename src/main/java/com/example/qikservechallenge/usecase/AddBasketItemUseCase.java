package com.example.qikservechallenge.usecase;

import com.example.qikservechallenge.core.data.Basket;

public interface AddBasketItemUseCase {

  Basket addItem(Integer userId, String product);

}
