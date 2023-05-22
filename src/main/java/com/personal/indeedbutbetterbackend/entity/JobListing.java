package com.personal.indeedbutbetterbackend.entity;

import lombok.*;

import jakarta.persistence.*;

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
}
