/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import DTO.PhieuThanhToan;
import DTO.ThongBao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class PhieuThanhToanDAO {
    public static ArrayList<PhieuThanhToan> LayDanhSachPTT(){
        ArrayList<PhieuThanhToan> resuilt = new ArrayList<PhieuThanhToan>();

        try
         {
         Connection con = DBConnection.createConnection(); //establishing connection
         Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
         ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUTHANHTOAN"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

        while(rs.next()) // Until next row is present otherwise it return false
         {
            PhieuThanhToan ptt = new PhieuThanhToan(rs.getString("MAPTT"), 
                            rs.getString("MAPC"), 
                            rs.getString("MAKH"),
                            rs.getString("MANV"), 
                            rs.getString("SOANH"), 
                            rs.getString("BHT"), 
                            rs.getString("CTHT"), 
                            rs.getString("CTUD"),
                            rs.getString("NGAYTAO"),
                            rs.getString("SOTIEN"));
            resuilt.add(ptt);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;
    }
    
    public static PhieuThanhToan LayPTTTheoMa(String MaPTT){
        PhieuThanhToan resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUTHANHTOAN WHERE MAPTT = '%s'",MaPTT));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new PhieuThanhToan(rs.getString("MAPTT"), 
                               rs.getString("MAPC"), 
                            rs.getString("MAKH"),
                            rs.getString("MANV"), 
                            rs.getString("SOANH"), 
                            rs.getString("BHT"), 
                            rs.getString("CTHT"), 
                            rs.getString("CTUD"),
                            rs.getString("NGAYTAO"),
                            rs.getString("SOTIEN"));

            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ArrayList<PhieuThanhToan> LayDanhSachPTTTheoKH(String MaKH){
        return null;
    }
    
    public static ArrayList<PhieuThanhToan> LayDanhSachPTTTheoNgay(String date){
        return null;
    }
    
    public static ThongBao ThemPTT(PhieuThanhToan ptt){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `phieuthanhtoan`(`MAPTT`, `MAPC`, `MAKH`, `MANV`, `SOANH`, `BHT`, `CTHT`, `CTUD`, `NGAYTAO`, `SOTIEN`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",ptt.MAPTT, ptt.MAPC, ptt.MAKH, ptt.MANV, ptt.SOANH, ptt.BHT, ptt.CTHT, ptt.CTUD, ptt.NGAYTAO, ptt.SOTIEN));
        return new ThongBao(true,"Thêm thành công phiếu thanh toán "+ ptt.MAPTT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false,"Lỗi truy vấn CSDL");
        }  
    }
    
    public static ThongBao XoaPTT(PhieuThanhToan ptt){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `phieuthanhtoan` WHERE MAPTT ='%s'", ptt.MAPTT));
        return new ThongBao(true, "Xóa thành công PTT "+ ptt.MAPTT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Lỗi truy vấn CSDL");
        }
    }
}
