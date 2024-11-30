/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CombinedUserAuthenticationGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CombinedUserAuthenticationGUI extends JFrame {
    private JTextField usernameField, emailField, phoneField, signUpUsernameField, signUpEmailField, signUpPhoneField;
    private JPasswordField passwordField, signUpPasswordField;
    private Connection connection;
    private Statement statement;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public CombinedUserAuthenticationGUI() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        setTitle("User Authentication");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JPanel loginPanel = createLoginPanel();
        JPanel signUpPanel = createSignUpPanel();

        cardPanel.add(loginPanel, "login");
        cardPanel.add(signUpPanel, "signup");

        cardLayout.show(cardPanel, "login");

        getContentPane().add(cardPanel);

        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setBounds(50, 50, 80, 25);
        loginPanel.add(lblNewLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 50, 150, 25);
        loginPanel.add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 80, 80, 25);
        loginPanel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 150, 25);
        loginPanel.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 120, 80, 25);
        loginPanel.add(btnLogin);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(140, 120, 80, 25);
        loginPanel.add(btnSignUp);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "signup");
            }
        });

        return loginPanel;
    }

    private JPanel createSignUpPanel() {
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setBounds(50, 20, 80, 25);
        signUpPanel.add(lblNewLabel_1);

        signUpUsernameField = new JTextField();
        signUpUsernameField.setBounds(140, 20, 150, 25);
        signUpPanel.add(signUpUsernameField);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setBounds(50, 50, 80, 25);
        signUpPanel.add(lblNewLabel_2);

        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setBounds(140, 50, 150, 25);
        signUpPanel.add(signUpPasswordField);

        JLabel lblNewLabel_3 = new JLabel("Email:");
        lblNewLabel_3.setBounds(50, 80, 80, 25);
        signUpPanel.add(lblNewLabel_3);

        signUpEmailField = new JTextField();
        signUpEmailField.setBounds(140, 80, 150, 25);
        signUpPanel.add(signUpEmailField);

        JLabel lblNewLabel_4 = new JLabel("Phone:");
        lblNewLabel_4.setBounds(50, 110, 80, 25);
        signUpPanel.add(lblNewLabel_4);

        signUpPhoneField = new JTextField();
        signUpPhoneField.setBounds(140, 110, 150, 25);
        signUpPanel.add(signUpPhoneField);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSignUp(
                    signUpUsernameField.getText(),
                    String.valueOf(signUpPasswordField.getPassword()),
                    signUpEmailField.getText(),
                    signUpPhoneField.getText()
                );
            }
        });
        btnSignUp.setBounds(50, 150, 100, 25);
        signUpPanel.add(btnSignUp);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "login");
            }
        });
        btnBack.setBounds(160, 150, 100, 25);
        signUpPanel.add(btnBack);

        return signUpPanel;
    }

    private void connectToDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleLogin() {
        String enteredUsername = usernameField.getText();
        char[] enteredPassword = passwordField.getPassword();

        try {
            String query = "SELECT * FROM user1 WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, enteredUsername);
            pstmt.setString(2, String.valueOf(enteredPassword));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // User found in user1 table
                openProfilePage(enteredUsername); // Removed JOptionPane and directly opening profile page
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred during login!", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openProfilePage(String username) {
        JFrame profileFrame = new JFrame("User Profile");
        
        JPanel profilePanel = new JPanel(new BorderLayout());
        
        JLabel lblUsername= new JLabel("Username: " + username);
        
        JButton btnShowAttributes= new JButton("Profile");
	    btnShowAttributes.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	            showSignupAttributes(username);  
	        }  
	    });
	    
	    profilePanel.add(lblUsername, BorderLayout.NORTH);
	    profilePanel.add(btnShowAttributes, BorderLayout.CENTER);

	    profileFrame.setContentPane(profilePanel);

	    profileFrame.setSize(300 ,200);    
	    profileFrame.setVisible(true);   
	    
	    this.setVisible(false); 
	    
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    private void handleSignUp(String username, String password, String email, String phone) {
        try {
            String query1 = "INSERT INTO user1 (username, password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt1 = connection.prepareStatement(query1);
            pstmt1.setString(1, username);
            pstmt1.setString(2, password);
            pstmt1.setString(3, email);
            pstmt1.setString(4, phone);
            pstmt1.executeUpdate();
            JOptionPane.showMessageDialog(this, "User registered successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while registering user!", "Registration Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  

	private void showSignupAttributes(String username) {	
		  try{
			  String query="SELECT * FROM user1 WHERE username=?";
			  PreparedStatement pstmt=connection.prepareStatement(query);  
			  pstmt.setString(1 ,username );
			  ResultSet rs=pstmt.executeQuery(); 

			  if(rs.next()){
				  JOptionPane.showMessageDialog(this,"Username: "+rs.getString("username") +"\n"+
						  "Email: "+rs.getString("email") +"\n"+
						  "Phone: "+rs.getString("phone"));
				  
				  }
		  }catch(SQLException ex){
			  ex.printStackTrace();  
		  }	  
	  }

	public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> { new CombinedUserAuthenticationGUI(); });        
     }
}