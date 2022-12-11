package librarymanagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class IssueDate extends JFrame {
    private JPanel dPanel;
    private JTable loanTable;
    private JTextField idField;
    private JButton deliverButton;


    Connection con;
    PreparedStatement pst;


    public void Connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement", "root", "");
            System.out.println("Success");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public IssueDate(){
        Connect();
        issueTable_load();
        setTitle("Issue Date Form");
        setSize(800,900);
        dPanel.setBackground(new Color(219,247,255));




        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 900);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(30, 900);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(755, 0);


        ImageIcon logo = new ImageIcon(IssueDate.class.getResource("issuedate.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(170, 170);
        iconLabel.setLocation(500, 155);


        add(iconLabel);
        add(stick_left);
        add(stick_right);
        add(dPanel);
        setResizable(false);


        deliverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deliverId;
                deliverId = idField.getText();

                try {
                    pst = con.prepareStatement("delete from on_loan where id = ?");
                    pst.setString(1, deliverId);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Success");
                    issueTable_load();
                    idField.setText("");
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }
        });
    }


    public void issueTable_load() {
        try {
            pst = con.prepareStatement("select * from on_loan");
            ResultSet rs = pst.executeQuery();
            loanTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
