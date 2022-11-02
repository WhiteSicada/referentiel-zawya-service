package com.referentiel.zawya.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZawyaResponse {
    private Long id;
    private String name;
    private String country;
    private String city;
}
