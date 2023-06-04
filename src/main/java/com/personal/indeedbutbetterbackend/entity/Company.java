package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Company")
public class Company {

    @Id
    @Column(name="company_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int companyId;

    @Column(name="name", nullable = false,unique = true)
    private String name;

    @Column(name="size")
    private String size;

    @Column(name="industry")
    private String industry;

    @Column(name="location", nullable = false)
    private String location;
}
