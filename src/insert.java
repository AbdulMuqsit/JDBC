//use of prepared statement
import java.sql.*;
public class insert {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            //create a query
          int result=insertData(con);
          if(result>0)
          System.out.println("Successfully inserted into  the table");
          else
              System.out.println("Failed to insert");
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
    public static int insertData(Connection con){
        int inserted=0;
        try{
            String q="insert into student(name) values (?) ";
            //get the PreparedStatement object
            PreparedStatement pstmt=con.prepareStatement(q);
            //set the values to query
            pstmt.setString(1,"PQR");
           inserted= pstmt.executeUpdate();


        }catch(Exception e){ System.out.println(e);}
        return inserted;
    }
}
