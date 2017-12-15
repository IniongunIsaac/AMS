// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.core.callbacks;

import com.c10n.scalibur.SCaliburException;
import com.c10n.scalibur.card.pin.PinCallback;
import com.c10n.scalibur.card.pin.IgnoreSpePinCallback;

public class IgnoreSpeVerifyPinCallBack extends VerifyPinCallback implements IgnoreSpePinCallback
{
    public IgnoreSpeVerifyPinCallBack(final String name, final char[] value) {
        super(name, value);
    }
}
