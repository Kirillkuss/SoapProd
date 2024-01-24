package com.itrail.soap.endpoints;

import com.itrail.soap.repository.JPADocumentRepository;
import com.itrail.soap.genereated.documents.GetDocumentRequestAdd;
import com.itrail.soap.genereated.documents.GetDocumentRequestDelete;
import com.itrail.soap.genereated.documents.GetDocumentRequestFindAll;
import com.itrail.soap.genereated.documents.GetDocumentRequestFindById;
import com.itrail.soap.genereated.documents.GetDocumentRequestModify;
import com.itrail.soap.genereated.documents.GetDocumentResponse;
import com.itrail.soap.model.ListResponse;
import java.util.NoSuchElementException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
@RequiredArgsConstructor
public class DocumentEndpoint {

    private static final String NAMESPACE_URI = "com/itrail/soap/genereated/documents";

    private final JPADocumentRepository jpaDocumentRepository;

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestFindById" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentFindById(@RequestPayload JAXBElement<GetDocumentRequestFindById> request) {
        GetDocumentResponse response = new GetDocumentResponse( );
        response.setDocument( jpaDocumentRepository.findById( request.getValue()
                                                                     .getIdDocument()).orElseThrow( () -> new NoSuchElementException( "Документа с таким ИД не существует" )));
        log.info( "getDocumentRequestFindById");
        return createJaxbElement( response,  GetDocumentResponse.class );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestFindAll" )
    public @ResponsePayload JAXBElement<ListResponse> getDocumentAll(@RequestPayload JAXBElement<GetDocumentRequestFindAll> request) {
        log.info( "getDocumentRequestFindAll");
        return createJaxbElement( new ListResponse( jpaDocumentRepository.findAll() ) , ListResponse.class );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestAdd" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentAdd( @RequestPayload JAXBElement<GetDocumentRequestAdd> request ) throws Exception{
        GetDocumentResponse response = new GetDocumentResponse( );
        if( jpaDocumentRepository.findById( request.getValue().getDocument().getIdDocument()).isPresent()) throw new IllegalAccessException("Документ с таким ИД уже существует");
        if( jpaDocumentRepository.findByNumar( request.getValue().getDocument().getNumar()).isPresent() ) throw new IllegalAccessException("Документ с таким номером документа уже существует");
        if( jpaDocumentRepository.findByPolis( request.getValue().getDocument().getPolis()).isPresent() ) throw new IllegalAccessException( "Документ с таким полисом уже существует");
        if( jpaDocumentRepository.findBySnils( request.getValue().getDocument().getSnils()).isPresent() ) throw new IllegalAccessException( "Документ с таким СНИЛСом уже существует");
        response.setDocument( jpaDocumentRepository.save( request.getValue().getDocument() ));
        log.info( "getDocumentRequestAdd");
        return createJaxbElement( response, GetDocumentResponse.class );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestDelete" )
    public @ResponsePayload JAXBElement<String> getDocumentDelete( @RequestPayload JAXBElement<GetDocumentRequestDelete> request ) throws Exception{
        String response = "success";
        if( jpaDocumentRepository.findById( request.getValue().getIdDocument()).isEmpty()) throw new IllegalAccessException("Документ с таким ИД не существует");
        jpaDocumentRepository.deleteById( request.getValue().getIdDocument() );
        log.info( "getDocumentRequestDelete");
        return createJaxbElement( response, String.class );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestModify" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentModyfy( @RequestPayload JAXBElement<GetDocumentRequestModify> request ) throws Exception{
        GetDocumentResponse response = new GetDocumentResponse( );
        if( jpaDocumentRepository.findById( request.getValue().getDocument().getIdDocument()).isEmpty()) throw new IllegalAccessException("Документ с таким ИД не существует");
        response.setDocument( jpaDocumentRepository.save( request.getValue().getDocument()) );
        log.info( "getDocumentRequestDelete");
        return createJaxbElement( response, GetDocumentResponse.class );
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }

    

}
