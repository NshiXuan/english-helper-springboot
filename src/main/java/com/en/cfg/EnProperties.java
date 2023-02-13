package com.en.cfg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("en")
@Component
@Data
public class EnProperties {
  private Cfg cfg;

  @Data
  public static class Cfg{
    private String[] corsOrigins;
  }
}
