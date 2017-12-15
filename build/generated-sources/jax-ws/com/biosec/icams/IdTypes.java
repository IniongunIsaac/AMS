
package com.biosec.icams;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for idTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="idTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NIN"/>
 *     &lt;enumeration value="DOCUMENT_NO"/>
 *     &lt;enumeration value="CHIP_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "idTypes")
@XmlEnum
public enum IdTypes {

    NIN,
    DOCUMENT_NO,
    CHIP_ID;

    public String value() {
        return name();
    }

    public static IdTypes fromValue(String v) {
        return valueOf(v);
    }

}
