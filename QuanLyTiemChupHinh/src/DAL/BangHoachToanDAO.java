/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.BangHoachToanDTO;
import DTO.ThongBaoDTO;

/**
 *
 * @author 16520
 */
public class BangHoachToanDAO {
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHT(){
     ArrayList<BangHoachToanDTO> resuilt = new ArrayList<BangHoachToanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM BANGHOACHTOAN";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            BangHoachToanDTO bht = new BangHoachToanDTO(rs.getString("MABHT"), 
                            rs.getString("MANV"), 
                            rs.getString("TENBHT"), 
                            rs.getString("NGAYTAO"), 
                            rs.getString("HIEULUC"));
            resuilt.add(bht);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;   
    }
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHTCoHieuLuc(){
        ArrayList<BangHoachToanDTO> resuilt = new ArrayList<BangHoachToanDTO>();
        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM BANGHOACHTOAN WHERE HIEULUC='Có'";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            BangHoachToanDTO bht = new BangHoachToanDTO(rs.getString("MABHT"), 
                            rs.getString("MANV"), 
                            rs.getString("TENBHT"), 
                            rs.getString("NGAYTAO"), 
                            rs.getString("HIEULUC"));
            resuilt.add(bht);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt; 
    }
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHTTheoTenVaHieuLuc(String tenBHT, String hieuLuc){
        ArrayList<BangHoachToanDTO> resuilt = new ArrayList<BangHoachToanDTO>();
        try
         {
         Connection con = DBConnection.createConnection(); 
         Statement statement = con.createStatement();
         //String sql = String.format("SELECT * FROM KHACHHANG WHERE MAKH LIKE'%%s%' AND TENKH LIKE '%%s%'",MaKH,TenKH);
         //String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%%s%'";
         String sql ="SELECT * FROM BANGHOACHTOAN WHERE HIEULUC='"+hieuLuc+"' AND TENBHT LIKE '%"+tenBHT+"%'";
         ResultSet rs = statement.executeQuery(sql); 

        while(rs.next()) 
         {
            BangHoachToanDTO bht = new BangHoachToanDTO(rs.getString("MABHT"), 
                            rs.getString("MANV"), 
                            rs.getString("TENBHT"), 
                            rs.getString("NGAYTAO"), 
                            rs.getString("HIEULUC"));
            resuilt.add(bht);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt; 
    }
    
    public static ThongBaoDTO ThemBHT(BangHoachToanDTO bht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `banghoachtoan`(`MABHT`, `MANV`, `TENBHT`, `NGAYTAO`, `HIEULUC`) VALUES ('%s','%s','%s','%s','%s')",bht.MABHT, bht.MANV, bht.TENBHT, bht.NGAYTAO, bht.HIEULUC));
        return new ThongBaoDTO(true,"Thêm thành công BHT "+ bht.MABHT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
        }  
    }
    
    public static ThongBaoDTO SuaBHT(BangHoachToanDTO bht){
         try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `banghoachtoan` SET `MANV`='%s',`TENBHT`='%s',`NGAYTAO`='%s',`HIEULUC`='%s' WHERE MABHT='%s'", bht.MANV, bht.TENBHT, bht.NGAYTAO, bht.HIEULUC, bht.MABHT));
        return new ThongBaoDTO(true, "Cập nhật thành công BHT "+ bht.MABHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO XoaBHT(BangHoachToanDTO bht){        
 
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `banghoachtoan` WHERE MABHT ='%s'", bht.MABHT));
        return new ThongBaoDTO(true, "Xóa thành công BHT "+ bht.MABHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
}
