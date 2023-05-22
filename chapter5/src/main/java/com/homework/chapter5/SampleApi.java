package com.homework.chapter5;

import com.homework.chapter5.exception.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleApi {

  @GetMapping
  public Member test(@RequestParam String value) {
    if(value.equals("value")) {
      throw new EntityNotFoundException(ErrorCode.INVALID_INPUT_VALUE);
    }else if(value.equals("none")){
      throw new IllegalStateException("절시구 저절시구 에러");
    }
    else{
      return  new Member("Park", "abc@abc.com");
    }
  }

  @PostMapping
  public void test2(@RequestBody @Valid Member member) {


  }




  @Getter
  @AllArgsConstructor
 public static class Member {
    @NotEmpty
   private String name;
    @Email
   private String email;

 }
}
