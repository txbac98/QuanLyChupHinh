package DB;

import java.sql.*;


public class DBConnection {
 public static Connection createConnection()
 {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/ql_chuphinh"; //MySQL URL and followed by the database name
    String username = "root"; //MySQL username
    String password = ""; //MySQL password
 
    try 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            if (conn!=null){
                System.out.println("Ket noi thanh cong");
            }
            else {
                System.out.println("Ket noi that bai");
            }
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }              
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    return conn; 
 }
}