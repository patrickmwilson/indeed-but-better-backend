package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Education")
public class Education {

    @Id
    @Column(name="education_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int educationId;

    @Column(name="university_name",nullable = false)
    private String universityName;

    @Column(name="degree_type",nullable = false)
    private String degreeType;

    @Column(name="major_name",nullable = false)
    private String majorName;

    @Column(name="gpa",nullable = false)
    private Double gpa;

    @Column(name="description")
    private String description;

    /*@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="user_fk")
    private User user;*/
}
