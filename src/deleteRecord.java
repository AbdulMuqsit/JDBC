import java.sql.*;
public class deleteRecord {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            String q="delete from student where sid=2";

            Statement stmt=con.createStatement();
         int rows=   stmt.executeUpdate(q);
//
            if(rows>0)
            System.out.println("Successfully deleted the record");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
}
