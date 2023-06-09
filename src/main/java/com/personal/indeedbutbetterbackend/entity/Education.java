package com.personal.indeedbutbetterbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name="graduation_year")
    private String graduationYear;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
