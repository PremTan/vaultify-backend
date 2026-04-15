package com.vaultify.common.enums;

import lombok.Getter;

@Getter
public enum GenderEnums {

        MALE("Male"),
        FEMALE("Female"),
        OTHER("Others");

        private final String label;

        GenderEnums(String label) {
            this.label = label;
        }

}