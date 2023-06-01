package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="job_listing_id", nullable = false)
    private JobListing jobListing;
}
