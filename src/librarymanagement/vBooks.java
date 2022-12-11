package librarymanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static librarymanagement.Baglan.con;
import static librarymanagement.Baglan.preparedStatement;
import static librarymanagement.Baglan.statement;


public class vBooks extends AbstractFD <Books> {
    public ArrayList<Books> fetch(){
        ArrayList<Books> r=new ArrayList<Books>();
        try {
            Baglan.statement= Baglan.con.createStatement();
            String q="Select * From books";
            ResultSet rs=statement.executeQuery(q);

            while(rs.next()){
                int id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                String author_name=rs.getString("author_name");
                String type=rs.getString("type");
                String book_page_count=rs.getString("book_page_count");
                String book_publishing_year=rs.getString("book_publishing_year");
                String book_publishing_house=rs.getString("book_publishing_house");
                String number_of_books=rs.getString("number_of_books");


                r.add(new Books(id,book_name,author_name,type,book_page_count,book_publishing_year,book_publishing_house,number_of_books));
            }

            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    void deleteMember(int id) {

    }


    public void addBooks(String book_name, String author_name,String type,String book_page_count,String book_publishing_year, String book_publishing_house, String number_of_books){
        String q="Insert Into books (book_name,author_name,type,book_page_count,book_publishing_year,book_publishing_house,number_of_books) VALUES (?,?,?,?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(q);
            preparedStatement.setString(1, book_name);
            preparedStatement.setString(2, author_name);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, book_page_count);
            preparedStatement.setString(5, book_publishing_house);
            preparedStatement.setString(6, book_publishing_year);
            preparedStatement.setString(7, number_of_books);
            preparedStatement.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void updateBooks(int id,String book_name, String author_name,String type,String book_page_count,String book_publishing_house, String book_publishing_year, String number_of_books){

        String query="Update books set book_name = ? , author_name= ? , type = ? , book_page_count = ? , book_publishing_house = ? , book_publishing_year = ? , number_of_books = ?  where id = ?";
        try {
            preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1, book_name);
            preparedStatement.setString(2, author_name);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, book_page_count);
            preparedStatement.setString(5, book_publishing_house);
            preparedStatement.setString(6, book_publishing_year);
            preparedStatement.setString(7, number_of_books);
            preparedStatement.setInt(8, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    void deleteBooks(int id) {
        String query="Delete from books where id = ? ";

        try {
            preparedStatement=con.prepareCall(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




    public ArrayList<Books> search(String member_fname){
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


                r.add(new Books(id, book_name, author_name, type, book_page_count, book_publishing_year, book_publishing_house, number_of_books ));
            }
            if(r.isEmpty())
            {
                String  message="Book is not found . ";
                JOptionPane.showMessageDialog(null,message);
            }
            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


}
