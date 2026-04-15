package com.vaultify.user.entity;

import com.vaultify.common.entity.Auditable;
import com.vaultify.common.dto.EntityMarker;
import com.vaultify.common.entity.CountrycodeMaster;
import com.vaultify.common.enums.GenderEnums;
import com.vaultify.common.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_user")
@NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u")
public class UserMaster extends Auditable implements Serializable, EntityMarker {

    private static final long serialVersionUID = -3537808561436160156L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name="user_name", length = 255)
    private String Username;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "mobile_number", nullable = false, length = 15)
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private GenderEnums gender;

    @Column(nullable = false, length = 250)
    private String password;

    private String profilePicture;

    @ManyToOne(fetch = LAZY, cascade = { DETACH })
    @JoinColumn(name = "country_code_id", nullable = false)
    private CountrycodeMaster countrycodeMaster;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

}
