package com.itrail.soap.service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.springframework.stereotype.Service;
import com.itrail.soap.generated.documents.GetDocumentRequestAdd;
import com.itrail.soap.generated.documents.GetDocumentRequestDelete;
import com.itrail.soap.generated.documents.GetDocumentRequestFindAll;
import com.itrail.soap.generated.documents.GetDocumentRequestFindById;
import com.itrail.soap.generated.documents.GetDocumentRequestModify;
import com.itrail.soap.generated.documents.GetDocumentResponse;
import com.itrail.soap.mapper.DocumentMapper;
import com.itrail.soap.model.ListResponse;
import com.itrail.soap.repository.JPADocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentService {

    private final JPADocumentRepository jpaDocumentRepository;
    private final DocumentMapper documentMapper;

    public JAXBElement<GetDocumentResponse> getDocumentFindById(JAXBElement<GetDocumentRequestFindById> request) {
        GetDocumentResponse response = new GetDocumentResponse( );
        response.setDocument( documentMapper.modelToGenerated( jpaDocumentRepository.findById( request.getValue()
                                                                     .getIdDocument()).orElseThrow( () -> new NoSuchElementException( "Документа с таким ИД не существует" ))));
        log.info( "getDocumentRequestFindById");
        return createJaxbElement( response,  GetDocumentResponse.class );
    }

    public JAXBElement<ListResponse> getDocumentAll( JAXBElement<GetDocumentRequestFindAll> request) {
        log.info( "getDocumentRequestFindAll");
        return createJaxbElement( new ListResponse( jpaDocumentRepository.findAll().stream().map( d -> documentMapper.modelToGenerated( d )).collect( Collectors.toList()) ) , ListResponse.class );
    }

    public JAXBElement<GetDocumentResponse> getDocumentAdd( JAXBElement<GetDocumentRequestAdd> request ) throws Exception{
        GetDocumentResponse response = new GetDocumentResponse( );
        if( jpaDocumentRepository.findById( request.getValue().getDocument().getIdDocument()).isPresent()) throw new IllegalAccessException("Документ с таким ИД уже существует");
        if( jpaDocumentRepository.findByNumar( request.getValue().getDocument().getNumar()).isPresent() ) throw new IllegalAccessException("Документ с таким номером документа уже существует");
        if( jpaDocumentRepository.findByPolis( request.getValue().getDocument().getPolis()).isPresent() ) throw new IllegalAccessException( "Документ с таким полисом уже существует");
        if( jpaDocumentRepository.findBySnils( request.getValue().getDocument().getSnils()).isPresent() ) throw new IllegalAccessException( "Документ с таким СНИЛСом уже существует");
        response.setDocument(documentMapper.modelToGenerated(jpaDocumentRepository.save( documentMapper.generatedToModel( request.getValue().getDocument() ))) );
        log.info( "getDocumentRequestAdd");
        return createJaxbElement( response, GetDocumentResponse.class );
    }

    public JAXBElement<String> getDocumentDelete( JAXBElement<GetDocumentRequestDelete> request ) throws Exception{
        String response = "success";
        if( jpaDocumentRepository.findById( request.getValue().getIdDocument()).isEmpty()) throw new IllegalAccessException("Документ с таким ИД не существует");
        jpaDocumentRepository.deleteById( request.getValue().getIdDocument() );
        log.info( "getDocumentRequestDelete");
        return createJaxbElement( response, String.class );
    }

    public  JAXBElement<GetDocumentResponse> getDocumentModyfy( JAXBElement<GetDocumentRequestModify> request ) throws Exception{
        GetDocumentResponse response = new GetDocumentResponse( );
        if( jpaDocumentRepository.findById( request.getValue().getDocument().getIdDocument()).isEmpty()) throw new IllegalAccessException("Документ с таким ИД не существует");
        response.setDocument(documentMapper.modelToGenerated(jpaDocumentRepository.save( documentMapper.generatedToModel( request.getValue().getDocument() ))) );
        log.info( "getDocumentRequestDelete");
        return createJaxbElement( response, GetDocumentResponse.class );
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
    
}
