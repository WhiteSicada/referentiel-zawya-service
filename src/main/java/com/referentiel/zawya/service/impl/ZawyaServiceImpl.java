package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.AlreadyExistsException;
import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.repository.ZawyaRepository;
import com.referentiel.zawya.service.ZawyaService;
import com.referentiel.zawya.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ZawyaServiceImpl implements ZawyaService {

    @Autowired
    private ZawyaRepository zawyaRepository;

    @Override
    public List<Zawiya> getAllZawiyas() {
        return zawyaRepository.findAll();
    }

    @Override
    public Zawiya createZawiya(ZawyaRequest zawyaRequest, MultipartFile image) throws IOException {
        if (zawyaRepository.existsByName(zawyaRequest.getName())) {
            throw new AlreadyExistsException(Constants.BaseResponseErrorMessages.getZawiyaAlreadyExists());
        }
        return zawyaRepository.save(ZawyaMapper.toEntity(zawyaRequest,image));
    }

    @Override
    public Zawiya updateZawiya(Long zawyaId, ZawyaRequest zawyaRequest) {
        Zawiya zawiya = zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException(Constants.BaseResponseErrorMessages.getZawiyaNotFound()));
        ZawyaMapper.oldToNew(zawiya, zawyaRequest);
        return zawyaRepository.save(zawiya);
    }

    @Override
    public void deleteZawiya(Long zawyaId) {
        if (!zawyaRepository.existsById(zawyaId)) {
            throw new NotFoundException(Constants.BaseResponseErrorMessages.getZawiyaNotFound());
        }
        zawyaRepository.deleteById(zawyaId);
        if (zawyaRepository.existsById(zawyaId)) {
            throw new AlreadyExistsException(Constants.BaseResponseErrorMessages.getZawiyaWasNotDeleted());
        }
    }

    @Override
    public Zawiya getZawiya(Long zawyaId) {
        return zawyaRepository.findById(zawyaId)
                .orElseThrow(() -> new NotFoundException(Constants.BaseResponseErrorMessages.getZawiyaNotFound()));
    }
}
