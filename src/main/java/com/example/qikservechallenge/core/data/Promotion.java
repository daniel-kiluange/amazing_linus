package com.example.qikservechallenge.core.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record Promotion(
    String id,
    PromotionType type,
    Long price,
    Integer requiredQuantity,
    Integer freeQuantity,
    Integer amount
) {

}
