package com.biosec.ams.core;

import com.biosec.icams.AppletStates;
import com.biosec.icams.AppletTypes;
import com.biosec.icams.CardStatusChangeFeedBackResponse;
import com.biosec.icams.IcamsWS;
import com.biosec.icams.IcamsWS_Service;
import com.biosec.icams.RetrievePINResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class WebServiceCommunicator {
    
    private static final String USERNAME = "admin1";
    private static final String PASSWORD = "weperm4now";
    private static URL URL;
    private static final String urlStr = "http://192.168.43.83:8180/iCams-ejb/IcamsWS/IcamsWS?wsdl";
    
    public WebServiceCommunicator(){
        try {
            URL = new URL(urlStr);
        } catch (MalformedURLException ex) {
            System.out.println("Error forming URL: " + ex.getMessage());
        }
    }
    
    public static void main(final String[] args) {
        try {
            updateICAMS(AppletTypes.E_ID_PKI, "3360009076971498");
        }
        catch (Exception no) {
            no.printStackTrace();
        }
    }
    
    public static void updateICAMS(final AppletTypes atype, final String chipId) {
        try {
            //System.out.println(PASSWORD);
            final CardStatusChangeFeedBackResponse rs = sendCardStatusFeedBack(URL, USERNAME, PASSWORD, chipId, atype, AppletStates.ACTIVE);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateICAMS000(final AppletTypes atype, final String chipId) {
        final IcamsWS_Service wx = new IcamsWS_Service(URL);
        final IcamsWS iws = wx.getIcamsWSPort();
        iws.sendCardStatusFeedBack(USERNAME, PASSWORD, chipId, atype, AppletStates.ACTIVE);
    }
    
    public String removePadding(String pin) {
        pin = pin.trim();
        if (pin.length() <= 8) {
            return pin;
        }
        final char[] pinc = pin.toCharArray();
        String unpaddedPin = "";
        for (int x = 1; x < pinc.length; ++x, ++x) {
            unpaddedPin += pinc[x];
        }
        return unpaddedPin;
    }
    
    public static SopinPuk getPins_deprectated(final String chipid) {
        final SopinPuk sp = new SopinPuk();
        try {
            final RetrievePINResponse response = rPins(chipid);
            sp.setPuk(response.getPuk());
            sp.setSopin(response.getSopin());
            return sp;
        }
        catch (Exception n) {
            n.printStackTrace();
            System.out.println("No SoPIN and PUK found for this individual");
            return null;
        }
    }
    
    public static RetrievePINResponse rPins(final String chipId) throws Exception {
        final IcamsWS_Service wx = new IcamsWS_Service();
        final IcamsWS iws = wx.getIcamsWSPort();
        return iws.retrievePINS(USERNAME, PASSWORD, chipId);
    }
    
    private static RetrievePINResponse retrievePINS(final String username, final String password, final String cardId) {
        final IcamsWS_Service service = new IcamsWS_Service();
        final IcamsWS port = service.getIcamsWSPort();
        return port.retrievePINS(username, password, cardId);
    }
    
    private static CardStatusChangeFeedBackResponse sendCardStatusFeedBack(final URL url, final String username, final String password, final String cardId, final AppletTypes appletObj, final AppletStates statusObj) throws Exception {
        final IcamsWS_Service service = new IcamsWS_Service(url);
        final IcamsWS port = service.getIcamsWSPort();
        return port.sendCardStatusFeedBack(username, password, cardId, appletObj, statusObj);
    }
}
