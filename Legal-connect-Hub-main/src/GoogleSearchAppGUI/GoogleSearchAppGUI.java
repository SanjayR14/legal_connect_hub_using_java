package GoogleSearchAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchAppGUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;
    private Set<String> displayedMeanings;
    private int mouseX, mouseY;

    public GoogleSearchAppGUI() {
        super("Google Search App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchField = new JTextField();
        searchButton = new JButton("Search");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchButton.addActionListener((ActionEvent e) -> {
            search();
        });

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        searchButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getX() - mouseX;
                int deltaY = e.getY() - mouseY;
                searchButton.setBounds(searchButton.getX() + deltaX, searchButton.getY() + deltaY,
                        searchButton.getWidth(), searchButton.getHeight());
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(new JLabel("Enter the search term:"));
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(new JScrollPane(resultArea));
        panel.setSize(100,100);

        getContentPane().add(panel);
        displayedMeanings = new HashSet<>();
    }

    void search() {
        String searchTerm = searchField.getText();

        try {
            String encodedSearchTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8.toString());
            String searchUrl = "https://www.google.co.in/search?q=" + encodedSearchTerm;

            Document document = Jsoup.connect(searchUrl).get();

            Elements definitionElements = document.select(".BNeawe div, .BNeawe div span");

            StringBuilder resultText = new StringBuilder();
            int linesPrinted = 0;

            for (Element element : definitionElements) {
                String elementText = element.text();
                if (isRelevant(elementText, searchTerm) && !displayedMeanings.contains(elementText)) {
                    resultText.append(" LAILA : ").append(elementText).append("\n");
                    linesPrinted++;
                    displayedMeanings.add(elementText);

                    if (linesPrinted == 5) {
                        break;
                    }
                }
            }

            if (linesPrinted == 0) {
                resultText.append("No relevant meaning found for '").append(searchTerm).append("'.\n");
            }

            resultArea.setText(resultText.toString());

        } catch (IOException e) {
            resultArea.setText("An error occurred: " + e.getMessage());
        }
    }

    boolean isRelevant(String result, String searchTerm) {
        String[] searchTerms = searchTerm.toLowerCase().split("\\s+");
        int matchCount = 0;

        for (String term : searchTerms) {
            if (result.toLowerCase().contains(term)) {
                matchCount++;
            }
        }

        return matchCount >= searchTerms.length / 2;
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            GoogleSearchAppGUI app = new GoogleSearchAppGUI();
            app.setSize(883, 463); // Setting the desired dimensions
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        }
    });
}
}