package com.example.qikservechallenge.usecase;

import com.example.qikservechallenge.core.data.Product;

public interface GetProductByIdUseCase {

  Product getProductByCode(String productCode);

}
