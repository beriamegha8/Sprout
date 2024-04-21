import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("Sprout E-Learning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(51, 153, 255));
        JLabel headerLabel = new JLabel("Welcome to Sprout E-Learning");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Description panel
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(Color.WHITE);
        JTextArea descriptionText = new JTextArea("Sprout E-Learning provides a platform for interactive and engaging learning experiences. Join us to explore a wide range of courses and take your learning journey to the next level.");
        descriptionText.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        descriptionText.setBackground(Color.WHITE);
        descriptionText.setBorder(new EmptyBorder(10, 10, 10, 10));
        descriptionPanel.add(descriptionText, BorderLayout.CENTER);

        // Image panel
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout with center alignment
        imagePanel.setBackground(Color.WHITE);
        ImageIcon imageIcon = loadImageIcon("Image 1.jpg");  // Load image
        JLabel imageLabel = new JLabel(imageIcon);
// Set preferred size for the image label (e.g., 600x400)
        imageLabel.setPreferredSize(new Dimension(600, 400)); // Adjust the dimensions as needed
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the image
        imagePanel.add(imageLabel);


        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0)); // 1 row, 3 columns, horizontal gap of 10
        buttonPanel.setBackground(Color.WHITE);
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to sign up button
                JOptionPane.showMessageDialog(HomePage.this, "Sign Up button clicked!");
            }
        });
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login page
                LoginFrame loginPage = new LoginFrame();
                loginPage.setVisible(true);
            }
        });

        JButton browseCoursesButton = new JButton("Browse Courses");
        browseCoursesButton.setFont(new Font("Arial", Font.BOLD, 18));
        browseCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to browse courses button
                JOptionPane.showMessageDialog(HomePage.this, "Browse Courses button clicked!");
            }
        });
        buttonPanel.add(signUpButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(browseCoursesButton);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(descriptionPanel, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    // Load image icon from resources
    private ImageIcon loadImageIcon(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);
            if (inputStream != null) {
                return new ImageIcon(ImageIO.read(inputStream));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            }
        });
    }
}
