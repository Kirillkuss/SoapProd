package com.itrail.soap.endpoints;

import com.itrail.soap.service.DocumentService;
import com.itrail.soap.generated.documents.GetDocumentRequestAdd;
import com.itrail.soap.generated.documents.GetDocumentRequestDelete;
import com.itrail.soap.generated.documents.GetDocumentRequestFindAll;
import com.itrail.soap.generated.documents.GetDocumentRequestFindById;
import com.itrail.soap.generated.documents.GetDocumentRequestModify;
import com.itrail.soap.generated.documents.GetDocumentResponse;
import com.itrail.soap.model.ListResponse;
import javax.xml.bind.JAXBElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import lombok.RequiredArgsConstructor;

@Endpoint
@RequiredArgsConstructor
public class DocumentEndpoint {

    private static final String NAMESPACE_URI = "com/itrail/soap/generated/documents";

    private final DocumentService documentService;

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestFindById" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentFindById(@RequestPayload JAXBElement<GetDocumentRequestFindById> request) {
        return documentService.getDocumentFindById( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestFindAll" )
    public @ResponsePayload JAXBElement<ListResponse> getDocumentAll(@RequestPayload JAXBElement<GetDocumentRequestFindAll> request) {
        return documentService.getDocumentAll( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestAdd" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentAdd( @RequestPayload JAXBElement<GetDocumentRequestAdd> request ) throws Exception{
        return documentService.getDocumentAdd( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestDelete" )
    public @ResponsePayload JAXBElement<String> getDocumentDelete( @RequestPayload JAXBElement<GetDocumentRequestDelete> request ) throws Exception{
        return documentService.getDocumentDelete( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getDocumentRequestModify" )
    public @ResponsePayload JAXBElement<GetDocumentResponse> getDocumentModyfy( @RequestPayload JAXBElement<GetDocumentRequestModify> request ) throws Exception{
        return documentService.getDocumentModyfy( request );
    }

}
