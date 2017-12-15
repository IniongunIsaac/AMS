
package com.biosec.icams;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for appletTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="appletTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eID"/>
 *     &lt;enumeration value="MoC"/>
 *     &lt;enumeration value="PKI"/>
 *     &lt;enumeration value="eID_PKI"/>
 *     &lt;enumeration value="eID_PKI_MoC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "appletTypes")
@XmlEnum
public enum AppletTypes {

    @XmlEnumValue("eID")
    E_ID("eID"),
    @XmlEnumValue("MoC")
    MO_C("MoC"),
    PKI("PKI"),
    @XmlEnumValue("eID_PKI")
    E_ID_PKI("eID_PKI"),
    @XmlEnumValue("eID_PKI_MoC")
    E_ID_PKI_MO_C("eID_PKI_MoC");
    private final String value;

    AppletTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AppletTypes fromValue(String v) {
        for (AppletTypes c: AppletTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
