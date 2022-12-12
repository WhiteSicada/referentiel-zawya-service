package com.referentiel.zawya.service;

import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.dto.request.FakirReqDTO;

import java.util.List;

public interface FakirService {
    List<Fakir> getAllFoukaras(Long zawyaId);

    Fakir createFakir(Long zawyaId, FakirReqDTO fakirReqDTO);

    Fakir updateFakir(Long fakirId, FakirReqDTO fakirReqDTO);

    void deleteFakir(Long fakirId);

}
