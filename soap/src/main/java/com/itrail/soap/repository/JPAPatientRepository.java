package com.itrail.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itrail.soap.genereated.patients.Patient;

@Repository
public interface JPAPatientRepository  extends JpaRepository<Patient, Long>{
    
}
