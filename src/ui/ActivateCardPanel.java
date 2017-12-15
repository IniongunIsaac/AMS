/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.biosec.ams.core.CardOperations;
import com.biosec.ams.core.ReturnMessage;
import com.biosec.ams.core.WebServiceCommunicator;
import com.biosec.ams.db.DbManager;
import com.biosec.icams.AppletTypes;
import com.biosec.icams.RetrievePINResponse;
import com.c10n.scalibur.ChannelException;
import com.c10n.scalibur.bio.Scanner;
import com.c10n.scalibur.ngeid.card.EIdPin;
import com.c10n.scalibur.ngeid.card.NGeIDCard;
import com.c10n.scalibur.ngeid.profile.NGeIDProfile;
import com.c10n.scalibur.profile.Pin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.smartcardio.Card;
import javax.smartcardio.CardTerminal;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import utilities.CustomOutputStream;
import utilities.UtilityOperations;

/**
 *
 * @author INIONGUN ISAAC I
 */
public class ActivateCardPanel extends javax.swing.JPanel{

    NGeIDProfile ngEIDProfile;
    CardTerminal cardTerminal;
    Scanner scanner;
    Card card;
    
    int fingerValue;
    
    ButtonGroup btnGrp;
    
    UtilityOperations utilOps;
    WebServiceCommunicator webServiceCommunicator;
    private EntityManager entityManager;
    
    private PrintStream standardOut;
    
    public ActivateCardPanel() {
        initComponents();
        addRadioButtonsToButtonGroup();
        
        final PrintStream printStream = new PrintStream(new CustomOutputStream(outputTextArea));
        this.standardOut = System.out;
        System.setOut(printStream);
        
        utilOps = new UtilityOperations();
        entityManager = null;
        
        //vertically align components on the output window
        //outputPanelOnScrollPane.setLayout(new BoxLayout(outputPanelOnScrollPane, BoxLayout.Y_AXIS));
//        GridLayout layout = new GridLayout(2, 1);
//        layout.setVgap(2);
//        outputPanelOnScrollPane.setLayout(layout);
        
        //Add Padding around the output window
        outputTextArea.setBorder(BorderFactory.createCompoundBorder(outputTextArea.getBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        
        //Listen for panel State changes
        this.addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event) {
                getRootPane().setDefaultButton(btnReInitialize);
                
                //Initialize card reader device
                initializeCardReaderDeviceWithNigerianEIDCardAsync();
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

        jPanel1 = new javax.swing.JPanel();
        rBtnLeftThumb = new javax.swing.JRadioButton();
        rBtnRightThumb = new javax.swing.JRadioButton();
        rBtnLeftIndex = new javax.swing.JRadioButton();
        rBtnRightIndex = new javax.swing.JRadioButton();
        rBtnRightMiddle = new javax.swing.JRadioButton();
        rBtnLeftMiddle = new javax.swing.JRadioButton();
        rBtnLeftRing = new javax.swing.JRadioButton();
        rBtnRightRing = new javax.swing.JRadioButton();
        rBtnRightLittle = new javax.swing.JRadioButton();
        rBtnLeftLittle = new javax.swing.JRadioButton();
        btnReInitialize = new javax.swing.JButton();
        btnActivateCard = new javax.swing.JButton();
        outputScrollPane = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        btnClearOutputWindow = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Activate Card", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Finger", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        rBtnLeftThumb.setBackground(new java.awt.Color(255, 255, 255));
        rBtnLeftThumb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnLeftThumb.setText("Left Thumb");

        rBtnRightThumb.setBackground(new java.awt.Color(255, 255, 255));
        rBtnRightThumb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnRightThumb.setText("Right Thumb");

        rBtnLeftIndex.setBackground(new java.awt.Color(255, 255, 255));
        rBtnLeftIndex.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnLeftIndex.setText("Left Index");

        rBtnRightIndex.setBackground(new java.awt.Color(255, 255, 255));
        rBtnRightIndex.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnRightIndex.setText("Right Index");
        rBtnRightIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnRightIndexActionPerformed(evt);
            }
        });

        rBtnRightMiddle.setBackground(new java.awt.Color(255, 255, 255));
        rBtnRightMiddle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnRightMiddle.setText("Rigth Middle");

        rBtnLeftMiddle.setBackground(new java.awt.Color(255, 255, 255));
        rBtnLeftMiddle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnLeftMiddle.setText("Left Middle");

        rBtnLeftRing.setBackground(new java.awt.Color(255, 255, 255));
        rBtnLeftRing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnLeftRing.setText("Left Ring");

        rBtnRightRing.setBackground(new java.awt.Color(255, 255, 255));
        rBtnRightRing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnRightRing.setText("Right Ring");

        rBtnRightLittle.setBackground(new java.awt.Color(255, 255, 255));
        rBtnRightLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnRightLittle.setText("Right Little");

        rBtnLeftLittle.setBackground(new java.awt.Color(255, 255, 255));
        rBtnLeftLittle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rBtnLeftLittle.setText("Left Little");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtnLeftThumb)
                    .addComponent(rBtnRightThumb))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtnLeftIndex)
                    .addComponent(rBtnRightIndex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtnRightMiddle)
                    .addComponent(rBtnLeftMiddle))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtnLeftRing)
                    .addComponent(rBtnRightRing))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtnRightLittle)
                    .addComponent(rBtnLeftLittle))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBtnLeftLittle)
                        .addGap(24, 24, 24)
                        .addComponent(rBtnRightLittle))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(rBtnLeftRing)
                            .addGap(24, 24, 24)
                            .addComponent(rBtnRightRing))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rBtnLeftMiddle)
                            .addGap(24, 24, 24)
                            .addComponent(rBtnRightMiddle))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(rBtnLeftIndex)
                            .addGap(24, 24, 24)
                            .addComponent(rBtnRightIndex))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(rBtnLeftThumb)
                            .addGap(24, 24, 24)
                            .addComponent(rBtnRightThumb))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnReInitialize.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReInitialize.setText("Re-Initialize");
        btnReInitialize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReInitializeActionPerformed(evt);
            }
        });

        btnActivateCard.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnActivateCard.setText("Activate Card");
        btnActivateCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateCardActionPerformed(evt);
            }
        });

        outputScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputScrollPane.setViewportView(outputTextArea);

        btnClearOutputWindow.setText("Clear Output");
        btnClearOutputWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOutputWindowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReInitialize, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearOutputWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActivateCard, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(outputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActivateCard, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnReInitialize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearOutputWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rBtnRightIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnRightIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnRightIndexActionPerformed

    private void btnReInitializeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReInitializeActionPerformed
        //AncestorEvent AncestorEvent = new AncestorEvent(this,this);
        initializeCardReaderDeviceWithNigerianEIDCardAsync();
    }//GEN-LAST:event_btnReInitializeActionPerformed

    private void btnActivateCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateCardActionPerformed
        activateCardAsync(evt);
    }//GEN-LAST:event_btnActivateCardActionPerformed

    private void btnClearOutputWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOutputWindowActionPerformed
        
        //outputPanelOnScrollPane.removeAll();
        //outputPanelOnScrollPane.revalidate();
        //outputPanelOnScrollPane.repaint();
        outputTextArea.setText("");
    }//GEN-LAST:event_btnClearOutputWindowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivateCard;
    private javax.swing.JButton btnClearOutputWindow;
    private javax.swing.JButton btnReInitialize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JRadioButton rBtnLeftIndex;
    private javax.swing.JRadioButton rBtnLeftLittle;
    private javax.swing.JRadioButton rBtnLeftMiddle;
    private javax.swing.JRadioButton rBtnLeftRing;
    private javax.swing.JRadioButton rBtnLeftThumb;
    private javax.swing.JRadioButton rBtnRightIndex;
    private javax.swing.JRadioButton rBtnRightLittle;
    private javax.swing.JRadioButton rBtnRightMiddle;
    private javax.swing.JRadioButton rBtnRightRing;
    private javax.swing.JRadioButton rBtnRightThumb;
    // End of variables declaration//GEN-END:variables

    private void addRadioButtonsToButtonGroup() {
        btnGrp = new ButtonGroup();
        btnGrp.add(rBtnLeftRing);
        btnGrp.add(rBtnRightRing);
        btnGrp.add(rBtnLeftThumb);
        btnGrp.add(rBtnRightThumb);
        btnGrp.add(rBtnLeftLittle);
        btnGrp.add(rBtnRightLittle);
        btnGrp.add(rBtnLeftMiddle);
        btnGrp.add(rBtnRightMiddle);
        btnGrp.add(rBtnLeftIndex);
        btnGrp.add(rBtnRightIndex);
    }
    
    public void populateOutputWindow(String output, int outputType){
        
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Color color = null;
                
                switch(outputType){
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
                
                //outputPanelOnScrollPane.add(outputTextArea);
                //outputPanelOnScrollPane.add(Box.createVerticalStrut(0));
                //outputPanelOnScrollPane.add(Box.createRigidArea(new Dimension(0,0)));
                //outputPanelOnScrollPane.validate();
                //set the scrollbar on the scrollpane to the bottom
                JScrollBar vertical = outputScrollPane.getVerticalScrollBar();
                vertical.setValue( vertical.getMaximum() );
                return null;
            }
        };
        mySwingWorker.execute();
    }
    
    private void initializeCardReaderDeviceWithNigerianEIDCard(final int choice) {
        try {
            this.cardTerminal = new CardOperations().chooseTerminal(choice);
            
            if(this.cardTerminal != null){
                this.card = this.cardTerminal.connect("*");
                
                if(this.card != null){
                    this.ngEIDProfile = new NGeIDProfile(this.card);
                    this.card.beginExclusive();
                    if (!this.ngEIDProfile.isInstance()) {
                        System.out.println("Card reader " + this.cardTerminal.getName() + " does not contain a Nigerian eID Card.");
                    }else{
                        System.out.println("Card reader " + this.cardTerminal.getName() + " contains a valid Nigerian eID Card.");
                    }
                    this.card.endExclusive();
                    this.ngEIDProfile.fallback();
                }else{
                    System.out.println("Card reader " + this.cardTerminal.getName() + " does not contain any Card.");
                }
                
            }else{
                System.out.println("No Card Reader Device Found. Please try again.");
            }
        }
        catch (Exception ex) {
            System.out.println("An error occurred while initializing Card Reader Device." + ex.getMessage());
        }
    }
    
    private void initializeCardReaderDeviceWithNigerianEIDCardAsync(){
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                initializeCardReaderDeviceWithNigerianEIDCard(0);
                return null;
            }
        };
        mySwingWorker.execute();
    }

    private void activateCardAsync(ActionEvent evt) {
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                activateCard();
                return null;
            }
        };

        Window win = SwingUtilities.getWindowAncestor((AbstractButton) evt.getSource());
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
        JLabel messageLabel = new JLabel("Activating Card, Please wait...");
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
    
    private void activateCard(){
        
        try{
            
            btnActivateCard.setEnabled(false);
            this.fingerValue = -1;
            NGeIDCard nGeIDCard = null;

            try {
                nGeIDCard = new NGeIDCard(this.cardTerminal);
            } catch (ChannelException ex) {
                System.out.println("There was a disconnection with the Card Reader Device. Re-Initializing" + ex.getMessage());
                this.initializeCardReaderDeviceWithNigerianEIDCardAsync();
                try {
                    nGeIDCard = new NGeIDCard(this.cardTerminal);
                } catch (ChannelException e) {
                    System.out.println("Card Reader Re-Initializing failed... " + e.getMessage());
                    this.resetSelectedFinger();
                    return;
                }
            }

            this.fingerValue = getSelectedFinger();
            if (this.fingerValue == -1) {
                System.out.println("Please Select a Finger and Try again.");
            } else {

                try {

                    System.out.println("Card activation process initiated....");
                    System.out.println("This process will unblock both eid and epki applet in the card...");
                    System.out.println("Securely retreiving unblocking keys  remotely....");
                    
                    final String chipId = nGeIDCard.readChipId();
                     EIdPin pin = nGeIDCard.getEIdPin();
                     Pin pp =pin.getProfilePin();
                     System.out.println("Max size: " + pp.getMaxSize());
                     System.out.println("Min size: " + pp.getMinSize());
                    System.out.println("Chip: " + chipId);
                    System.out.println("EID: " + nGeIDCard.getEIdPin());
                    System.out.println("PUK: " + nGeIDCard.getEIdPuk());
                    System.out.println("SOPIN: " + nGeIDCard.getEPkiSoPin());
                    System.out.println("ePKI USER PIN: " + nGeIDCard.getEPkiUserPin());
                    System.out.println("Finger Print: " + nGeIDCard.getFingerprints()[0]);
                    RetrievePINResponse rpResponse = null;
                    char[] puk = null;
                    char[] sopin = null;
                    
                    try {
                        try {
                            new WebServiceCommunicator();
                            rpResponse = WebServiceCommunicator.rPins("2501012927966934");
                            if (rpResponse.getReturnMessage().equalsIgnoreCase("error")) {
                                System.out.println("Unable to obtain Pins for this card. Done");
                                return;
                            }
                            puk = rpResponse.getPuk().toCharArray();
                            sopin = rpResponse.getSopin().toCharArray();
                            System.out.println("puk: " + rpResponse.getPuk());
                            System.out.println("sopin: " + rpResponse.getSopin());
                            System.out.println("Pins successfully retrieved.... ");

                        } catch (Exception ex) {
                            System.out.println("Unable to Retrieve Pins for Card");
                        }

                        ReturnMessage returnMessage = new ReturnMessage();
                        //if (x == 0) {
                        byte[] minutiae = null;
                        try {
                            minutiae = new CardOperations().verifyFinger2(new NGeIDCard(this.cardTerminal), this.fingerValue);
                            System.out.println("Fingerprint verrification successful.");
                        } catch (Exception ex2) {
                            System.out.println("Fingerprint verification failure." + ex2.getMessage());
                            //mn.insertLogs(this.em, "activatecard", chipId, "failed", new CardOperations().fingerNames[this.fv], Login.user.getUsername(), "Fingerprint verification failure", minutiae);
                            return;
                        }
                        try {
                            returnMessage = new CardOperations().unblockUserPIN(new NGeIDCard(this.cardTerminal), sopin);
                            if (!returnMessage.isResult()) {
                                System.out.println("Unblock Failure: Wrong SOPIN");
                                //mn.insertLogs(this.em, "activatecard", chipId, "failed", "notrequired", Login.user.getUsername(), "Failed attempt to unblock card : " + returnMessage.getMessage(), null);
                                return;
                            }
                            returnMessage = new CardOperations().changeUserPINwithMoC2(new NGeIDCard(this.cardTerminal), this.fingerValue, chipId, minutiae);
                        } finally {
                            Arrays.fill(minutiae, (byte) 0);
                            minutiae = null;
                        }
                        if (returnMessage.isResult()) {
                            returnMessage = new CardOperations().changeEIDPIN_PUK2(new NGeIDCard(this.cardTerminal), puk, chipId);
                            if (returnMessage.isResult()) {
                                //mn.insertLogs(this.entityManager, "activatecard", chipId, "success", new CardOperations().fingerNames[this.fv], Login.user.getUsername(), "", minutiae);
                                System.out.println("Card successfully Activated. You can now unplug the Card.");
                                utilOps.displayMessage("Card successfully Activated. You can now unplug the Card.", "Success Message", JOptionPane.INFORMATION_MESSAGE);
                                //this.processICAMSUpdateRecord(this.entityManager, chipId, AppletTypes.E_ID_PKI);
                            } else {
                                //mn.insertLogs(this.entityManager, "activatecard", chipId, "failed", new CardOperations().fingerNames[this.fv], Login.user.getUsername(), returnMessage.getMessage(), null);
                            }
                        } else {
                            //mn.insertLogs(this.entityManager, "activatecard", chipId, "failed", new CardOperations().fingerNames[this.fv], Login.user.getUsername(), returnMessage.getMessage(), null);
                        }
                        this.resetSelectedFinger();
                        //}

                    } catch (Exception ex) {
                        System.out.println("Unable to retrieve Pins: " + ex.getMessage());
                    }

                } catch (Exception ex) {
                    this.resetSelectedFinger();
                    System.out.println("An error occured: " + ex.getMessage());
                }

            }
            
        }finally{
            btnActivateCard.setEnabled(true);
        }
                
    }

    private void resetSelectedFinger() {
        btnGrp.clearSelection();
    }
    
    private JRadioButton getButton(final int index) {
        switch (index) {
            case 0: {
                return this.rBtnLeftThumb;
            }
            case 1: {
                return this.rBtnLeftIndex;
            }
            case 2: {
                return this.rBtnLeftMiddle;
            }
            case 3: {
                return this.rBtnLeftRing;
            }
            case 4: {
                return this.rBtnLeftLittle;
            }
            case 5: {
                return this.rBtnRightThumb;
            }
            case 6: {
                return this.rBtnRightIndex;
            }
            case 7: {
                return this.rBtnRightMiddle;
            }
            case 8: {
                return this.rBtnRightRing;
            }
            case 9: {
                return this.rBtnRightLittle;
            }
            default: {
                return null;
            }
        }
    }
    
    private int getSelectedFinger() {
        if (this.rBtnLeftThumb.isSelected()) {
            return 0;
        }
        if (this.rBtnLeftIndex.isSelected()) {
            return 1;
        }
        if (this.rBtnLeftMiddle.isSelected()) {
            return 2;
        }
        if (this.rBtnLeftRing.isSelected()) {
            return 3;
        }
        if (this.rBtnLeftLittle.isSelected()) {
            return 4;
        }
        if (this.rBtnRightThumb.isSelected()) {
            return 5;
        }
        if (this.rBtnRightIndex.isSelected()) {
            return 6;
        }
        if (this.rBtnRightMiddle.isSelected()) {
            return 7;
        }
        if (this.rBtnRightRing.isSelected()) {
            return 8;
        }
        if (this.rBtnRightLittle.isSelected()) {
            return 9;
        }
        return -1;
    }
    
    private void processICAMSUpdateRecord(final EntityManager em, final String chipId, final AppletTypes at) {
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final DbManager m = new DbManager();
                    m.addPushLog(em, chipId);
                    final WebServiceCommunicator webServiceCommunicator = ActivateCardPanel.this.webServiceCommunicator;
                    WebServiceCommunicator.updateICAMS(at, chipId);
                    m.updatePushLog(em, chipId);
                    ActivateCardPanel.this.processICAMSUpdate(at);
                }
                catch (Exception ex) {}
            }
        });
        t.start();
    }
    
    private void processICAMSUpdate(final AppletTypes at) {
        final WebServiceCommunicator imp = new WebServiceCommunicator();
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final DbManager m = new DbManager();
                    final EntityManager em = m.em();
                    final List<String> idx = m.getUnprocessedChipID(em);
                    for (final String chipId : idx) {
                        WebServiceCommunicator.updateICAMS(at, chipId);
                        m.updatePushLog(em, chipId);
                    }
                }
                catch (Exception x) {
                    x.printStackTrace();
                }
            }
        });
        t.start();
    }
}