package com.sct.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class HttpInterfacesConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("RESPONSE: {} {} {}", clientResponse.request().getMethod(), clientResponse.request().getURI(),
                    clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }

    @Configuration
    public class DemoRepositoryServerHttpInterfacesConfigurator
            extends com.sct.demo.client.config.HttpInterfacesAbstractConfigurator {
        @Override
        protected WebClient getWebClient() {
            return loadBalancedWebClientBuilder()
                    .baseUrl("http://demo-repository-server")
                    .filter(logResponse())
                    .build();
        }
    }

    @Configuration
    public class SystemRepositoryServerHttpInterfacesConfigurator
            extends com.sct.system.client.config.HttpInterfacesAbstractConfigurator {
        @Override
        protected WebClient getWebClient() {
            return loadBalancedWebClientBuilder()
                    .baseUrl("http://system-repository-server")
                    .filter(logResponse())
                    .build();
        }
    }

}
