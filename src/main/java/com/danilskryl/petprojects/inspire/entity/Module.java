package com.danilskryl.petprojects.inspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "module", schema = "inspire")
public class Module extends BaseEntity implements Serializable {

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1000, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "module")
    private Set<Chapter> chapters;
}
