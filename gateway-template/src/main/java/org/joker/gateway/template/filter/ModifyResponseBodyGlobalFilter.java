package org.joker.gateway.template.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class ModifyResponseBodyGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyResponseBodyGlobalFilter.class);

    private GatewayFilter modifyResponseBodyGatewayFilter;

    public ModifyResponseBodyGlobalFilter(ModifyResponseBodyGatewayFilterFactory modifyResponseBodyGatewayFilterFactory) {
        ModifyResponseBodyGatewayFilterFactory.Config config = new ModifyResponseBodyGatewayFilterFactory.Config();
        config.setRewriteFunction(Object.class, Object.class, (exchange, o) -> Mono.just(o));
        config.setNewContentType(MediaType.TEXT_PLAIN.getType());
        modifyResponseBodyGatewayFilter = modifyResponseBodyGatewayFilterFactory.apply(config);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("Modify response body");
        return modifyResponseBodyGatewayFilter.filter(exchange, chain);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
