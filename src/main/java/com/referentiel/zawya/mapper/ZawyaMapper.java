package com.referentiel.zawya.mapper;

import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ZawyaMapper {

    public static ZawyaResponse toDto(Zawya zawya){
        ZawyaResponse response = new ZawyaResponse();
        response.setId(zawya.getId());
        response.setName(zawya.getName());
        response.setCity(zawya.getCity());
        response.setCountry(zawya.getCountry());
        return response;
    }

    public static List<ZawyaResponse> toDtos(List<Zawya> zawayas){
        return zawayas.stream().map(ZawyaMapper::toDto).collect(Collectors.toList());
    }


    public static Zawya toEntity(ZawyaRequest request){
        Zawya response = new Zawya();
        response.setName(request.getName());
        response.setCity(request.getCity());
        response.setCountry(request.getCountry());
        return response;
    }

    public static void oldToNew(Zawya oldZawya, ZawyaRequest zawyaRequest) {
        oldZawya.setName(zawyaRequest.getName());
        oldZawya.setCity(zawyaRequest.getCity());
        oldZawya.setCountry(zawyaRequest.getCountry());
    }

    public static ZawyaDetailedResponse toDetailedDto(Zawya zawya) {
        ZawyaDetailedResponse response = new ZawyaDetailedResponse();
        response.setId(zawya.getId());
        response.setName(zawya.getName());
        response.setCity(zawya.getCity());
        response.setCountry(zawya.getCountry());
        response.setFoukaras(FakirMapper.toDtos(zawya.getFoukaras()));
        return response;
    }
}
