package com.example.qikservechallenge.core.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  String id;
  String name;
  Long price;
  @JsonProperty(access = Access.WRITE_ONLY)
  @Default
  Integer quantity = 1;
  @JsonInclude(Include.NON_NULL)
  @Default
  List<Promotion> promotions = List.of();
  @JsonProperty(access = Access.READ_ONLY)
  @JsonInclude(Include.NON_NULL)
  @Default
  Integer totalOfItems = null;

  public void increaseQuantity(int value) {
    totalOfItems += value;
    quantity += value;
  }

  public <T> T mapTo(Function<Product, T> callback) {
    return callback.apply(this);
  }
}
