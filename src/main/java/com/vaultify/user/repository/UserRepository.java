package com.vaultify.user.repository;

import com.vaultify.user.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserMaster, Long> {

    Optional<UserMaster> findByEmail(String email);

    boolean existsByEmail(String email);
//    Optional<UserMaster> findByEmail(String email);

    Optional<UserMaster> findByMobile(String mobile);
//
    Optional<UserMaster> findByEmailOrMobile(String email, String mobile);

}