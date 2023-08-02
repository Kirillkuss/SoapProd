package com.itrail.soap.endpoints;

import com.itrail.soap.repository.JPADocumentRepository;
import com.itrail.soap.xsd.GetDocumentRequest;
import com.itrail.soap.xsd.GetDocumentResponse;
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

    private static final String NAMESPACE_URI = "com/itrail/soap/xsd";

    private final JPADocumentRepository jpaDocumentRepository;

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequest" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocument(@RequestPayload JAXBElement<GetDocumentRequest> request) {
        log.info( "Method getDocument");
        return createJaxbElement( new GetDocumentResponse( jpaDocumentRepository.findById( request.getValue()
                                                                                                  .getIdDocument()).orElseThrow()), GetDocumentResponse.class );
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }

}
