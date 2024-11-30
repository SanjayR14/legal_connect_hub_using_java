import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;
import java.util.TimerTask;
import javax.mail.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.internet.*;

class Choose extends JFrame {
    JPanel doula;
    static JPanel home;
    JButton doulabutton, userbutton;
    static JButton back;
    
    
    Choose(JButton doulabutton, JButton userbutton) {
        this.doulabutton = doulabutton;
        this.userbutton = userbutton;
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 1200);
        setTitle("Shop Application");
        doula = new JPanel(null);
        doula.setBackground(new Color(0xE6EDF2));
        home = new JPanel(null);
        home.setBackground(new Color(0xffffff));
        
        back= new JButton("Back");
        back.setBackground(Color.PINK);
        back.setBounds(690, 300, 250, 50);
        home.add(back);
        
        doulabutton.setFont(new Font("Arial", Font.BOLD, 18));
        userbutton.setFont(new Font("Arial", Font.BOLD, 18));

        doulabutton.setBackground(Color.PINK);
        doulabutton.setBounds(400, 300, 250, 50);
        doula.add(doulabutton);

        userbutton.setBackground(Color.PINK);
        userbutton.setBounds(690, 300, 250, 50);
        doula.add(userbutton);

        add(doula);
        setVisible(true);

        doulabutton.addActionListener(new DoulaListener());
        userbutton.addActionListener(new UserListener());
        back.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {

                    home.setVisible(false);
                    setTitle("Choose");
                    add(doula, BorderLayout.CENTER);
                    doula.setVisible(true);
                    revalidate();
                    repaint();
                }
            }
        });
            
        }
  
    class DoulaListener implements ActionListener {
        JPanel loginpaneld,signuppaneld,otppaneld;//home;
        JButton loginButtond, signupButtond, otpButtond,back1d,back2d,regenerated,otplu,logind,bck;
        JTextField user1d, passd, fird, lastd, gmaild, phoned, addressd, citd,relink,otpud;
        JLabel timerLabeld,otpDisplayLabeld,otpbard;
        Timer timer;JLabel timerLabel;
        int remainingTimed;String otp;
        boolean regenerating = false;

        DoulaListener() {

            loginpaneld = new JPanel(null);
            loginpaneld.setBackground(new Color(0xccffff));

            signuppaneld = new JPanel(null);
            signuppaneld.setBackground(new Color(0xccffff));

            loginButtond = new JButton("LOGIN");
            signupButtond = new JButton("SIGNUP");
            back1d= new JButton("Back");
            back2d = new JButton("Back");
            
            loginpaneld = new JPanel(null);
            loginpaneld.setBackground(new Color(0xccffff));
            otpButtond = new JButton("Send OTP");
            user1d = new JTextField(15);
            passd= new JTextField(15);

            fird = new JTextField(15);
            lastd = new JTextField(15);
            gmaild = new JTextField(15);
            phoned = new JTextField(15);
            addressd = new JTextField(15);
            citd = new JTextField(15);
            relink=new JTextField(15);
            
            JLabel usernameLabeld = new JLabel("Username:");
            JLabel passwordLabeld = new JLabel("Password:");
            
            JLabel firstNameLabeld = new JLabel("First Name:");
            JLabel lastNameLabeld = new JLabel("Last Name:");
            JLabel gmailLabeld = new JLabel("Gmail ID:");
            JLabel phoneLabeld = new JLabel("Phone No:");
            JLabel addressLabeld = new JLabel("Address:");
            JLabel citizenshipLabeld = new JLabel("Citizenship ID:");
            JLabel passwordLabelSignupd = new JLabel("Password:");
            JLabel resume = new JLabel("Resume link:");
            

            gmailLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            phoneLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            addressLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            citizenshipLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            passwordLabelSignupd.setFont(new Font("Arial", Font.BOLD, 18));
            resume.setFont(new Font("Arial", Font.BOLD, 18));

           
            usernameLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            passwordLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            loginButtond.setBounds(500, 400, 100, 30);
            signupButtond.setBounds(650, 400, 100, 30);
            user1d.setBounds(500, 300, 250, 25);
            passd.setBounds(500, 340, 250, 25);
            usernameLabeld.setBounds(400, 300, 250, 20);
            passwordLabeld.setBounds(400, 340, 250, 20);

            

             loginpaneld.add(usernameLabeld);
             loginpaneld.add(passwordLabeld);
             loginpaneld.add(signupButtond);
             loginpaneld.add(loginButtond);
             loginpaneld.add(user1d);
             loginpaneld.add(passd);
             loginpaneld.add(back2d);
            
             
             
            firstNameLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            lastNameLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            gmailLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            phoneLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            addressLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            citizenshipLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            
            lastd.setBounds(500, 250, 250, 25);
            gmaild.setBounds(500, 300, 250, 25);
            phoned.setBounds(500, 350, 250, 25);
            addressd.setBounds(500, 400, 250, 25);
            citd.setBounds(500, 450, 250, 25);
            fird.setBounds(500, 200, 250, 25);
            relink.setBounds(500,500,250,25);
            
            resume.setBounds(390,500,250,25);
            firstNameLabeld.setBounds(400, 200, 250, 30);
            lastNameLabeld.setBounds(400, 250, 250, 30);
            gmailLabeld.setBounds(400, 300, 250, 30);
            phoneLabeld.setBounds(400, 350, 250, 30);
            addressLabeld.setBounds(400, 400, 250, 30);
            citizenshipLabeld.setBounds(380, 450, 250, 30);
            
            otpButtond.setBounds(500, 550, 100, 30);
            
            back1d.setBounds(500, 600, 250, 30);
            back2d.setBounds(500, 450, 250, 30);
            
             
             signuppaneld.add(fird);
             signuppaneld.add(lastd);
             signuppaneld.add(phoned);
             signuppaneld.add(gmaild);
             signuppaneld.add(addressd);
             signuppaneld.add(citd);
             signuppaneld.add(relink);
             
             signuppaneld.add(fird);
            signuppaneld.add(lastd);
            signuppaneld.add(gmaild);
            signuppaneld.add(phoned);
            signuppaneld.add(addressd);
            signuppaneld.add(citd);
            
            signuppaneld.add(resume);
             signuppaneld.add(firstNameLabeld);
            signuppaneld.add(lastNameLabeld);
            signuppaneld.add(gmailLabeld);
            signuppaneld.add(phoneLabeld);
            signuppaneld.add(addressLabeld);
            signuppaneld.add(citizenshipLabeld);
            
            //OTP FOR USER
            otppaneld=new JPanel(null);
            otppaneld.setBackground(new Color(0xccffff));
            otpbard  = new JLabel(" One Time password ");
            otpbard.setBounds(400, 300, 250, 20);
            otpbard.setFont(new Font("Arial", Font.BOLD, 18));
            otppaneld.add(otpbard);
            
            otpud = new JTextField(15);
            otpud.setBounds(590, 300, 250, 25);
            otpud.setFont(new Font("Arial", Font.BOLD, 18));
            otppaneld.add(otpud);
            
            bck = new JButton("Back");
            bck.setBounds(500, 450, 100, 30);
            bck.setFont(new Font("Arial", Font.BOLD, 18));
            otppaneld.add(bck);
            
            logind = new JButton("Login");
            logind.setBounds(500, 400, 100, 30);
            logind.setFont(new Font("Arial", Font.BOLD, 18));
            otppaneld.add(logind);
            timerLabel = new JLabel("Time remaining: 2:00");
           
            otppaneld.add(logind);
            regenerated = new JButton("Regenerate OTP");
            regenerated.setBounds(650, 400, 200, 30);
            regenerated.setFont(new Font("Arial", Font.BOLD, 18));
            otppaneld.add(regenerated);
            timerLabeld = new JLabel("Time remaining: 2:00");
            timerLabeld.setBounds(500, 350, 300, 30);
            timerLabeld.setFont(new Font("Arial", Font.BOLD, 18));
            
            
            
            generateOTP(); 
            startTimer(); 
            otppaneld.add(timerLabeld);
            otppaneld.setVisible(true);
             
             
             
             signuppaneld.add(back1d);
             signuppaneld.add(otpButtond);
             regenerated.addActionListener(this);
             signupButtond.addActionListener(this);
             logind.addActionListener(this);
             loginButtond.addActionListener(this);
             back1d.addActionListener(this);
             back2d.addActionListener(this);
             otpButtond.addActionListener(this);
             bck.addActionListener(this);
        }
        void checkOTP() {
        String enteredOTP = otpud.getText();
        if (enteredOTP.equals(otp)) {
            timer.cancel();
            otppaneld.setVisible(false);
            setTitle("Home Page");
            add(home, BorderLayout.CENTER);
            home.setVisible(true);
            revalidate();
            repaint();
            regenerateOTP();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid OTP. Please try again.");
        }
    }

    void regenerateOTP() {
        if (!regenerating) {
            regenerating = true;
            timer.cancel();
            generateOTP();
            startTimer();
            regenerating = false;
        }
    }

    void generateOTP() {
        otp = generateRandomOTP();
    }

    void updateTimerLabel() {
        int minutes = remainingTimed / 60;
        int seconds = remainingTimed % 60;
        timerLabeld.setText("Time remaining: " + String.format("%d:%02d", minutes, seconds));
    }

    void startTimer() {
        remainingTimed = 120;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateTimerLabel();
                    }
                });

                if (remainingTimed == 0) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(null, "OTP Expired. Please regenerate.");
                    regenerateOTP();
                } else {
                    remainingTimed--;
                }
            }
        }, 0, 1000);
    }

        
        void sendEmail(String toEmail, String subject, String message,
                                 String senderEmail, String senderPassword) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
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
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
        }
       
       String generateRandomOTP() {
                Random random = new Random();
        int otpDigits = 4; 

        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < otpDigits; i++) {
            otpBuilder.append(random.nextInt(10));
        }

        return otpBuilder.toString();
    }
        
        
       
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == doulabutton) {
                doula.setVisible(false);
                setTitle("LoginPage");
                add(loginpaneld, BorderLayout.CENTER);
                loginpaneld.setVisible(true);
                revalidate();
                repaint();
            }
            if(e.getSource() == bck){
                otppaneld.setVisible(false);
                setTitle("LoginPage");
                add(loginpaneld, BorderLayout.CENTER);
                loginpaneld.setVisible(true);
                revalidate();
                repaint();
            }
            if (e.getSource() == regenerated){
                regenerateOTP();
                String toEmail = gmaild.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             
            }
            if (e.getSource() == regenerated){
                regenerateOTP();
                String toEmail = user1d.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             
            }
            if (e.getSource() == back) {
                home.setVisible(false);
                setTitle("LoginPage");
                add(signuppaneld, BorderLayout.CENTER);
                signuppaneld.setVisible(true);
                revalidate();
                repaint();
            }
            if (e.getSource() == logind) {
                checkOTP();
              
            }
            if (e.getSource() == loginButtond) {
                loginpaneld.setVisible(false);
                setTitle("Otppanel");
                add(otppaneld, BorderLayout.CENTER);
                otppaneld.setVisible(true);
                revalidate();
                repaint();
                String userld = user1d.getText();
                String passid = passd.getText();
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO po (username, password) VALUES (?,?)");
                stmt.setString(1, userld);
                stmt.setString(2, passid);
                
                int rowsInserted = stmt.executeUpdate();
                
                String toEmail = user1d.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             
                

                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
                          
            
        }
             if (e.getSource() == back1d) {
                signuppaneld.setVisible(false);
                setTitle("signup Page");
                add(loginpaneld, BorderLayout.CENTER);
                loginpaneld.setVisible(true);
                revalidate();
                repaint();
             }
            if (e.getSource() == signupButtond) {
                loginpaneld.setVisible(false);
                setTitle("signup Page");
                add(signuppaneld, BorderLayout.CENTER);
                signuppaneld.setVisible(true);
                revalidate();
                repaint();
                 
    }
            if(e.getSource() == otpButtond){
                
            
                signuppaneld.setVisible(false);
                setTitle("home");
                add(otppaneld, BorderLayout.CENTER);
                otppaneld.setVisible(true);
            
                String fir1 = fird.getText();
                String  gma1= gmaild.getText();
                String addre1=addressd.getText();
                String ph1=phoned.getText();
                String citdo1=citd.getText();
                String pa1=passd.getText(); 
                String last1 = new String(lastd.getText());
                String relinkd=relink.getText();
                try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO ko (username,lastname,gmail,address,phone,citizen,password,rlink) VALUES (?,?,?,?,?,?,?,?)");
                stmt.setString(1, fir1);
                stmt.setString(2, last1);
                stmt.setString(3, gma1);
                stmt.setString(4, addre1);
                stmt.setString(5, ph1);
                stmt.setString(6, citdo1);
                stmt.setString(7, pa1);
                stmt.setString(8, relinkd);
                          
                int rowsInserted = stmt.executeUpdate();
                String toEmail = gmaild.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             
                

                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
            
            if (e.getSource() == back2d) {
                loginpaneld.setVisible(false);
                setTitle("choose");
                add(doula, BorderLayout.CENTER);
                doula.setVisible(true);
                revalidate();
                repaint();
            }  
    }
    }
    
    class UserListener implements ActionListener {
        JPanel loginpanel, signuppanel,otppanel,otppanell;
        String otp,toEmail;
        int remainingTime;Timer timer;JLabel timerLabel;
        JButton loginButton, signupButton, otpButton,back1,back2,loginu,regenerate,otplu,back3;
        JTextField user1, pass, firu, lastu, gmailu, phoneu, addressu, citu,otpu;
        JPasswordField passSignup;
        JLabel DisplayLabel,otpbar;

        boolean regenerating = false;

        UserListener() {
            
            loginpanel = new JPanel(null);
            loginpanel.setBackground(new Color(0xccffff));

            signuppanel = new JPanel(null);
            signuppanel.setBackground(new Color(0xccffff));
          
            loginButton = new JButton("LOGIN");
            signupButton = new JButton("SIGNUP");
            back1 = new JButton("Back");
            back2 = new JButton("Back");
            
            otpButton = new JButton("Send OTP");

            user1 = new JTextField(15);
            pass= new JTextField(15);

            firu = new JTextField(15);
            lastu = new JTextField(15);
            gmailu = new JTextField(15);
            phoneu = new JTextField(15);
            addressu = new JTextField(15);
            citu = new JTextField(15);
            passSignup = new JPasswordField(15);

            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");

            JLabel firstNameLabel = new JLabel("First Name:");
            JLabel lastNameLabel = new JLabel("Last Name:");
            JLabel gmailLabel = new JLabel("Gmail ID:");
            JLabel phoneLabel = new JLabel("Phone No:");
            JLabel addressLabel = new JLabel("Address:");
            JLabel citizenshipLabel = new JLabel("Citizenship ID:");
            JLabel passwordLabelSignup = new JLabel("Password:");

            usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));

            firstNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            lastNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            gmailLabel.setFont(new Font("Arial", Font.BOLD, 18));
            phoneLabel.setFont(new Font("Arial", Font.BOLD, 18));
            addressLabel.setFont(new Font("Arial", Font.BOLD, 18));
            citizenshipLabel.setFont(new Font("Arial", Font.BOLD, 18));
            passwordLabelSignup.setFont(new Font("Arial", Font.BOLD, 18));

            usernameLabel.setBounds(400, 300, 250, 20);
            passwordLabel.setBounds(400, 340, 250, 20);

            firstNameLabel.setBounds(400, 200, 250, 30);
            lastNameLabel.setBounds(400, 250, 250, 30);
            gmailLabel.setBounds(400, 300, 250, 30);
            phoneLabel.setBounds(400, 350, 250, 30);
            addressLabel.setBounds(400, 400, 250, 30);
            citizenshipLabel.setBounds(370, 450, 250, 30);
            passwordLabelSignup.setBounds(400, 500, 250, 30);

            user1.setBounds(500, 300, 250, 25);
            pass.setBounds(500, 340, 250, 25);
            back1.setBounds(500, 600, 250, 25);
            back2.setBounds(500, 450, 250, 25);
            firu.setBounds(500, 200, 250, 25);
            lastu.setBounds(500, 250, 250, 25);
            gmailu.setBounds(500, 300, 250, 25);
            phoneu.setBounds(500, 350, 250, 25);
            addressu.setBounds(500, 400, 250, 25);
            citu.setBounds(500, 450, 250, 25);
            passSignup.setBounds(500, 500, 250, 25);

            loginButton.setBounds(500, 400, 100, 30);
            signupButton.setBounds(650, 400, 100, 30);

            otpButton.setBounds(500, 550, 100, 30);

            loginpanel.add(usernameLabel);
            loginpanel.add(passwordLabel);
            loginpanel.add(signupButton);
            loginpanel.add(loginButton);
            loginpanel.add(user1);
            loginpanel.add(pass);
            
            loginpanel.add(back2);
            //signup for user
            
            signuppanel.add(firstNameLabel);
            signuppanel.add(lastNameLabel);
            signuppanel.add(gmailLabel);
            signuppanel.add(phoneLabel);
            signuppanel.add(addressLabel);
            signuppanel.add(citizenshipLabel);
            signuppanel.add(passwordLabelSignup);

            signuppanel.add(firu);
            signuppanel.add(lastu);
            signuppanel.add(gmailu);
            signuppanel.add(phoneu);
            signuppanel.add(addressu);
            signuppanel.add(citu);
            signuppanel.add(passSignup);
            signuppanel.add(back1);
            signuppanel.add(otpButton);
            //otp panel for login{
            otppanell=new JPanel(null);
            otppanell.setBackground(new Color(0xccffff));
            
            // otp panel
            
            otppanel=new JPanel(null);
            otppanel.setBackground(new Color(0xccffff));
            
            timerLabel = new JLabel("Time remaining: 2:00");
            
            
            otpu = new JTextField(15);
            otpu.setBounds(590, 300, 250, 25);
            otpu.setFont(new Font("Arial", Font.BOLD, 18));
            otppanel.add(otpu);
            
            
            
            loginu = new JButton("Login");
            loginu.setBounds(500, 400, 100, 30);
            loginu.setFont(new Font("Arial", Font.BOLD, 18));
            
            otpbar  = new JLabel(" One Time password ");
            otpbar.setBounds(400, 300, 250, 20);
            otpbar.setFont(new Font("Arial", Font.BOLD, 18));
            otppanel.add(otpbar);
            regenerate = new JButton("Regenerate OTP");
            regenerate.setBounds(650, 400, 200, 30);
            regenerate.setFont(new Font("Arial", Font.BOLD, 18));
            otppanel.add(regenerate);
            otppanel.add(loginu);
            
            back3 = new JButton("Back");
            back3.setBounds(500, 450, 350, 30);
            back3.setFont(new Font("Arial", Font.BOLD, 18));
            otppanel.add(back3);
            
            timerLabel = new JLabel("Time remaining: 2:00");
            timerLabel.setBounds(500, 350, 300, 30);
            timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
            
           
            
            generateOTP(); 
            startTimer();
            otppanel.setVisible(true);
            
            
            otppanel.add(timerLabel);
           //otp panel end
            back3.addActionListener(this);
            regenerate.addActionListener(this);
            otpButton.addActionListener(this);
            signupButton.addActionListener(this);
            loginButton.addActionListener(this);
            back1.addActionListener(this);
            back2.addActionListener(this);
            loginu.addActionListener(this);
    
        }
        
       
    void checkOTP() {
        String enteredOTP = otpu.getText();
        if (enteredOTP.equals(otp)) {
            timer.cancel();
            otppanel.setVisible(false);
            setTitle("Home Page");
            add(home, BorderLayout.CENTER);
            home.setVisible(true);
            revalidate();
            repaint();
            regenerateOTP();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid OTP. Please try again.");
        }
    }

    void regenerateOTP() {
        if (!regenerating) {
            regenerating = true;
            timer.cancel();
            generateOTP();
            startTimer();
            regenerating = false;
        }
    }

    void generateOTP() {
        otp = generateRandomOTP();
    }

    void updateTimerLabel() {
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        timerLabel.setText("Time remaining: " + String.format("%d:%02d", minutes, seconds));
    }

    void startTimer() {
        remainingTime = 120;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateTimerLabel();
                    }
                });

                if (remainingTime == 0) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(null, "OTP Expired. Please regenerate.");
                    regenerateOTP();
                } else {
                    remainingTime--;
                }
            }
        }, 0, 1000);
    }

        
        void sendEmail(String toEmail, String subject, String message,
                                 String senderEmail, String senderPassword) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
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
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
        }
       
       String generateRandomOTP() {
                Random random = new Random();
        int otpDigits = 4; 

        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < otpDigits; i++) {
            otpBuilder.append(random.nextInt(10));
        }

        return otpBuilder.toString();
    }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == signupButton) {
                loginpanel.setVisible(false);
                setTitle("signup Page");
                add(signuppanel, BorderLayout.CENTER);
                signuppanel.setVisible(true);
                revalidate();
                repaint();
            }
            if(e.getSource()==back3){
                otppanel.setVisible(false);
                setTitle("signup Page");
                add(loginpanel, BorderLayout.CENTER);
                loginpanel.setVisible(true);
                revalidate();
                repaint();
             }
             
            
            if(e.getSource()==otpButton){
                signuppanel.setVisible(false);
                setTitle("signup Page");
                add(otppanel, BorderLayout.CENTER);
                otppanel.setVisible(true);
                revalidate();
                repaint();
                String fir1u = firu.getText();
                String gma1u = gmailu.getText();
                String addre1u = addressu.getText();
                String ph1u = phoneu.getText();
                String citdo1u = citu.getText();
                String spassu = passSignup.getText();
                String last1u = lastu.getText();  

try {
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
    PreparedStatement stmt = con.prepareStatement("INSERT INTO use (username, LASTNAME, gmail, address, phone, citizen, password) VALUES (?, ?, ?, ?, ?, ?, ?)");
    stmt.setString(1, fir1u);
    stmt.setString(2, last1u);
    stmt.setString(3, gma1u);
    stmt.setString(4, addre1u);
    stmt.setString(5, ph1u);
    stmt.setString(6, citdo1u);
    stmt.setString(7, spassu);
    
    int rowsInserted = stmt.executeUpdate();


        if (rowsInserted > 0) {
    System.out.println("A new user was inserted successfully!");

    String toEmail = gma1u;
    
    if (toEmail != null && !toEmail.isEmpty()) {
        String subject = "ONE TIME PASSWORD";
        String message = "Your OTP from heal wave: " + otp;  
        String senderEmail = "h8702643@gmail.com";
        String senderPassword = "osxa rglp zcir cimn";
        
        try {
            sendEmail(toEmail, subject, message, senderEmail, senderPassword);

            // Update UI
            DisplayLabel.setText("Mail has been sent to your email: " + toEmail);
            DisplayLabel.setFont(new Font("Arial", Font.BOLD, 18));
            DisplayLabel.setBounds(400, 250, 700, 30);
            otppanel.add(DisplayLabel);
        } catch (Exception ex) {
            System.out.println("Error sending email: " + ex.getMessage());
            ex.printStackTrace();
        }
    } else {
        System.out.println("Error sending email: Invalid recipient address");
    }
    }
                con.close();
    } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
    } catch (Exception ex) {
                ex.printStackTrace();
    }

            }
            
            if (e.getSource() == regenerate) {
                regenerateOTP();
                
                String toEmail = gmailu.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                
                DisplayLabel.setText("Mail has sent to your : " + toEmail);
            
                DisplayLabel.setFont(new Font("Arial", Font.BOLD, 18));
                DisplayLabel.setBounds(400, 250, 700, 30);
            
                otppanel.add(DisplayLabel);
            
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             }
            
            if (e.getSource() == regenerate) {
                regenerateOTP();
                
                String toEmail1 =  user1.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                
                DisplayLabel.setText("Mail has sent to your : " + toEmail1);
            
                DisplayLabel.setFont(new Font("Arial", Font.BOLD, 18));
                DisplayLabel.setBounds(400, 250, 700, 30);
            
                otppanel.add(DisplayLabel);
            
                sendEmail(toEmail1, subject, message, senderEmail, senderPassword);
             }
            
            if (e.getSource() == loginButton) {
                loginpanel.setVisible(false);
                setTitle("signup Page");
                add(otppanel, BorderLayout.CENTER);
                otppanel.setVisible(true);
                revalidate();
                repaint();
                String userld = user1.getText();
                String passid = pass.getText();
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "123");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO he (username, password) VALUES (?,?)");
                stmt.setString(1, userld);
                stmt.setString(2, passid);
                
                int rowsInserted = stmt.executeUpdate();
                
                String toEmail = user1.getText();
                String subject = "ONE TIME PASSWORD";
                String message = "Your otp from heal wave "+"\n"+otp;
                String senderEmail = "h8702643@gmail.com";
                String senderPassword = "osxa rglp zcir cimn";
                sendEmail(toEmail, subject, message, senderEmail, senderPassword);
             
                

                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
                   
            }
            if(e.getSource() == otplu){
                loginpanel.setVisible(false);
                setTitle("Home Page");
                add(home, BorderLayout.CENTER);
                home.setVisible(true);
                revalidate();
                repaint();
                
            }
            if (e.getSource() == userbutton) {
                doula.setVisible(false);
                setTitle("LoginPage");
                add(loginpanel, BorderLayout.CENTER);
                loginpanel.setVisible(true);
                revalidate();
                repaint();
            }
              if (e.getSource() == back1) {
                signuppanel.setVisible(false);
                setTitle("sign in page Page");
                add(loginpanel, BorderLayout.CENTER);
                loginpanel.setVisible(true);
                revalidate();
                repaint();
            }
                if (e.getSource() == loginu) {
                    checkOTP();
                }
               
              if (e.getSource() == back2) {
                loginpanel.setVisible(false);
                setTitle("choose");
                add(doula, BorderLayout.CENTER);
                doula.setVisible(true);
                revalidate();
                repaint();
            }
              if (e.getSource()==back) {
                    
                    home.setVisible(false);
                    setTitle("Choose");
                    add(doula, BorderLayout.CENTER);
                    doula.setVisible(true);
                    revalidate();
                    repaint();
                }
            }
       
            }       
    }

public class NewPage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JButton doulabutton = new JButton("Doula");
            JButton userbutton = new JButton("User");
            new Choose(doulabutton, userbutton);
        });
    }
}
