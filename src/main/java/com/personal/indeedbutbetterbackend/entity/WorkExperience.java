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
@Table(name="Work_Experience")
public class WorkExperience {

    @Id
    @Column(name="work_experience_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int workExperienceId;

    @Column(name="job_title",nullable=false)
    private String jobTitle;

    @Column(name="company_name",nullable=false)
    private String companyName;

    @Column(name="start_date",nullable=false)
    private String startDate;

    @Column(name="end_date")
    private String endDate;

    @Column(name="description")
    private String description;

    @Column(name="location")
    private String location;

    @Column(name="sort_index")
    private Integer sortIndex;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
