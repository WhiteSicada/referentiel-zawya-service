package com.referentiel.zawya.repository;

import com.referentiel.zawya.model.Fakir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakirRepository extends JpaRepository<Fakir,Long> {
}
