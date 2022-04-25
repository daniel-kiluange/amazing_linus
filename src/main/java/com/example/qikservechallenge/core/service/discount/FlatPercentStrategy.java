package com.example.qikservechallenge.core.service.discount;

import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.core.data.Promotion;

public record FlatPercentStrategy(Product item, Promotion promotion) implements DiscountStrategy {

  @Override
  public Long doCalc() {
    var total = item.getQuantity() * item.getPrice();
    return (total * promotion.amount()) / 100;
  }
}
