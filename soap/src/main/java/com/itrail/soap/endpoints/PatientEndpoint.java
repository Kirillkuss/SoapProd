package com.itrail.soap.endpoints;

import java.util.NoSuchElementException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.itrail.soap.genereated.patients.GetPatientRequestFindAll;
import com.itrail.soap.genereated.patients.GetPatientRequestFindById;
import com.itrail.soap.genereated.patients.Patient;
import com.itrail.soap.model.ListPatients;
import com.itrail.soap.repository.JPAPatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
@RequiredArgsConstructor
public class PatientEndpoint {

    private static final String NAMESPACE_URI = "com/itrail/soap/genereated/patients";

    private final JPAPatientRepository jpaPatientRepository;

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getPatientRequestFindById" )
    public @ResponsePayload JAXBElement<Patient> getDocumentFindById(@RequestPayload JAXBElement<GetPatientRequestFindById> request) {
        log.info( "getPatientFindById");
        return createJaxbElement( jpaPatientRepository.findById( request.getValue().getIdPatient()).orElseThrow( () -> new NoSuchElementException( "Пациента с таким ИД не существует" )),  Patient.class );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getPatientRequestFindAll" )
    public @ResponsePayload JAXBElement<ListPatients> getDocumentAll(@RequestPayload JAXBElement<GetPatientRequestFindAll> request) {
        log.info( "getPatientsFindAll");
        return createJaxbElement( new ListPatients( jpaPatientRepository.findAll()) , ListPatients.class );
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
    
}
