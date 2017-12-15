// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.callbacks;

import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.card.pin.PinCallback;

public class PinCallbackFromWS implements PinCallback
{
    String value;
    
    public PinCallbackFromWS(final String value) {
        this.value = value;
    }
    
    public PinCallback.PinValue getPin() throws SCaliburException {
        return new PinCallback.PinValue(this.value.toCharArray());
    }
}
