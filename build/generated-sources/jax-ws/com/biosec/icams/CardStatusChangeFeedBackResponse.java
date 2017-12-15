
package com.biosec.icams;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cardStatusChangeFeedBackResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cardStatusChangeFeedBackResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMVStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moCStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PKIStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eIDStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardStatusChangeFeedBackResponse", propOrder = {
    "cardId",
    "emvStatus",
    "moCStatus",
    "pkiStatus",
    "returnMessage",
    "eidStatus"
})
public class CardStatusChangeFeedBackResponse {

    protected String cardId;
    @XmlElement(name = "EMVStatus")
    protected String emvStatus;
    protected String moCStatus;
    @XmlElement(name = "PKIStatus")
    protected String pkiStatus;
    protected String returnMessage;
    @XmlElement(name = "eIDStatus")
    protected String eidStatus;

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
     * Gets the value of the emvStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMVStatus() {
        return emvStatus;
    }

    /**
     * Sets the value of the emvStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMVStatus(String value) {
        this.emvStatus = value;
    }

    /**
     * Gets the value of the moCStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoCStatus() {
        return moCStatus;
    }

    /**
     * Sets the value of the moCStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoCStatus(String value) {
        this.moCStatus = value;
    }

    /**
     * Gets the value of the pkiStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPKIStatus() {
        return pkiStatus;
    }

    /**
     * Sets the value of the pkiStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPKIStatus(String value) {
        this.pkiStatus = value;
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
     * Gets the value of the eidStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEIDStatus() {
        return eidStatus;
    }

    /**
     * Sets the value of the eidStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEIDStatus(String value) {
        this.eidStatus = value;
    }

}
