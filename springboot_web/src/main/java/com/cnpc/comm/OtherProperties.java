package com.cnpc.comm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "other")
@PropertySource("classpath:other.properties")
public class OtherProperties {
    private String title;
    private String blog;
}
