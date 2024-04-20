package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuizzesPage extends JFrame {
    public QuizzesPage() {
        setTitle("Quizzes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Set initial size
        setLocationRelativeTo(null); // Center the frame on the screen

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240)); // Set background color

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(51, 153, 255)); // Set background color
        JLabel headerLabel = new JLabel("Quizzes");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE); // Set text color
        headerPanel.add(headerLabel);

        // Content panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240)); // Set background color
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Sample quizzes (replace with dynamic data)
        String[] quizTitles = {"Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5"};
        for (String title : quizTitles) {
            contentPanel.add(createQuizButton(title));
        }

        // Add components to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add main panel to the frame
        getContentPane().add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JButton createQuizButton(String title) {
        JButton button = new JButton(title);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setForeground(Color.WHITE); // Set text color
        button.setBackground(new Color(51, 153, 255)); // Set background color
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(200, 80)); // Set button size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open quiz page with dummy questions and answers
                openQuizPage(title);
            }
        });
        return button;
    }

    private void openQuizPage(String quizTitle) {
        JFrame quizFrame = new JFrame(quizTitle);
        quizFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        quizFrame.setSize(600, 400);
        quizFrame.setLocationRelativeTo(this);

        JPanel quizPanel = new JPanel(new GridLayout(0, 1, 10, 10)); // Updated to single column layout
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Sample questions and answers (replace with actual data)
        String[] questions = {"Question 1?", "Question 2?", "Question 3?"};
        String[][] answers = {
                {"Answer 1a", "Answer 1b", "Answer 1c"},
                {"Answer 2a", "Answer 2b", "Answer 2c"},
                {"Answer 3a", "Answer 3b", "Answer 3c"}
        };

        // List to store selected answers
        List<String> selectedAnswers = new ArrayList<>();

        // Add questions, checkboxes, and answers to the quiz panel
        for (int i = 0; i < questions.length; i++) {
            JLabel questionLabel = new JLabel(questions[i]);
            quizPanel.add(questionLabel);

            // Create checkbox group for each question
            ButtonGroup buttonGroup = new ButtonGroup();

            // Add checkboxes for each answer
            for (String answer : answers[i]) {
                JCheckBox checkBox = new JCheckBox(answer);
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JCheckBox source = (JCheckBox) e.getSource();
                        if (source.isSelected()) {
                            selectedAnswers.add(source.getText());
                        } else {
                            selectedAnswers.remove(source.getText());
                        }
                    }
                });
                buttonGroup.add(checkBox);
                quizPanel.add(checkBox);
            }
        }

        // "Done" button to check answers
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show correct answers
                StringBuilder message = new StringBuilder("Correct answer(s):\n");
                for (String answer : selectedAnswers) {
                    message.append(answer).append("\n");
                }
                JOptionPane.showMessageDialog(quizFrame, message.toString());
            }
        });
        quizPanel.add(doneButton);

        quizFrame.getContentPane().add(new JScrollPane(quizPanel));
        quizFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizzesPage::new);
    }
}
