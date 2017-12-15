
package com.biosec.icams;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retrievePINResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retrievePINResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sopin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrievePINResponse", propOrder = {
    "cardId",
    "puk",
    "returnMessage",
    "sopin"
})
public class RetrievePINResponse {

    protected String cardId;
    protected String puk;
    protected String returnMessage;
    protected String sopin;

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
     * Gets the value of the puk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuk() {
        return puk;
    }

    /**
     * Sets the value of the puk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuk(String value) {
        this.puk = value;
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
     * Gets the value of the sopin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSopin() {
        return sopin;
    }

    /**
     * Sets the value of the sopin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSopin(String value) {
        this.sopin = value;
    }

}
