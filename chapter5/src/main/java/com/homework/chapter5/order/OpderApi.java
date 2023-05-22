package com.homework.chapter5.order;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 주문
 * 1. 주문에 대한 결제는 무통장(account), 카드(creditCard) 가 가능
 * 2. 결제 수단(무통장, 카드)는 상호배타적이며 필수로 한개는 선택해야함
 * 3. 무통장(account) 필수값 : 계좌번호(accountNumber), bankCode, holder
 * 4. 신용카드(creditCard) 필수값 : number, brand, csv
 */
@RestController
@RequestMapping("/orders")
public class OpderApi {
  @PostMapping
  public OrderSheetRequest order(@RequestBody @Valid final OrderSheetRequest dto){
    return dto;
  }

}
