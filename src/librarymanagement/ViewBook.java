package librarymanagement;

import net.proteanit.sql.DbUtils;

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

import static librarymanagement.Database.statement;

public class ViewBook extends JFrame {


    private JPanel vPanel;
    private JTable booksTable;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField searchField;
    private JTextField book_nameField;
    private JTextField author_nameField;
    private JTextField book_typeField;
    private JTextField book_page_countField;
    private JTextField book_publishing_yearField;
    private JTextField book_publishing_houseField;
    private JTextField number_of_booksField;
    private JButton listButton;
    private JButton exitButton;
    private JButton searchButton;

    DefaultTableModel model;
    vBooks view=new vBooks();

    public ViewBook(){

        table_loadbooks();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        model=(DefaultTableModel)booksTable.getModel();

        setTitle("View Book Form");
        setSize(800,900);
        vPanel.setBackground(new Color(219,247,255));

        JPanel stick_left = new JPanel();
        stick_left.setSize(30, 900);
        stick_left.setBackground(new Color(148, 215, 225));
        stick_left.setLocation(0, 0);

        JPanel stick_right = new JPanel();
        stick_right.setSize(30, 900);
        stick_right.setBackground(new Color(148, 215, 225));
        stick_right.setLocation(755, 0);

        ImageIcon logo = new ImageIcon(ViewBook.class.getResource("viewbook.png"));
        JLabel iconLabel = new JLabel(logo);
        iconLabel.setSize(170, 170);
        iconLabel.setLocation(400, 5);


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
                BookList();
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
        add(vPanel);
        setResizable(false);
    }


    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String member_fname=searchField.getText();
        model.setRowCount(0);
        ArrayList<Books> books=new ArrayList<Books>();
        books=view.search(member_fname);
        if(books != null)
        {
            for(Books book : books)
            {
                Object adding[] = {book.getId(), book.getBook_name(),
                        book.getAuthor_name(), book.getType(),
                        book.getBook_page_count(), book.getBook_publishing_year(),
                        book.getBook_publishing_house(), book.getNumber_of_books()
                };
                model.addRow(adding);
            }
        }
    }

    public void table_loadbooks() {
        try {
            Baglan.statement= Baglan.con.createStatement();
            String query="Select * From books";
            ResultSet rs=statement.executeQuery(query);
            booksTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String book_name =book_nameField.getText();
        String author_name =author_nameField.getText();
        String type = book_typeField.getText();
        String book_page_count =book_page_countField.getText();
        String book_publishing_year = book_publishing_yearField.getText();
        String book_publishing_house = book_publishing_houseField.getText();
        String number_of_books=number_of_booksField.getText();

        int selectedRowArea =booksTable.getSelectedRow();
        if(selectedRowArea == -1)
        {
            if(model.getRowCount()==0)
            {
                String  message="Books table is null ";
                JOptionPane.showMessageDialog(this, message);

            }
            else {
                String  message="Please select Book. ";
                JOptionPane.showMessageDialog(this, message);

            }
        }
        else
        {
            int id=(int)model.getValueAt(selectedRowArea,0);
            view.updateBooks(id,book_name,author_name,type,book_page_count,book_publishing_year,book_publishing_house,number_of_books);
            String  message="Success ";
            JOptionPane.showMessageDialog(this, message);
        }

    }


    public void BookList() {

        model.setRowCount(0);
        ArrayList<Books> books = new ArrayList<Books>();
        books = view.fetch();
        if (books != null) {
            for (Books book : books) {
                Object adding[] = {book.getId(), book.getBook_name(),
                        book.getAuthor_name(), book.getType(),
                        book.getBook_page_count(), book.getBook_publishing_year(),
                        book.getBook_publishing_house(), book.getNumber_of_books()};
                model.addRow(adding);
            }
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                String message = "Books table is null. ";
                JOptionPane.showMessageDialog(this, message);

            } else {
                String message = "Please select book!. ";
                JOptionPane.showMessageDialog(this, message);
            }
        } else {
            int id = (int) model.getValueAt(selectedRow, 0);
            view.deleteBooks(id);
            String message = "Book successfully deleted. ";
            JOptionPane.showMessageDialog(this, message);
        }
    }


    public ArrayList<Books> search(String member_fname) {
        ArrayList<Books> r=new ArrayList<Books>();
        try {
            Baglan.statement= Baglan.con.createStatement();
            String query="Select * From books where book_name ='"+member_fname+"'";
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()){
                int id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                String author_name=rs.getString("author_name");
                String type=rs.getString("type");
                String book_page_count=rs.getString("book_page_count");
                String book_publishing_year=rs.getString("book_publishing_year");
                String book_publishing_house=rs.getString("book_publishing_house");
                String number_of_books=rs.getString("number_of_books");

                String  message= book_name;
                JOptionPane.showMessageDialog(null,message);
                r.add(new Books(id, book_name, author_name, type, book_page_count, book_publishing_year, book_publishing_house, number_of_books ));
            }
            if(r.isEmpty())
            {
                String  message="Books is not found. ";
                JOptionPane.showMessageDialog(null,message);
            }
            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


}
