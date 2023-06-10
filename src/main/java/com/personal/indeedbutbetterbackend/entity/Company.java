package com.personal.indeedbutbetterbackend.entity;

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
@Table(name="Company")
public class Company {

    @Id
    @Column(name="company_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name="name", nullable = false,unique = true)
    private String name;

    @Column(name="size")
    private String size;

    @Column(name="industry")
    private String industry;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;
}
