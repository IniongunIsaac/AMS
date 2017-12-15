// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.callbacks;

import com.c10n.scalibur.ngeid.card.NGeIDCard;
import java.util.Arrays;
import java.util.List;
import java.io.Console;
import java.io.IOException;
import com.c10n.scalibur.SCaliburException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Password
{
    String[] fingerNames;
    
    public Password() {
        this.fingerNames = new String[] { "Left Thumb", "Left Index Finger", "Left Middle Finger", "Left Ring Finger", "Left Little Finger", "Right Thumb", "Right Index Finger", "Right Middle Finger", "Right Ring Finger", "Right Little Finger" };
    }
    
    public char[] readPassword() throws SCaliburException {
        final Console cons = System.console();
        if (null == cons) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                return in.readLine().toCharArray();
            }
            catch (IOException e) {
                throw new SCaliburException("unable to read Password.", (Throwable)e);
            }
        }
        return cons.readPassword();
    }
    
    private int choose(final String message, final List<?> options) throws IOException {
        if (1 == options.size()) {
            System.out.println("Using: " + options.get(0));
            return 0;
        }
        System.out.println(message + ":");
        if (0 == options.size()) {
            System.out.println(" no device present!");
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
    
    public int choose(final String message, final String[] options) throws IOException {
        return this.choose(message, Arrays.asList(options));
    }
    
    public int chooseFinger(final NGeIDCard idCard) throws Exception {
        System.out.println();
        final int fingerPos = this.choose("Choose finger to scan", this.fingerNames);
        if (!idCard.getFingerprints()[fingerPos].getExistenceTester().exists()) {
            throw new SCaliburException("Finger " + fingerPos + " does not exist on card.");
        }
        if (0 == idCard.getFingerprints()[fingerPos].getRetryCounterReader().read()) {
            throw new SCaliburException("Finger " + fingerPos + " is blocked on card.");
        }
        return fingerPos;
    }
}
