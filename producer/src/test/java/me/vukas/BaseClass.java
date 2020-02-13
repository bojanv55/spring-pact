package me.vukas;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import me.vukas.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseClass {

  @Autowired
  HomeController homeController;

  @BeforeEach
  public void setup(){
    RestAssuredMockMvc.standaloneSetup(homeController);
  }

}
