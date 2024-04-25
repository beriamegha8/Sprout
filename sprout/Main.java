package sprout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {
    JPanel headerPanel, mainPanel, footerPanel;
    JButton LoginButton, SignupButton;
    JLabel title, footerLbl, mainScreenLbl, clock;
    JMenuBar menuBar;
    JMenu file, about;
    JMenuItem aboutProject, aboutDevelopers, exit;
    public static Main main;

    public Main() {
        super("E-Learning System");
        Font titleFont = new Font("Arial", Font.BOLD, 24); // Example: Arial font, bold, size 24
        setFont(titleFont);

        // Other frame settings
        setSize(1280, 720);
        //setLocation(35, 30);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.main = this;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("sprout/icons/systemIcon.png"));
        setIconImage(icon.getImage());

        headerPanel = new JPanel(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel, BorderLayout.CENTER);

        footerPanel = new JPanel(new BorderLayout());
        add(footerPanel, BorderLayout.SOUTH);

        //Header Code
        aboutProject = new JMenuItem("About Project");
        aboutDevelopers = new JMenuItem("About Developers");
        menuBar = new JMenuBar();
        about = new JMenu("About");
        exit = new JMenuItem("Exit");
        // Adding Shortcut key to close the window
        KeyStroke ctrlE = KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        exit.setAccelerator(ctrlE);
        file = new JMenu("File");
        file.add(exit);
        about.add(aboutProject);
        about.add(aboutDevelopers);
        exit.addActionListener(this);
        aboutDevelopers.addActionListener(this);
        aboutProject.addActionListener(this);
        menuBar.add(file);
        menuBar.add(about);
        headerPanel.add(menuBar, BorderLayout.NORTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sprout/icons/header.png"));
        Image i2 = i1.getImage().getScaledInstance(1280, 121, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        title = new JLabel(i3);
        headerPanel.add(title, BorderLayout.CENTER);

        //Main Center Code
        Color oliveGreen = new Color(85, 107, 47);

        LoginButton = new JButton("Login");
        LoginButton.setHorizontalAlignment(JButton.CENTER);
        LoginButton.setBounds(420, 15, 150, 70);
        LoginButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        LoginButton.setBackground(oliveGreen);
        LoginButton.setForeground(Color.white);
        LoginButton.setHorizontalTextPosition(JButton.CENTER);
        LoginButton.setVerticalTextPosition(JButton.BOTTOM);
        LoginButton.setForeground(oliveGreen);
        LoginButton.addActionListener(this);

        SignupButton = new JButton("SignUp");
        SignupButton.setHorizontalAlignment(JButton.CENTER);
        SignupButton.setBounds(715, 15, 150, 70);
        SignupButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        SignupButton.setBackground(oliveGreen);
        SignupButton.setForeground(Color.white);
        SignupButton.setHorizontalTextPosition(JButton.CENTER);
        SignupButton.setVerticalTextPosition(JButton.BOTTOM);
        SignupButton.setForeground(oliveGreen);
        SignupButton.addActionListener(this);

        ImageIcon mainPic1 = new ImageIcon(ClassLoader.getSystemResource("sprout/icons/logonew.png"));
        Image mainPic2 = mainPic1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon mainPic3 = new ImageIcon(mainPic2);
        mainScreenLbl = new JLabel(mainPic3);
        mainScreenLbl.setBounds(350, 50, 500, 500);

        // add to mainPanel
        mainPanel.add(LoginButton);
        mainPanel.add(SignupButton);
        mainPanel.add(mainScreenLbl);

        // Footer Panel Code
        JPanel footerColorPanel = new JPanel();
        footerColorPanel.setBackground(oliveGreen);
        footerColorPanel.setPreferredSize(new Dimension(1280, 100));

        footerPanel.add(footerColorPanel, BorderLayout.SOUTH);

        // Display clock in the footer
        clock = new JLabel();
        clock.setHorizontalAlignment(JLabel.RIGHT);
        DateFormat df = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        Calendar calobj = Calendar.getInstance();
        clock.setText(df.format(calobj.getTime()));
        clock.setFont(new Font(Font.SERIF, Font.BOLD, 19));
        clock.setForeground(new Color(14, 168, 29));
        footerPanel.add(clock, BorderLayout.NORTH);

        // A Swing timer fires one or more action events after a specified delay.
        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat df = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
                Calendar calobj = Calendar.getInstance();
                clock.setText(df.format(calobj.getTime()));
            }
        });
        t.setRepeats(true);
        t.setCoalesce(true);
        t.setInitialDelay(0);
        t.start();

        // Settings for the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == LoginButton) {
            new Login();
        } else if (ae.getSource() == SignupButton) {
            new Signup();
        } else if (ae.getSource() == aboutDevelopers) {
            new AboutDevelopers();
        } else if (ae.getSource() == aboutProject) {
            new AboutProject();
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}