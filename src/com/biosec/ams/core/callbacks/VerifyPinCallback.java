// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.core.callbacks;

import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.card.pin.PinCallback;

class VerifyPinCallback implements PinCallback
{
    char[] value;
    String name;
    
    public VerifyPinCallback(final String name, final char[] value) {
        this.name = name;
        this.value = value;
    }
    
    public PinCallback.PinValue getPin() throws SCaliburException {
        return new PinCallback.PinValue(this.value);
    }
}
