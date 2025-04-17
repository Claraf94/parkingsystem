/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smartparking;

import grpc.generated.TicketPayment.*;
import grpc.generated.TrackingSpacesAndReservation.TrackingSpacesAndReservationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.logging.Logger;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 *This GUI represents also the TicketPayment Client class and it simulates payment of a parking ticket 
 * the communication between client and server occurs through a non blocking stub (asynchronous call)
 * 
 */
public class TicketPaymentClientGUI extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(TicketPaymentClientGUI.class.getName());
    // a non-blocking stub to make an asynchronous call
    private TicketPaymentServiceGrpc.TicketPaymentServiceStub asyncStub;
    private ManagedChannel channel;
    //to send multiples payments
    private StreamObserver<TicketPaymentRequest> requestObserver;
    private double remaining;
    private double totalToPay;

    /**
     * Creates new form TicketPaymentGUI
     */
    public TicketPaymentClientGUI() {
        initComponents();
        //gRPC channel settings
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .intercept(new SmartParkingClientInterceptor())
                .build();
        //create an instance of the BearerToken from the generated JWT and 
        //make a stub in the main method of our client to use it
        String jwt = getJwt();
        BearerToken token = new BearerToken(jwt);
        asyncStub = TicketPaymentServiceGrpc.newStub(channel)
                    .withCallCredentials(token)
                    .withDeadlineAfter(1000, TimeUnit.SECONDS);
    }
    
    private static String getJwt() {
        return Jwts.builder()
                .setSubject("TicketPaymentGUI") // client's identifier
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
                .compact();
    }
    /**
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        paymentType = new javax.swing.JComboBox<>();
        totalAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        paymentValue = new javax.swing.JTextField();
        processPayment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentDetails = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        remainingAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        getValue = new javax.swing.JButton();
        parkingID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Payment type:");

        jLabel2.setText("Total:");

        paymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cash", "Voucher" }));
        paymentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTypeActionPerformed(evt);
            }
        });

        totalAmount.setEditable(false);
        totalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountActionPerformed(evt);
            }
        });

        jLabel3.setText("Payment Value:");

        paymentValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentValueActionPerformed(evt);
            }
        });

        processPayment.setText("Process Payment");
        processPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processPaymentActionPerformed(evt);
            }
        });

        paymentDetails.setColumns(20);
        paymentDetails.setRows(5);
        jScrollPane1.setViewportView(paymentDetails);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Payment details:");

        jLabel6.setText("Remaining: ");

        remainingAmount.setEditable(false);
        remainingAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingAmountActionPerformed(evt);
            }
        });

        jLabel7.setText("Insert the parking ticket ID:");

        getValue.setText("Get Value");
        getValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getValueActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TICKET PAYMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remainingAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(getValue))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(parkingID, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(processPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paymentValue, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(parkingID)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(paymentValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(processPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(remainingAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paymentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTypeActionPerformed
        //no need to implement
    }//GEN-LAST:event_paymentTypeActionPerformed

    private void totalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountActionPerformed
        //when the GUI starts, a random amount to be paid will be generated 
    }//GEN-LAST:event_totalAmountActionPerformed

    //invokes the process payment
    private void paymentValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentValueActionPerformed
        processPaymentActionPerformed(evt);
    }//GEN-LAST:event_paymentValueActionPerformed
    
    //send the payment request
    private void processPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processPaymentActionPerformed
        String payment;
        double paid;
        String ticketID = parkingID.getText().trim().toUpperCase();

        //try to convert the value and get the type of payment 
        payment = paymentType.getSelectedItem().toString();
        paid = Double.parseDouble(paymentValue.getText());

        //checking if the value is equal or less than zero
        if (paid <= 0) {
            paymentDetails.append("Value to be paid cannot be negative or zero.");
            return;
        }

        //checking if the value inserted when trying to use card ou voucher
        //is more than the amount, which cannot be
        if (!payment.equals("Cash") && paid > remaining) {
            paymentDetails.append("It is not possible to pay a bigger amount than the remaining by using " + payment + "\n");
            return;
        }

        //when initializing the payment 
        if (requestObserver == null) {
            requestObserver = asyncStub.processPayment(new StreamObserver<TicketPaymentReply>() {
                @Override
                public void onNext(TicketPaymentReply reply) {
                    if (reply.getConfirmation()) {
                        paymentDetails.append("Payment confirmed!\nReceipt ID: " + reply.getReceiptID());
                        //cleaning all the data after confirmation
                        parkingID.setText("");
                        totalAmount.setText("");
                        paymentValue.setText("");
                        totalToPay = 0;
                        remaining = 0;
                        requestObserver = null;
                        remainingAmount.setText("");

                    } else {
                        paymentDetails.append("Something went wrong with the payment. Please, try again.");
                    }
                }

                @Override
                public void onError(Throwable t) {
                    paymentDetails.append("Error while trying payment." + t.getMessage());
                    logger.log(Level.WARNING, "Server could not process the payment.", t);
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client received onComplete()");
                }
            });
        }

        //when cash payment is more than the amount to be paid
        //in case the amount inserted is more than the price to be charged,
        //need to calculate the change 
        if (payment.equals("Cash") && paid > remaining) {
            double change = paid - remaining;
            change = Math.round(change * 100) / 100.0;

            TicketPaymentRequest payTicket = TicketPaymentRequest.newBuilder()
                    .setParkingID(ticketID)
                    .setPaymentType(payment)
                    .setAmount(remaining)
                    .setPaymentID(UUID.randomUUID().toString())
                    .build();
            requestObserver.onNext(payTicket);
            //shows the partial payment
            paymentDetails.append("Paid €" + paid + " by " + payment + "\n");
            //shows change due
            paymentDetails.append("Change: €" + change + "\n");
            remaining = 0;
        } else {
            //when paying by card or voucher or cash was not enought to finish the payment
            TicketPaymentRequest payTicket = TicketPaymentRequest.newBuilder()
                    .setParkingID(ticketID)
                    .setPaymentType(payment)
                    .setAmount(paid)
                    .setPaymentID(UUID.randomUUID().toString())
                    .build();
            requestObserver.onNext(payTicket);
            //subtracting the value paid from the value to be paid
            remaining -= paid;
            remaining = Math.round(remaining * 100.0) / 100.0;
            remainingAmount.setText(Double.toString(remaining));
            paymentDetails.append("Paid €" + paid + " by " + payment + "\n");
        }

        if (remaining == 0) {
            requestObserver.onCompleted();
            totalAmount.setText("");
            remainingAmount.setText("");
        }
    }//GEN-LAST:event_processPaymentActionPerformed

    private void remainingAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingAmountActionPerformed
        //no need to develop any code since is a non editable field
    }//GEN-LAST:event_remainingAmountActionPerformed
    
    //send the value request for the parking ticket
    private void getValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getValueActionPerformed
        String ticketID = parkingID.getText().trim().toUpperCase();
        //making sure the output is empty
        paymentDetails.setText("");

        //verifying if the ID only contains letters/numbers
        if (ticketID.matches("[A-Z0-9]+")) {
            AmountRequest request = AmountRequest.newBuilder()
                    .setParkingID(ticketID)
                    .build();

            asyncStub.randomAmount(request, new StreamObserver<AmountReply>() {
                @Override
                public void onNext(AmountReply reply) {
                    totalToPay = reply.getAmount();
                    remaining = totalToPay;
                    totalAmount.setText(Double.toString(totalToPay));
                    remainingAmount.setText(Double.toString(remaining));
                    paymentDetails.append("Parking ticket: " + ticketID + ". Value to be paid: " + Double.toString(totalToPay) + "\n");

                }

                @Override
                public void onError(Throwable t) {
                    paymentDetails.setText("Error requesting total amount for the parking ticket." + t.getMessage() + "\n");
                    logger.log(Level.WARNING, "Server could not generate the amount to be paid.", t);
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client received onComplete()");
                }
            });

        } else {
            paymentDetails.setText("Parking ID cannot be empty and can only contains numbers and letters.\n");
        }
    }//GEN-LAST:event_getValueActionPerformed

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
            java.util.logging.Logger.getLogger(TicketPaymentClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketPaymentClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketPaymentClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketPaymentClientGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketPaymentClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField parkingID;
    private javax.swing.JTextArea paymentDetails;
    private javax.swing.JComboBox<String> paymentType;
    private javax.swing.JTextField paymentValue;
    private javax.swing.JButton processPayment;
    private javax.swing.JTextField remainingAmount;
    private javax.swing.JTextField totalAmount;
    // End of variables declaration//GEN-END:variables
}
