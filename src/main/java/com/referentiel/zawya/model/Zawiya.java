package com.referentiel.zawya.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zawiya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "imageType")
    private String imageType;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    // STUDENT HAVE MANY CARS
    @OneToMany(mappedBy = "zawiya", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fakir> foukaras = new ArrayList<>();


    public void addFakir(Fakir fakir) {
        this.getFoukaras().add(fakir);
        fakir.setZawiya(this);
    }

    public void removeFakir(Fakir fakir) {
        this.getFoukaras().remove(fakir);
        fakir.setZawiya(null);
    }
}
