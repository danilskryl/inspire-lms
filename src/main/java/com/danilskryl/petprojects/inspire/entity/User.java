package com.danilskryl.petprojects.inspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "inspire")
public class User extends BaseEntity implements Serializable {

    @Column(name = "username", nullable = false, length = 25, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 25)
    private String password;

    @Column(name = "firstname", nullable = false, length = 25)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 25)
    private String lastname;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

    @Enumerated(EnumType.STRING)
    private Role role;

    public String getFullName() {
        return firstname + " " + lastname;
    }

    public List<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
}
