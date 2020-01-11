/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import java.util.ArrayList;
import DTO.ChiTietHoachToanDTO;
import DTO.ThongBaoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 16520
 */
public class ChiTietHoachToanDAO {
    public static ArrayList<ChiTietHoachToanDTO> LayDanhSachCTHT(String MaBHT){
        ArrayList<ChiTietHoachToanDTO> resuilt = new ArrayList<ChiTietHoachToanDTO>();

        try
         {
         Connection con = DBConnection.createConnection(); //establishing connection
         Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
         ResultSet rs = statement.executeQuery("SELECT * FROM CHITIETHOACHTOAN WHERE MABHT='" + MaBHT + "'"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

        while(rs.next()) // Until next row is present otherwise it return false
         {
            ChiTietHoachToanDTO ctht = new ChiTietHoachToanDTO(rs.getString("MABHT"),
                            rs.getString("MACTHT"),
                            rs.getString("NOIDUNG"), 
                            rs.getString("GIA"));
            resuilt.add(ctht);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;
    }
    
    public static ThongBaoDTO ThemCTBHT(ChiTietHoachToanDTO ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `chitiethoachtoan`(`MACTHT`, `MABHT`, `NOIDUNG`, `GIA`) VALUES ('%s','%s','%s','%s')",ctht.MACTHT, ctht.MABHT, ctht.NOIDUNG, ctht.GIA));
        return new ThongBaoDTO(true,"Thêm thành công hoạch toán "+ ctht.MACTHT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
        }  
    }
    
    public static ThongBaoDTO SuaCTBHT(ChiTietHoachToanDTO ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `chitiethoachtoan` SET `MABHT`='%s',`NOIDUNG`='%s',`GIA`='%s' WHERE `MACTHT`='%s'", ctht.MABHT, ctht.NOIDUNG, ctht.GIA, ctht.MACTHT));
        return new ThongBaoDTO(true, "Cập nhật thành công hoạch toán "+ ctht.MACTHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO XoaCTBHT(ChiTietHoachToanDTO ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `chitiethoachtoan` WHERE MACTHT ='%s'", ctht.MACTHT));
        return new ThongBaoDTO(true, "Xóa thành công hoạch toán "+ ctht.MACTHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
    
    public static void XoaCTHTVoiMaBHT(String MaBHT){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `chitiethoachtoan` WHERE MABHT ='%s'", MaBHT));
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        }
    }
}
