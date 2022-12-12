package com.referentiel.zawya.controller;

import com.referentiel.zawya.dto.BaseResponseDTO;
import com.referentiel.zawya.dto.request.FakirReqDTO;
import com.referentiel.zawya.mapper.FakirMapper;
import com.referentiel.zawya.service.FakirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/referentiel")
@RequiredArgsConstructor
public class FakirController {

    private final FakirService fakirService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/zawyas/{zawyaId}/foukaras")
    public BaseResponseDTO getAllFoukaras(@PathVariable Long zawyaId) {
        return FakirMapper.toFakirDTOs(fakirService.getAllFoukaras(zawyaId));
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/zawyas/{zawyaId}/foukaras")
    public BaseResponseDTO createFakir(@PathVariable Long zawyaId, @Valid @RequestBody FakirReqDTO fakirReqDTO) {
        return FakirMapper.toFakirDTO(fakirService.createFakir(zawyaId, fakirReqDTO));
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/foukaras/{fakirId}")
    public BaseResponseDTO updateFakir(@PathVariable Long fakirId, @Valid @RequestBody FakirReqDTO fakirReqDTO) {
        return FakirMapper.toFakirDTO(fakirService.updateFakir(fakirId, fakirReqDTO));
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/foukaras/{fakirId}")
    public void deleteFakir(@PathVariable Long fakirId) {
        fakirService.deleteFakir(fakirId);
    }


}
