package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.dto.request.FakirReqDTO;
import com.referentiel.zawya.repository.FakirRepository;
import com.referentiel.zawya.repository.ZawyaRepository;
import com.referentiel.zawya.service.FakirService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.referentiel.zawya.utils.Constants.BaseResponseErrorMessages.getFakirNotFound;
import static com.referentiel.zawya.utils.Constants.BaseResponseErrorMessages.getZawiyaNotFound;

@Slf4j
@Service
@RequiredArgsConstructor
public class FakirServiceImpl implements FakirService {
    private final FakirRepository fakirRepository;
    private final ZawyaRepository zawyaRepository;

    @Override
    public List<Fakir> getAllFoukaras(Long zawyaId) {
        Zawiya zawiya = zawyaRepository.findById(zawyaId).orElseThrow(() -> new NotFoundException(getZawiyaNotFound()));
        return zawiya.getFoukaras();
    }

    @Override
    public Fakir createFakir(Long zawyaId, FakirReqDTO fakirReqDTO) {
        Zawiya zawiya = zawyaRepository.findById(zawyaId).orElseThrow(() -> new NotFoundException(getZawiyaNotFound()));
        zawiya.addFakir(FakirMapper.toEntity(fakirReqDTO));
        zawiya = zawyaRepository.save(zawiya);
        List<Fakir> foukaras = zawiya.getFoukaras();
        return foukaras.get(foukaras.size() - 1);
    }

    @Override
    public Fakir updateFakir(Long fakirId, FakirReqDTO fakirReqDTO) {
        Fakir fakir = fakirRepository.findById(fakirId).orElseThrow(() -> new NotFoundException(getFakirNotFound()));
        return fakirRepository.save(FakirMapper.oldToNew(fakir, fakirReqDTO));
    }

    @Override
    public void deleteFakir(Long fakirId) {
        Fakir fakir = fakirRepository.findById(fakirId).orElseThrow(() -> new NotFoundException(getFakirNotFound()));
        Zawiya zawiya = fakir.getZawiya();
        zawiya.removeFakir(fakir);
        zawyaRepository.save(zawiya);
        fakirRepository.delete(fakir);
    }
}
