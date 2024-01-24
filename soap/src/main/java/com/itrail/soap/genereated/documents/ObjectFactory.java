//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.01.24 at 04:35:32 PM MSK 
//


package com.itrail.soap.genereated.documents;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.itrail.soap.genereated.documents package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Document_QNAME = new QName("com/itrail/soap/genereated/documents", "document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.itrail.soap.genereated.documents
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocumentRequestFindById }
     * 
     */
    public GetDocumentRequestFindById createGetDocumentRequestFindById() {
        return new GetDocumentRequestFindById();
    }

    /**
     * Create an instance of {@link GetDocumentRequestFindAll }
     * 
     */
    public GetDocumentRequestFindAll createGetDocumentRequestFindAll() {
        return new GetDocumentRequestFindAll();
    }

    /**
     * Create an instance of {@link GetDocumentRequestAdd }
     * 
     */
    public GetDocumentRequestAdd createGetDocumentRequestAdd() {
        return new GetDocumentRequestAdd();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link GetDocumentRequestDelete }
     * 
     */
    public GetDocumentRequestDelete createGetDocumentRequestDelete() {
        return new GetDocumentRequestDelete();
    }

    /**
     * Create an instance of {@link GetDocumentRequestModify }
     * 
     */
    public GetDocumentRequestModify createGetDocumentRequestModify() {
        return new GetDocumentRequestModify();
    }

    /**
     * Create an instance of {@link GetDocumentResponse }
     * 
     */
    public GetDocumentResponse createGetDocumentResponse() {
        return new GetDocumentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Document }{@code >}
     */
    @XmlElementDecl(namespace = "com/itrail/soap/genereated/documents", name = "document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

}
