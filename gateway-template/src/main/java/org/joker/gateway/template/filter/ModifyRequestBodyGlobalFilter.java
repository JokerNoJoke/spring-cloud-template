package org.joker.gateway.template.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import reactor.core.publisher.Mono;

@Configuration
public class ModifyRequestBodyGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyRequestBodyGlobalFilter.class);

    private GatewayFilter modifyRequestBodyGatewayFilter;

    public ModifyRequestBodyGlobalFilter(ModifyRequestBodyGatewayFilterFactory modifyRequestBodyGatewayFilterFactory) {
        ModifyRequestBodyGatewayFilterFactory.Config config = new ModifyRequestBodyGatewayFilterFactory.Config();
        config.setRewriteFunction(Object.class, Object.class, (exchange, o) -> Mono.just(o));
        config.setContentType(MediaType.APPLICATION_JSON.getType());
        modifyRequestBodyGatewayFilter = modifyRequestBodyGatewayFilterFactory.apply(config);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if (headers.containsKey(HttpHeaderNames.CONTENT_TYPE.toString())) {
            if (headers.get(HttpHeaderNames.CONTENT_TYPE.toString())
                    .contains(HttpHeaderValues.APPLICATION_JSON.toString())) {
                LOGGER.info("Modify request body");
                return modifyRequestBodyGatewayFilter.filter(exchange, chain);
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 2;
    }

}
