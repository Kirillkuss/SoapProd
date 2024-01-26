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
import com.itrail.soap.endpoints.PatientEndpoint;
import com.itrail.soap.generated.patients.Gender;
import com.itrail.soap.generated.patients.GetPatientRequestAdd;
import com.itrail.soap.generated.patients.GetPatientRequestFindAll;
import com.itrail.soap.generated.patients.GetPatientRequestFindById;

@Disabled
@DisplayName("Тестирование конечной точки DocumentEndpoint")
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT,
                 classes = SoapApplication.class )
public class PatientEndpointTest {

    private final String NAMESPASE = "com/itrail/soap/generated/patients";

    @Autowired
    private PatientEndpoint patientEndpoint;

    @Test
    @DisplayName("Получение списка пациентов")
    public void testFindAllPatients(){
        JAXBElement<GetPatientRequestFindAll> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getPatientRequestFindAll"),
                                                                  GetPatientRequestFindAll.class,
                                                                               new GetPatientRequestFindAll());
        assertNotNull (patientEndpoint.getPatientAll( jaxbElement ).getValue().getPatients() );
    }

    @ParameterizedTest
    @CsvSource({"1", "5"})
    @DisplayName("Получение пациента по ИД")
    public void testFindPatientById( Long id ){
        GetPatientRequestFindById request = new GetPatientRequestFindById();
        request.setIdPatient( 1L );
        JAXBElement<GetPatientRequestFindById> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getPatientRequestFindById"),
                                                                   GetPatientRequestFindById.class,
                                                                                request );
        assertNotNull (patientEndpoint.getPatientFindById( jaxbElement ));
    }

    @Test
    @Transactional
    @DisplayName("Добавление клиента")
    public void testAddPatient() throws Exception{
        GetPatientRequestAdd request = new GetPatientRequestAdd();
        request.setIdPatient( -1L );
        request.setSurname( "test" );
        request.setName( "name" );
        request.setFullName( "test" );
        request.setGender( Gender.MAN );
        request.setPhone( "+13857135");
        request.setAddress("test");
        request.setIdDocument( 8L );    
        JAXBElement<GetPatientRequestAdd> jaxbElement = new JAXBElement<>( new QName( NAMESPASE, "getPatientRequestFindById"),
                                                              GetPatientRequestAdd.class,
                                                                           request );
        assertNotNull (patientEndpoint.addPatient( jaxbElement ));
    }
    
}
