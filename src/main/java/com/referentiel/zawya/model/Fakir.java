package com.referentiel.zawya.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class Fakir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String idCard;

    private String profession;

    private String address;

    private String macPhoneAddress;

    // A CAR BELONGS TO A STUDENT
    @ManyToOne()
    @JoinColumn(name = "zawya_id")
    private Zawya zawya;

}