/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amsclient;

import com.c10n.scalibur.bio.Biometrics;

/*import com.biosec.icams.CardStatusChangeReason;
import com.biosec.icams.IcamsWS;
import com.biosec.icams.IcamsWS_Service;
import com.biosec.icams.IdTypes;
import com.biosec.icams.RequestCardStatusChangeResponse;*/

/**
 *
 * @author INIONGUN ISAAC I
 */
public class AMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*IcamsWS_Service is = new IcamsWS_Service();
        IcamsWS ip = is.getIcamsWSPort();
        IdTypes idType = null;
        CardStatusChangeReason ch = null;
        RequestCardStatusChangeResponse result =  ip.requestCardBlock("", "", idType.NIN, null, ch.EXPIRED);
        System.out.println(result.getReturnMessage());*/
        
//        String str = "201907";
//        System.out.println("Jul. " + str.substring(0,4));
//        System.out.println("Month: " + str.substring(4,6));

        Biometrics bio = new Biometrics();
        
        final String[] scannerNames = bio.getScannerNames();
        
        System.out.println("Scanner Length: " + scannerNames.length);
        System.out.println("Scanner: " + scannerNames);
        
        for(String scanner: scannerNames)
            System.out.println("Scanner Names: " + scanner);
    
    }
    
}
