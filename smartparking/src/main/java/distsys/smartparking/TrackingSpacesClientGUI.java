/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smartparking;

import com.google.protobuf.Empty;
import grpc.generated.TrackingSpacesAndReservation.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *This GUI represents also the TrackingSpaces client class and it simulates tracking
 *the number of available parking spaces in real time
 * communication between client and server occurs through a non blocking stub(asynchronous calls)
 * 
 */
public class TrackingSpacesClientGUI extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(TrackingSpacesClientGUI.class.getName());
    //gRPC non blocking stub for server streaming service
    private TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceStub stub;
    private ManagedChannel channel;
    
    /**
     * Creates new form TrackingSpacesGUI
     */
    public TrackingSpacesClientGUI() {
        initComponents();
        
        //gRPC channel settings
        String host = "localhost";
        int port = 50051;
        channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .intercept(new SmartParkingClientInterceptor())
                .build();
        //create an instance of the BearerToken from the generated JWT and 
        //make a stub in the main method of our client to use it
        String jwt = getJwt();
        BearerToken token = new BearerToken(jwt);
        stub = TrackingSpacesAndReservationServiceGrpc.newStub(channel)
                .withCallCredentials(token)
                .withDeadlineAfter(1000, TimeUnit.SECONDS);

    }
    
    private static String getJwt() {
        return Jwts.builder()
                .setSubject("TrackingSpacesGUI") // client's identifier
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

        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        tracking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click on the button bellow to start tracking available spots");

        tracking.setText("Track");
        tracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackingActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRACKING AVAILABLE SPACES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(tracking)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(tracking)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    //send the request for parking spots tracking
    private void trackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackingActionPerformed
        // prepare to collect multiple responses from the server
        ArrayList<Integer> emptySpotsCollection = new ArrayList<>();
        //empty request to the server
        Empty request = Empty.newBuilder().build();
        // prepare to receive a stream of responses from the server
        StreamObserver<SpotsAvailability> responseObserver = new StreamObserver<SpotsAvailability>() {
            @Override
            public void onNext(SpotsAvailability spotsAvailability) {
                System.out.println("Requesting updates about available sposts:");
                //updates the text area during the thread inside the GUI
                SwingUtilities.invokeLater(() -> {
                    jTextArea1.append("Spots available for parking: " + spotsAvailability.getEmptySpots() + "\n");
                });
                //stores all the values inside the arrayList
                emptySpotsCollection.add(spotsAvailability.getEmptySpots());
            }

            @Override
            public void onError(Throwable t) {
                try {
                    throw new Exception("Error requesting spots: " + t.getLocalizedMessage());
                } catch (Exception ex) {
                    logger.getLogger(TrackingSpacesClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onCompleted() {
                System.out.println("Client received onComplete()");
                System.out.println("Data sent: " + emptySpotsCollection.toString());
            }
        };
    
        // send the request to the server on the nonblocking stub. Pass the StreamObserver to the server
        stub.trackingSpots(request, responseObserver);
        // print a line here to show the client continues on rather than waiting for the server response.
        System.out.println(LocalTime.now() + "Client has sent request");
    }//GEN-LAST:event_trackingActionPerformed

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
            java.util.logging.Logger.getLogger(TrackingSpacesClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackingSpacesClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label1;
    private javax.swing.JButton tracking;
    // End of variables declaration//GEN-END:variables
}
