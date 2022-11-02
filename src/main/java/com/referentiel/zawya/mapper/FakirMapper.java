package com.referentiel.zawya.mapper;

import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.model.Zawya;
import com.referentiel.zawya.payload.request.FakirRequest;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.FakirResponse;
import com.referentiel.zawya.payload.response.ZawyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FakirMapper {
    public static FakirResponse toDto(Fakir fakir) {
        FakirResponse response = new FakirResponse();
        response.setId(fakir.getId());
        response.setFirstName(fakir.getFirstName());
        response.setLastName(fakir.getLastName());
        response.setEmail(fakir.getEmail());
        response.setPhoneNumber(fakir.getPhoneNumber());
        response.setIdCard(fakir.getIdCard());
        response.setProfession(fakir.getProfession());
        response.setAddress(fakir.getAddress());
        response.setZawya(fakir.getZawya().getName());
        response.setMacPhoneAddress(fakir.getMacPhoneAddress());
        return response;
    }

    public static List<FakirResponse> toDtos(List<Fakir> foukaras) {
        return foukaras.stream().map(FakirMapper::toDto).collect(Collectors.toList());
    }


    public static Fakir toEntity(FakirRequest fakirRequest) {
        Fakir response = new Fakir();
        oldToNew(response,fakirRequest);
        return response;
    }

    public static void oldToNew(Fakir oldFakir, FakirRequest fakirRequest) {
        oldFakir.setFirstName(fakirRequest.getFirstName());
        oldFakir.setLastName(fakirRequest.getLastName());
        oldFakir.setEmail(fakirRequest.getEmail());
        oldFakir.setPhoneNumber(fakirRequest.getPhoneNumber());
        oldFakir.setIdCard(fakirRequest.getIdCard());
        oldFakir.setProfession(fakirRequest.getProfession());
        oldFakir.setAddress(fakirRequest.getAddress());
        oldFakir.setMacPhoneAddress(fakirRequest.getMacPhoneAddress());
    }

}
