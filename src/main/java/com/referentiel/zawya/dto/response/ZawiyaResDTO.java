package com.referentiel.zawya.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZawiyaResDTO {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
    private byte[] image;
}
