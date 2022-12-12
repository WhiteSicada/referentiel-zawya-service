package com.referentiel.zawya.service;

import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.dto.request.ZawyaReqDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ZawyaService {

    List<Zawiya> getAllZawiyas();

    Zawiya createZawiya(ZawyaReqDTO zawyaReqDTO, MultipartFile image) throws IOException;

    Zawiya updateZawiya(Long zawyaId, ZawyaReqDTO zawyaReqDTO);

    void deleteZawiya(Long zawyaId);

    Zawiya getZawiya(Long zawyaId);
}
