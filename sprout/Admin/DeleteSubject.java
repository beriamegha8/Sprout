package sprout.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

import sprout.DBConnection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;

public class DeleteSubject extends JFrame implements ActionListener{
    JLabel title, subjectCbLbl;
    JComboBox subjectsCb, coursesCb;
    JButton deleteBtn;
    JPanel middlePanel;
    public DeleteSubject(){
        super("Delete Subject");
        setLayout(new BorderLayout());
        
        title = new JLabel("Delete Subject", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);
        
        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        add(middlePanel, BorderLayout.CENTER);
        
        subjectCbLbl = new JLabel("Select Subject");
        subjectCbLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        subjectCbLbl.setBounds(80, 30, 120, 28);
        subjectCbLbl.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(subjectCbLbl);

        String[] manual = this.getSubjects();
        subjectsCb = new JComboBox(manual);
        subjectsCb.setSelectedIndex(-1);
        subjectsCb.setBounds(200, 30, 140, 28);
        subjectsCb.addActionListener(this);
        subjectsCb.setForeground(Color.black);
        subjectsCb.setBackground(Color.white);
        middlePanel.add(subjectsCb);
        
        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        deleteBtn.setHorizontalAlignment(JButton.CENTER);
        deleteBtn.addActionListener(this);
        add(deleteBtn, BorderLayout.SOUTH);
        

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(500,200);
        setLocation(420,320);
        setVisible(true);
    }
    private String[] getSubjects() {
        String[] subjectsData = null;
        try {
            DBConnection c1 = new DBConnection();
            String q1 = "SELECT count(*) FROM Subjects";
            ResultSet cnt = c1.s.executeQuery(q1);
            cnt.next();
            int count = Integer.valueOf(cnt.getString(1));
            cnt.close();

            String q2 = "SELECT * FROM Subjects";
            ResultSet rs = c1.s.executeQuery(q2);
            
            
            System.out.println("Number of subjects retrieved from the database: " + count);
    
            subjectsData = new String[count];
            
            int i = 0;
            while (rs.next()) {
                subjectsData[i] = rs.getString("Name");
                i++;
            }
            System.out.println("Subjects retrieved from the database: " + Arrays.toString(subjectsData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjectsData;
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deleteBtn){
            Object selected = subjectsCb.getSelectedItem();
            String subjectName = selected.toString();
            int input = JOptionPane.showConfirmDialog(null, "Deleting Subject will delete all Corresponding Courses to this subject"
                    + ", do you want to proceed?", "Select an Option...",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(input == 0){
                DBConnection c1 = new DBConnection();
                try{
                    String q = "Delete From Subjects Where Name ='" + subjectName + "'";
                    int x = c1.s.executeUpdate(q);
                    if(x == 0){
                        JOptionPane.showMessageDialog(null, "Got some error");
                    }else{
                        JOptionPane.showMessageDialog(null, "Subject Deleted Successfully");
                        dispose();
                    }
            }catch(Exception e){
                e.printStackTrace();
                }
            finally{
                c1.Close();
                }
            }
        }
        }
        public static void main(String[] args) {
            new DeleteSubject();
        }

}
