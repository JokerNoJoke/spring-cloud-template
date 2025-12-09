package com.sct.system.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.context.annotation.Configuration;

import com.sct.system.context.TenantContext;

@Configuration
public class HibernateCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver<Long> {

    @Override
    public Long resolveCurrentTenantIdentifier() {
        Long tenantId = TenantContext.getId();
        return tenantId == null ? 0L : tenantId;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

}
