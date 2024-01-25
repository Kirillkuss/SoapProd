package com.itrail.soap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentMapper {

    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "typeDocument", target = "typeDocument")
    @Mapping(source = "seria", target = "seria")
    @Mapping(source = "numar", target = "numar")
    @Mapping(source = "snils", target = "snils")
    @Mapping(source = "polis", target = "polis")
    com.itrail.soap.model.Document generatedToModel( com.itrail.soap.generated.documents.Document document );


    @Mapping(source = "idDocument", target = "idDocument")
    @Mapping(source = "typeDocument", target = "typeDocument")
    @Mapping(source = "seria", target = "seria")
    @Mapping(source = "numar", target = "numar")
    @Mapping(source = "snils", target = "snils")
    @Mapping(source = "polis", target = "polis")
    com.itrail.soap.generated.documents.Document modelToGenerated( com.itrail.soap.model.Document document );
    
}
