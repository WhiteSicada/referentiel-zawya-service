package com.referentiel.zawya.controller;

import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawiyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;
import com.referentiel.zawya.service.ZawyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/referentiel")
public class ZawyaController {

    // SERVICES
    @Autowired
    private ZawyaService zawyaService;

    @GetMapping("/zawiyas")
    @ResponseStatus(HttpStatus.OK)
    public List<ZawyaResponse> getAllZawiyas() {
        List<Zawiya> zawiyas = zawyaService.getAllZawiyas();
        return ZawyaMapper.toDtos(zawiyas);
    }

    @PostMapping("/zawiyas")
    @ResponseStatus(HttpStatus.OK)
    public ZawyaResponse createZawiya(
            @RequestParam String name,
            @RequestParam String country,
            @RequestParam String city,
            @RequestParam MultipartFile image) throws IOException {
        Zawiya zawiya = zawyaService.createZawiya(ZawyaMapper.toRequest(name, city, country), image);
        return ZawyaMapper.toDto(zawiya);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawiyas/{zawiyaId}")
    public ZawyaResponse getZawiya(@PathVariable Long zawiyaId) {
        Zawiya zawiya = zawyaService.getZawiya(zawiyaId);
        return ZawyaMapper.toDto(zawiya);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawiyasDetails/{zawiyaId}")
    public ZawiyaDetailedResponse getZawiyaWithFoukaras(@PathVariable Long zawiyaId) {
        Zawiya zawiya = zawyaService.getZawiya(zawiyaId);
        return ZawyaMapper.toDetailedDto(zawiya);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/zawiyas/{zawiyaId}")
    public ZawyaResponse updateZawiya(@PathVariable Long zawiyaId, @RequestBody ZawyaRequest zawyaRequest) {
        Zawiya zawiya = zawyaService.updateZawiya(zawiyaId, zawyaRequest);
        return ZawyaMapper.toDto(zawiya);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/zawiyas/{zawiyaId}")
    public void deleteZawiya(@PathVariable Long zawiyaId) {
        zawyaService.deleteZawiya(zawiyaId);
    }


}
