package com.vaultify.common.repository;

import com.vaultify.common.entity.CountrycodeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountrycodeRepository  extends JpaRepository<CountrycodeMaster, Integer> {

    Optional<CountrycodeMaster> findByCountryCode(String string);

    Optional<CountrycodeMaster> findByCountryName(String countryName);
}