package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LeaderboardPage extends JFrame {
    private Map<String, CourseDetails> courseDetailsMap;

    public LeaderboardPage() {
        setTitle("Course Leaderboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Set initial size
        setLocationRelativeTo(null); // Center the frame on the screen

        // Sample data for course leaderboard (replace with actual data)
        courseDetailsMap = new HashMap<>();
        courseDetailsMap.put("Course 1", new CourseDetails(150, 80, 60));
        courseDetailsMap.put("Course 2", new CourseDetails(120, 50, 40));
        courseDetailsMap.put("Course 3", new CourseDetails(90, 30, 20));
        courseDetailsMap.put("Course 4", new CourseDetails(80, 25, 15));
        courseDetailsMap.put("Course 5", new CourseDetails(70, 20, 10));

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(51, 153, 255)); // Set background color
        JLabel headerLabel = new JLabel("Course Leaderboard");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE); // Set text color
        headerPanel.add(headerLabel);

        // Leaderboard panel
        JPanel leaderboardPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        leaderboardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Add leaderboard entries with details and gamification features
        for (Map.Entry<String, CourseDetails> entry : courseDetailsMap.entrySet()) {
            JPanel entryPanel = createLeaderboardEntry(entry.getKey(), entry.getValue());
            leaderboardPanel.add(entryPanel);
        }

        // Add components to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(leaderboardPanel), BorderLayout.CENTER);

        // Add main panel to the frame
        getContentPane().add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private JPanel createLeaderboardEntry(String courseName, CourseDetails details) {
        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.setBackground(Color.WHITE);
        entryPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Course name label
        JLabel nameLabel = new JLabel(courseName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        entryPanel.add(nameLabel, BorderLayout.WEST);

        // Gamification features panel
        JPanel gamificationPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        gamificationPanel.setBackground(Color.WHITE);

        // Progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(details.getCompletionPercentage());
        progressBar.setStringPainted(true);
        gamificationPanel.add(progressBar);

        // Badges (sample badges - replace with actual badges)
        JPanel badgesPanel = new JPanel();
        badgesPanel.setBackground(Color.WHITE);
        JLabel badgesLabel = new JLabel("Badges:");
        badgesPanel.add(badgesLabel);
        JLabel badge1 = new JLabel(new ImageIcon("badge1.png"));
        badgesPanel.add(badge1); // Add badge images
        JLabel badge2 = new JLabel(new ImageIcon("badge2.png"));
        badgesPanel.add(badge2);
        gamificationPanel.add(badgesPanel);

        // Quizzes completed label
        JLabel quizzesLabel = new JLabel("Quizzes completed: " + details.getQuizzesCompleted());
        gamificationPanel.add(quizzesLabel);

        entryPanel.add(gamificationPanel, BorderLayout.CENTER);

        return entryPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LeaderboardPage::new);
    }

    // Inner class to hold course details
    private static class CourseDetails {
        private int points;
        private int quizzesCompleted;
        private int completionPercentage;

        public CourseDetails(int points, int quizzesCompleted, int completionPercentage) {
            this.points = points;
            this.quizzesCompleted = quizzesCompleted;
            this.completionPercentage = completionPercentage;
        }

        public int getPoints() {
            return points;
        }

        public int getQuizzesCompleted() {
            return quizzesCompleted;
        }

        public int getCompletionPercentage() {
            return completionPercentage;
        }
    }
}
