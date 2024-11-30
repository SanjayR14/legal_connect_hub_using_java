/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruban
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    public MainGUI() {
        setTitle("Main GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openLawBotButton = new JButton("Open Law Bot");
        openLawBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LawBotGUI when the button is clicked
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        LawBotGUI lawBotGUI = new LawBotGUI();
                        lawBotGUI.setVisible(true);
                    }
                });
            }
        });

        setLayout(new FlowLayout());
        add(openLawBotButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
            }
        });
    }
}

class LawBotGUI extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JLabel promptLabel;
    private JLabel infoLabel;
    private JLabel logoLabel;

    public LawBotGUI() {
        setTitle("Law Bot GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logoIcon = new ImageIcon("C:\\Users\\chubr\\Downloads\\Dj.jpg");
        Image image = logoIcon.getImage();
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(newImage);
        logoLabel = new JLabel(logoIcon);

        inputTextArea = new JTextArea();
        inputTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton askButton = new JButton("Ask Law Bot");
        promptLabel = new JLabel("Ask your questions or doubts below:");
        infoLabel = new JLabel("Input format: Article Article Number");

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(Box.createVerticalGlue());
        inputPanel.add(promptLabel);
        inputPanel.add(infoLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(new JScrollPane(inputTextArea));
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(askButton);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(new JScrollPane(outputTextArea));
        inputPanel.add(Box.createVerticalGlue());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(logoLabel, BorderLayout.NORTH);
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        askButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = inputTextArea.getText();
                String lawBotResponse = getLawBotResponse(question);
                outputTextArea.setText("Law Bot's Answer:\n" + lawBotResponse);
            }
        });
    }

    private String getLawBotResponse(String question) {
        if (question.toLowerCase().matches(".*\\barticle\\s+\\d+.*")) {
            String[] parts = question.split("\\s+");
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equalsIgnoreCase("article") && i + 1 < parts.length) {
                    String articleNumber = parts[i + 1];
                    return getArticleResponse(articleNumber);
                }
            }
        }
        return "I'm a law bot. I'm still learning, but here's a generic legal response.";
    }

    private String getArticleResponse(String articleNumber) {
        switch (articleNumber) {
            case "5":
                return "Article 5: Every person with domicile in the territory of India at the commencement of this Constitution is a citizen based on certain conditions.";
            case "6":
                return "Article 6: Defines citizenship for those who migrated to India from Pakistan with specific conditions.";
            case "7":
                return "Article 7: Addresses citizenship for those who migrated from India to Pakistan after March 1, 1947, with specific exceptions.";
            case "8":
                return "Article 8: Deals with citizenship for individuals residing outside India but having Indian ancestry.";
            case "9":
                return "Article 9: Specifies that acquiring foreign citizenship voluntarily disqualifies a person from Indian citizenship.";
            case "10":
                return "Article 10: Those who are citizens under the mentioned provisions will continue to be citizens, subject to future laws.";
            case "11":
                return "Article 11: Parliament has the power to make provisions regarding the acquisition, termination, and other matters related to citizenship.";
            default:
                return "I'm a law bot. I'm still learning, but here's a generic legal response.";
        }
    }
}