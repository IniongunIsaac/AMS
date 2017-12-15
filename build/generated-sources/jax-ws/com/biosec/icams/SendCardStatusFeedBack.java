
package com.biosec.icams;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendCardStatusFeedBack complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendCardStatusFeedBack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appletObj" type="{http://webservice.icams.biosec.com/}appletTypes" minOccurs="0"/>
 *         &lt;element name="statusObj" type="{http://webservice.icams.biosec.com/}appletStates" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendCardStatusFeedBack", propOrder = {
    "username",
    "password",
    "cardId",
    "appletObj",
    "statusObj"
})
public class SendCardStatusFeedBack {

    protected String username;
    protected String password;
    protected String cardId;
    protected AppletTypes appletObj;
    protected AppletStates statusObj;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

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
     * Gets the value of the appletObj property.
     * 
     * @return
     *     possible object is
     *     {@link AppletTypes }
     *     
     */
    public AppletTypes getAppletObj() {
        return appletObj;
    }

    /**
     * Sets the value of the appletObj property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppletTypes }
     *     
     */
    public void setAppletObj(AppletTypes value) {
        this.appletObj = value;
    }

    /**
     * Gets the value of the statusObj property.
     * 
     * @return
     *     possible object is
     *     {@link AppletStates }
     *     
     */
    public AppletStates getStatusObj() {
        return statusObj;
    }

    /**
     * Sets the value of the statusObj property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppletStates }
     *     
     */
    public void setStatusObj(AppletStates value) {
        this.statusObj = value;
    }

}
