/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

 import SERVICEDB.DBConnection;
 import DTO.KhachHangDTO;
import DTO.ThongBaoDTO;
import java.util.ArrayList;


 public class KhachHangDAO {
     
     public static KhachHangDTO LayKHTheoMa(String MaKH){
         KhachHangDTO resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM KHACHHANG WHERE MAKH = '%s'",MaKH));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new KhachHangDTO(rs.getString("MAKH"), 
                       rs.getString("TENKH"), 
                       rs.getString("NGAYSINH"), 
                       rs.getString("SDT"), 
                       rs.getString("EMAIL"));
            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
     }
     
 public static ThongBaoDTO ThemKhachHang(KhachHangDTO khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
    statement.executeUpdate(String.format("INSERT INTO KHACHHANG VALUES ('%s','%s','%s','%s','%s')",khachHang.MAKH, khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL));
    return new ThongBaoDTO(true,"Thêm thành công khách hàng "+ khachHang.MAKH);
    
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
    }  
 }
 
 
 public static ThongBaoDTO SuaKhachHang(KhachHangDTO khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    statement.executeUpdate(String.format("UPDATE `khachhang` SET `TENKH`='%s',`NGAYSINH`='%s',`SDT`='%s',`EMAIL`='%s' WHERE `MAKH`='%s'", khachHang.TENKH, khachHang.NGAYSINH, khachHang.SDT, khachHang.EMAIL,khachHang.MAKH));
    return new ThongBaoDTO(true, "Cập nhật thành công khách hàng "+ khachHang.MAKH);
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
    }
 }
 
 public static ThongBaoDTO XoaKhachHang(KhachHangDTO khachHang){
   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    statement.executeUpdate(String.format("DELETE FROM `khachhang` WHERE MAKH='%s'", khachHang.MAKH));
    return new ThongBaoDTO(true, "Xóa thành công khách hàng "+ khachHang.MAKH);
    }
   catch(SQLException e)
    {
    e.printStackTrace();
    return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
    }
 }
 
 public static ArrayList<KhachHangDTO> LayDanhSachKhachHang(String MaKH, String TenKH){
     ArrayList<KhachHangDTO> resuilt = new ArrayList<KhachHangDTO>();

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
       KhachHangDTO khachHang = new KhachHangDTO(rs.getString("MAKH"), 
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
 
 
 public static ArrayList<KhachHangDTO> LayDanhSachKhachHang(){
     
    ArrayList<KhachHangDTO> resuilt = new ArrayList<KhachHangDTO>();

   try
    {
    Connection con = DBConnection.createConnection(); //establishing connection
    Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
    ResultSet rs = statement.executeQuery("SELECT * FROM KHACHHANG"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

   while(rs.next()) // Until next row is present otherwise it return false
    {
       KhachHangDTO khachHang = new KhachHangDTO(rs.getString("MAKH"), 
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
 
