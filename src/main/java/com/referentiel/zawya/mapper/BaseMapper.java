package com.referentiel.zawya.mapper;

import com.referentiel.zawya.dto.BaseResponseDTO;

public class BaseMapper {

    public static BaseResponseDTO toBaseResponse(String status, Object data) {
        return new BaseResponseDTO(status, data);
    }

}
