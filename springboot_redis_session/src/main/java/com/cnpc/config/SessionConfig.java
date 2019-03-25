package com.cnpc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
/*
maxInactiveIntervalInSeconds: 设置 Session 失效时间，使⽤用 Redis Session 之后，原 Spring Boot 中
的 server.session.timeout 属性不不再⽣生效。
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
