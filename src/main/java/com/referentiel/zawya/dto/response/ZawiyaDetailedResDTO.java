package com.referentiel.zawya.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZawiyaDetailedResDTO {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
    private byte[] image;
    private List<FakirResDTO> foukaras;
}
