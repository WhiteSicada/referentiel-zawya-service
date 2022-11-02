package com.referentiel.zawya.service;

import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;

import java.util.List;

public interface ZawyaService {

    List<Zawya> getAllZawyas();

    Zawya createZawya(ZawyaRequest zawyaRequest);

    Zawya updateZawya(Long zawyaId, ZawyaRequest zawyaRequest);

    void deleteZawya(Long zawyaId);

    Zawya getZawya(Long zawyaId);
}
