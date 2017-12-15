// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.callbacks;

import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.card.pin.PinCallback;

public class VerifyPinCallback implements PinCallback
{
    String name;
    
    public VerifyPinCallback(final String name) {
        this.name = name;
    }
    
    public PinCallback.PinValue getPin() throws SCaliburException {
        System.out.print("Enter " + this.name + ": ");
        return new PinCallback.PinValue(new Password().readPassword());
    }
}
