package com.referentiel.zawya.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ZawyaRequest {
    private String name;
    private String country;
    private String city;
}
