/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ruban
 */
package Otp;


import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import SignupLawyer. *;
import Signup.*;
import java.awt.Color;

public class Otp extends javax.swing.JFrame {

    private String userType; 
    private String generatedOTP;
    private String Email;
     
    public void setEmail(String email,String userType) {
        this.Email = email;
        this.userType = userType;
    }

    public Otp() {
        initComponents();
        
        
        GetOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String toEmail = Email;
                if (!toEmail.trim().isEmpty()) {
                    generatedOTP = generateRandomOTP(6);
                    sendEmail(toEmail, "Your OTP", "Your OTP is: " + generatedOTP, "h8702643@gmail.com", "osxa rglp zcir cimn");
                    javax.swing.JOptionPane.showMessageDialog(null, "OTP has been sent to your email.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                }
            }
        });

        
        COnfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String enteredOTP = receivedOtp.getText();
                if (enteredOTP.equals(generatedOTP)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "OTP confirmed. You can proceed.");

                    if (userType.equals("lawyer")) {
                        // Navigate back to Lawyer class
                        new SignupLawyer().setVisible(false);
                    } else if (userType.equals("user")) {
                        // Navigate back to User class
                        new Signup().setVisible(false);
                    }
                    dispose(); // Close the current OTP frame
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Incorrect OTP. Please check and try again.");
                }
            }
        });


    }

    private void sendEmail(String toEmail, String subject, String message,
            String senderEmail, String senderPassword) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(senderEmail));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);

            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateRandomOTP(int length) {
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            otpBuilder.append(random.nextInt(10));
        }

        return otpBuilder.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        receivedOtp = new javax.swing.JTextField();
        GetOtp = new javax.swing.JButton();
        COnfirm = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        receivedOtp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receivedOtpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receivedOtpFocusLost(evt);
            }
        });
        receivedOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedOtpActionPerformed(evt);
            }
        });

        GetOtp.setText("get-otp");
        GetOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetOtpActionPerformed(evt);
            }
        });

        COnfirm.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        COnfirm.setText("Confirm");
        COnfirm.setBorder(null);
        COnfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COnfirmActionPerformed(evt);
            }
        });

        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Minimal Professional Lawyer Firm Justice & Law Logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-90, -20, 420, 390);

        jLabel2.setText("Enter your Otp :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(GetOtp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(receivedOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(COnfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(GetOtp)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(receivedOtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(COnfirm)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void COnfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COnfirmActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_COnfirmActionPerformed

    private void GetOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetOtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GetOtpActionPerformed

    private void receivedOtpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedOtpFocusGained
        jLabel2.setVisible(false);
        if(receivedOtp.getText().equals("Enter Username"))
        {
            receivedOtp.setText("");
            receivedOtp.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_receivedOtpFocusGained

    private void receivedOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedOtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receivedOtpActionPerformed

    private void receivedOtpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedOtpFocusLost
        // TODO add your handling code here:
        
        if(receivedOtp.getText().equals(""))
        {
            receivedOtp.setText("Enter Username");
            receivedOtp.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_receivedOtpFocusLost

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
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Otp().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton COnfirm;
    private javax.swing.JButton GetOtp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField receivedOtp;
    // End of variables declaration//GEN-END:variables
}
