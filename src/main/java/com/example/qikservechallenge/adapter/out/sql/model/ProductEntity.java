package com.example.qikservechallenge.adapter.out.sql.model;

import java.util.function.Function;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "PRODUCT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String code;
  private String name;
  private Long price;

  public <T> T mapTo(Function<ProductEntity, T> callback) {
    return callback.apply(this);
  }
}
