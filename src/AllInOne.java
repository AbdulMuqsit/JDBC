import java.sql.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AllInOne {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JAVA?characterEncoding=UTF-8","root","DBMS@123");
            System.out.println("Enter the operation you want to perform ");
            System.out.println("1.For creating the table ");
            System.out.println("2.For inserting the values ");
            System.out.println("3.For inserting Dynamic values ");
            System.out.println("4.For updating the values");
            System.out.println("5.For deleting the records ");
            System.out.println("7.For fetching the records ");
            Scanner value=new Scanner(System.in);
            int expression= value.nextInt();

            switch (expression){
                case 1:
                    System.out.println("You entered 1 i.e to create a new table");
                    createDB(con);
                    break;
                case 2:
                    System.out.println("You entered 2 ");
                                int result=insertData(con);
            if(result>0)
                System.out.println("Successfully inserted into  the table");
            else
                System.out.println("Failed to insert");
                break;
                case 3:
                    System.out.println("You entered 3 ");
                                int result1=bufferReader(con);
            if(result1>0)
                System.out.println("Successfully inserted into  the table");
            else
                System.out.println("Failed to insert");
                    break;
                case 4:
                    System.out.println("You enterd 4 ");
                    UpdateDB(con);
                    break;
                case 5:
                                int deleted=DeleteDB(con);
            if(deleted>0)
                System.out.println("Successfully deleted ");
            else System.out.println("Failed to delete ");
                    System.out.println("You entered 5 ");
                    break;
                case 7:
                    System.out.println("You selected option 7 ");
                    fetchData(con);
                    break;
                default:
                    System.out.println("Invalid number entered ");



            }
            //create a query



            con.close();
        }catch(Exception e){ System.out.println(e);}

    }


    public static void createDB(Connection con)
    {
        try{

            String q="create table ToShow(RollNo int,name varchar(30),Age int,Address varchar(30),PhoneNo int)";

            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
//
            System.out.println("Successfully created the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
        public static int insertData(Connection con){
        int inserted=0;
        try{
            String q="insert into ToShow(RollNo,name,Age,Address,PhoneNo) values (?,?,?,?,?) ";
            //get the PreparedStatement object
            PreparedStatement pstmt=con.prepareStatement(q);
            //set the values to query
            pstmt.setInt(1,3);
            pstmt.setString(2,"Min");
            pstmt.setInt(3,21);
            pstmt.setString(4,"Shopian");
            pstmt.setInt(5,7788256);


            inserted= pstmt.executeUpdate();


        }catch(Exception e){ System.out.println(e);}
        return inserted;
    }
        public static int bufferReader(Connection con){
        int inserted=0;

        try{

            //create a query
            String q="insert into ToShow(RollNo,name,Age,Address,PhoneNo) values (?,?,?,?,?) ";
            //get the PreparedStatement object
            PreparedStatement pstmt=con.prepareStatement(q);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter RollNo ");
            String Roll=br.readLine();
            int RollNo=Integer.parseInt(Roll);
            System.out.println("Enter name ");
            String name=br.readLine();
            System.out.println("Enter Age ");
            String age=br.readLine();
            int Age=Integer.parseInt(age);
            System.out.println("Enter address ");
            String address=br.readLine();
            System.out.println("Enter Phone No ");
            String pno=br.readLine();
            int PhoneNo=Integer.parseInt(pno);
            //set the values to query
            pstmt.setInt(1,RollNo);
            pstmt.setString(2,name);
            pstmt.setInt(3,Age);
            pstmt.setString(4,address);
            pstmt.setInt(5,PhoneNo);


        inserted=    pstmt.executeUpdate();
//            System.out.println("Successfully inserted into  the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return inserted;
    }
        public static  void UpdateDB(Connection con){
        try{
            String q="update ToShow set name=? where RollNo=?";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name ");
            String name= br.readLine();

            System.out.println("Enter student RollNo");
            int RollNo=Integer.parseInt(br.readLine());
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setInt(2,RollNo);
            pstmt.executeUpdate();
//
            System.out.println("Successfully updated the table");
            con.close();
        }catch(Exception e){ System.out.println(e);}


    }
    public  static int DeleteDB(Connection con)
    {
        int deleted=0;
        try{
            String q="delete from ToShow where RollNo=3";

            Statement stmt=con.createStatement();
            deleted=   stmt.executeUpdate(q);
//

            con.close();
        }catch(Exception e){ System.out.println(e);}

        return deleted;
    }
    public static void  fetchData(Connection con)
    {
        try{

//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from emp");
//            ResultSet rs=stmt.executeQuery("select 1");
            ResultSet rs=stmt.executeQuery("select * from ToShow");

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ " " + rs.getInt(3)+" "+ rs.getString(4)+" "+rs.getInt(5));
//                System.out.println("Hello");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
