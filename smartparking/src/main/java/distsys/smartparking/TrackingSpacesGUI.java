/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smartparking;

import com.google.protobuf.Empty;
import grpc.generated.TrackingSpacesAndReservation.SpotsAvailability;
import grpc.generated.TrackingSpacesAndReservation.TrackingSpacesAndReservationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import static jdk.internal.net.http.common.Log.channel;

/**
 *
 * @author dell
 */
public class TrackingSpacesGUI extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(TrackingSpacesGUI.class.getName());
    TrackingSpacesAndReservationServiceGrpc.TrackingSpacesAndReservationServiceStub stub;
    ManagedChannel channel;
    
    /**
     * Creates new form TrackingSpacesGUI
     */
    public TrackingSpacesGUI() {
        initComponents();
        
        //gRPC channel settings
        String host = "localhost";
        int port = 50051;
        channel = ManagedChannelBuilder.
                forAddress(host, port)
                .usePlaintext()
                .build();
        stub = TrackingSpacesAndReservationServiceGrpc.newStub(channel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tracking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(tracking))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tracking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void trackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackingActionPerformed
        try {
            // prepare to collect multiple responses from the server
            ArrayList<Integer> emptySpotsCollection = new ArrayList<>();
            //empty request to the server
            Empty request = Empty.newBuilder().build();

            // prepare to receive a stream of responses from the server
            StreamObserver<SpotsAvailability> responseObserver = new StreamObserver<SpotsAvailability> () {
                @Override
                public void onNext(SpotsAvailability spotsAvailability) {
                    System.out.println("Requesting updates about available sposts:");
                    SwingUtilities.invokeLater(() -> {
                        jTextArea1.append("Spots available for parking: " + spotsAvailability.getEmptySpots() + "\n");
                    });
                        emptySpotsCollection.add(spotsAvailability.getEmptySpots());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error requesting spots: " + t.getLocalizedMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Client received onComplete()");
                        System.out.println( "Data sent: "  + emptySpotsCollection.toString());   
                    try {
                        //shutdown channel
                        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrackingSpacesGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            };

            // send the request to the server on the nonblocking stub. Pass the StreamObserver to the server
            stub.trackingSpots(request, responseObserver);

            // print a line here to show the client continues on rather than waiting for the server response.
            System.out.println(LocalTime.now() + "Parking spots being localized");           
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        } 
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
            java.util.logging.Logger.getLogger(TrackingSpacesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackingSpacesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackingSpacesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton tracking;
    // End of variables declaration//GEN-END:variables
}
