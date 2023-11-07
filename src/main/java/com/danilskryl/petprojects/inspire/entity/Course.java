package com.danilskryl.petprojects.inspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course", schema = "inspire")
public class Course extends BaseEntity implements Serializable {

    @ManyToOne
    private User author;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1000, columnDefinition = "TEXT")
    private String description;

    @Column(name = "course_duration", nullable = false, columnDefinition = "TIME")
    private LocalTime courseDuration;

    @OneToMany(mappedBy = "course")
    private Set<Module> modules;

    @ManyToMany(mappedBy = "courses")
    private Set<User> users;
}
