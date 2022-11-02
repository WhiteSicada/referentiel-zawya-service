package com.referentiel.zawya.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakirRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String idCard;
    private String profession;
    private String address;
    private String macPhoneAddress;
}
