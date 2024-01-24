package com.itrail.soap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.itrail.soap.genereated.documents.Document;

@Repository
public interface JPADocumentRepository  extends JpaRepository<Document, Long> {

    @Query( "SELECT u FROM Document u WHERE u.numar = :numar")
    Optional<Document> findByNumar( String numar);

    @Query( "SELECT u FROM Document u WHERE u.snils = :snils")
    Optional<Document> findBySnils( String snils );
    
    @Query( "SELECT u FROM Document u WHERE u.polis = :polis")
    Optional<Document> findByPolis( String polis );    

}
