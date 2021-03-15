package com.magic.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Magic
 * @version V1.0.0
 * @Description:
 * @date 2021/3/13 23:53
 */
@Configuration
public class GateWayConfig {

    /*@Bean
    public GatewayFilter requestGatewayFilter(){

    }*/

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
