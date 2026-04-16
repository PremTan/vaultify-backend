package com.vaultify.common.entity;

import com.vaultify.user.entity.UserMaster;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "countrycode_master")
@NamedQuery(name = "CountrycodeMaster.findAll", query = "SELECT a FROM CountrycodeMaster a")
public class CountrycodeMaster implements Serializable {

    private static final long serialVersionUID = -8961881903511441110L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "country_code_id", unique = true, nullable = false)
    private Integer countrycodeId;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    private String countryFlag;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "currency", nullable = false)
    private String currency;

    @OneToMany(mappedBy = "countrycodeMaster")
    private Set<UserMaster> userMasters = new HashSet<>();

}

