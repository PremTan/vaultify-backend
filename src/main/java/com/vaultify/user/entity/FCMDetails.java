package com.vaultify.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;

@Setter
@Getter
@Entity
@Table(name = "fcm_details")
@NamedQuery(name = "FCMDetails.findAll", query = "SELECT p FROM FCMDetails p")
public class FCMDetails {

    private static final long serialVersionUID = -5526771250610713578L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "fcm_id", unique = true, nullable = false)
    private Long tokenId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @Column(name = "notification_token", nullable = false)
    private String notificationToken;

    @Column(name = "device_type", nullable = false)
    private String deviceType;

    @Column(name = "imei", nullable = true)
    private String imei;

    @Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP", updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    public void beforePersist() {
        this.createdDate = now();
    }
}
