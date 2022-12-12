package com.referentiel.zawya.controller;

import com.referentiel.zawya.dto.BaseResponseDTO;
import com.referentiel.zawya.dto.request.ZawyaReqDTO;
import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.service.ZawyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/referentiel")
@RequiredArgsConstructor
public class ZawiyaController {

    private final ZawyaService zawyaService;

    @GetMapping("/zawiyas")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDTO getAllZawiyas() {
        return ZawyaMapper.toDTOs(zawyaService.getAllZawiyas());
    }

    @PostMapping("/zawiyas")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDTO createZawiya(
            @RequestParam String name,
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam String address,
            @RequestParam MultipartFile image) throws IOException {
        return ZawyaMapper.toDTO(zawyaService.createZawiya(ZawyaMapper.toRequest(name, city, country, address), image));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawiyas/{zawiyaId}")
    public BaseResponseDTO getZawiya(@PathVariable Long zawiyaId) {
        return ZawyaMapper.toDTO(zawyaService.getZawiya(zawiyaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawiyasDetails/{zawiyaId}")
    public BaseResponseDTO getZawiyaWithFoukaras(@PathVariable Long zawiyaId) {
        return ZawyaMapper.toDetailedDTO(zawyaService.getZawiya(zawiyaId));
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/zawiyas/{zawiyaId}")
    public BaseResponseDTO updateZawiya(@PathVariable Long zawiyaId, @RequestBody ZawyaReqDTO zawyaReqDTO) {
        Zawiya zawiya = zawyaService.updateZawiya(zawiyaId, zawyaReqDTO);
        return ZawyaMapper.toDTO(zawiya);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/zawiyas/{zawiyaId}")
    public void deleteZawiya(@PathVariable Long zawiyaId) {
        zawyaService.deleteZawiya(zawiyaId);
    }

}
