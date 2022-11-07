package com.referentiel.zawya.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZawyaResponse {
    private Long id;
    private String name;
    private String country;
    private String city;
    private byte[] image;
}
