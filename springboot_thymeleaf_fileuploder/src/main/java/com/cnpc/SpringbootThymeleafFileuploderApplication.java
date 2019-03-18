package com.cnpc;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@SpringBootApplication
public class SpringbootThymeleafFileuploderApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringbootThymeleafFileuploderApplication.class, args );
    }

    //TomcatServletWebServerFactory() ⽅方法主要是为了了解决上
    // 传⽂文件⼤大于 10M 出现连接重置的问题，此异常内
    //容 GlobalException 也捕获不不到
public TomcatServletWebServerFactory tomcatEmbedded(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(  );
        tomcat.addConnectorCustomizers( (TomcatConnectorCustomizer) connector -> {
            if(connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>){
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setMaxSwallowSize( -1 );
            }
        } );
        return tomcat;
}

}
