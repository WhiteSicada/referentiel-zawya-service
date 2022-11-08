package com.referentiel.zawya.mapper;

import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.payload.request.ZawyaRequest;
import com.referentiel.zawya.payload.response.ZawiyaDetailedResponse;
import com.referentiel.zawya.payload.response.ZawyaResponse;
import com.referentiel.zawya.utils.ImageUtility;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ZawyaMapper {

    public static ZawyaResponse toDto(Zawiya zawiya) {
        return ZawyaResponse.builder()
                .id(zawiya.getId())
                .name(zawiya.getName())
                .city(zawiya.getCity())
                .country(zawiya.getCountry())
                .address(zawiya.getAddress())
                .image(ImageUtility.decompressImage(zawiya.getImage()))
                .build();
    }

    public static List<ZawyaResponse> toDtos(List<Zawiya> zawayas) {
        return zawayas.stream().map(ZawyaMapper::toDto).collect(Collectors.toList());
    }


    public static Zawiya toEntity(ZawyaRequest request, MultipartFile image) throws IOException {
        return Zawiya.builder()
                .name(request.getName())
                .city(request.getCity())
                .country(request.getCountry())
                .imageName(image.getOriginalFilename())
                .imageType(image.getContentType())
                .image(ImageUtility.compressImage(image.getBytes()))
                .build();
    }

    public static void oldToNew(Zawiya oldZawiya, ZawyaRequest zawyaRequest) {
        oldZawiya.setName(zawyaRequest.getName());
        oldZawiya.setCity(zawyaRequest.getCity());
        oldZawiya.setCountry(zawyaRequest.getCountry());
    }

    public static ZawiyaDetailedResponse toDetailedDto(Zawiya zawiya) {
        return ZawiyaDetailedResponse.builder()
                .id(zawiya.getId())
                .name(zawiya.getName())
                .city(zawiya.getCity())
                .country(zawiya.getCountry())
                .image(ImageUtility.decompressImage(zawiya.getImage()))
                .address(zawiya.getAddress())
                .foukaras(FakirMapper.toDtos(zawiya.getFoukaras()))
                .build();
    }

    public static ZawyaRequest toRequest(String name, String city, String country) {
        return ZawyaRequest.builder()
                .name(name)
                .city(city)
                .country(country)
                .build();
    }
}
