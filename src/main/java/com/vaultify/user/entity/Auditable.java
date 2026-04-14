package com.vaultify.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//import static java.time.LocalDateTime.now;
//import static java.util.Objects.nonNull;
//import static org.springframework.security.core.context.SecurityContextHolder.getContext;


@Getter
@Setter
@MappedSuperclass
public abstract class Auditable {

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "deleted_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedDate;

//    @PrePersist
//    public void beforePersist() {
//        if (nonNull(getContext()) && nonNull(getContext().getAuthentication())
//                && nonNull(getContext().getAuthentication().getName())) {
//            this.createdBy = getContext().getAuthentication().getName();
//        }
//        this.createdDate = now();
//    }

//    @PreUpdate
//    public void beforeUpdate() {
//        if (nonNull(getContext()) && nonNull(getContext().getAuthentication())
//                && nonNull(getContext().getAuthentication().getName())) {
//            this.updatedBy = getContext().getAuthentication().getName();
//        }
//        this.updatedDate = now();
//    }
//
//    @PreRemove
//    public void beforeDelete() {
//        if (nonNull(getContext()) && nonNull(getContext().getAuthentication())
//                && nonNull(getContext().getAuthentication().getName())) {
//            this.deletedBy = getContext().getAuthentication().getName();
//        }
//        this.deletedDate = now();
//    }
}
