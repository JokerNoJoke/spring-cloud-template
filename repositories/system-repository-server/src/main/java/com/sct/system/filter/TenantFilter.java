package com.sct.system.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.sct.system.context.TenantContext;

import reactor.core.publisher.Mono;

@Component
public class TenantFilter implements WebFilter {

    private static final String TENANT_HEADER = "X-Tenant-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String tenantId = exchange.getRequest().getHeaders().getFirst(TENANT_HEADER);
        if (tenantId != null && !tenantId.isBlank()) {
            TenantContext.setId(Long.parseLong(tenantId));
        }
        return chain.filter(exchange).doFinally(signalType -> TenantContext.clear());
    }

}
