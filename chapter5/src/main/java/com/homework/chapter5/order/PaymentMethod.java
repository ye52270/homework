package com.homework.chapter5.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
enum PaymentMethod {
  CARD("카드"),
  BANK_TRANSFER("무통장");
  private final String description;
}
