
package com.biosec.icams;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for appletStates.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="appletStates">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="active"/>
 *     &lt;enumeration value="blocked"/>
 *     &lt;enumeration value="suspend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "appletStates")
@XmlEnum
public enum AppletStates {

    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("blocked")
    BLOCKED("blocked"),
    @XmlEnumValue("suspend")
    SUSPEND("suspend");
    private final String value;

    AppletStates(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AppletStates fromValue(String v) {
        for (AppletStates c: AppletStates.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
