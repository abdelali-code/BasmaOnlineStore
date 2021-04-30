package ma.bsamashop.getwayservice;

//import ma.bsamashop.getwayservice.AuthFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GetwayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayServiceApplication.class, args);
    }


    @Bean
    public AuthFilter zuulFilter() {
        return new AuthFilter();
    }


    @Bean
    public RoleFilter roleFilter() {
        return new RoleFilter();
    }
}
