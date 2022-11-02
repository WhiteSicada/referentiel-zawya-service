package com.referentiel.zawya.repository;

import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZawyaRepository extends JpaRepository<Zawya,Long> {
    boolean existsByName(String name);
}
