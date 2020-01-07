/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import DTO.PhieuThanhToanDTO;
import DTO.ThongBaoDTO;
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
    public static ArrayList<PhieuThanhToanDTO> LayDanhSachPTT(){
        ArrayList<PhieuThanhToanDTO> resuilt = new ArrayList<PhieuThanhToanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); //establishing connection
         Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
         ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUTHANHTOAN"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

        while(rs.next()) // Until next row is present otherwise it return false
         {
            PhieuThanhToanDTO ptt = new PhieuThanhToanDTO(rs.getString("MAPTT"), 
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
    
    public static PhieuThanhToanDTO LayPTTTheoMa(String MaPTT){
        PhieuThanhToanDTO resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUTHANHTOAN WHERE MAPTT = '%s'",MaPTT));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new PhieuThanhToanDTO(rs.getString("MAPTT"), 
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
    
    public static ArrayList<PhieuThanhToanDTO> LayDanhSachPTTTheoKH(String MaKH){
        return null;
    }
    
    public static ArrayList<PhieuThanhToanDTO> LayDanhSachPTTTheoNgay(String date){
        return null;
    }
    
    public static ThongBaoDTO ThemPTT(PhieuThanhToanDTO ptt){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `phieuthanhtoan`(`MAPTT`, `MAPC`, `MAKH`, `MANV`, `SOANH`, `BHT`, `CTHT`, `CTUD`, `NGAYTAO`, `SOTIEN`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",ptt.MAPTT, ptt.MAPC, ptt.MAKH, ptt.MANV, ptt.SOANH, ptt.BHT, ptt.CTHT, ptt.CTUD, ptt.NGAYTAO, ptt.SOTIEN));
        return new ThongBaoDTO(true,"Thêm thành công phiếu thanh toán "+ ptt.MAPTT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
        }  
    }
    
    public static ThongBaoDTO XoaPTT(PhieuThanhToanDTO ptt){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `phieuthanhtoan` WHERE MAPTT ='%s'", ptt.MAPTT));
        return new ThongBaoDTO(true, "Xóa thành công PTT "+ ptt.MAPTT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
}
