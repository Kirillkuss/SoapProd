package com.itrail.soap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.itrail.soap.model.Patient;

@Repository
public interface JPAPatientRepository  extends JpaRepository<Patient, Long>{

    @Query( "SELECT u FROM Patient u WHERE u.document.idDocument = :id")
    Optional<Patient> findPatientByIdDocument( Long id );

    @Query ( "SELECT u FROM Patient u WHERE u.phone = :phoneNumber")
    Optional<Patient> findByPhone( String phoneNumber );

    @Query ("SELECT u FROM Patient u where u.idPatient = :id")
    Optional<Patient> findByIdPatinet( Long id );
    
}
