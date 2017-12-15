
package com.biosec.icams;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cardDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chipStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validityFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validityTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardDetails", propOrder = {
    "cardId",
    "chipStatus",
    "documentNo",
    "nin",
    "returnMessage",
    "validityFrom",
    "validityTo"
})
public class CardDetails {

    protected String cardId;
    protected String chipStatus;
    protected String documentNo;
    protected String nin;
    protected String returnMessage;
    protected String validityFrom;
    protected String validityTo;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardId(String value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the chipStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChipStatus() {
        return chipStatus;
    }

    /**
     * Sets the value of the chipStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChipStatus(String value) {
        this.chipStatus = value;
    }

    /**
     * Gets the value of the documentNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNo() {
        return documentNo;
    }

    /**
     * Sets the value of the documentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNo(String value) {
        this.documentNo = value;
    }

    /**
     * Gets the value of the nin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNin() {
        return nin;
    }

    /**
     * Sets the value of the nin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNin(String value) {
        this.nin = value;
    }

    /**
     * Gets the value of the returnMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * Sets the value of the returnMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnMessage(String value) {
        this.returnMessage = value;
    }

    /**
     * Gets the value of the validityFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidityFrom() {
        return validityFrom;
    }

    /**
     * Sets the value of the validityFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidityFrom(String value) {
        this.validityFrom = value;
    }

    /**
     * Gets the value of the validityTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidityTo() {
        return validityTo;
    }

    /**
     * Sets the value of the validityTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidityTo(String value) {
        this.validityTo = value;
    }

}
