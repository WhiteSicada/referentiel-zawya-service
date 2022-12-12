package com.referentiel.zawya.mapper;

import com.referentiel.zawya.dto.BaseResponseDTO;
import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.dto.request.FakirReqDTO;
import com.referentiel.zawya.dto.response.FakirResDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FakirMapper extends BaseMapper {
    public static FakirResDTO toDto(Fakir fakir) {
        FakirResDTO response = new FakirResDTO();
        response.setId(fakir.getId());
        response.setFirstName(fakir.getFirstName());
        response.setLastName(fakir.getLastName());
        response.setEmail(fakir.getEmail());
        response.setPhoneNumber(fakir.getPhoneNumber());
        response.setIdCard(fakir.getIdCard());
        response.setProfession(fakir.getProfession());
        response.setAddress(fakir.getAddress());
        response.setZawya(fakir.getZawiya().getName());
        return response;
    }

    public static List<FakirResDTO> toDTOs(List<Fakir> foukaras) {
        return foukaras.stream().map(FakirMapper::toDto).collect(Collectors.toList());
    }


    public static Fakir toEntity(FakirReqDTO fakirReqDTO) {
        Fakir response = new Fakir();
        oldToNew(response, fakirReqDTO);
        return response;
    }

    public static Fakir oldToNew(Fakir oldFakir, FakirReqDTO fakirReqDTO) {
        return ObjectMapperUtils.map(fakirReqDTO,oldFakir);
    }


    public static BaseResponseDTO toFakirDTOs(List<Fakir> foukaras) {
        return toBaseResponse("success", toDTOs(foukaras));
    }

    public static BaseResponseDTO toFakirDTO(Fakir fakir) {
        return toBaseResponse("success", toDto(fakir));
    }
}
