package hotel.management.system;


import java.sql.*;


public class conn {

    public Connection c;
    public Statement s;

    public conn()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///projecthms","root","password");
            s = c.createStatement();
            System.out.println("1....");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

