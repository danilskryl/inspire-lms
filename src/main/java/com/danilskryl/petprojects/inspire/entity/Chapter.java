package com.danilskryl.petprojects.inspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chapter", schema = "inspire")
public class Chapter extends BaseEntity implements Serializable {

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "content", nullable = false, length = 3000, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @OneToMany(mappedBy = "chapter")
    private Set<Task> tasks;
}
