package com.example.qikservechallenge.adapter.out.sql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "product_promotion")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductPromotion {

  @Id
  private String id;
  @Column(name = "product_id")
  private Integer productEntityId;
  private Integer promotionId;
}
