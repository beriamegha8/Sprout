package sprout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class AboutDevelopers extends JFrame{
    JTable groupMembers;
    JPanel tablePanel;
    JLabel title;
    public AboutDevelopers() {
        super("About Developers");
        setSize(620,380);
        setLocation(430,280);
        setLayout(new BorderLayout());

        //ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("sprout/icons/systemIcon.png"));
        //setIconImage(icon.getImage());
        Color oliveGreen = new Color(85, 107, 47);

        title = new JLabel("Group Members", JLabel.CENTER);
        title.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        title.setBackground(oliveGreen);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        String[][] rowData = {{"22070122117", "Megha Beria", "<html>Frontend<br/> and Database Connectivity<html>"},
                {"22070122116", "Maryam Bahlooli", "<html>Frontend</html>"},
                {"22070122126", "Moksh Oswal", "<html>Database Connectivity<br/> and Report</html>"},
                {"22070122144", "Piyush Pareek", "<html>Report</html>"}};
        String columns[] = {"PRN", "Name", "Contributions"};

        tablePanel = new JPanel(new BorderLayout());
        add(tablePanel, BorderLayout.CENTER);

        JTable table = new JTable(rowData, columns);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.LIGHT_GRAY);
        table.setRowHeight(60);
        table.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(10);
        colModel.getColumn(1).setPreferredWidth(110);
        colModel.getColumn(2).setPreferredWidth(90);
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AboutDevelopers();
    }
}
