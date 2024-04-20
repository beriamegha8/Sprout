package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    public MainPage() {
        setTitle("E-Learning Platform");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600); // Set initial size
        setLocationRelativeTo(null); // Center the frame on the screen

        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(51, 153, 255)); // Set background color
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png")); // Set logo image
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        JButton homeButton = createNavButton("Home");
        JButton coursesButton = createNavButton("Courses");
        JButton profileButton = createNavButton("Profile");
        navPanel.add(homeButton);
        navPanel.add(coursesButton);
        navPanel.add(profileButton);
        headerPanel.add(navPanel, BorderLayout.EAST);

        // Featured course section
        JPanel featuredCoursePanel = new JPanel(new GridLayout(2, 3, 10, 10));
        featuredCoursePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        featuredCoursePanel.setBackground(Color.WHITE); // Set background color

        // Sample course cards (replace with dynamic data)
        for (int i = 1; i <= 6; i++) {
            featuredCoursePanel.add(createCourseCard("Course " + i, "Instructor Name", "Description", "course" + i + ".jpg"));
        }

        // Add components to main content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(featuredCoursePanel), BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(51, 153, 255));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        button.setFocusPainted(false); // Remove focus border
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle navigation action
                JOptionPane.showMessageDialog(MainPage.this, "Navigating to " + text);
            }
        });
        return button;
    }

    private JPanel createCourseCard(String title, String instructor, String description, String imagePath) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Add border
        cardPanel.setBackground(Color.WHITE); // Set background color

        // Image
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        cardPanel.add(imageLabel, BorderLayout.NORTH);

        // Course info
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel instructorLabel = new JLabel("Instructor: " + instructor);
        JLabel descriptionLabel = new JLabel("<html><p style='width:150px;'>" + description + "</p></html>"); // Wrap text
        infoPanel.add(instructorLabel, BorderLayout.CENTER);
        infoPanel.add(descriptionLabel, BorderLayout.SOUTH);
        cardPanel.add(infoPanel, BorderLayout.CENTER);

        // Enroll button
        JButton enrollButton = new JButton("Enroll");
        enrollButton.setFont(new Font("Arial", Font.PLAIN, 14));
        enrollButton.setBackground(new Color(51, 153, 255));
        enrollButton.setForeground(Color.WHITE);
        enrollButton.setFocusPainted(false);
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle enrollment action
                JOptionPane.showMessageDialog(MainPage.this, "Enrolling in " + title);
            }
        });
        cardPanel.add(enrollButton, BorderLayout.SOUTH);

        return cardPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPage::new);
    }
}
