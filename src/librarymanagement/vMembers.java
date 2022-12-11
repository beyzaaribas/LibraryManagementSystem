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


public class vMembers extends AbstractFD<Members> implements ISearch<Members>{

    public ArrayList<Members> fetch(){
        ArrayList<Members> r=new ArrayList<Members>();
        try {
            Baglan.statement= Baglan.con.createStatement();
            String q="Select * From members";
            ResultSet rs=statement.executeQuery(q);

            while(rs.next()){
                int id=rs.getInt("id");
                String member_fullname=rs.getString("member_fullname");
                String member_phone=rs.getString("member_phone");
                String member_address=rs.getString("member_address");
                String member_email=rs.getString("member_email");
                String member_gender=rs.getString("member_gender");


                r.add(new Members(id, member_fullname, member_phone, member_address, member_email, member_gender));
            }

            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public void addMember(String member_fullname, String member_phone,String member_address,String member_email,String member_gender){
        String q="Insert Into members (member_fullname,member_phone,member_address,member_email,member_gender) VALUES (?,?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(q);
            preparedStatement.setString(1, member_fullname);
            preparedStatement.setString(2, member_phone);
            preparedStatement.setString(3, member_address);
            preparedStatement.setString(4, member_email);
            preparedStatement.setString(5, member_gender);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void updateMember(int id,String member_fullname, String member_phone,String member_address,String member_email){

        String query="Update members set member_fullname = ? , member_phone= ? , member_address = ? , member_email = ?  where id = ?";
        try {
            preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1, member_fullname);
            preparedStatement.setString(2, member_phone);
            preparedStatement.setString(3, member_address);
            preparedStatement.setString(4, member_email);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void deleteMember(int id){
        String query="Delete from members where id = ? ";

        try {
            preparedStatement=con.prepareCall(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    void deleteBooks(int id) {

    }

    public ArrayList<Members> search(String member_fname){
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


                r.add(new Members(id, member_fullname, member_phone, member_address, member_email, member_gender));
            }
            if(r.isEmpty())
            {
                String  message="Member is not found . ";
                JOptionPane.showMessageDialog(null,message);
            }
            return r;

        } catch (SQLException ex) {
            Logger.getLogger(Baglan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
