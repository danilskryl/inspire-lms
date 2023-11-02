package com.danilskryl.petprojects.inspire.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.danilskryl.petprojects.inspire.entity.Permission.*;

@RequiredArgsConstructor
@Getter
public enum Role {
    STUDENT(Collections.emptySet()),
    TEACHER(Set.of(
            TEACHER_CREATE,
            TEACHER_DELETE,
            TEACHER_UPDATE,
            TEACHER_READ
    )),
    ADMIN(Set.of(
            ADMIN_CREATE,
            ADMIN_DELETE,
            ADMIN_UPDATE,
            ADMIN_READ
    )),
    OWNER(Set.of(
            ADMIN_CREATE,
            ADMIN_DELETE,
            ADMIN_UPDATE,
            ADMIN_READ,
            TEACHER_CREATE,
            TEACHER_DELETE,
            TEACHER_UPDATE,
            TEACHER_READ
    ));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = new ArrayList<>(getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
