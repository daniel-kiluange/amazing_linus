package com.example.qikservechallenge.adapter.out.sql.model;

import com.example.qikservechallenge.core.data.PromotionType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "promotion")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PromotionEntity {

  @Id
  private Long id;
  private String code;
  private String type;
  private Long price;
  private Integer requiredQuantity;
  private Integer freeQuantity;
  private Integer amount;
}
