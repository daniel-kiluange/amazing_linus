package com.example.qikservechallenge.adapter.out.sql.repository;

import com.example.qikservechallenge.adapter.out.sql.model.ProductEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  Optional<ProductEntity> findByCode(String code);
}
