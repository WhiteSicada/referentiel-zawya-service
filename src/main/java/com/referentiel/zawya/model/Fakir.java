package com.referentiel.zawya.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    // A CAR BELONGS TO A STUDENT
    @ManyToOne()
    @JoinColumn(name = "zawiya_id")
    private Zawiya zawiya;

}
