
package com.biosec.icams;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cardStatusChangeReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cardStatusChangeReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="stolen"/>
 *     &lt;enumeration value="lost"/>
 *     &lt;enumeration value="expired"/>
 *     &lt;enumeration value="post_issuance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "cardStatusChangeReason")
@XmlEnum
public enum CardStatusChangeReason {

    @XmlEnumValue("stolen")
    STOLEN("stolen"),
    @XmlEnumValue("lost")
    LOST("lost"),
    @XmlEnumValue("expired")
    EXPIRED("expired"),
    @XmlEnumValue("post_issuance")
    POST_ISSUANCE("post_issuance");
    private final String value;

    CardStatusChangeReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardStatusChangeReason fromValue(String v) {
        for (CardStatusChangeReason c: CardStatusChangeReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
