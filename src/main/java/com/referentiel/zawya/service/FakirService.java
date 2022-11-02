package com.referentiel.zawya.service;

import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.payload.request.FakirRequest;
import com.referentiel.zawya.payload.response.FakirResponse;

import java.util.List;

public interface FakirService {
    List<Fakir> getAllFoukaras(Long zawyaId);

    Fakir createFakir(Long zawyaId, FakirRequest fakirRequest);

    Fakir updateFakir(Long fakirId, FakirRequest fakirRequest);

    void deleteFakir(Long fakirId);

}
