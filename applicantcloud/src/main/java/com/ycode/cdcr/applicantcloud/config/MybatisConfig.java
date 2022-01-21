package com.ycode.cdcr.applicantcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
@EnableTransactionManagement
@Configuration
public class MybatisConfig {

//  @Bean
//  public MybatisPlusInterceptor mybatisPlusInterceptor() {
//    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//    return interceptor;
//  }

}
