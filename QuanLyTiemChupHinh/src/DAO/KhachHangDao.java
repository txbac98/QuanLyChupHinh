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
 import Model.KhachHang;
import java.util.ArrayList;


 public class KhachHangDao {
 public static Boolean ThemKhachHang(KhachHang khachHang){
    Connection con = null;
    Statement statement = null;
    ResultSet rs = null;

   try
    {
    con = DBConnection.createConnection(); //establishing connection
    statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    int ex = statement.executeUpdate(String.format("INSERT INTO KHACHHANG VALUES ('%s','%s','%s','%s','%s')",khachHang.MAKH, khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL));
        if (ex==1) return true;
    
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    }
     return false;
 }
 
 
 public static Boolean SuaKhachHang(KhachHang khachHang){
     Connection con = null;
    Statement statement = null;
    ResultSet rs = null;

   try
    {
    con = DBConnection.createConnection(); //establishing connection
    statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    if (statement==null) return false;
    statement.executeUpdate(String.format("UPDATE `khachhang` SET `TENKH`='%s',`NGAYSINH`='%s',`SDT`='%s',`EMAIL`='%s' WHERE `MAKH`='%s'", khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL,khachHang.MAKH));
    return true;
    
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    }
     return false;
 }
 
 public static Boolean XoaKhachHang(KhachHang khachHang){
      Connection con = null;
    Statement statement = null;
    ResultSet rs = null;

   try
    {
    con = DBConnection.createConnection(); //establishing connection
    statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    if (statement==null) return false;
    statement.executeUpdate(String.format("DELETE FROM `khachhang` WHERE MAKH='%s'", khachHang.MAKH));
    return true;
    
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    }
     return false;
 }
 
 public static String LayMaMoi(){
     return null;
 }
 
 public static ArrayList<KhachHang> LayDanhSachKhachHang(){
     
    ArrayList<KhachHang> resuilt = new ArrayList<KhachHang>();
    Connection con = null;
    Statement statement = null;
    ResultSet rs = null;

   try
    {
    con = DBConnection.createConnection(); //establishing connection
    statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    rs = statement.executeQuery("SELECT * FROM KHACHHANG"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

   while(rs.next()) // Until next row is present otherwise it return false
    {
       KhachHang khachHang = new KhachHang(rs.getString("MAKH"), 
                       rs.getString("TENKH"), 
                       rs.getString("NGAYSINH"), 
                       rs.getString("SDT"), 
                       rs.getString("EMAIL"));
       resuilt.add(khachHang);
    }
    }
    catch(SQLException e)
    {
    e.printStackTrace();
    }
    return resuilt;
    }
 }
 
