package com.en.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebCfg implements WebMvcConfigurer {
  @Autowired
  private EnProperties properties;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // /**表示对应所有的路径开放全局跨域访问权限
    registry.addMapping("/**")
            // 开放哪些IP、端口、域名的访问权限
            .allowedOrigins(properties.getCfg().getCorsOrigins())
            // .allowedOrigins("*")
            // 是否允许发送Cookie信息
            .allowCredentials(true)
            // 哪些HTTP方法允许跨域访问
            .allowedMethods("GET", "POST")
            .allowedHeaders("*");

  }
}
