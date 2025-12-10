package com.sct.demo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.sct.demo.context.TenantContext;
import com.sct.demo.context.UserContext;

import reactor.core.publisher.Mono;

@Component
public class ContextFilter implements WebFilter {

    private static final String TENANT_HEADER = "X-Tenant-Id";
    private static final String USER_HEADER = "X-User-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String tenantId = exchange.getRequest().getHeaders().getFirst(TENANT_HEADER);
        if (tenantId != null && !tenantId.isBlank()) {
            TenantContext.setId(Long.parseLong(tenantId));
        }
        String userId = exchange.getRequest().getHeaders().getFirst(USER_HEADER);
        if (userId != null && !userId.isBlank()) {
            UserContext.setId(Long.parseLong(userId));
        }
        return chain.filter(exchange).doFinally(signalType -> {
            TenantContext.clear();
            UserContext.clear();
        });
    }

}
