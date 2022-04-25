package com.example.qikservechallenge.core.data;

import com.example.qikservechallenge.core.service.discount.BuyXGetYFreeStrategy;
import java.util.UUID;
import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Basket {

  @Default
  @Getter
  private UUID id = UUID.randomUUID();
  @Getter
  @Setter
  private Integer userId;
  @Getter
  @Setter
  @Default
  private Vector<Product> items = new Vector<>();
  @Setter
  private Long rawTotal;
  @Setter
  private Long totalPromos;
  @Setter
  private Long totalPayable;

  public Long getRawTotal() {
    var total = 0L;
    if (!items.isEmpty()) {
      for (Product item : items) {
        total += item.price * item.quantity;
      }
    }
    return total;
  }

  public Long getTotalPromos() {
    return items.stream().filter(item -> !item.promotions.isEmpty()).map(item -> {
      var promos = item.promotions;
      return promos.stream().map(promotion -> getTotalOfDiscounts(item, promotion))
          .reduce(0L, Long::sum);
    }).reduce(0L, Long::sum);
  }

  private Long getTotalOfDiscounts(Product item, Promotion promotion) {
    return switch (promotion.type()) {
      case QTY_BASED_PRICE_OVERRIDE -> 0L;
      case FLAT_PERCENT -> 0L;
      case BUY_X_GET_Y_FREE -> new BuyXGetYFreeStrategy(item, promotion).doCalc();
    };
  }

  public Long getTotalPayable() {
    return getRawTotal() - getTotalPromos();
  }
}
