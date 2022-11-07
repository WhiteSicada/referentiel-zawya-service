package com.referentiel.zawya.controller;

import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.payload.request.FakirRequest;
import com.referentiel.zawya.payload.response.FakirResponse;
import com.referentiel.zawya.service.FakirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/referentiel")
public class FakirController {

    // SERVICES
    @Autowired
    private FakirService fakirService;

    // todo : ADD DOCUMENTATION
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawyas/{zawyaId}/foukaras")
    public List<FakirResponse> getAllFoukaras(@PathVariable Long zawyaId) {
        List<Fakir> allFoukaras = fakirService.getAllFoukaras(zawyaId);
        return FakirMapper.toDtos(allFoukaras);
    }

    // todo : ADD DOCUMENTATION
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/zawyas/{zawyaId}/foukaras")
    public FakirResponse createFakir(@PathVariable Long zawyaId, @Valid @RequestBody FakirRequest fakirRequest) {
        Fakir fakir = fakirService.createFakir(zawyaId, fakirRequest);
        return FakirMapper.toDto(fakir);
    }

    // todo : ADD DOCUMENTATION
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/foukaras/{fakirId}")
    public FakirResponse updateFakir(@PathVariable Long fakirId, @Valid @RequestBody FakirRequest fakirRequest) {
        Fakir fakir = fakirService.updateFakir(fakirId, fakirRequest);
        return FakirMapper.toDto(fakir);
    }

    // todo : ADD DOCUMENTATION
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/foukaras/{fakirId}")
    public void deleteFakir(@PathVariable Long fakirId) {
        fakirService.deleteFakir(fakirId);
    }


}
