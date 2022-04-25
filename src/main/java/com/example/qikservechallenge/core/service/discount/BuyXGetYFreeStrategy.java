package com.example.qikservechallenge.core.service.discount;

import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.core.data.Promotion;

public class BuyXGetYFreeStrategy implements DiscountStrategy {

  private final Product item;
  private final Promotion promotion;

  public BuyXGetYFreeStrategy(Product item, Promotion promotion) {
    this.item = item;
    this.promotion = promotion;
  }

  @Override
  public Long doCalc() {
    var discount = 0L;
    if (item.getQuantity() >= promotion.requiredQuantity()) {
      var x = item.getQuantity();

      while (x >= promotion.requiredQuantity()) {
        x -= promotion.requiredQuantity();
        discount += item.getPrice() * promotion.freeQuantity();
      }
    }
    return discount;
  }
}
