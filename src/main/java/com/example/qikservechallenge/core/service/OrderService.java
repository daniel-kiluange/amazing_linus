package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.usecase.GetBasketUseCase;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final GetBasketUseCase getBasketUseCase;

  public void placeOrder(Integer userId) {
    var basket = this.getBasketUseCase.getBasket(userId);
    if (!Objects.isNull(basket)) {
      log.info("Place order for user {}", userId);
      //Save order
    } else {
      throw new RuntimeException("Cart not found");
    }

  }

}
