package com.ycode.cdcr;

import com.apple.eawt.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YangLin
 * @createTime 2022/01/07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicantcloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApplicantcloudApplication.class,args);
  }
}
