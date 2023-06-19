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

    @Column(name="skill_name",nullable = false)
    private String skillName;

    @Column(name="sort_index")
    private Integer sortIndex;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="job_listing_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JobListing jobListing;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Skill)) {
            return false;
        }
        Skill s = (Skill) o;
        return this.skillName.equals(s.getSkillName());
    }
}
