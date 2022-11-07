package com.referentiel.zawya.service;

import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ZawyaService {

    List<Zawiya> getAllZawiyas();

    Zawiya createZawiya(ZawyaRequest zawyaRequest, MultipartFile image) throws IOException;

    Zawiya updateZawiya(Long zawyaId, ZawyaRequest zawyaRequest);

    void deleteZawiya(Long zawyaId);

    Zawiya getZawiya(Long zawyaId);
}
