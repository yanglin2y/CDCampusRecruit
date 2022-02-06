package com.ycode.cdcr.entcloud.config;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author YangLin
 * @createTime 2022/01/14
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

  @Override
  protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    for (HttpMessageConverter<?> converter : converters) {
      // 解决controller返回普通文本中文乱码问题
      if (converter instanceof StringHttpMessageConverter) {
        ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
      }
      // 解决controller返回json对象中文乱码问题
      if (converter instanceof MappingJackson2HttpMessageConverter) {
        ((MappingJackson2HttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
      }
    }
  }
}

