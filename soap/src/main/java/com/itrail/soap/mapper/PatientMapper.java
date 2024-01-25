package com.itrail.soap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {

    @Mapping(source = "idPatient", target = "idPatient")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "document", target = "document")
    com.itrail.soap.model.Patient GeneratedToModal( com.itrail.soap.generated.patients.Patient patient );

    @Mapping(source = "idPatient", target = "idPatient")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "document", target = "document")
    com.itrail.soap.generated.patients.Patient modelToGenerated( com.itrail.soap.model.Patient patient );
    
}
