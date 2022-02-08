package com.ycode.cdcr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YangLin
 * @createTime 2022/01/25
 */
@SpringBootApplication()
@EnableDiscoveryClient
@MapperScan("com.ycode.cdcr.base.mapper")
public class HrApplication {

  public static void main(String[] args) {
    SpringApplication.run(HrApplication.class,args);
  }
}
