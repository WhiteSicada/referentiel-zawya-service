package com.referentiel.zawya.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZawyaDetailedResponse {
    private Long id;
    private String name;
    private String country;
    private String city;
    private List<FakirResponse> foukaras;
}
