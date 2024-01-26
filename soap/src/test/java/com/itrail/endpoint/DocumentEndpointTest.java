package com.itrail.endpoint;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;
import com.itrail.soap.SoapApplication;
import com.itrail.soap.endpoints.DocumentEndpoint;
import com.itrail.soap.generated.documents.Document;
import com.itrail.soap.generated.documents.GetDocumentRequestAdd;
import com.itrail.soap.generated.documents.GetDocumentRequestDelete;
import com.itrail.soap.generated.documents.GetDocumentRequestFindAll;
import com.itrail.soap.generated.documents.GetDocumentRequestFindById;
import com.itrail.soap.generated.documents.GetDocumentRequestModify;

@Disabled
@DisplayName("Тестирование конечной точки DocumentEndpoint")
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT,
                 classes = SoapApplication.class )
public class DocumentEndpointTest {

    private final String NAMESPASE = "com/itrail/soap/generated/documents";

    @Autowired
    private DocumentEndpoint documentEndpoint;

    @Test
    @DisplayName("Получение списка документов")
    public void testFindAllDocuments() {
        JAXBElement<GetDocumentRequestFindAll> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getDocumentRequestFindAll"),
                                                                   GetDocumentRequestFindAll.class,
                                                                                new GetDocumentRequestFindAll());
        assertNotNull (documentEndpoint.getDocumentAll( jaxbElement ).getValue().getListDocument() );
    }

    @ParameterizedTest
    @CsvSource({"1", "3"})
    @DisplayName("Получние документа по ИД")
    public void testFindByID( Long id ){
        GetDocumentRequestFindById request = new GetDocumentRequestFindById();
        request.setIdDocument( id );
        JAXBElement<GetDocumentRequestFindById> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getDocumentRequestFindById"),
                                                                    GetDocumentRequestFindById.class,
                                                                                 request );
        assertNotNull( documentEndpoint.getDocumentFindById( jaxbElement ));
    }

    @Test
    @Transactional //rollback
    @DisplayName("Добавление документа")
    public void testAddDocument() throws Exception{
        Document document = new Document();
        document.setIdDocument(-1L);
        document.setTypeDocument("Pass");
        document.setSeria("TX");
        document.setNumar("--2323");
        document.setSnils("--1");
        document.setPolis("--1");
        GetDocumentRequestAdd request = new GetDocumentRequestAdd();
        request.setDocument( document );
        JAXBElement<GetDocumentRequestAdd> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getDocumentRequestAdd"),
                                                               GetDocumentRequestAdd.class,
                                                                            request );
        assertNotNull( documentEndpoint.getDocumentAdd( jaxbElement ));                                                             
    }

    @Test
    @Transactional //rollback
    @DisplayName("Удалить документ")
    public void testDeleteDocument() throws Exception{
        GetDocumentRequestDelete request = new GetDocumentRequestDelete();
        request.setIdDocument( 1L );
        JAXBElement<GetDocumentRequestDelete> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getDocumentRequestDelete"),
                                                                  GetDocumentRequestDelete.class,
                                                                               request );
        documentEndpoint.getDocumentDelete( jaxbElement );                                                                     
    }


    @Test
    @Transactional //rollback
    @DisplayName("Обновить документ")
    public void testModifyDocument() throws Exception{
        GetDocumentRequestModify request = new GetDocumentRequestModify();
        Document document = new Document();
        document.setIdDocument(1L);
        document.setTypeDocument("Pass");
        document.setSeria("TX");
        document.setNumar("--2323");
        document.setSnils("--1");
        document.setPolis("--1");
        request.setDocument( document );
        JAXBElement<GetDocumentRequestModify> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getDocumentRequestModify"),
                                                                  GetDocumentRequestModify.class,
                                                                               request );
        documentEndpoint.getDocumentModyfy( jaxbElement );

    }


}
