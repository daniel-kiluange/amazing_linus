package com.example.qikservechallenge.core.service;

import com.example.qikservechallenge.adapter.out.sql.model.PromotionEntity;
import com.example.qikservechallenge.adapter.out.sql.repository.PromotionRepository;
import com.example.qikservechallenge.core.data.Promotion;
import com.example.qikservechallenge.core.data.PromotionType;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPromotionsComponent {

  private final PromotionRepository promotionRepository;

  public List<Promotion> getProductsPromotionsByCode(Integer productId) {

    var promotionsList = this.promotionRepository.findByProductId(productId);

    return promotionsList.stream().map(parsePromotion()).collect(Collectors.toList());
  }

  private Function<PromotionEntity, Promotion> parsePromotion() {
    return p -> new Promotion(p.getCode(), PromotionType.valueOf(p.getType()), p.getPrice(),
        p.getRequiredQuantity(), p.getFreeQuantity(), p.getAmount());
  }
}
