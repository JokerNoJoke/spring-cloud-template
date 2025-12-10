package com.sct.demo.context;

public class TenantContext {

    private static final ThreadLocal<Long> CURRENT_TENANT = new ThreadLocal<>();

    public static Long getId() {
        return CURRENT_TENANT.get();
    }

    public static void setId(Long id) {
        CURRENT_TENANT.set(id);
    }

    public static void clear() {
        CURRENT_TENANT.remove();
    }

}
