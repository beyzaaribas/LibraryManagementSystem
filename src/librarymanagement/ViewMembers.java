package librarymanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

import static librarymanagement.Database.statement;

public class ViewMembers extends JFrame implements ISearch<Members> {

    private JPanel mPanel;
    private JTable membersTable;
    private JTextField member_fullnameField;
    private JTextField member_phoneField;
    private JTextField member_emailField;
    private JTextArea member_addressField;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField searchField;
    private JButton listButton;
    private JButton exitButton;
    private JButton searchButton;

    DefaultTableModel model;
    vMembers view=new vMembers();


    public ViewMembers(){
        table_loadmembers();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        model=(DefaultTableModel)membersTable.getModel();

        setTitle("View Members Form");
        setSize(new Dimension(800,900));
        mPanel.setBackground(new Color(219,247,255));


        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 850);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(30, 850);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(755, 0);


        ImageIcon logo = new ImageIcon(ViewMembers.class.getResource("viewmembers.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(170, 170);
        iconLabel.setLocation(440, 5);


        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               MemberList();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



        add(iconLabel);
        add(stick_left);
        add(stick_right);
        add(mPanel);
        setResizable(false);

    }
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String member_fname=searchField.getText();
        model.setRowCount(0);
        ArrayList<Members> members=new ArrayList<Members>();
        members=view.search(member_fname);
        if(members != null)
        {
            for(Members member : members)
            {
                Object adding[] = {member.getId(), member.getMember_fullname(),
                        member.getMember_phone(), member.getMember_address(),
                        member.getMember_email(), member.getMember_gender()};
                model.addRow(adding);
            }
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = membersTable.getSelectedRow();
        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                String message = "Member table is null. ";
                JOptionPane.showMessageDialog(this, message);

            } else {
                String message = "Please select member!. ";
                JOptionPane.showMessageDialog(this, message);
            }
        } else {
            int id = (int) model.getValueAt(selectedRow, 0);
            view.deleteMember(id);
            String message = "member successfully deleted. ";
            JOptionPane.showMessageDialog(this, message);
        }
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String member_fullname =member_fullnameField.getText();
        String member_phone =member_phoneField.getText();
        String member_address = member_addressField.getText();
        String member_email =member_emailField.getText();

        int selectedRowArea =membersTable.getSelectedRow();
        if(selectedRowArea == -1)
        {
            if(model.getRowCount()==0)
            {
                String  message="Members table is null ";
                JOptionPane.showMessageDialog(this, message);

            }
            else {
                String  message="Please select member. ";
                JOptionPane.showMessageDialog(this, message);

            }
        }
        else
        {
            int id=(int)model.getValueAt(selectedRowArea,0);
            view.updateMember(id,member_fullname,member_phone,member_address,member_email);
            String  message="Success ";
            JOptionPane.showMessageDialog(this, message);
        }

    }

    public void MemberList() {

        model.setRowCount(0);
        ArrayList<Members> members = new ArrayList<Members>();
        members = view.fetch();
        if (members != null) {
            for (Members member : members) {
                Object adding[] = {member.getId(), member.getMember_fullname(),
                        member.getMember_phone(), member.getMember_address(),
                        member.getMember_email(), member.getMember_gender()};
                model.addRow(adding);
            }
        }
    }
    public void table_loadmembers() {
        try {
            Baglan.statement= Baglan.con.createStatement();
            String query="Select * From members";
            ResultSet rs=statement.executeQuery(query);
            membersTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Members> search(String member_fname) {
        ArrayList<Members> r=new ArrayList<Members>();
        try {
            Baglan.statement= Baglan.con.createStatement();
            String query="Select * From members where member_fullname ='"+member_fname+"'";
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                int id=rs.getInt("id");
                String member_fullname = rs.getString("member_fullname");
                String member_phone=rs.getString("member_phone");
                String member_address=rs.getString("member_address");
                String member_email=rs.getString("member_email");
                String member_gender=rs.getString("member_gender");

                String  message= member_fullname;
                JOptionPane.showMessageDialog(null,message);

                r.add(new Members(id, member_fullname, member_phone, member_address, member_email, member_gender));
            }
            if(r.isEmpty())
            {
                String  message="Member is not found. ";
                JOptionPane.showMessageDialog(null,message);
            }
            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
