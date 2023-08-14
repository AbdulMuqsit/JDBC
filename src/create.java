import java.sql.*;
public class create {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            String q="create table student(sid int primary key auto_increment,name varchar(30) not null)";

            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
//
                System.out.println("Successfully created the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
}
