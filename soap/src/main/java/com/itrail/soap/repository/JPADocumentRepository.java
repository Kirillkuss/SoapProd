package com.itrail.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itrail.soap.xsd.Document;

@Repository
public interface JPADocumentRepository  extends JpaRepository<Document, Long> {

}
