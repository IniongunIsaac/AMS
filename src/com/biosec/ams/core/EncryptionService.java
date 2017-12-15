// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.core;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Hashtable;
import java.io.File;

public class EncryptionService
{
    public Hashtable<String, String> getSOPINPUK(final File f) {
        final Hashtable<String, String> data = new Hashtable<String, String>();
        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            final NodeList nodes = doc.getElementsByTagName("QCMResponse");
            for (int i = 0; i < nodes.getLength(); ++i) {
                final Node node = nodes.item(i);
                if (node.getNodeType() == 1) {
                    final Element element = (Element)node;
                    data.put("code", getValue("documentNo", element));
                    data.put("documentNo", getValue("documentNo", element));
                    data.put("PUK", getValue("PUK", element));
                    data.put("SOPIN", getValue("SOPIN", element));
                }
            }
        }
        catch (Exception ex) {}
        return data;
    }
    
    public Hashtable<String, String> getSOPINPUK(final String s) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        final Hashtable<String, String> data = new Hashtable<String, String>();
        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(s);
            doc.getDocumentElement().normalize();
            System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttt");
            final NodeList nodes = doc.getElementsByTagName("QCMResponse");
            for (int i = 0; i < nodes.getLength(); ++i) {
                final Node node = nodes.item(i);
                if (node.getNodeType() == 1) {
                    final Element element = (Element)node;
                    data.put("code", getValue("documentNo", element));
                    data.put("documentNo", getValue("documentNo", element));
                    data.put("PUK", getValue("PUK", element));
                    data.put("SOPIN", getValue("SOPIN", element));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    private static String getValue(final String tag, final Element element) {
        final NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        final Node node = nodes.item(0);
        return node.getNodeValue();
    }
}
