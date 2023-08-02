package com.itrail.soap.config.adapter;
/** 
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.itrail.soap.xsd.GetDocumentRequest;
import com.itrail.soap.xsd.GetDocumentResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentClient extends WebServiceGatewaySupport  {
    
    public GetDocumentResponse getDocument( Long id ){
        GetDocumentRequest getDocumentRequest = new GetDocumentRequest();
        getDocumentRequest.setIdDocument( id );
        GetDocumentResponse response = (GetDocumentResponse) getWebServiceTemplate().marshalSendAndReceive(getDocumentRequest);
        return response;
    }
}*/
