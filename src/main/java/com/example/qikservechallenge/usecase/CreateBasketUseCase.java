package com.example.qikservechallenge.usecase;

import com.example.qikservechallenge.core.data.Basket;
import java.util.UUID;

public interface CreateBasketUseCase {

  Basket createBasket(Integer userId);

}
