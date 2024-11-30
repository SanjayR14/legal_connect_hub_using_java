package Signup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Otp . *;
import Front . *;
import MainLogin. *;

public class Signup extends javax.swing.JFrame {
    // Class member to hold the generated OTP

    public Signup() {
        initComponents();
        // Add action listener for get_otp button
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        Phone_num = new javax.swing.JTextField();
        Sign_up = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Sign_in = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        Verify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(745, 500));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 152, 152));
        jPanel1.setLayout(null);

        jTextField7.setBackground(new java.awt.Color(0, 152, 152));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("Legal-Connect-Hub");
        jTextField7.setBorder(null);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(18, 640, 133, 20);

        jTextField8.setBackground(new java.awt.Color(0, 152, 152));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("Copyright © 2017,");
        jTextField8.setBorder(null);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(18, 666, 125, 20);

        jTextField9.setBackground(new java.awt.Color(0, 152, 152));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText(" LCH. All rights reserved.");
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9);
        jTextField9.setBounds(6, 692, 168, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Minimal Professional Lawyer Firm Justice & Law Logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-90, -40, 420, 560);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 330, 490);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 152, 152));
        jTextField1.setText("USER SIGN-UP");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 14, -1, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setText("Username  :");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 71, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setText("Enter Email To verify :");
        jTextField3.setBorder(null);
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 80, 150, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField4.setText("phone no :");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 71, 20));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField5.setText("Password :");
        jTextField5.setBorder(null);
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 71, -1));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setText("Confirm Password :");
        jTextField6.setBorder(null);
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        jPanel2.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 148, -1));

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel2.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 148, -1));
        jPanel2.add(Phone_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 148, -1));

        Sign_up.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sign_up.setText("Sign-up");
        Sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sign_upActionPerformed(evt);
            }
        });
        jPanel2.add(Sign_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        Back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel2.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        Sign_in.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sign_in.setText("Sign-in");
        Sign_in.setBorder(null);
        Sign_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sign_inActionPerformed(evt);
            }
        });
        jPanel2.add(Sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 148, -1));
        jPanel2.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 148, -1));

        Verify.setText("Verify");
        Verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyActionPerformed(evt);
            }
        });
        jPanel2.add(Verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel1.setText("Already Have one?");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 110, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(330, 0, 610, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void Sign_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sign_inActionPerformed
        // TODO add your handling code here:
         new MainLogin().setVisible(true);
         
    }//GEN-LAST:event_Sign_inActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        new Front().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void Sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sign_upActionPerformed
        // TODO add your handling code here:
    String usernameValue = Username.getText();
    String emailValue = Email.getText();
    String phoneValue = Phone_num.getText();
    String passwordValue = jPasswordField1.getText();
    String confirmPasswordValue = jPasswordField2.getText();

    
    // Check if the passwords match before inserting into the database
    if (!passwordValue.equals(confirmPasswordValue)) {
        // Handle password mismatch error (e.g., show a message dialog)
        JOptionPane.showMessageDialog(this, "Passwords do not match!", "Password Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
        if (phoneValue.length() != 10 || !phoneValue.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "Phone number should be 10 digits!", "Phone Number Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Establish a connection to your database (replace the connection URL, username, and password)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000");
        
        String checkEmailQuery = "SELECT * FROM signup WHERE email = ?";
            PreparedStatement checkEmailStmt = conn.prepareStatement(checkEmailQuery);
            checkEmailStmt.setString(1, emailValue);
            ResultSet resultSet = checkEmailStmt.executeQuery();

            // If the email already exists, show an error message
            if (resultSet.next()) {
            String verificationStatus = resultSet.getString("verify_email");
            if ("pending".equals(verificationStatus)) {
                JOptionPane.showMessageDialog(this, "Email verification is pending. Please verify your email before proceeding.", "Verification Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Email is already registered!", "Email Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
        // Create a prepared statement for inserting values into the database
        String insertQuery = "INSERT INTO signup (username, email, phone_num, password) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        
        // Set parameter values for the prepared statement
        pstmt.setString(1, usernameValue);
        pstmt.setString(2, emailValue);
        pstmt.setString(3, phoneValue);
        pstmt.setString(4, passwordValue);
        
        // Execute the insert statement
        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            // Insertion successful
            JOptionPane.showMessageDialog(this, "Sign-up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Insertion failed
            JOptionPane.showMessageDialog(this, "Sign-up failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Close the prepared statement and connection
        pstmt.close();
        conn.close();
    } catch (SQLException ex) {
        // Handle any SQL exceptions
        ex.printStackTrace();
    }
    

        
    }//GEN-LAST:event_Sign_upActionPerformed



    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void VerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyActionPerformed
    String userEmail = Email.getText();
    
    // Create an instance of the Otp class
    Otp otpPage = new Otp();
    
    // Set the email in the OTP page
    otpPage.setEmail(userEmail,"user");
    
    // Make the OTP page visible
    otpPage.setVisible(true);
    }//GEN-LAST:event_VerifyActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // ... (existing code)

    /* Create and display the Signup form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            
            new Signup().setVisible(true);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Phone_num;
    private javax.swing.JButton Sign_in;
    private javax.swing.JButton Sign_up;
    private javax.swing.JTextField Username;
    private javax.swing.JButton Verify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}


