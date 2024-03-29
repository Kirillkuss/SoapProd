//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.01.26 at 02:22:26 PM MSK 
//


package com.itrail.soap.generated.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="document"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_document" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="type_document" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="seria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numar" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="snils" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="polis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "document", propOrder = {
    "idDocument",
    "typeDocument",
    "seria",
    "numar",
    "snils",
    "polis"
})
public class Document {

    @XmlElement(name = "id_document")
    protected long idDocument;
    @XmlElement(name = "type_document", required = true)
    protected String typeDocument;
    @XmlElement(required = true)
    protected String seria;
    @XmlElement(required = true)
    protected String numar;
    @XmlElement(required = true)
    protected String snils;
    @XmlElement(required = true)
    protected String polis;

    /**
     * Gets the value of the idDocument property.
     * 
     */
    public long getIdDocument() {
        return idDocument;
    }

    /**
     * Sets the value of the idDocument property.
     * 
     */
    public void setIdDocument(long value) {
        this.idDocument = value;
    }

    /**
     * Gets the value of the typeDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeDocument() {
        return typeDocument;
    }

    /**
     * Sets the value of the typeDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeDocument(String value) {
        this.typeDocument = value;
    }

    /**
     * Gets the value of the seria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeria() {
        return seria;
    }

    /**
     * Sets the value of the seria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeria(String value) {
        this.seria = value;
    }

    /**
     * Gets the value of the numar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumar() {
        return numar;
    }

    /**
     * Sets the value of the numar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumar(String value) {
        this.numar = value;
    }

    /**
     * Gets the value of the snils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnils() {
        return snils;
    }

    /**
     * Sets the value of the snils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnils(String value) {
        this.snils = value;
    }

    /**
     * Gets the value of the polis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolis() {
        return polis;
    }

    /**
     * Sets the value of the polis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolis(String value) {
        this.polis = value;
    }

}
