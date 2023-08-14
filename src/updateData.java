import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class updateData {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            String q="update student set name=? where sid=?";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name ");
            String name= br.readLine();

            System.out.println("Enter student id");
            int sid=Integer.parseInt(br.readLine());
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setInt(2,sid);
            pstmt.executeUpdate();
//
            System.out.println("Successfully updated the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
