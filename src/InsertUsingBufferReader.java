import java.sql.*;
import java.io.*;
public class InsertUsingBufferReader {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            //create a query
            String q="insert into student(name) values (?) ";
            //get the PreparedStatement object
            PreparedStatement pstmt=con.prepareStatement(q);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name ");
            String name=br.readLine();
            //set the values to query
            pstmt.setString(1,name);
            pstmt.executeUpdate();
            System.out.println("Successfully inserted into  the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
}
