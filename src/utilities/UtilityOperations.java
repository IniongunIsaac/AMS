/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ui.DashboardFrame;

/**
 *
 * @author INIONGUN ISAAC I
 */
public class UtilityOperations {
    
    public void centralizeFrame(Component component){
        //position the JFrame in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        component.setLocation(dim.width / 2 - component.getSize().width / 2, dim.height / 2 - component.getSize().height / 2);
    }
    
    public void setFrameIcon(Component component){
        ImageIcon img = new ImageIcon("C:\\Users\\INIONGUN ISAAC I\\Documents\\NetBeansProjects\\AMSClient\\src\\res\\images\\nimccard.jpg");
        //component.setIconImage(img.getImage());
    }
    
    public void addPadding(JComponent component, int top, int right, int bottom, int left){
        component.setBorder(BorderFactory.createCompoundBorder(component.getBorder(), BorderFactory.createEmptyBorder(top, right, bottom, left)));
    }
    
    public void displayMessage(String message, String title, int messageType){
        int msgType;
        switch(messageType){
            case JOptionPane.ERROR_MESSAGE:
                msgType = JOptionPane.ERROR_MESSAGE;
                break;
            case JOptionPane.INFORMATION_MESSAGE:
                msgType = JOptionPane.INFORMATION_MESSAGE;
                break;
            case JOptionPane.WARNING_MESSAGE:
                msgType = JOptionPane.WARNING_MESSAGE;
                break;
        }
        
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
    
    public URL getURL(String url) throws MalformedURLException {
        return new URL(url);
    }
    
}
