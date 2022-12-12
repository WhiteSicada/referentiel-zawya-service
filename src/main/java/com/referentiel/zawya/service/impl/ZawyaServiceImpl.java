package com.referentiel.zawya.service.impl;

import com.referentiel.zawya.exception.AlreadyExistsException;
import com.referentiel.zawya.exception.NotFoundException;
import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.dto.request.ZawyaReqDTO;
import com.referentiel.zawya.repository.ZawyaRepository;
import com.referentiel.zawya.service.ZawyaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.referentiel.zawya.utils.Constants.BaseResponseErrorMessages.getZawiyaAlreadyExists;
import static com.referentiel.zawya.utils.Constants.BaseResponseErrorMessages.getZawiyaNotFound;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZawyaServiceImpl implements ZawyaService {

    private final ZawyaRepository zawyaRepository;

    @Override
    public List<Zawiya> getAllZawiyas() {
        return zawyaRepository.findAll();
    }

    @Override
    public Zawiya createZawiya(ZawyaReqDTO zawyaReqDTO, MultipartFile image) throws IOException {
        if (zawyaRepository.existsByName(zawyaReqDTO.getName()))
            throw new AlreadyExistsException(getZawiyaAlreadyExists());
        return zawyaRepository.save(ZawyaMapper.toEntity(zawyaReqDTO, image));
    }

    @Override
    public Zawiya updateZawiya(Long zawyaId, ZawyaReqDTO zawyaReqDTO) {
        Zawiya zawiya = zawyaRepository.findById(zawyaId).orElseThrow(() -> new NotFoundException(getZawiyaNotFound()));
        ZawyaMapper.oldToNew(zawiya, zawyaReqDTO);
        return zawyaRepository.save(zawiya);
    }

    @Override
    public void deleteZawiya(Long zawyaId) {
        if (!zawyaRepository.existsById(zawyaId))
            throw new NotFoundException(getZawiyaNotFound());
        zawyaRepository.deleteById(zawyaId);
    }

    @Override
    public Zawiya getZawiya(Long zawyaId) {
        return zawyaRepository.findById(zawyaId).orElseThrow(() -> new NotFoundException(getZawiyaNotFound()));
    }
}
