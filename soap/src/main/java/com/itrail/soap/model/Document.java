package com.itrail.soap.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "document")
@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Document  implements Serializable{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_document")
    private Long idDocument;

    @Column( name = "type_document")
    private String typeDocument;

    @Column( name = "seria")
    private String seria;

    @Column( name = "numar")
    private String numar;

    @Column( name = "snils")
    private String snils;

    @Column( name = "polis")
    private String polis;

}