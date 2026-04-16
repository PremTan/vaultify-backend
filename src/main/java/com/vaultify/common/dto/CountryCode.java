package com.vaultify.common.dto;

import com.vaultify.common.validations.ValidAddUser;
import com.vaultify.common.validations.ValidEditUser;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CountryCode implements DtoMarker, Comparable<CountryCode> {

    @NotNull(message = "CountrycodeId is required.", groups = {ValidAddUser.class, ValidEditUser.class})
    private Integer countrycodeId;
    private String countryName;
    private String countryCode;
    private String countryFlag;
    private String currency;
    private String currencyCode;
    @Override
    public int compareTo(CountryCode o) {
        return Long.compare(countrycodeId, o.getCountrycodeId());
    }
}
