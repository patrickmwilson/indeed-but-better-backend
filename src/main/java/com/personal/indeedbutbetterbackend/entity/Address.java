package com.personal.indeedbutbetterbackend.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Address")
public class Address {

    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int addressId;

    @Column(name="street_address",nullable=false)
    private String streetAddress;

    @Column(name="city",nullable=false)
    private String city;

    @Column(name="state",nullable=false)
    private String state;

    @Column(name="zip_code",nullable=false)
    private int zipCode;


}
