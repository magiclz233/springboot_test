package com.cnpc.comm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "neo")
@Data
public class CnpcProperties {

    private String title;
    private String description;
}
