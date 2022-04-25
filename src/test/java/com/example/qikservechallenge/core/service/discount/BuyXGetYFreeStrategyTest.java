package com.example.qikservechallenge.core.service.discount;

import com.example.qikservechallenge.core.data.Product;
import com.example.qikservechallenge.core.data.Promotion;
import com.example.qikservechallenge.core.data.PromotionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuyXGetYFreeStrategyTest {

  @Test
  void testOneProductBUY_X_GET_Y_FREE() {
    Product item = Product.builder()
        .price(999L)
        .quantity(1)
        .build();
    Promotion promotion = new Promotion("abc", PromotionType.BUY_X_GET_Y_FREE, null, 2, 1, null);

    var buyXGetYFreeStrategy = new BuyXGetYFreeStrategy(item, promotion);

    var result = buyXGetYFreeStrategy.doCalc();

    Assertions.assertEquals(0, result);
  }

  @Test
  void testTwoProductsBUY_X_GET_Y_FREE() {
    Product item = Product.builder()
        .price(999L)
        .quantity(2)
        .build();
    Promotion promotion = new Promotion("abc", PromotionType.BUY_X_GET_Y_FREE, null, 2, 1, null);

    var buyXGetYFreeStrategy = new BuyXGetYFreeStrategy(item, promotion);

    var result = buyXGetYFreeStrategy.doCalc();

    Assertions.assertEquals(999, result);
  }

  @Test
  void testTreeProductsBUY_X_GET_Y_FREE() {
    Product item = Product.builder()
        .price(999L)
        .quantity(3)
        .build();
    Promotion promotion = new Promotion("abc", PromotionType.BUY_X_GET_Y_FREE, null, 2, 1, null);

    var buyXGetYFreeStrategy = new BuyXGetYFreeStrategy(item, promotion);

    var result = buyXGetYFreeStrategy.doCalc();

    Assertions.assertEquals(999, result);
  }
  @Test
  void testFourProductsBUY_X_GET_Y_FREE() {
    Product item = Product.builder()
        .price(999L)
        .quantity(4)
        .build();
    Promotion promotion = new Promotion("abc", PromotionType.BUY_X_GET_Y_FREE, null, 2, 1, null);

    var buyXGetYFreeStrategy = new BuyXGetYFreeStrategy(item, promotion);

    var result = buyXGetYFreeStrategy.doCalc();

    Assertions.assertEquals(1998, result);
  }

}