package LawyerHome;


import Hire.*;
import Front.*;
import DatabaseTextToTextBot.*;
import GoogleSearchAppGUI.GoogleSearchAppGUI;
import LawyerSignin.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//import net.miginfocom.swing.MigLayout;
//import org.jdesktop.animation.timing.Animator;
//import org.jdesktop.animation.timing.TimingTarget;
//import org.jdesktop.animation.timing.TimingTargetAdapter;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ruban
 */
public class LawyerHome extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    String LawyerSignin ;
    private String enteredUsername;
    private String Uid;
    
    public LawyerHome(String Uid) {
        initComponents();
        this.LawyerSignin = Uid;
        cardLayout = (CardLayout) jPanel2.getLayout();
        this.UID.setText(Uid);
       
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        status = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        c2home = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bot = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        c1profile = new javax.swing.JPanel();
        USERNAME = new javax.swing.JTextField();
        PHONE_NUMBER = new javax.swing.JTextField();
        EMAIL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LOCATION = new javax.swing.JTextField();
        UID = new javax.swing.JTextField();
        q = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        c3Case = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        profile.setBackground(new java.awt.Color(255, 204, 51));
        profile.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        profile.setText("Profile");
        profile.setBorder(null);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        status.setBackground(new java.awt.Color(255, 204, 0));
        status.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        status.setText("case-status");
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Logout");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setText("Home");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("L C H");

        jLabel9.setIcon(new javax.swing.ImageIcon("R:\\cit-22smcb0055\\SEM-III\\JAVA\\Project copy\\Main\\icons\\icons8_law_40px_1.png")); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status)
                    .addComponent(jButton1)
                    .addComponent(profile)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(52, 52, 52)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.CardLayout());

        c2home.setBackground(new java.awt.Color(204, 255, 255));

        jTextField1.setText("Search...");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("NSimSun", 3, 24)); // NOI18N
        jLabel5.setText("Legal Connect Hub");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Copyright  ©  2023");

        jLabel8.setText("LEGAL CONNECT HUB");

        bot.setText("Ask Laila.");
        bot.setBorder(null);
        bot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("R:\\cit-22smcb0055\\SEM-III\\JAVA\\Project copy\\Main\\icons\\icons8_bot_24px.png")); // NOI18N

        jTextPane1.setBackground(new java.awt.Color(204, 255, 255));
        jTextPane1.setBorder(null);
        jTextPane1.setText("  OUR VISION\n\tAt Legal Connect Hub, our vision is to revolutionize the legal landscape by providing a unified platform where users and lawyers converge. We aim to simplify legal processes, ensuring accessibility, transparency, and efficiency for all involved parties.\n\n  CONVERGENCE PLATFORM\n\tLegal Connect Hub serves as a comprehensive hub, enabling users to connect with experienced lawyers, facilitating consultations, and managing legal requirements, all within a single, user-friendly interface.\n\n  BINDING USERS WITH LAWYERS\n\tOur platform bridges the gap between users in need of legal advice and lawyers specializing in various domains. It creates an environment conducive to seamless communication, collaboration, and effective resolution of legal matters.");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout c2homeLayout = new javax.swing.GroupLayout(c2home);
        c2home.setLayout(c2homeLayout);
        c2homeLayout.setHorizontalGroup(
            c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c2homeLayout.createSequentialGroup()
                .addGroup(c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(c2homeLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(c2homeLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2homeLayout.createSequentialGroup()
                .addGroup(c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(c2homeLayout.createSequentialGroup()
                        .addContainerGap(57, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(c2homeLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(c2homeLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        c2homeLayout.setVerticalGroup(
            c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c2homeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c2homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(bot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPanel2.add(c2home, "card2");

        c1profile.setBackground(new java.awt.Color(255, 255, 255));

        USERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERNAMEActionPerformed(evt);
            }
        });

        PHONE_NUMBER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PHONE_NUMBERActionPerformed(evt);
            }
        });

        EMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMAILActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("PHONE-NUMBER");

        jLabel3.setText("EMAIL");

        jLabel4.setText("Loaction");

        LOCATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOCATIONActionPerformed(evt);
            }
        });

        UID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UIDActionPerformed(evt);
            }
        });

        q.setText("UID");

        javax.swing.GroupLayout c1profileLayout = new javax.swing.GroupLayout(c1profile);
        c1profile.setLayout(c1profileLayout);
        c1profileLayout.setHorizontalGroup(
            c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c1profileLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(q, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PHONE_NUMBER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LOCATION, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USERNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EMAIL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        c1profileLayout.setVerticalGroup(
            c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c1profileLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PHONE_NUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(c1profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LOCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel2.add(c1profile, "card1");

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, "card4");

        c3Case.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout c3CaseLayout = new javax.swing.GroupLayout(c3Case);
        c3Case.setLayout(c3CaseLayout);
        c3CaseLayout.setHorizontalGroup(
            c3CaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        c3CaseLayout.setVerticalGroup(
            c3CaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel2.add(c3Case, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        cardLayout.show(jPanel2, "card1");
        showUserProfile(LawyerSignin);
    }//GEN-LAST:event_profileActionPerformed

    private void USERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USERNAMEActionPerformed

    private void PHONE_NUMBERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PHONE_NUMBERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PHONE_NUMBERActionPerformed

    private void EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMAILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMAILActionPerformed

    private void LOCATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOCATIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOCATIONActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
         displayAllRequests(UID.getText());
         //checkAndPromptForResponse(UID.getText());
    }//GEN-LAST:event_statusActionPerformed

    private void UIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Front().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        cardLayout.show(jPanel2, "card2");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void botActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botActionPerformed
        // TODO add your handling code here:
        new GoogleSearchAppGUI().setVisible(true);

    }//GEN-LAST:event_botActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

private void showUserProfile(String Uid) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000")) {
        String query = "SELECT * FROM lawyersignup WHERE uid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, Uid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("username");
                    String phoneNum = rs.getString("phone_num");
                    String email = rs.getString("email");
                    String location = rs.getString("location");
                    String uid = rs.getString("uid");
                
                    System.out.println("Retrieved Name: " + name); // Check the retrieved name in console
                    
                    USERNAME.setText(name);
                    PHONE_NUMBER.setText(phoneNum);
                    EMAIL.setText(email);
                    LOCATION.setText(location);
                    UID.setText(uid);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Method to check if the lawyer has any pending requests and prompt for a response
public void checkAndPromptForResponse(String lawyerUid) {
    try {
        // Establish a connection to your database (replace with your actual database connection details)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000");

        // Check if the lawyer has any pending requests
        String checkQuery = "SELECT * FROM request WHERE lawyer_uid = ? AND status = 'Pending'";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setString(1, lawyerUid);

        ResultSet resultSet = checkStmt.executeQuery();

        if (resultSet.next()) {
            // Lawyer has pending requests, prompt for response
            promptForResponse(lawyerUid);
        } else {
            // Lawyer doesn't have any pending requests
            System.out.println("No pending requests for lawyer with UID: " + lawyerUid);
            // You can add further handling if needed
        }

        resultSet.close();
        checkStmt.close();
        conn.close();
    } catch (SQLException ex) {
        // Handle any SQL exceptions
        ex.printStackTrace();
        System.out.println("Error: Unable to check pending requests.");
    }
}

private void displayCaseDetails(String lawyerUID, int requestID) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000")) {
   String query = "SELECT r.user_name, r.status, r.request_id, c.case_details " +
               "FROM request r " +
               "LEFT JOIN cases c ON r.lawyer_uid = c.lawyerUID " +
               "WHERE r.lawyer_uid = ? AND r.request_id = ? AND (r.status = 'Pending' OR r.status = 'Accepted')";


        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, lawyerUID);
            pstmt.setInt(2, requestID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String caseDetails = rs.getString("case_details");
                    JOptionPane.showMessageDialog(null, "Case Details for Request ID " + requestID + ":\n" + caseDetails, "Case Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No case details found for Request ID " + requestID, "Case Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching case details.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void displayAllRequests(String lawyerUID) {
    JPanel requestsPanel = new JPanel();
    requestsPanel.setLayout(new BoxLayout(requestsPanel, BoxLayout.Y_AXIS));

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000")) {
        String query = "SELECT r.user_name, r.status, r.request_id FROM request r WHERE r.lawyer_uid = ? AND (r.status = 'Pending' OR r.status = 'Accepted')";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, lawyerUID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No pending or accepted requests for the lawyer: " + lawyerUID);
                    JOptionPane.showMessageDialog(null, "No pending or accepted requests!");
                } else {
                    while (rs.next()) {
                        String userName = rs.getString("user_name");
                        String status = rs.getString("status");
                        int requestID = rs.getInt("request_id");

                        JLabel userLabel = new JLabel("User Name: " + userName);
                        JLabel statusLabel = new JLabel("Status: " + status);

                        JPanel requestPanel = new JPanel(new GridLayout(0, 1));
                        requestPanel.add(userLabel);
                        requestPanel.add(statusLabel);
                        requestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                        JButton acceptButton = new JButton("Accept");
                        acceptButton.addActionListener(e -> updateRequestStatus(lawyerUID, userName, "Accepted"));

                        JButton declineButton = new JButton("Decline");
                        declineButton.addActionListener(e -> updateRequestStatus(lawyerUID, userName, "Rejected"));

                        JButton detailsButton = new JButton("Case Details");
                        detailsButton.addActionListener(e -> displayCaseDetails(lawyerUID, requestID));

                        requestPanel.add(acceptButton);
                        requestPanel.add(declineButton);
                        requestPanel.add(detailsButton);
                        requestsPanel.add(requestPanel);
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching requests.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    JScrollPane scrollPane = new JScrollPane(requestsPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JFrame frame = new JFrame("Pending and Accepted Requests");
    frame.setLayout(new BorderLayout());
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.pack();
    frame.setSize(600, 400);
    frame.setVisible(true);
}


public void updateRequestStatus(String lawyerUID, String userName, String status) {
    // Update the request status in the database based on lawyerUID and userName
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000")) {
        String updateQuery = "UPDATE request SET status = ? WHERE lawyer_uid = ? AND user_name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, status);
            pstmt.setString(2, lawyerUID);
            pstmt.setString(3, userName);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Request status updated for lawyer: " + lawyerUID + " and user: " + userName);
            } else {
                System.out.println("Failed to update request status.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating request status.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void promptForResponse(String lawyerUID) {
    // Display a dialog box to prompt the lawyer for response (accept or reject)
    // You can use JOptionPane or any other suitable method to create a dialog box
    
    // Example using JOptionPane
    int choice = JOptionPane.showConfirmDialog(null, "You have pending requests. Do you want to accept?", "Pending Requests", JOptionPane.YES_NO_OPTION);
    
    // Check the lawyer's choice
    if (choice == JOptionPane.YES_OPTION) {
        // Lawyer accepted the request, update the request status as 'Accepted'
        updateRequestStatus(lawyerUID, "Accepted");
    } else {
        // Lawyer declined the request, update the request status as 'Rejected'
        updateRequestStatus(lawyerUID, "Rejected");
    }
    
    JOptionPane.showMessageDialog(null, "Request Updated! " );
}

// Method to update the request status in the database
public void updateRequestStatus(String lawyerUID, String status) {
 try {
        // Establish a connection to your database (replace with your actual database connection details)
        System.out.println("Lawyer UID: " + UID);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "0000");

        // Update the request status
        String updateQuery = "UPDATE request SET status = ? WHERE lawyer_uid = ? AND status = 'Pending'";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setString(1, status);
        updateStmt.setString(2, lawyerUID);

        // Print the update query for debugging
        System.out.println("Update Query: " + updateStmt.toString());

        int rowsUpdated = updateStmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Request status updated to " + status + " for lawyer with UID: " + UID);
            // You can add further handling if needed
        } else {
            System.out.println("Failed to update request status.");
            // You can add further handling if needed
        }

        updateStmt.close();
        conn.close();
    } catch (SQLException ex) {
        // Handle any SQL exceptions
        ex.printStackTrace();
        System.out.println("Error: Unable to update request status.");
    }
}









    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EMAIL;
    private javax.swing.JTextField LOCATION;
    private javax.swing.JTextField PHONE_NUMBER;
    private javax.swing.JTextField UID;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JButton bot;
    private javax.swing.JPanel c1profile;
    private javax.swing.JPanel c2home;
    private javax.swing.JPanel c3Case;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton profile;
    private javax.swing.JLabel q;
    private javax.swing.JButton status;
    // End of variables declaration//GEN-END:variables
}
