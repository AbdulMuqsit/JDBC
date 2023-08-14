import java.sql.*;
class Main{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from emp");
//            ResultSet rs=stmt.executeQuery("select 1");
            int count=stmt.executeUpdate("insert into emp values(8,'Sa'),(9,'Ad')");
            System.out.println(count+"Rows affected");
            ResultSet rs=stmt.executeQuery("select * from emp");

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
//                System.out.println("Hello");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}