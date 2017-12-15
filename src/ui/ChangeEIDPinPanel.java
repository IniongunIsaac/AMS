/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.biosec.ams.core.CardOperations;
import com.biosec.ams.core.ReturnMessage;
import com.biosec.ams.core.WebServiceCommunicator;
import com.biosec.icams.RetrievePINResponse;
import com.c10n.scalibur.ChannelException;
import com.c10n.scalibur.bio.Scanner;
import com.c10n.scalibur.ngeid.card.NGeIDCard;
import com.c10n.scalibur.ngeid.profile.NGeIDProfile;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.persistence.EntityManager;
import javax.smartcardio.Card;
import javax.smartcardio.CardTerminal;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import utilities.UtilityOperations;

/**
 *
 * @author INIONGUN ISAAC I
 */
public class ChangeEIDPinPanel extends javax.swing.JPanel {

    NGeIDProfile ngEIDProfile;
    CardTerminal cardTerminal;
    Scanner scanner;
    Card card;

    int fingerValue;

    ButtonGroup btnGrp;

    UtilityOperations utilOps;
    WebServiceCommunicator webServiceCommunicator;
    private EntityManager entityManager;
    
    private AncestorEvent ancestorEvent;
    
    public ChangeEIDPinPanel() {
        initComponents();
        
        utilOps = new UtilityOperations();
        
        //vertically align components on the output window
        outputPanelOnScrollPane.setLayout(new BoxLayout(outputPanelOnScrollPane, BoxLayout.Y_AXIS));
        
        //Add padding to the output panel
        utilOps.addPadding(outputPanelOnScrollPane, 15, 15, 15, 15);
        
        //Listen for when the Panel state changes
        this.addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event) {
                
                //Initialize card reader device
                initializeCardReaderDeviceWithNigerianEIDCardAsync();

                ancestorEvent = event;
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                
            }
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputPanelOnScrollPane = new javax.swing.JPanel();
        btnReInitializeAndChangeEIDPin = new javax.swing.JButton();
        btnClearOutput = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change eID Pin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        outputPanelOnScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        outputPanelOnScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Window"));

        javax.swing.GroupLayout outputPanelOnScrollPaneLayout = new javax.swing.GroupLayout(outputPanelOnScrollPane);
        outputPanelOnScrollPane.setLayout(outputPanelOnScrollPaneLayout);
        outputPanelOnScrollPaneLayout.setHorizontalGroup(
            outputPanelOnScrollPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        outputPanelOnScrollPaneLayout.setVerticalGroup(
            outputPanelOnScrollPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(outputPanelOnScrollPane);

        btnReInitializeAndChangeEIDPin.setText("Re-Initialize & Change eID Pin");
        btnReInitializeAndChangeEIDPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReInitializeAndChangeEIDPinActionPerformed(evt);
            }
        });

        btnClearOutput.setText("Clear Output");
        btnClearOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReInitializeAndChangeEIDPin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearOutput)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReInitializeAndChangeEIDPin)
                    .addComponent(btnClearOutput))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOutputActionPerformed
        
        outputPanelOnScrollPane.removeAll();
        outputPanelOnScrollPane.revalidate();
        outputPanelOnScrollPane.repaint();
        
    }//GEN-LAST:event_btnClearOutputActionPerformed

    private void btnReInitializeAndChangeEIDPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReInitializeAndChangeEIDPinActionPerformed
        
        //Change eIDPin
        changeEIDPinAsync(evt);
        
    }//GEN-LAST:event_btnReInitializeAndChangeEIDPinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearOutput;
    private javax.swing.JButton btnReInitializeAndChangeEIDPin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel outputPanelOnScrollPane;
    // End of variables declaration//GEN-END:variables


    private void populateOutputWindow(String output, int outputType) {

        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Color color = null;

                switch (outputType) {
                    case 0:
                        color = Color.decode("0xFF0000");
                        break;
                    case 1:
                        color = Color.decode("0x006633");
                        break;
                    case 2:
                        color = Color.decode("0xE26633");
                        break;
                }

//                JLabel outputLabel = new JLabel(output);
//                outputLabel.setForeground(color);
//                outputLabel.setFont(new Font("", Font.PLAIN, 16));
                JTextArea outputTextArea = new JTextArea(2, 20);
                outputTextArea.setText("# " + output);
                outputTextArea.setWrapStyleWord(true);
                outputTextArea.setLineWrap(true);
                outputTextArea.setOpaque(false);
                outputTextArea.setEditable(false);
                outputTextArea.setFocusable(false);
                outputTextArea.setBackground(UIManager.getColor("Label.background"));
                outputTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
                outputTextArea.setForeground(color);
                outputTextArea.setBorder(UIManager.getBorder("Label.border"));

                outputPanelOnScrollPane.add(outputTextArea);
                //outputPanelOnScrollPane.add(Box.createVerticalStrut(0));
                //outputPanelOnScrollPane.add(Box.createRigidArea(new Dimension(0,0)));
                outputPanelOnScrollPane.validate();
                return null;
            }
        };
        mySwingWorker.execute();
    }

    private void initializeCardReaderDeviceWithNigerianEIDCard(final int choice) {
        try {
            this.cardTerminal = new CardOperations().chooseTerminal(choice);

            if (this.cardTerminal != null) {
                this.card = this.cardTerminal.connect("*");

                if (this.card != null) {
                    this.ngEIDProfile = new NGeIDProfile(this.card);
                    this.card.beginExclusive();
                    if (!this.ngEIDProfile.isInstance()) {
                        populateOutputWindow("Card reader " + this.cardTerminal.getName() + " does not contain a Nigerian eID Card.", 0);
                    } else {
                        populateOutputWindow("Card reader " + this.cardTerminal.getName() + " contains a valid Nigerian eID Card.", 1);

                        //Change eIDPin
                        changeEIDPinAsync(ancestorEvent);

                    }
                    this.card.endExclusive();
                    this.ngEIDProfile.fallback();
                } else {
                    populateOutputWindow("Card reader " + this.cardTerminal.getName() + " does not contain any Card.", 2);
                }

            } else {
                populateOutputWindow("No Card Reader Device Found. Please try again.", 0);
            }
        } catch (Exception ex) {
            populateOutputWindow("An error occurred while initializing Card Reader Device. " + ex.getMessage(), 0);
        }
    }

    private void initializeCardReaderDeviceWithNigerianEIDCardAsync() {
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                initializeCardReaderDeviceWithNigerianEIDCard(0);
                return null;
            }
        };
        mySwingWorker.execute();
    }

    private void changeEIDPinAsync(AWTEvent event) {
        
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                changeEIDPin();
                return null;
            }
        };

        Window win = SwingUtilities.getWindowAncestor((Component) event.getSource());
        final JDialog dialog = new JDialog(win, "Dialog", Dialog.ModalityType.APPLICATION_MODAL);

        mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("state")) {
                    if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                        dialog.dispose();
                    }
                }
            }
        });
        mySwingWorker.execute();

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        JPanel panel = new JPanel(new BorderLayout());
        utilOps.addPadding(panel, 15, 15, 15, 15);
        panel.add(progressBar, BorderLayout.CENTER);
        JLabel messageLabel = new JLabel("Changing eID Pin for Card, Please wait...");
        messageLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        utilOps.addPadding(messageLabel, 0, 0, 10, 0);
        panel.add(messageLabel, BorderLayout.PAGE_START);
        //disable canceling the dialog
        dialog.setUndecorated(true);
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(win);
        dialog.setVisible(true);
        
    }
    
    private void changeEIDPin(){
        
        try {

            //this.fingerValue = -1;
            NGeIDCard nGeIDCard = null;

            try {
                nGeIDCard = new NGeIDCard(this.cardTerminal);
            } catch (ChannelException ex) {
                populateOutputWindow("There was a disconnection with the Card Reader Device. Re-Initializing... " + ex.getMessage(), 0);
                this.initializeCardReaderDeviceWithNigerianEIDCardAsync();
                try {
                    nGeIDCard = new NGeIDCard(this.cardTerminal);
                } catch (ChannelException e) {
                    populateOutputWindow("Card Reader Re-Initializing failed. " + e.getMessage(), 0);
                    return;
                }
            }

            try {

                populateOutputWindow("Change eID PIN process initiated .....", 1);
                populateOutputWindow("You will be required to provide your earlier eID PIN to complete this process.....", 1);

                final String chipId = nGeIDCard.readChipId();
                RetrievePINResponse rpResponse = null;
                char[] puk = null;
                char[] sopin = null;

                try {

                    try{
                        
                        new WebServiceCommunicator();
                        rpResponse = WebServiceCommunicator.rPins(chipId);
                        if (rpResponse.getReturnMessage().equalsIgnoreCase("error")) {
                            populateOutputWindow("Unable to obtain Pins for this card. Done", 0);
                            return;
                        }
                        puk = rpResponse.getPuk().toCharArray();
                        sopin = rpResponse.getSopin().toCharArray();
                        populateOutputWindow("Pins successfully retrieved.", 1);
                        
                    }catch(Exception ex){
                        populateOutputWindow("Unable to Retrieve Pins for Card", 0);
                        return;
                    }

                    ReturnMessage returnMessage = new ReturnMessage();
                    
                    returnMessage = new CardOperations().changeEIDPIN_PIN(new NGeIDCard(this.cardTerminal));
                    if (returnMessage.isResult()) {
                        //mn.insertLogs(MainPanel.this.em, "changeeidpin", chipId, "success", "notrequired", Login.user.getUsername(), rt.getMessage(), null);
                        populateOutputWindow("eID Pin Changed successfully.", 1);
                        utilOps.displayMessage("eID Pin Changed successfully.", "Success Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        populateOutputWindow("eID Pin not Changed, please try again.", 1);
                        utilOps.displayMessage("eID Pin not changed, please try again.", "Error Message", JOptionPane.ERROR_MESSAGE);
                        //mn.insertLogs(MainPanel.this.em, "changeeidpin", chipId, "failed", "notrequired", Login.user.getUsername(), rt.getMessage(), null);
                    }

                } catch (Exception ex) {
                    populateOutputWindow("Unable to retrieve Pins: " + ex.getMessage(), 0);
                    return;
                }

            } catch (Exception ex) {
                //this.resetSelectedFinger();
                populateOutputWindow("An error occured: " + ex.getMessage(), 0);
            }

            //}
        } finally {
            //btnActivateCard.setEnabled(true);
        }
        
    }
}
