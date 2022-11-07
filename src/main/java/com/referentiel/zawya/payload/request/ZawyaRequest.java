package com.referentiel.zawya.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZawyaRequest {
    private String name;
    private String country;
    private String city;
}
