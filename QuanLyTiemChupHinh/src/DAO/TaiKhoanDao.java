/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import DB.DBConnection;
import Model.TaiKhoan;

/**
 *
 * @author 16520
 */
public class TaiKhoanDao {
    public Boolean KiemTraDangNhap(TaiKhoan taiKhoan){
        String userName = taiKhoan.MANV; //Keeping user entered values in temporary variables.
        String password = taiKhoan.MATKHAU;

       Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

       String userNameDB = "";
        String passwordDB = "";

       try
        {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            resultSet = statement.executeQuery("select MANV,MATKHAU from TAIKHOAN"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

           while(resultSet.next()) // Until next row is present otherwise it return false
            {
             userNameDB = resultSet.getString("MANV"); //fetch the values present in database
             passwordDB = resultSet.getString("MATKHAU");

              if(taiKhoan.MANV.equals(userNameDB) && password.equals(passwordDB))
              {
                 return true; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
              }
           }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return false; // Just returning appropriate message otherwise
    }    
    
    public Boolean TaoTaiKhoan(TaiKhoan taiKhoan){
        return false;
    }
}
