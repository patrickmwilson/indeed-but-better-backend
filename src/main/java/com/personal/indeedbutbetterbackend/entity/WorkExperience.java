package com.personal.indeedbutbetterbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @Column(name="end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @Column(name="description")
    private String description;

    /*@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name="user_fk")
    private User user;*/
}
