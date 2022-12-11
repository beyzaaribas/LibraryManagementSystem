package librarymanagement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame  {

    private JPanel menuPanel;
    private JLabel uaddLbl;
    private JLabel uviewLbl;
    private JLabel abookLbl;
    private JLabel vbookLbl;
    private JLabel ibookLbl;
    private JLabel dateLbl;


    public Menu() {

        setTitle("Menu");
        setSize(new Dimension(900, 750));
        menuPanel.setBackground(new Color(219, 247, 255));



        JButton uaddButton = new JButton();
        uaddButton.setBounds(50,125,150,150);
        uaddButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("useradd_icon.png"));
            uaddButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        uaddLbl.setBounds(100,275,125,50);

        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                // Perform some action when the button is clicked
                // In this case, redirect to another page in the form
                UserAdd uAddForm = new UserAdd();
                uAddForm.setVisible(true);

            }
        };
        uaddButton.addActionListener(action);

        // Add the action to the ActionMap for the button's component
        ActionMap actionMap = uaddButton.getActionMap();
        actionMap.put(action.getValue(Action.NAME), action);



        JButton uviewButton = new JButton();
        uviewButton.setBounds(50,400,150,150);
        uviewButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("viewmembers_icon.png"));
            uviewButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        uviewLbl.setBounds(75,550,125,50);


        uviewButton.addActionListener(e -> {
            ViewMembers viewMembers = new ViewMembers();
            viewMembers.setVisible(true);

        });



        JButton abookButton = new JButton();
        abookButton.setBounds(325,125,150,150);
        abookButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("addbook_icon.png"));
            abookButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        abookLbl.setBounds(370,275,125,50);
        abookButton.addActionListener(e -> {
            ABook aBook = new ABook();
            aBook.setVisible(true);
        });


        JButton vbookButton = new JButton();
        vbookButton.setBounds(325,400,150,150);
        vbookButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("viewbook_icon.png"));
            vbookButton.setIcon(new ImageIcon(img));
            //img.getScaledInstance(100,100,100);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        vbookLbl.setBounds(365,550,125,50);
        vbookButton.addActionListener(e -> {
            ViewBook viewBook = new ViewBook();
            viewBook.setVisible(true);
        });



        JButton ibookButton = new JButton();
        ibookButton.setBounds(600,125,150,150);
        ibookButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("issuebook_icon.png"));
            ibookButton.setIcon(new ImageIcon(img));
            //img.getScaledInstance(100,100,100);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        ibookLbl.setBounds(650,275,125,50);
        ibookButton.addActionListener(e -> {
            IssueBook issueBook = new IssueBook();
            issueBook.setVisible(true);
        });


        JButton dateButton = new JButton();
        dateButton.setBounds(600,400,150,150);
        dateButton.setBackground(new Color(219, 247, 255));
        try {
            Image img = ImageIO.read(getClass().getResource("issuedate_icon.png"));
            dateButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        dateLbl.setBounds(650,550,125,50);
        dateButton.addActionListener(e -> {
            IssueDate issueDate = new IssueDate();
            issueDate.setVisible(true);
        });



        ImageIcon logo = new ImageIcon(Menu.class.getResource("logo.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(155, 155);
        iconLabel.setLocation(725, 600);


        JPanel stick_left = new JPanel();
        stick_left.setSize(15, 750);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(15, 750);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(869, 0);



        add(uaddLbl);
        add(uviewLbl);
        add(ibookLbl);
        add(dateLbl);
        add(vbookLbl);
        add(abookLbl);
        add(stick_left);
        add(stick_right);
        add(dateButton);
        add(ibookButton);
        add(vbookButton);
        add(abookButton);
        add(uaddButton);
        add(uviewButton);
        add(iconLabel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(menuPanel);
    }

}
