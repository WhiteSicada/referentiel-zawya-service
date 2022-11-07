package com.referentiel.zawya.repository;

import com.referentiel.zawya.model.Zawiya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZawyaRepository extends JpaRepository<Zawiya,Long> {
    boolean existsByName(String name);
}
