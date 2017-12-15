// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.callbacks;

import com.c10n.scalibur.SCaliburException;
import java.util.Arrays;
import com.c10n.scalibur.card.pin.PinCallback;

public class ChangePinCallBack implements PinCallback
{
    String name;
    public char[] enteredPin;
    
    public ChangePinCallBack(final String name) {
        this.enteredPin = null;
        this.name = name;
    }
    
    public PinCallback.PinValue getPin() throws SCaliburException {
        System.out.print("Enter new " + this.name + ": ");
        char[] newPin = new Password().readPassword();
        System.out.print("Re-enter new " + this.name + ": ");
        char[] newPin2 = null;
        try {
            newPin2 = new Password().readPassword();
        }
        catch (SCaliburException e) {
            Arrays.fill(newPin, '\0');
            newPin = null;
        }
        if (!Arrays.equals(newPin, newPin2)) {
            System.out.println("The entered new " + this.name + "s are not equal.");
            Arrays.fill(newPin2, '\0');
            newPin2 = null;
            Arrays.fill(newPin, '\0');
            newPin = null;
            throw new SCaliburException("unable to read pins.");
        }
        Arrays.fill(newPin2, '\0');
        this.enteredPin = newPin;
        return new PinCallback.PinValue(newPin);
    }
}
