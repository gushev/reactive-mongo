package com.beats.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SamplesServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SamplesServiceApplication.class, args);
  }

}
