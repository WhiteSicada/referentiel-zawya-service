package com.referentiel.zawya.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Zawya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String city;

    // STUDENT HAVE MANY CARS
    @OneToMany(mappedBy = "zawya", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fakir> foukaras = new ArrayList<>();


    public void addFakir(Fakir fakir) {
        this.getFoukaras().add(fakir);
        fakir.setZawya(this);
    }

    public void removeFakir(Fakir fakir) {
        this.getFoukaras().remove(fakir);
        fakir.setZawya(null);
    }
}
