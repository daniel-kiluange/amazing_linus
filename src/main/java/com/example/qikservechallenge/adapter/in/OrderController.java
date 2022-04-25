package com.example.qikservechallenge.adapter.in;

import com.example.qikservechallenge.core.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/{userId}")
  public void placeOrder(@PathVariable Integer userId) {
    orderService.placeOrder(userId);
  }

}
