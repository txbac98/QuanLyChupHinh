/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import SERVICEDB.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.BangHoachToan;
import DTO.ThongBao;

/**
 *
 * @author 16520
 */
public class BangHoachToanDAO {
    
    public static ArrayList<BangHoachToan> LayDanhSachBHT(){
     ArrayList<BangHoachToan> resuilt = new ArrayList<BangHoachToan>();

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
            BangHoachToan bht = new BangHoachToan(rs.getString("MABHT"), 
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
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTCoHieuLuc(){
        ArrayList<BangHoachToan> resuilt = new ArrayList<BangHoachToan>();
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
            BangHoachToan bht = new BangHoachToan(rs.getString("MABHT"), 
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
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTTheoTenVaHieuLuc(String tenBHT, String hieuLuc){
        ArrayList<BangHoachToan> resuilt = new ArrayList<BangHoachToan>();
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
            BangHoachToan bht = new BangHoachToan(rs.getString("MABHT"), 
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
    
    public static ThongBao ThemBHT(BangHoachToan bht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `banghoachtoan`(`MABHT`, `MANV`, `TENBHT`, `NGAYTAO`, `HIEULUC`) VALUES ('%s','%s','%s','%s','%s')",bht.MABHT, bht.MANV, bht.TENBHT, bht.NGAYTAO, bht.HIEULUC));
        return new ThongBao(true,"Thêm thành công BHT "+ bht.MABHT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false,"Không thể kết nối CSDL");
        }  
    }
    
    public static ThongBao SuaBHT(BangHoachToan bht){
         try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `banghoachtoan` SET `MANV`='%s',`TENBHT`='%s',`NGAYTAO`='%s',`HIEULUC`='%s' WHERE MABHT='%s'", bht.MANV, bht.TENBHT, bht.NGAYTAO, bht.HIEULUC, bht.MABHT));
        return new ThongBao(true, "Cập nhật thành công BHT "+ bht.MABHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
    
    public static ThongBao XoaBHT(BangHoachToan bht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `banghoachtoan` WHERE MABHT ='%s'", bht.MABHT));
        return new ThongBao(true, "Xóa thành công BHT "+ bht.MABHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
}
