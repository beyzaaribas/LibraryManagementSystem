package librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame implements ActionListener {

    private JPanel loginPanel;
    private JPanel contPanel;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JLabel UsernameLbl;
    private JLabel PasswordLbl;

    // username: btc
    // password: 1010

    public LoginForm() {

        setTitle("Library Management System");
        setSize(new Dimension(700, 800));
        loginPanel.setBackground(new Color(219, 247, 255));
        contPanel.setBackground(new Color(219, 247, 255));
        contPanel.setSize(new Dimension(700, 600));
        contPanel.setLocation(0, 200);

        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 800);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(30, 800);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(655, 0);


        ImageIcon logo = new ImageIcon(LoginForm.class.getResource("system_logo.png"));
        JLabel iconLabel = new JLabel(logo);

        iconLabel.setSize(326, 261);
        iconLabel.setLocation(174, 30);


        UsernameLbl.setBounds(155, 380, 80, 30);
        PasswordLbl.setBounds(155, 430, 80, 30);
        UsernameLbl.setForeground(new Color(4, 60, 93));
        PasswordLbl.setForeground(new Color(4, 60, 93));


        loginField.setBounds(240, 380, 250, 30);
        passwordField.setBounds(240, 430, 250, 30);


        JButton loginBtn = new JButton("Login");
        loginBtn.setSize(100, 30);
        loginBtn.setBackground(new Color(8, 89, 134));
        loginBtn.setLocation(390, 510);
        loginBtn.setForeground(Color.white);

        loginBtn.addActionListener(this);


        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(event -> {
            loginField.setText("");
            passwordField.setText("");
        });
        clearBtn.setSize(100, 30);
        clearBtn.setBackground(new Color(8, 89, 134));
        clearBtn.setLocation(240, 510);
        clearBtn.setForeground(Color.white);


        add(UsernameLbl);
        add(PasswordLbl);
        add(loginField);
        add(passwordField);
        add(clearBtn);
        add(loginBtn);
        setResizable(false);
        add(stick_left);
        add(stick_right);
        add(iconLabel);
        add(contPanel);
        add(loginPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = loginField.getText();        //get user entered username from the loginField
        String passValue = new String(passwordField.getPassword());        //get user entered password from the passwordField

        //check whether the credentials are authentic or not
        if (userValue.equals("btc") && passValue.equals("1010")) {  //if authentic, navigate user to a menu

            //create instance of the menu
            Menu menuForm = new Menu();

            //make page visible to the user
            menuForm.setVisible(true);

            //create a welcome label and set it to the new page
            JLabel messagebox = new JLabel("Welcome: " + userValue);
            menuForm.getContentPane().add(messagebox);
            dispose();
        } else {
            //show error message
            JOptionPane.showMessageDialog(LoginForm.this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
