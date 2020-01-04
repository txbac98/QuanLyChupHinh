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

 import SERVICEDB.DBConnection;
 import DTO.KhachHang;
import DTO.ThongBao;
import java.util.ArrayList;


 public class KhachHangDAO {
 public static ThongBao ThemKhachHang(KhachHang khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
    statement.executeUpdate(String.format("INSERT INTO KHACHHANG VALUES ('%s','%s','%s','%s','%s')",khachHang.MAKH, khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL));
    return new ThongBao(true,"Thêm thành công khách hàng "+ khachHang.MAKH);
    
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBao(false,"Không thể kết nối CSDL");
    }  
 }
 
 
 public static ThongBao SuaKhachHang(KhachHang khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    statement.executeUpdate(String.format("UPDATE `khachhang` SET `TENKH`='%s',`NGAYSINH`='%s',`SDT`='%s',`EMAIL`='%s' WHERE `MAKH`='%s'", khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL,khachHang.MAKH));
    return new ThongBao(true, "Cập nhật thành công khách hàng "+ khachHang.MAKH);
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBao(false, "Không thể kết nối CSDL");
    }
 }
 
 public static ThongBao XoaKhachHang(KhachHang khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    statement.executeUpdate(String.format("DELETE FROM `khachhang` WHERE MAKH='%s'", khachHang.MAKH));
    return new ThongBao(true, "Xóa thành công khách hàng "+ khachHang.MAKH);
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBao(false, "Không thể kết nối CSDL");
    }
 }
 
 public static ArrayList<KhachHang> LayDanhSachKhachHang(String MaKH, String TenKH){
     ArrayList<KhachHang> resuilt = new ArrayList<KhachHang>();

   try
    {
    Connection con = DBConnection.createConnection(); 
    Statement statement = con.createStatement();
    //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
    //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
    String sql ="SELECT * FROM KHACHHANG WHERE MAKH LIKE '%"+MaKH + "%' AND TENKH LIKE '%"+ TenKH +"%'";
    ResultSet rs = statement.executeQuery(sql); 

   while(rs.next()) 
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
 
 
 public static ArrayList<KhachHang> LayDanhSachKhachHang(){
     
    ArrayList<KhachHang> resuilt = new ArrayList<KhachHang>();

   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    ResultSet rs = statement.executeQuery("SELECT * FROM KHACHHANG"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

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
 
