package com.referentiel.zawya.controller;

import com.referentiel.zawya.dto.BaseResponseDTO;
import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.dto.request.FakirReqDTO;
import com.referentiel.zawya.service.FakirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/referentiel")
@RequiredArgsConstructor
public class FakirController {

    private final FakirService fakirService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawyas/{zawyaId}/foukaras")
    public BaseResponseDTO getAllFoukaras(@PathVariable Long zawyaId) {
        List<Fakir> allFoukaras = fakirService.getAllFoukaras(zawyaId);
        return FakirMapper.toFakirDTOs(allFoukaras);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/zawyas/{zawyaId}/foukaras")
    public BaseResponseDTO createFakir(@PathVariable Long zawyaId, @Valid @RequestBody FakirReqDTO fakirReqDTO) {
        Fakir fakir = fakirService.createFakir(zawyaId, fakirReqDTO);
        return FakirMapper.toFakirDTO(fakir);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/foukaras/{fakirId}")
    public BaseResponseDTO updateFakir(@PathVariable Long fakirId, @Valid @RequestBody FakirReqDTO fakirReqDTO) {
        Fakir fakir = fakirService.updateFakir(fakirId, fakirReqDTO);
        return FakirMapper.toFakirDTO(fakir);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/foukaras/{fakirId}")
    public void deleteFakir(@PathVariable Long fakirId) {
        fakirService.deleteFakir(fakirId);
    }


}
