package com.ycode.cdcr;

import com.ycode.cdcr.netty.NettyServer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YangLin
 * @createTime 2022/02/08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NettyApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(NettyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ExecutorService pool= Executors.newSingleThreadExecutor();
    NettyServer nettyServer = new NettyServer();
    pool.submit(new Runnable() {
      @Override
      public void run() {
        try {
          nettyServer.start();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
