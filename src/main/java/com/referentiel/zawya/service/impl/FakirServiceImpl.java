package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawiya;
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
        Zawiya zawiya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
        return zawiya.getFoukaras();
    }

    @Override
    public Fakir createFakir(Long zawyaId, FakirRequest fakirRequest) {
        Zawiya zawiya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException("Zawya not found !"));
        zawiya.addFakir(FakirMapper.toEntity(fakirRequest));
        zawiya = zawyaRepository.save(zawiya);
        List<Fakir> foukaras = zawiya.getFoukaras();
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
        Zawiya zawiya = fakir.getZawiya();
        zawiya.removeFakir(fakir);
        zawyaRepository.save(zawiya);
        fakirRepository.delete(fakir);
    }
}
