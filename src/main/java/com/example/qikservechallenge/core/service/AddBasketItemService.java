package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.core.data.Basket;
import com.example.qikservechallenge.usecase.AddBasketItemUseCase;
import com.example.qikservechallenge.usecase.GetBasketUseCase;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddBasketItemService implements AddBasketItemUseCase {

  private final GetBasketUseCase getBasketUseCase;
  private final GetProductByIdComponent getProductByIdComponent;

  @Override
  @CachePut(value = "basket", key = "#userId")
  public Basket addItem(Integer userId, String product) {
    var basket = this.getBasketUseCase.getBasket(userId);
    var item = getProductByIdComponent.getProductByCode(product);

    basket.getItems().stream().filter(bsktItem -> Objects.equals(bsktItem.getId(), item.getId()))
        .findFirst()
        .ifPresentOrElse(it -> it.increaseQuantity(item.getQuantity()),
            () -> {
              item.setTotalOfItems(1);
              basket.getItems().add(item);
            });

    return basket;
  }
}
