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
@Table(name="Skill")
public class Skill {

    @Id
    @Column(name="skill_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int skillId;

    @Column(name="skill_name")
    private String skillName;

    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="job_listing_id", nullable = false)
    private JobListing jobListing;
}
