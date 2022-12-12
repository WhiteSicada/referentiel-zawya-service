package com.referentiel.zawya.mapper;

import com.referentiel.zawya.dto.BaseResponseDTO;
import com.referentiel.zawya.model.Zawiya;
import com.referentiel.zawya.dto.request.ZawyaReqDTO;
import com.referentiel.zawya.dto.response.ZawiyaDetailedResDTO;
import com.referentiel.zawya.dto.response.ZawiyaResDTO;
import com.referentiel.zawya.utils.ImageUtility;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ZawyaMapper extends BaseMapper {

    public static ZawiyaResDTO toZawiyaDTO(Zawiya zawiya) {
        return ZawiyaResDTO.builder()
                .id(zawiya.getId())
                .name(zawiya.getName())
                .city(zawiya.getCity())
                .country(zawiya.getCountry())
                .address(zawiya.getAddress())
                .image(ImageUtility.decompressImage(zawiya.getImage()))
                .build();
    }


    public static BaseResponseDTO toDTO(Zawiya zawiya) {
        return toBaseResponse("success", toZawiyaDTO(zawiya));
    }

    public static BaseResponseDTO toDTOs(List<Zawiya> zawayas) {
        return toBaseResponse("success", zawayas.stream().map(ZawyaMapper::toZawiyaDTO).collect(Collectors.toList()));
    }


    public static Zawiya toEntity(ZawyaReqDTO request, MultipartFile image) throws IOException {
        return Zawiya.builder()
                .name(request.getName())
                .city(request.getCity())
                .country(request.getCountry())
                .address((request.getAddress()))
                .imageName(image.getOriginalFilename())
                .imageType(image.getContentType())
                .image(ImageUtility.compressImage(image.getBytes()))
                .build();
    }

    public static void oldToNew(Zawiya oldZawiya, ZawyaReqDTO zawyaReqDTO) {
        oldZawiya.setName(zawyaReqDTO.getName());
        oldZawiya.setCity(zawyaReqDTO.getCity());
        oldZawiya.setCountry(zawyaReqDTO.getCountry());
    }

    public static BaseResponseDTO toDetailedDTO(Zawiya zawiya) {
        return toBaseResponse("success", ZawiyaDetailedResDTO.builder()
                .id(zawiya.getId())
                .name(zawiya.getName())
                .city(zawiya.getCity())
                .country(zawiya.getCountry())
                .image(ImageUtility.decompressImage(zawiya.getImage()))
                .address(zawiya.getAddress())
                .foukaras(FakirMapper.toDTOs(zawiya.getFoukaras()))
                .build());
    }

    public static ZawyaReqDTO toRequest(String name, String city, String country, String address) {
        return ZawyaReqDTO.builder()
                .name(name)
                .city(city)
                .country(country)
                .address(address)
                .build();
    }
}
