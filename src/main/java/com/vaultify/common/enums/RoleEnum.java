package com.vaultify.common.enums;

import com.vaultify.common.constants.RoleConst;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {

    ADMIN(RoleConst.ADMIN),
    USER(RoleConst.USER),
    ANONYMOUS(RoleConst.ANONYMOUS),
    OTHER(RoleConst.OTHER);

    private final String val ;

    public String val() {
        return val;
    }

    public static RoleEnum getRole(String role) {

        return switch (role) {
            case RoleConst.ROLE_PREFIX + RoleConst.ADMIN -> ADMIN;
            case RoleConst.ROLE_PREFIX + RoleConst.USER -> USER;
            default -> USER;
        };
    }
}
