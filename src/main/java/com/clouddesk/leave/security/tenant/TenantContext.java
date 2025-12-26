package com.clouddesk.leave.security.tenant;

public final class TenantContext {
    private static final ThreadLocal<Long> COMPANY_ID = new ThreadLocal<>();
    private TenantContext() {}

    public static void setCompanyId(Long id) { COMPANY_ID.set(id); }
    public static Long getCompanyId() { return COMPANY_ID.get(); }
    public static void clear() { COMPANY_ID.remove(); }
}