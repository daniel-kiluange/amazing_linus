package com.example.qikservechallenge.adapter.in;

import com.example.qikservechallenge.core.data.Basket;
import com.example.qikservechallenge.usecase.AddBasketItemUseCase;
import com.example.qikservechallenge.usecase.CreateBasketUseCase;
import com.example.qikservechallenge.usecase.GetBasketUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketController {

  private final CreateBasketUseCase createBasketUseCase;
  private final GetBasketUseCase getBasketUseCase;
  private final AddBasketItemUseCase addBasketItemUseCase;

  @PostMapping("/{userId}")
  public Basket save(@PathVariable Integer userId) {
    return createBasketUseCase.createBasket(userId);
  }

  @GetMapping("/{userId}")
  public Basket get(@PathVariable Integer userId) {
    return getBasketUseCase.getBasket(userId);
  }

  @PostMapping("/{userId}/add/{product}")
  public Basket save(@PathVariable Integer userId, @PathVariable String product) {
    return addBasketItemUseCase.addItem(userId, product);
  }

}
