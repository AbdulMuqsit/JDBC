import java.sql.*;
import java.util.Scanner;
public class DynamicDelete {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            System.out.println("Enter the id to delete ");

            String q="delete from student where sid=1";

            Statement stmt=con.createStatement();
            int rows=   stmt.executeUpdate(q);
//
            if(rows>0)
                System.out.println("Successfully deleted the record");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
}
