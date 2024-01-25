package com.itrail.soap.endpoints;

import javax.xml.bind.JAXBElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.itrail.soap.generated.patients.GetPatientRequestAdd;
import com.itrail.soap.generated.patients.GetPatientRequestFindAll;
import com.itrail.soap.generated.patients.GetPatientRequestFindById;
import com.itrail.soap.generated.patients.Patient;
import com.itrail.soap.model.ListPatients;
import com.itrail.soap.service.PatientService;
import lombok.RequiredArgsConstructor;

@Endpoint
@RequiredArgsConstructor
public class PatientEndpoint {

    private static final String NAMESPACE_URI = "com/itrail/soap/generated/patients";

    private final PatientService patientService;

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getPatientRequestFindById" )
    public @ResponsePayload JAXBElement<Patient> getPatientFindById(@RequestPayload JAXBElement<GetPatientRequestFindById> request) {
        return patientService.getPatientFindById( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getPatientRequestFindAll" )
    public @ResponsePayload JAXBElement<ListPatients> getPatientAll(@RequestPayload JAXBElement<GetPatientRequestFindAll> request) {
        return patientService.getPatientAll( request );
    }

    @PayloadRoot( namespace = NAMESPACE_URI, localPart = "getPatientRequestAdd" )
    public @ResponsePayload JAXBElement<Patient> addPatient( @RequestPayload JAXBElement<GetPatientRequestAdd> request) {
        return patientService.addPatient( request );
    }

}
