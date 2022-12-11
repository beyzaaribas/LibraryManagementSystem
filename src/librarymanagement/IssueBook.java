package librarymanagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class IssueBook extends JFrame {
    private JPanel iPanel;
    private JTable memberTable;
    private JTextField member_idField;
    private JTextField book_idField;
    private JTextField on_loanDateField;
    private JTable bookTable;
    private JButton issueButton;
   private DefaultTableModel model1;
   private DefaultTableModel model2;

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

    public  IssueBook(){

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        model1=(DefaultTableModel)bookTable.getModel();
        model2=(DefaultTableModel)memberTable.getModel();

        Connect();
        booktable_load();
        membertable_load();
        setTitle("Issue Book Form");
        setSize(800,900);
        iPanel.setBackground(new Color(219,247,255));


        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 900);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(30, 900);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(755, 0);


        ImageIcon logoo = new ImageIcon(IssueBook.class.getResource("issuebook.png"));
        JLabel iconLabel1 = new JLabel(logoo);
        iconLabel1.setSize(170, 170);
        iconLabel1.setLocation(250, 20);

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String on_loan_date, member_id, book_id;
                on_loan_date = on_loanDateField.getText();
                member_id = member_idField.getText();
                book_id = book_idField.getText();
                try {
                    pst = con.prepareStatement("insert into on_loan(on_loan_date,member_id,book_id)values(?,?,?)");
                    pst.setString(1, on_loan_date);
                    pst.setString(2, member_id);
                    pst.setString(3, book_id);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Issue Added!!!!");

                    on_loanDateField.setText("");
                    member_idField.setText("");
                    book_idField.setText("");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });


        add(iconLabel1);
        add(stick_left);
        add(stick_right);
        add(iPanel);
        setResizable(false);

    }

    public void booktable_load() {
        try {
            pst = con.prepareStatement("select * from books");
            ResultSet rs = pst.executeQuery();
            bookTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void membertable_load() {
        try {
            pst = con.prepareStatement("select * from members");
            ResultSet rs = pst.executeQuery();
            memberTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
