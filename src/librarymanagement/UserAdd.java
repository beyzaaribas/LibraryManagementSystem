package librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static librarymanagement.Baglan.con;
import static librarymanagement.Baglan.preparedStatement;
import static librarymanagement.Baglan.statement;


public class UserAdd extends JFrame  {



    private JPanel aPanel;
    private JLabel fullNameLabel;
    private JTextField member_fullnameField;
    private JTextField member_phoneField;
    private JTextField member_emailField;
    private JButton exitButton;
    private JButton addUserButton;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel genderLabel;
    private JLabel adressLabel;
    private JRadioButton female_RadioButton;
    private JTextArea member_addressField;
    private JRadioButton male_RadioButton;

    private JLabel registerLabel;
    private ButtonGroup member_gender_RadioButton= new ButtonGroup();

    vMembers view = new vMembers();


    public UserAdd() {

        male_RadioButton.setActionCommand("Erkek");
        female_RadioButton.setActionCommand("Kadın");
        member_gender_RadioButton.add(female_RadioButton);
        member_gender_RadioButton.add(male_RadioButton);



        setTitle("User Add Form");
        setSize(new Dimension(700, 850));
        aPanel.setBackground(new Color(219,247,255));

        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 850);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(100, 850);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(655, 0);


        ImageIcon logo = new ImageIcon(UserAdd.class.getResource("useradd.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(170, 170);
        iconLabel.setLocation(255, 30);





        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });



        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });


        add(stick_left);
        add(stick_right);
        add(iconLabel);
        add(aPanel);
        setResizable(false);


    }



    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String member_fullname =member_fullnameField.getText();
            String member_phone =member_phoneField.getText();
            String member_address =member_addressField.getText();
            String member_email =member_emailField.getText();
            String member_gender = "";
            if(female_RadioButton.isSelected())
            {
                member_gender ="Female";
            }
            if(male_RadioButton.isSelected())
            {
                member_gender="Male";
            }


            view.addMember(member_fullname,member_phone,member_address,member_email,member_gender);

            String  message="Success. ";
            JOptionPane.showMessageDialog(this, message);
            member_fullnameField.setText("");
            member_phoneField.setText("");
            member_emailField.setText("");
            member_addressField.setText("");
        } catch (Exception e) {
            String message="Please enter the field.";
            JOptionPane.showMessageDialog(null, message);
        }

    }//GEN-LAST:event_ekleActionPerformed



}
