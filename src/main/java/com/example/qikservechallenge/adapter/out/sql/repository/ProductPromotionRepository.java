package com.example.qikservechallenge.adapter.out.sql.repository;

import com.example.qikservechallenge.adapter.out.sql.model.ProductPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, String> {

}
