package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.FakirRequest;
import com.referentiel.zawya.repository.FakirRepository;
import com.referentiel.zawya.repository.ZawyaRepository;
import com.referentiel.zawya.service.FakirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakirServiceImpl implements FakirService {


    // REPOSITORIES
    @Autowired
    private FakirRepository fakirRepository;

    @Autowired
    private ZawyaRepository zawyaRepository;

    @Override
    public List<Fakir> getAllFoukaras(Long zawyaId) {
        Zawya zawya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
        return zawya.getFoukaras();
    }

    @Override
    public Fakir createFakir(Long zawyaId, FakirRequest fakirRequest) {
        Zawya zawya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
        zawya.addFakir(FakirMapper.toEntity(fakirRequest));
        zawya = zawyaRepository.save(zawya);
        List<Fakir> foukaras = zawya.getFoukaras();
        return foukaras.get(foukaras.size() - 1);
    }

    @Override
    public Fakir updateFakir(Long fakirId, FakirRequest fakirRequest) {
        Fakir fakir = fakirRepository.findById(fakirId)
                .orElseThrow(() -> new NotFoundException("Fakir not found !"));
        FakirMapper.oldToNew(fakir, fakirRequest);
        return fakirRepository.save(fakir);
    }

    @Override
    public void deleteFakir(Long fakirId) {
        Fakir fakir = fakirRepository.findById(fakirId)
                .orElseThrow(() -> new NotFoundException("Fakir not found !"));
        Zawya zawya = fakir.getZawya();
        zawya.removeFakir(fakir);
        zawyaRepository.save(zawya);
        fakirRepository.delete(fakir);
    }
}
