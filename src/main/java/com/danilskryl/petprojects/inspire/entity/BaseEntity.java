package com.danilskryl.petprojects.inspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private Long id;

    @Column(name = "date_create", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateCreate;
    @Column(name = "date_update", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateUpdate;
    @Column(name = "date_remove", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateRemove;
    @Column(name = "user_update")
    private String userUpdate;
    @Column(name = "user_remove")
    private String userRemove;

    @PrePersist
    protected void onCreate() {
        dateCreate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdate = LocalDateTime.now();
    }

    @PreRemove
    protected void onRemove() {
        dateRemove = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(dateCreate, that.dateCreate) && Objects.equals(dateUpdate, that.dateUpdate) && Objects.equals(dateRemove, that.dateRemove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreate, dateUpdate, dateRemove);
    }
}