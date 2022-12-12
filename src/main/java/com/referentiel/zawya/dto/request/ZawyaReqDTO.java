package com.referentiel.zawya.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZawyaReqDTO {
    private String name;
    private String country;
    private String city;
    private String address;
}
