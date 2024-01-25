package com.itrail.soap.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.springframework.stereotype.Service;
import com.itrail.soap.generated.patients.GetPatientRequestAdd;
import com.itrail.soap.generated.patients.GetPatientRequestFindAll;
import com.itrail.soap.generated.patients.GetPatientRequestFindById;
import com.itrail.soap.generated.patients.Patient;
import com.itrail.soap.mapper.PatientMapper;
import com.itrail.soap.model.Document;
import com.itrail.soap.model.Gender;
import com.itrail.soap.model.ListPatients;
import com.itrail.soap.repository.JPADocumentRepository;
import com.itrail.soap.repository.JPAPatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {

    private final JPAPatientRepository jpaPatientRepository;
    private final JPADocumentRepository jpaDocumentRepository;
    private final PatientMapper patientMapper;

    /**
     * Получение пациента по ИД
     * @param request - ИД пациента 
     * @return Patient
     */
    public JAXBElement<Patient> getPatientFindById( JAXBElement<GetPatientRequestFindById> request) {
        log.info( "getPatientFindById");
        return createJaxbElement( patientMapper.modelToGenerated( jpaPatientRepository.findById( request.getValue().getIdPatient())
                                                                                      .orElseThrow( () -> new NoSuchElementException( "Пациента с таким ИД не существует" ))),  Patient.class );
    }
    /**
     * Получение списка пациентов
     * @param request
     * @return ListPatients
     */
    public JAXBElement<ListPatients> getPatientAll( JAXBElement<GetPatientRequestFindAll> request) {
        log.info( "getPatientsFindAll");
        return createJaxbElement( new ListPatients( jpaPatientRepository.findAll()
                                                                        .stream()
                                                                        .map( s ->  patientMapper.modelToGenerated( s ))
                                                                        .collect( Collectors.toList() ))  , ListPatients.class );
    }
    /**
     * Добавить пациента
     * @param request - входные параметры
     * @return Patient
     */
    public JAXBElement<Patient> addPatient( JAXBElement<GetPatientRequestAdd> request) {
        if( jpaPatientRepository.findByPhone( request.getValue().getPhone() ).isPresent() ) throw new IllegalArgumentException(  "Пользователь с таким номером телефона уже существует, укажите другой");
        if( jpaPatientRepository.findPatientByIdDocument( request.getValue().getIdDocument() ).isPresent() ) throw new IllegalArgumentException( "Неверное значение ИД документа, попробуйте другой");
        if( jpaPatientRepository.findById( request.getValue().getIdPatient()).isPresent()) throw new IllegalArgumentException(  "Пользователь с таким ИД уже существует");
        Optional<Document> document = jpaDocumentRepository.findById( request.getValue().getIdDocument() );
        if( document.isEmpty()) throw new IllegalArgumentException( "Документ с таким ИД не существует");
        com.itrail.soap.model.Patient patient = new com.itrail.soap.model.Patient();
        patient.setIdPatient(request.getValue().getIdPatient());
        patient.setSurname(request.getValue().getSurname());
        patient.setName(request.getValue().getName());
        patient.setFullName(request.getValue().getFullName());
            if ( request.getValue().getGender().name() == "MAN") { 
                patient.setGender( Gender.MAN );
            }else{
                patient.setGender( Gender.WOMAN );
            }
        patient.setPhone(request.getValue().getPhone());
        patient.setAddress(request.getValue().getAddress());
        patient.setDocument(document.stream().findFirst().orElse(null));

        log.info( "addPatinet");
        return createJaxbElement( patientMapper.modelToGenerated( jpaPatientRepository.save( patient)), Patient.class); 
    } 

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
    
}
