package com.example.qikservechallenge.adapter.out.sql.repository;

import com.example.qikservechallenge.adapter.out.sql.model.PromotionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {

  @Query(value = "SELECT * FROM product_promotion as pp inner join promotion as p on pp.promotion_id = p.id where pp.product_id = :productId", nativeQuery = true)
  List<PromotionEntity> findByProductId(@Param("productId") Integer productId);
}
