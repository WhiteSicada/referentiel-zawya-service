package com.referentiel.zawya.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakirReqDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String idCard;
    private String profession;
    private String address;
}
