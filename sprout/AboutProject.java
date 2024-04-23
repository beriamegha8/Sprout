package sprout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class AboutProject extends JFrame{
    JTextArea aboutText;
    JLabel title;
    public AboutProject() {
        super("About Project");
        setSize(540,380);
        setLocation(430,280);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("sprout/icons/systemIcon.png"));
        setIconImage(icon.getImage());
        Color oliveGreen = new Color(85, 107, 47);
        title = new JLabel("E-Learning System", JLabel.CENTER);
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setBackground(oliveGreen);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        Color lightOliveGreen = new Color(192, 208, 160);
        Font font = new Font(Font.SERIF, Font.PLAIN, 22);
        String txt = "*E-Learning System is a desktop-based Windows application "
                + "developed in Java with Swing and AWT. This project aims at serving Students and Teachers in "
                + "Online based learning. \n\n" +
                "*Admins can add subjects, Teachers can add courses in a particular subject and "
                + "Students can Enroll courses and study them, and also Students can message other participants in a "
                + "particular course except the Teacher teaching that course.";

        aboutText = new JTextArea(txt);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        //aboutText.setFont(new Font(Font.DIALOG, Font.ITALIC, 19));
        aboutText.setFont(font);
        aboutText.setForeground(Color.BLACK);
        aboutText.setBackground(lightOliveGreen);
        aboutText.setBorder(new LineBorder(Color.lightGray, 2, true));
        aboutText.setEditable(false);
        add(aboutText, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AboutProject();
    }
}
