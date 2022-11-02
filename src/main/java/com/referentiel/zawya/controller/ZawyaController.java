package com.referentiel.zawya.controller;

import com.referentiel.zawya.mapper.ZawyaMapper;
import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;
import com.referentiel.zawya.service.ZawyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/zawyas")
@CrossOrigin(value = "*")
public class ZawyaController {

    // SERVICES
    @Autowired
    private ZawyaService zawyaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ZawyaResponse> getAllZawyas(){
        List<Zawya> zawyas = zawyaService.getAllZawyas();
        return ZawyaMapper.toDtos(zawyas);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ZawyaResponse createZawya(@Valid @RequestBody ZawyaRequest zawyaRequest){
        Zawya zawya = zawyaService.createZawya(zawyaRequest);
        return ZawyaMapper.toDto(zawya);
    }

    @GetMapping("/{zawyaId}")
    @ResponseStatus(HttpStatus.OK)
    public ZawyaDetailedResponse getZawya(@PathVariable Long zawyaId){
        Zawya zawya = zawyaService.getZawya(zawyaId);
        return ZawyaMapper.toDetailedDto(zawya);
    }

    @PutMapping("/{zawyaId}")
    @ResponseStatus(HttpStatus.OK)
    public ZawyaResponse updateZawya(@PathVariable Long zawyaId, @RequestBody ZawyaRequest studentRequest){
        Zawya zawya = zawyaService.updateZawya(zawyaId, studentRequest);
        return ZawyaMapper.toDto(zawya);
    }

    @DeleteMapping("{zawyaId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteZawya(@PathVariable Long zawyaId){
        zawyaService.deleteZawya(zawyaId);
    }


}
