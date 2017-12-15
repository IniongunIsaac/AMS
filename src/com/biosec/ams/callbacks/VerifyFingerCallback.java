// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.callbacks;

import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.ngeid.card.NGeIDCard;
import com.c10n.scalibur.bio.Biometrics;
import com.c10n.scalibur.card.fp.FingerprintCallback;
import ui.ActivateCardPanel_Copy;

public class VerifyFingerCallback implements FingerprintCallback
{
    int fingerPos;
    Biometrics bio;
    NGeIDCard idCard;
    String[] fingerNames;
    
    public VerifyFingerCallback(final NGeIDCard idCard, final Biometrics bio, final int fingerPos) {
        this.fingerNames = new String[] { "Left Thumb", "Left Index Finger", "Left Middle Finger", "Left Ring Finger", "Left Little Finger", "Right Thumb", "Right Index Finger", "Right Middle Finger", "Right Ring Finger", "Right Little Finger" };
        this.fingerPos = fingerPos;
        this.bio = bio;
        this.idCard = idCard;
    }
    
    public FingerprintCallback.Minutiae getMinutiae() {
        try{
            byte[] minutiae = null;
        final String[] scannerNames = this.bio.getScannerNames();
        final int scanner = 0;
        //System.out.println();
        //ActivateCardPanel_Copy ac = new ActivateCardPanel_Copy();
        //ac.populateOutputWindow("Please put your " + this.fingerNames[this.fingerPos] + " on " + scannerNames[scanner] + ".", 2);
        System.out.println("Please put your " + this.fingerNames[this.fingerPos] + " on " + scannerNames[scanner] + ".");
        System.out.println("Capturing...");
        //ac.populateOutputWindow("Capturing....", 1);
        try {
            minutiae = this.bio.getScanner(scannerNames[scanner]).capture().extract(this.idCard.getFingerprints()[this.fingerPos].getMaxMinutiae());
        }
        catch (Exception e) {
            System.out.println("device failure. check if fingerprint scanner device is properly pluffed");
            //ac.populateOutputWindow("device failure. check if fingerprint scanner device is properly pluffed", 0);
            e.printStackTrace();
            return null;
        }
        System.out.println("Done.");
        //ac.populateOutputWindow("done", 1);
        return new FingerprintCallback.Minutiae(minutiae);
        }
    catch(Exception ex){
        System.out.println("Scalibur exception" + ex.getMessage());
}
        return null;
    }
}
