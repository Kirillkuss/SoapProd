package com.itrail.soap.xsd;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.itrail.soap.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocumentRequest }
     * 
     */
    public GetDocumentRequest createGetDocumentRequest() {
        return new GetDocumentRequest();
    }

    /**
     * Create an instance of {@link GetDocumentResponse }
     * 
     */
    public GetDocumentResponse createGetDocumentResponse() {
        return new GetDocumentResponse();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

}
