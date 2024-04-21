import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 250); // Initial size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set default font for all Swing components
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("PasswordField.font", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 16));

        // Create components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(this);

        // Create login panel with GridBagLayout
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        loginPanel.add(new JLabel("Login", SwingConstants.CENTER), gbc);

        gbc.gridy++;
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridy++;
        loginPanel.add(usernameField, gbc);
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        loginPanel.add(passwordField, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        loginPanel.add(new JLabel(), gbc); // Empty label for spacing
        gbc.gridx = 1;
        loginPanel.add(loginButton, gbc);

        // Add login panel to scroll pane
        JScrollPane scrollPane = new JScrollPane(loginPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add scroll pane to the center of the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String query = String.format("SELECT PASSWORD FROM LEARNER WHERE USERNAME = '%s' ",username);
            String db_user = "your_username" ;
            String db_password = "your_password";

            //jdbc connection
            try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprout",db_user,db_password)){

                Statement st = conn.createStatement();
                ResultSet resultSet = st.executeQuery(query);
               
                boolean logged = false;
                if(resultSet.next()){
                    String check_password = resultSet.getString(1);
                    if (check_password.equals(password)) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    logged = true;
                    // You can open a new window or perform other actions upon successful login
                    } 
                    
                 }

                 if(!logged) {
                    JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
                 }
             }
            catch(Exception x){
            x.printStackTrace();
            }


            // Perform authentication (replace this with your actual authentication logic)
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
