package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.AlreadyExistsException;
import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;
import com.referentiel.zawya.repository.ZawyaRepository;
import com.referentiel.zawya.service.ZawyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZawyaServiceImpl implements ZawyaService {

    @Autowired
    private ZawyaRepository zawyaRepository;

    @Override
    public List<Zawya> getAllZawyas() {
        return zawyaRepository.findAll();
    }

    @Override
    public Zawya createZawya(ZawyaRequest zawyaRequest) {
        if (zawyaRepository.existsByName(zawyaRequest.getName())) {
            throw new AlreadyExistsException("Zawya already exists !");
        }
        return zawyaRepository.save(ZawyaMapper.toEntity(zawyaRequest));
    }

    @Override
    public Zawya updateZawya(Long zawyaId, ZawyaRequest zawyaRequest) {
        Zawya zawya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
        ZawyaMapper.oldToNew(zawya, zawyaRequest);
        return zawyaRepository.save(zawya);
    }

    @Override
    public void deleteZawya(Long zawyaId) {
        if (!zawyaRepository.existsById(zawyaId)) {
            throw new NotFoundException("Zawya not found !");
        }
        zawyaRepository.deleteById(zawyaId);
        if (zawyaRepository.existsById(zawyaId)) {
            throw new AlreadyExistsException("Zawya was not deleted !");
        }
    }

    @Override
    public Zawya getZawya(Long zawyaId) {
        return zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
    }
}
