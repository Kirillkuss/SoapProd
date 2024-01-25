package com.itrail.soap.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "patient")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonInclude( Include.NON_NULL )
public class Patient implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_patient")
    private Long idPatient;

    @Column( name = "surname")
    private String surname;

    @Column( name = "name")
    private String name;

    @Column( name = "full_name")
    private String fullName;

    @Column( name = "gender")
    private Gender gender;

    @Column( name = "phone")
    private String phone;

    @Column( name = "address")
    private String address;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "document_id", referencedColumnName = "id_document" ) 
    private Document document;
}
