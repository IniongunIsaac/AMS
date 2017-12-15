// 
// Decompiled by Procyon v0.5.30
// 

package utilities;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JTextArea;
import java.io.OutputStream;
import javax.swing.UIManager;

public class CustomOutputStream extends OutputStream
{
    private JTextArea textArea;
    
    public CustomOutputStream(final JTextArea textArea) {
        this.textArea = textArea;
        this.textArea.setWrapStyleWord(true);
        this.textArea.setLineWrap(true);
        this.textArea.setOpaque(false);
        this.textArea.setEditable(false);
        this.textArea.setFocusable(false);
        this.textArea.setBackground(Color.WHITE);
        this.textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        this.textArea.setForeground(Color.decode("0x006633"));
        this.textArea.setBorder(UIManager.getBorder("Label.border"));
    }
    
    @Override
    public void write(final int b) throws IOException {
        this.textArea.append(String.valueOf((char)b));
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
    }
}
