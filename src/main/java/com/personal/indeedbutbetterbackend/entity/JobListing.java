package com.personal.indeedbutbetterbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Job_Listing")
public class JobListing {

    @Id
    @Column(name="job_listing_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int jobListingId;

    @Column(name="job_title",nullable=false)
    private String jobTitle;

    @Column(name="description")
    private String description;

    @Column(name="salary")
    private double salary;

    @Column(name="location")
    private String location;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;

}
