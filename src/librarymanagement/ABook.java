package librarymanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABook extends JFrame {
    private JPanel bPanel;
    private JTextField book_nameField;
    private JTextField author_nameField;
    private JTextField page_countField;
    private JTextField book_publishing_yearField;
    private JTextField book_publishing_houseField;
    private JTextField number_booksField;
    private JButton exitButton;
    private JButton addBooks;
    private JTextField book_typeField;

    vBooks view = new vBooks();


    public ABook(){
        setTitle("Add Book Form");
        setSize(700,850);
        bPanel.setBackground(new Color(219,247,255));


        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 850);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(100, 850);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(655, 0);


        ImageIcon logo = new ImageIcon(ABook.class.getResource("addbook.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(170, 170);
        iconLabel.setLocation(330, 45);

        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksButtonActionPerformed(evt);
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
        add(bPanel);
        setResizable(false);





    }


    private void addBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String book_name =book_nameField.getText();
            String author_name =author_nameField.getText();
            String type =book_typeField.getText();
            String book_page_count =page_countField.getText();
            String book_publishing_year =book_publishing_yearField.getText();
            String book_publishing_house =book_publishing_houseField.getText();
            String number_of_books = number_booksField.getText();



            view.addBooks(book_name,author_name,type,book_page_count,book_publishing_year,book_publishing_house,number_of_books);

            String  message="Success. ";
            JOptionPane.showMessageDialog(this, message);
            book_nameField.setText("");
            author_nameField.setText("");
            book_typeField.setText("");
            page_countField.setText("");
            book_publishing_yearField.setText("");
            book_publishing_houseField.setText("");
            number_booksField.setText("");
        } catch (Exception e) {
            String message="Please enter the field.";
            JOptionPane.showMessageDialog(null, message);
        }

    }


}
