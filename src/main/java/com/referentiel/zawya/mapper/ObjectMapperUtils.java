package com.referentiel.zawya.mapper;

import com.referentiel.zawya.model.Fakir;
import com.referentiel.zawya.dto.request.FakirReqDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class ObjectMapperUtils {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.typeMap(FakirReqDTO.class, Fakir.class).addMappings(mapper -> {
            mapper.skip(Fakir::setId);
        });
    }

    public static <S, D> D map(final S entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }


    public static <S, D> List<D> mapAll(final Collection<S> entityList, Class<D> outCLass) {
        return entityList == null || entityList.isEmpty() ? new ArrayList<>() : entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }


    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}