/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosec.ams.core;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.c10n.scalibur.ngeid.profile.NGeIDProfile;
import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.card.pin.IgnoreSpePinCallback;
import com.biosec.ams.callbacks.VerifyFingerCallback;
import com.c10n.scalibur.ngeid.card.Fingerprint;
import com.c10n.scalibur.profile.IsoFingerprint;
import com.c10n.scalibur.card.fp.FingerprintCallback;
import com.c10n.scalibur.bio.Biometrics;
import java.util.Arrays;
import javax.persistence.EntityManager;
import com.c10n.scalibur.card.pin.PinCallback;
import com.biosec.ams.callbacks.ChangePinCallBack;
import com.biosec.ams.callbacks.VerifyPinCallback;
import com.biosec.ams.core.callbacks.IgnoreSpeVerifyPinCallBack;
import com.c10n.scalibur.ExecutePACEException;
import com.c10n.scalibur.PinException;
import com.c10n.scalibur.card.pin.PinPairCallback;
import com.c10n.scalibur.ngeid.card.NGeIDCard;
import java.util.List;
import javax.smartcardio.CardTerminals;
import com.c10n.scalibur.SCalibur;
import javax.smartcardio.CardTerminal;
import ui.ActivateCardPanel_Copy;

public class CardOperations
{
    public final String[] fingerNames;
    
    public CardOperations() {
        this.fingerNames = new String[] { "Left Thumb", "Left Index Finger", "Left Middle Finger", "Left Ring Finger", "Left Little Finger", "Right Thumb", "Right Index Finger", "Right Middle Finger", "Right Ring Finger", "Right Little Finger" };
    }
    
    public CardTerminal chooseTerminal(final int choice) throws Exception {
        final List<CardTerminal> terminals = SCalibur.getTerminalFactory().terminals().list(CardTerminals.State.CARD_PRESENT);
        final int index = this.choose("Choose smart card reader", terminals, choice);
        return terminals.get(index);
    }
    
    public ReturnMessage changeEIDPIN_PIN(final NGeIDCard idCard) throws Exception {
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getProfile().getCard().beginExclusive();
            idCard.getProfile().getMfPath().select();
            idCard.getProfile().getCard().endExclusive();
            idCard.getEIdPin().getChanger().change((PinPairCallback)null);
            System.out.println("You can unplug the card ");
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
            returnMessage.setResult(true);
        }
        catch (PinException e) {
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            returnMessage.setMessage(e.getMessage());
        }
        catch (ExecutePACEException e2) {
            e2.printStackTrace();
            System.out.println(e2.getClass().getSimpleName() + ": " + e2.getMessage());
            returnMessage.setMessage(e2.getMessage());
        }
        return returnMessage;
    }
    
    @Deprecated
    public void changeEIDPIN_PUKPIN(final NGeIDCard idCard, String puk, String npin) throws Exception {
        try {
            idCard.getEIdPin().getPukResetter().reset((PinCallback)new VerifyPinCallback("eID PUK"), (PinCallback)new ChangePinCallBack("eID PIN"));
            System.out.println("Change successful!");
        }
        catch (PinException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        catch (ExecutePACEException e2) {
            System.out.println(e2.getClass().getSimpleName() + ": " + e2.getMessage());
        }
        finally {
            puk = null;
            npin = null;
        }
    }
    
    public ReturnMessage changeEIDPIN_PUK2(final NGeIDCard idCard, char[] puk, final String chipid) throws Exception {
        char[] newPin = null;
        char[] newPin2 = null;
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getEIdPin().getPukResetter().reset((PinCallback)new IgnoreSpeVerifyPinCallBack("eID PUK", puk), (PinCallback)new ChangePinCallBack("eID PIN"));
            System.out.println("You can unplug the card ");
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
            returnMessage.setResult(true);
            return returnMessage;
        }
        catch (PinException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            returnMessage.setMessage(e.getMessage());
            e.printStackTrace();
        }
        catch (ExecutePACEException e2) {
            System.out.println(e2.getClass().getSimpleName() + ": " + e2.getMessage());
            e2.printStackTrace();
            returnMessage.setMessage(e2.getMessage());
        }
        finally {
            if (null != puk) {
                Arrays.fill(puk, '\0');
                puk = null;
            }
            if (null != newPin) {
                Arrays.fill(newPin, '\0');
                newPin = null;
            }
            if (null != newPin2) {
                Arrays.fill(newPin2, '\0');
                newPin2 = null;
            }
        }
        return returnMessage;
    }
    
    public ReturnMessage changeUserPIN_PIN(final NGeIDCard idCard, final String chipid) throws Exception {
        char[] pin = null;
        char[] newPin = null;
        char[] newPin2 = null;
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getEPkiUserPin().getChanger().change((PinCallback)new VerifyPinCallback("ePKI User PIN"), (PinCallback)new ChangePinCallBack("ePKI User PIN"));
            System.out.println("ePKI Pin Change successful!");
            System.out.println("_________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            returnMessage.setResult(true);
            return returnMessage;
        }
        catch (PinException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            returnMessage.setMessage(e.getMessage());
        }
        finally {
            if (null != pin) {
                Arrays.fill(pin, '\0');
                pin = null;
            }
            if (null != newPin) {
                Arrays.fill(newPin, '\0');
                newPin = null;
            }
            if (null != newPin2) {
                Arrays.fill(newPin2, '\0');
                newPin2 = null;
            }
        }
        return returnMessage;
    }
    
    public ReturnMessage changeUserPINwithMoC2(final NGeIDCard idCard, final int fingerPos, final String chipid, final byte[] minutiae) throws Exception {
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            final Biometrics bio = new Biometrics();
            final int isTherValidVerifiableFinger = this.checkFinger(idCard, fingerPos);
            if (isTherValidVerifiableFinger != 0) {}
            final FingerprintCallback fpCb = (FingerprintCallback)new FingerprintCallback() {
                public FingerprintCallback.Minutiae getMinutiae() throws Exception {
                    return new FingerprintCallback.Minutiae(minutiae);
                }
            };
            final Fingerprint fp = idCard.getFingerprints()[fingerPos];
            System.out.println("Please enter and re-enter new ePKI User PIN on Pinpad");
            final ChangePinCallBack ccb = new ChangePinCallBack("ePKI User PIN");
            final com.c10n.scalibur.ngeid.profile.Fingerprint fprint = fp.getProfileFingerprint();
            idCard.getEPkiUserPin().getFingerprintResetter().reset((PinCallback)ccb, (IsoFingerprint)fprint, fpCb);
            System.out.println("ePKI pin successfully set");
            returnMessage.setResult(true);
            return returnMessage;
        }
        catch (PinException e) {
            returnMessage.setResult(false);
            System.out.println(e.getMessage());
            returnMessage.setMessage(e.getMessage());
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
            return returnMessage;
        }
        catch (Exception eo) {
            returnMessage.setResult(false);
            returnMessage.setMessage(eo.getMessage());
            return returnMessage;
        }
    }
    
    public ReturnMessage changeUserPINwithMoC(final EntityManager em, final String username, final NGeIDCard idCard, final int fingerPos, final String chipid, final byte[] mi) throws Exception {
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            final Biometrics bio = new Biometrics();
            final int isTherValidVerifiableFinger = this.checkFinger(idCard, fingerPos);
            if (isTherValidVerifiableFinger != 0) {}
            final FingerprintCallback fpCb = (FingerprintCallback)new VerifyFingerCallback(idCard, bio, fingerPos);
            final Fingerprint fp = idCard.getFingerprints()[fingerPos];
            final ChangePinCallBack ccb = new ChangePinCallBack("ePKI User PIN");
            final com.c10n.scalibur.ngeid.profile.Fingerprint fprint = fp.getProfileFingerprint();
            idCard.getEPkiUserPin().getFingerprintResetter().reset((PinCallback)ccb, (IsoFingerprint)fprint, fpCb);
            System.out.println("ePKI Pin successfully set");
            returnMessage.setResult(true);
            return returnMessage;
        }
        catch (PinException e) {
            System.out.println("Fingerprint verification failed!");
            returnMessage.setMessage("Fingerprint verification failed!");
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
            return returnMessage;
        }
        catch (Exception eo) {
            returnMessage.setMessage(eo.getMessage());
            return returnMessage;
        }
    }
    
    public ReturnMessage changeUserPIN_PUK(final EntityManager em, final String username, final NGeIDCard idCard, final String sopin, final String chipid) throws Exception {
        char[] pin = null;
        char[] newPin = null;
        char[] newPin2 = null;
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getEPkiUserPin().getUnblocker().unblock((PinCallback)new VerifyPinCallback("ePKI SO PIN"));
            System.out.println("Unblock succesfull!");
            System.out.println("ePKI Pin Change successful!");
            returnMessage.setResult(true);
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
        }
        catch (PinException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            returnMessage.setMessage(e.getMessage());
        }
        finally {
            if (null != pin) {
                Arrays.fill(pin, '\0');
                pin = null;
            }
            if (null != newPin) {
                Arrays.fill(newPin, '\0');
                newPin = null;
            }
            if (null != newPin2) {
                Arrays.fill(newPin2, '\0');
                newPin2 = null;
            }
        }
        return returnMessage;
    }
    
    public ReturnMessage unblockeidPIN(final NGeIDCard idCard, final char[] puk) throws Exception {
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getEIdPin().getUnblocker().unblock((PinCallback)new IgnoreSpePinCallback() {
                public PinCallback.PinValue getPin() throws Exception {
                    return new PinCallback.PinValue(puk);
                }
            });
            System.out.println("eID pin successfully unblocked");
            returnMessage.setResult(true);
        }
        catch (Exception ex) {
            returnMessage.setResult(false);
            returnMessage.setMessage(ex.getMessage());
        }
        return returnMessage;
    }
    
    public ReturnMessage unblockUserPIN(final NGeIDCard idCard, final char[] puk) throws Exception {
        final ReturnMessage returnMessage = new ReturnMessage();
        try {
            idCard.getEPkiUserPin().getUnblocker().unblock((PinCallback)new IgnoreSpePinCallback() {
                public PinCallback.PinValue getPin() throws Exception {
                    return new PinCallback.PinValue(puk);
                }
            });
            System.out.println("epki pin successfully unblocked");
            returnMessage.setResult(true);
        }
        catch (Exception ex) {
            returnMessage.setResult(false);
            returnMessage.setMessage(ex.getMessage());
        }
        return returnMessage;
    }
    
    public String identifyChip(final NGeIDCard idCard) throws Exception {
        final String hexChipId = idCard.readChipId();
        System.out.println("Chip ID: 0x" + hexChipId);
        return hexChipId;
    }
    
    public byte[] verifyFinger2(final NGeIDCard idCard, final int fingerPos) throws Exception {
        final Biometrics bio = new Biometrics();
        final byte[][] minutiae = { null };
        final FingerprintCallback fpCb = (FingerprintCallback)new VerifyFingerCallback(idCard, bio, fingerPos) {
            @Override
            public FingerprintCallback.Minutiae getMinutiae() {
                final FingerprintCallback.Minutiae m = super.getMinutiae();
                minutiae[0] = Arrays.copyOf(m.getValue(), m.getValue().length);
                return m;
            }
        };
        idCard.getFingerprints()[fingerPos].getVerifier().verify(fpCb);
        return minutiae[0];
    }
    
    public boolean verifyFinger(final NGeIDCard idCard, final int fingerPos) throws Exception {
        byte[] minutiae = null;
        final Biometrics bio = new Biometrics();
        try {
            final int isTherValidVerifiableFinger = this.checkFinger(idCard, fingerPos);
            if (isTherValidVerifiableFinger != 0) {
                return false;
            }
            final com.c10n.scalibur.ngeid.profile.Fingerprint fp = this.getFingerprintByPosition(idCard.getProfile(), fingerPos);
            minutiae = this.getMinutiae(bio, fingerPos, fp.getMaxMinutiae(), 2);
            idCard.getProfile().getCard().beginExclusive();
            return this.verifyFinger(idCard, fingerPos, minutiae);
        }
        finally {
            if (null != minutiae) {
                Arrays.fill(minutiae, (byte)0);
                minutiae = null;
            }
        }
    }
    
    public boolean verifyFinger(final NGeIDCard idCard, final int fingerPos, final byte[] minutiae) throws Exception {
        try {
            final com.c10n.scalibur.ngeid.profile.Fingerprint fp = this.getFingerprintByPosition(idCard.getProfile(), fingerPos);
            fp.verify(minutiae);
            System.out.println("Verification successful!");
            return true;
        }
        catch (PinException e) {
            System.out.println("Fingerprint verification failed!");
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    private int checkFinger(final NGeIDCard idCard, final int fingerPos) throws Exception {
        if (!idCard.getFingerprints()[fingerPos].getExistenceTester().exists()) {
            System.out.println("Finger " + this.fingerNames[fingerPos] + " does not exist on card!");
            return -1;
        }
        if (0 == idCard.getFingerprints()[fingerPos].getRetryCounterReader().read()) {
            System.out.println("Finger " + this.fingerNames[fingerPos] + " is blocked on card!");
            return -2;
        }
        return 0;
    }
    
    public int getRetryCounter(final NGeIDCard idCard, final int fingerPos) throws Exception {
        if (!idCard.getFingerprints()[fingerPos].getExistenceTester().exists()) {
            System.out.println("Finger " + this.fingerNames[fingerPos] + " does not exist on card!");
            return -1;
        }
        final int retries = idCard.getFingerprints()[fingerPos].getRetryCounterReader().read();
        System.out.println("Retries for finger " + this.fingerNames[fingerPos] + " is: " + retries);
        return retries;
    }
    
    int chooseFinger(final NGeIDCard idCard) throws Exception {
        final int fingerPos = this.choose("Choose finger to scan", this.fingerNames, 2);
        if (!idCard.getFingerprints()[fingerPos].getExistenceTester().exists()) {
            System.out.println("Finger " + this.fingerNames[fingerPos] + " does not exist on card!");
        }
        if (0 == idCard.getFingerprints()[fingerPos].getRetryCounterReader().read()) {
            System.out.println("Finger " + this.fingerNames[fingerPos] + " is blocked on card!");
        }
        return fingerPos;
    }
    
    public byte[] getMinutiae(final Biometrics bio, final int fingerPos, final int maxMinutiae, final int choice) throws Exception {
        byte[] minutiae = null;
        final String[] scannerNames = bio.getScannerNames();
        final int scanner = 0;
        System.out.println("Please put your " + this.fingerNames[fingerPos] + " on " + scannerNames[scanner] + ".");
        System.out.println("Capturing...");
        minutiae = bio.getScanner(scannerNames[scanner]).capture().extract(maxMinutiae);
        System.out.println("Done.");
        return minutiae;
    }
    
    public com.c10n.scalibur.ngeid.profile.Fingerprint getFingerprintByPosition(final NGeIDProfile profile, final int fingerPos) throws Exception {
        switch (fingerPos) {
            case 0: {
                return profile.getLeftThumb();
            }
            case 1: {
                return profile.getLeftPointer();
            }
            case 2: {
                return profile.getLeftMiddle();
            }
            case 3: {
                return profile.getLeftRing();
            }
            case 4: {
                return profile.getLeftLittle();
            }
            case 5: {
                return profile.getRightThumb();
            }
            case 6: {
                return profile.getRightPointer();
            }
            case 7: {
                return profile.getRightMiddle();
            }
            case 8: {
                return profile.getRightRing();
            }
            case 9: {
                return profile.getRightLittle();
            }
            default: {
                throw new Exception("invalid choice.");
            }
        }
    }
    
    public int choose(final String message, final String[] options, final int choice) throws IOException {
        return this.choose(message, Arrays.asList(options), choice);
    }
    
    public int choose(final String message, final List<?> options, final int choice) throws IOException {
        if (1 == options.size()) {
            System.out.println("Using: " + options.get(0));
            return 0;
        }
        System.out.println(message + ":");
        if (0 == options.size()) {
            if (choice == 1) {
                System.out.println("Device Error. Verify that the card reader is properly plugged on and card properly inserted");
            }
            else if (choice == 0) {
                System.out.println("Device Error. Plugin in card reader ");
            }
            else {
                System.out.println("Device Error. Verify that the fingerprint device is properly plugged on");
            }
            System.out.println("no device present!");
            throw new IOException("no device present!");
        }
        while (true) {
            for (int i = 0, c = options.size(); i < c; ++i) {
                System.out.printf("%2d: %s\n", i, options.get(i));
            }
            System.out.print("> ");
            final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            final String line = in.readLine();
            try {
                final int opt = Integer.parseInt(line);
                if (0 <= opt && opt < options.size()) {
                    return opt;
                }
            }
            catch (NumberFormatException ex) {}
            System.out.println("Please enter a number between 0 and " + (options.size() - 1) + ".");
        }
    }
}
