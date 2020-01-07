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
import DTO.TaiKhoanDTO;
import DTO.ThongBaoDTO;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class TaiKhoanDAO {
    public static ThongBaoDTO KiemTraDangNhap(String MaNV, String MatKhau){
       String userNameDB = "";
        String passwordDB = "";
        String loaiNV ="";
       try
        {
            Connection  con = DBConnection.createConnection(); //establishing connection
            if (con==null) return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
            Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
            ResultSet resultSet = statement.executeQuery("select MANV,MATKHAU,LOAINV from TAIKHOAN"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

            
           while(resultSet.next()) // Until next row is present otherwise it return false
            {
             userNameDB = resultSet.getString("MANV"); //fetch the values present in database
             passwordDB = resultSet.getString("MATKHAU");
             loaiNV = resultSet.getString("LOAINV");
             
              if(MaNV.equals(userNameDB) && MatKhau.equals(passwordDB))
              {
                 return new ThongBaoDTO(true, "Truy cập bộ phận "+ loaiNV);///If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
              }
             
           }
           return new ThongBaoDTO(false, "Thông tin đăng nhập không chính xác");
        }
        catch(SQLException e)
        {
            
            e.printStackTrace();
            return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
       
    }    
    
    public static TaiKhoanDTO LayTaiKhoanTheoMa(String MaNV){
       TaiKhoanDTO resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM TAIKHOAN WHERE MANV = '%s'",MaNV));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new TaiKhoanDTO(rs.getString("MaNV"), 
                               rs.getString("TENNV"), 
                               rs.getString("MATKHAU"), 
                               rs.getString("LOAINV"));
            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTaiKhoan(){
        ArrayList<TaiKhoanDTO> resuilt = new ArrayList<TaiKhoanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM TAIKHOAN";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            TaiKhoanDTO taiKhoan = new TaiKhoanDTO(rs.getString("MANV"), 
                            rs.getString("TENNV"), 
                            rs.getString("MATKHAU"), 
                            rs.getString("LOAINV"));
            resuilt.add(taiKhoan);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;   
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTKTheoTen(String tenNV){
        ArrayList<TaiKhoanDTO> resuilt = new ArrayList<TaiKhoanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM TAIKHOAN WHERE TENNV LIKE '%"+tenNV+"%'";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            TaiKhoanDTO taiKhoan = new TaiKhoanDTO(rs.getString("MANV"), 
                            rs.getString("TENNV"), 
                            rs.getString("MATKHAU"), 
                            rs.getString("LOAINV"));
            resuilt.add(taiKhoan);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;  
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTKTheoTenVaLoai(String tenNV, String loaiNV){
        ArrayList<TaiKhoanDTO> resuilt = new ArrayList<TaiKhoanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM TAIKHOAN WHERE TENNV LIKE '%"+tenNV+"%' AND LOAINV='"+loaiNV+"'";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            TaiKhoanDTO taiKhoan = new TaiKhoanDTO(rs.getString("MANV"), 
                            rs.getString("TENNV"), 
                            rs.getString("MATKHAU"), 
                            rs.getString("LOAINV"));
            resuilt.add(taiKhoan);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;  
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTaiKhoanTheoLoai(String loaiNV){
        ArrayList<TaiKhoanDTO> resuilt = new ArrayList<TaiKhoanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM TAIKHOAN WHERE LOAINV='"+loaiNV+"'";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            TaiKhoanDTO taiKhoan = new TaiKhoanDTO(rs.getString("MANV"), 
                            rs.getString("TENNV"), 
                            rs.getString("MATKHAU"), 
                            rs.getString("LOAINV"));
            resuilt.add(taiKhoan);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;  
    }
    
    public static ThongBaoDTO ThemTaiKhoan(TaiKhoanDTO taiKhoan){
        if (LayTaiKhoanTheoMa(taiKhoan.MANV)!=null) return new ThongBaoDTO(false, "Tài khoản với mã NV này đã tồn tại");
         try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `taikhoan`(`MANV`, `TENNV`, `MATKHAU`, `LOAINV`) VALUES ('%s','%s','%s','%s')",taiKhoan.MANV, taiKhoan.TENNV, taiKhoan.MATKHAU, taiKhoan.LOAINV));
        return new ThongBaoDTO(true,"Thêm thành công tài khoản "+ taiKhoan.MANV);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Không thể truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO SuaTaiKhoan(TaiKhoanDTO taiKhoan){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("UPDATE `taikhoan` SET `TENNV`='%s',`MATKHAU`='%s',`LOAINV`='%s' WHERE `MANV`='%s'", taiKhoan.TENNV, taiKhoan.MATKHAU, taiKhoan.LOAINV, taiKhoan.MANV));
        return new ThongBaoDTO(true,"Sửa thành công tài khoản "+ taiKhoan.MANV);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Không thể truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO DoiMatKhau(String MaNV, String mkCu, String mkMoi){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("UPDATE `taikhoan` SET `MATKHAU`='%s' WHERE `MANV`='%s' AND `MATKHAU`='%s'", mkMoi, MaNV, mkCu));
        return new ThongBaoDTO(true,"Sửa thành công tài khoản "+ MaNV);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Không thể truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO XoaTaiKhoan(TaiKhoanDTO taiKhoan){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("DELETE FROM `taikhoan` WHERE MANV='%s'",taiKhoan.MANV));
        return new ThongBaoDTO(true,"Xóa thành công tài khoản "+ taiKhoan.MANV);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Không thể truy vấn CSDL");
        }
    }
}
