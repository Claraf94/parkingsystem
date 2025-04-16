/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smartparking;

import grpc.generated.TrackingSpacesAndReservation.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class ReservationGUI extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(ReservationGUI.class.getName());
    private StreamObserver<ReservationRequest> requestObserver;
    // Non-blocking stub to make asynchronous calls
    private TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceStub asyncStub;
    private ManagedChannel channel;
    //creating a temporary list to store the reservations before they have been completed
    List<Reservation> pending = new ArrayList<Reservation>();

    /**
     * Creates new form ReservationGUI
     */
    public ReservationGUI() {
        initComponents();
        //gRPC channel settings
        String host = "localhost";
        int port = 50051;
        channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = TrackingSpacesAndReservationServiceGrpc.newStub(channel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userIDLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JFormattedTextField();
        time = new javax.swing.JFormattedTextField();
        labelDetails = new javax.swing.JLabel();
        operation = new javax.swing.JButton();
        userIDValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        getID = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputDetails = new javax.swing.JTextArea();
        requestReservation = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userIDLabel.setText("User ID: ");

        jLabel2.setText("Date:");

        jLabel3.setText("Time:");

        try {
            date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        date.setToolTipText("Insert date as dd/MM/2025");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        try {
            time.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        time.setToolTipText("Insert time as HH:mm");
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        labelDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDetails.setText("Reservation Details:");

        operation.setText("Add");
        operation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationActionPerformed(evt);
            }
        });

        userIDValue.setEditable(false);
        userIDValue.setToolTipText("Click on the button \"Get ID\" to generate your ID");
        userIDValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDValueActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click on the button below to generate an User ID");

        getID.setText("Get ID");
        getID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getIDActionPerformed(evt);
            }
        });

        outputDetails.setEditable(false);
        outputDetails.setColumns(20);
        outputDetails.setLineWrap(true);
        outputDetails.setRows(5);
        outputDetails.setWrapStyleWord(true);
        jScrollPane1.setViewportView(outputDetails);

        requestReservation.setText("End");
        requestReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestReservationActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To finalize the process, click on the button bellow");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("To make your reservation, click on the button bellow");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(userIDLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIDValue)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 136, Short.MAX_VALUE))))
                    .addComponent(labelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(getID))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(requestReservation))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(operation)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getID)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIDLabel)
                    .addComponent(userIDValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(operation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestReservation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        String setTime = time.getText();
        outputDetails.setText("Selected Time: " + setTime);
    }//GEN-LAST:event_timeActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        String setDate = date.getText();
        outputDetails.setText("Selected Date: " + setDate);
    }//GEN-LAST:event_dateActionPerformed

    private void operationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationActionPerformed
        String userID = userIDValue.getText();
        String reservationDate = date.getText();
        String reservationTime = time.getText();
        
        //making sure all the fields were inserted and correct data format
        if (!userID.isEmpty() && !reservationDate.trim().equals("  /  /    ") && !reservationTime.trim().equals("  :  ")) {
            if (reservationTime.matches("([01][0-9]|2[0-3]):([0-5][0-9])")
            && reservationDate.matches("^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/202[5]$")) {
                //instantiating the reservation when all the fields were completed
                Reservation newReservation = new Reservation(userID, reservationDate, reservationTime);
                //adding to the temporary list
                pending.add(newReservation);
                
                outputDetails.setText("Reservation temporarily added.\n" + newReservation.toString()
                + "\nYou can add a new one or click 'End' to end the process.");
                
                //cleaning the fields
                date.setText("");
                time.setText("");
            }else{
                outputDetails.setText("Please, check if date is in the format dd/MM/2025 and time HH:mm.");
            }
        }else{
                outputDetails.setText("Please, fill in all the fields.");
        }
    }//GEN-LAST:event_operationActionPerformed

    private void getIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIDActionPerformed
        if(userIDValue.getText().isEmpty()){
            String userID = UUID.randomUUID().toString();
            userIDValue.setText(userID);
        }
    }//GEN-LAST:event_getIDActionPerformed

    private void userIDValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDValueActionPerformed
        String userID = this.userIDValue.getText();
        System.out.println(userID);
    }//GEN-LAST:event_userIDValueActionPerformed

    private void requestReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestReservationActionPerformed
        if (pending.isEmpty()) {
            outputDetails.setText("No reservations to submit.");
            return;
        }
        
        //cleaning the content of the ouput box every time a reservation is added
        outputDetails.setText("");
        
        //server request
        StreamObserver<ReservationReply> responseObserver = new StreamObserver<ReservationReply>() {
            @Override
            public void onNext(ReservationReply reply) {
                outputDetails.append("Confirmed: " + reply.getReserved() + "\n"
                        + reply.getMessage() + "\n"
                        + reply.getReservationDetails() + "\n\n");
            }

            @Override
            public void onError(Throwable t) {
                outputDetails.setText("Error requesting the reservations. " + t.getLocalizedMessage());
            }

            @Override
            public void onCompleted() {
                outputDetails.append("All reservations sent successfully.\n");
                logger.info("Reservations completed.");
                //makes the pending list empty again
                pending.clear();
            }
        };

        //intitializing the communication with the server to send the reservations
        requestObserver = asyncStub.reservation(responseObserver);

        try {
            for(Reservation res : pending){ 
                String userID = res.getUserID();
                String reservationDate = res.getDate();
                String reservationTime = res.getTime();
        
                //making sure all the fields were inserted and correct data format
                if (!userID.isEmpty() && !reservationDate.trim().equals("  /  /    ") && !reservationTime.trim().equals("  :  ")) {
                    if (reservationTime.matches("([01][0-9]|2[0-3]):([0-5][0-9])")
                    && reservationDate.matches("^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/202[5]$")) {
                        ReservationRequest request = ReservationRequest.newBuilder()
                        .setUserID(res.getUserID())
                        .setDate(res.getDate())
                        .setTime(res.getTime())
                        .setReservationID(res.getReservationID())
                        .build();

                        requestObserver.onNext(request);
                        
                    }else{
                        outputDetails.append("Reservation ID: " + res.getReservationID() + " with invalid date and tirme format.");
                    }
                }else{
                    outputDetails.append("All field must have the proper data.");
                }
            }
            
            requestObserver.onCompleted();

        } catch (Exception e) {
            logger.info("Error while trying the request: " + e.getMessage());
        }     
    }//GEN-LAST:event_requestReservationActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField date;
    private javax.swing.JButton getID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDetails;
    private javax.swing.JButton operation;
    private javax.swing.JTextArea outputDetails;
    private javax.swing.JButton requestReservation;
    private javax.swing.JFormattedTextField time;
    private javax.swing.JLabel userIDLabel;
    private javax.swing.JTextField userIDValue;
    // End of variables declaration//GEN-END:variables

}
