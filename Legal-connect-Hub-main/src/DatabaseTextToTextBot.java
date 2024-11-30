package Login1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTextToTextBot extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/java_project";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    private JTextArea chatInputTextArea;
    private JTextArea chatOutputTextArea;
    private JLabel chatPromptLabel;
    private JLabel chatInfoLabel;

    public DatabaseTextToTextBot() {
        setTitle("Database Chat Bot");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatInputTextArea = new JTextArea();
        chatInputTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatOutputTextArea = new JTextArea();
        chatOutputTextArea.setEditable(false);
        chatOutputTextArea.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton chatAskButton = new JButton("Ask Bot");
        chatPromptLabel = new JLabel("Ask your questions or type 'exit' to quit:");
        chatInfoLabel = new JLabel("Input format for Law Bot: Article Article Number");

        setLayout(new BorderLayout());

        JPanel chatInputPanel = new JPanel();
        chatInputPanel.setLayout(new BoxLayout(chatInputPanel, BoxLayout.Y_AXIS));
        chatInputPanel.add(Box.createVerticalGlue());
        chatInputPanel.add(chatPromptLabel);
        chatInputPanel.add(chatInfoLabel);
        chatInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        chatInputPanel.add(new JScrollPane(chatInputTextArea));
        chatInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        chatInputPanel.add(chatAskButton);
        chatInputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        chatInputPanel.add(new JScrollPane(chatOutputTextArea));
        chatInputPanel.add(Box.createVerticalGlue());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(chatInputPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        chatAskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userChatInput = chatInputTextArea.getText();
                if (userChatInput.equalsIgnoreCase("exit")) {
                    System.out.println("Database Chat Bot: Goodbye!");
                    System.exit(0);
                } else {
                    String botResponse = getBotResponse(userChatInput);
                    chatOutputTextArea.setText("Bot's Answer:\n" + botResponse);
                }
            }
        });
    }

    private String getBotResponse(String userInput) {
        if (userInput.toLowerCase().matches(".*\\barticle\\s+\\d+.*")) {
            return getLawBotResponse(userInput);
        } else if (userInput.equalsIgnoreCase("add")) {
            // Handle adding articles to the database
            addArticle();
            return "Article added to the database.";
        } else {
            return retrieveDataFromDatabase(userInput);
        }
    }

    private String getLawBotResponse(String question) {
        String[] parts = question.split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equalsIgnoreCase("article") && i + 1 < parts.length) {
                String articleNumber = parts[i + 1];
                return getArticleResponse(articleNumber);
            }
        }
        return "I'm a law bot. I'm still learning, but here's a generic legal response.";
    }

    private String retrieveDataFromDatabase(String userInput) {
        String sql = "SELECT article_def FROM bot WHERE LOWER(article_name) = ?";
        System.out.println("SQL Query: " + sql);

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userInput.toLowerCase());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("article_def");
                } else {
                    return "No matching response found in the database.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving data from the database. See logs for details.";
        }
    }

    private String getArticleResponse(String articleNumber) {
        // Implement your logic for generating responses based on article numbers
        // For now, return a generic response
        return "I'm a law bot. I'm still learning, but here's a generic legal response.";
    }

    private void addArticle() {
        // Implement your logic for adding articles to the database
        // For now, show a message
        System.out.println("Adding article to the database...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DatabaseTextToTextBot bot = new DatabaseTextToTextBot();
                bot.setVisible(true);
            }
        });
    }
}
