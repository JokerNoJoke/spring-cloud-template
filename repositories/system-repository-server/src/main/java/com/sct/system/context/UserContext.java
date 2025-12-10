package com.sct.system.context;

public class UserContext {

    private static final ThreadLocal<Long> CURRENT_USER = new ThreadLocal<>();

    public static Long getId() {
        return CURRENT_USER.get();
    }

    public static void setId(Long id) {
        CURRENT_USER.set(id);
    }

    public static void clear() {
        CURRENT_USER.remove();
    }

}
