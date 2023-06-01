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

    @Column(name="name",nullable = false,unique = true)
    private String companyName;

}
