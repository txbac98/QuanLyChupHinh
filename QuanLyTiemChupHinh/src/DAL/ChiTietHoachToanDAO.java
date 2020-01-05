/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import java.util.ArrayList;
import DTO.ChiTietHoachToan;
import DTO.ThongBao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 16520
 */
public class ChiTietHoachToanDAO {
    public static ArrayList<ChiTietHoachToan> LayDanhSachCTHT(String MaBHT){
        ArrayList<ChiTietHoachToan> resuilt = new ArrayList<ChiTietHoachToan>();

        try
         {
         Connection con = DBConnection.createConnection(); //establishing connection
         Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
         ResultSet rs = statement.executeQuery("SELECT * FROM CHITIETHOACHTOAN WHERE MABHT='" + MaBHT + "'"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

        while(rs.next()) // Until next row is present otherwise it return false
         {
            ChiTietHoachToan ctht = new ChiTietHoachToan(rs.getString("MABHT"),
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
    
    public static ThongBao ThemCTBHT(ChiTietHoachToan ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO `chitiethoachtoan`(`MACTHT`, `MABHT`, `NOIDUNG`, `GIA`) VALUES ('%s','%s','%s','%s')",ctht.MACTHT, ctht.MABHT, ctht.NOIDUNG, ctht.GIA));
        return new ThongBao(true,"Thêm thành công hoạch toán "+ ctht.MACTHT);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false,"Không thể kết nối CSDL");
        }  
    }
    
    public static ThongBao SuaCTBHT(ChiTietHoachToan ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `chitiethoachtoan` SET `MABHT`='%s',`NOIDUNG`='%s',`GIA`='%s' WHERE `MACTHT`='%s'", ctht.MABHT, ctht.NOIDUNG, ctht.GIA, ctht.MACTHT));
        return new ThongBao(true, "Cập nhật thành công hoạch toán "+ ctht.MACTHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
    
    public static ThongBao XoaCTBHT(ChiTietHoachToan ctht){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `chitiethoachtoan` WHERE MACTHT ='%s'", ctht.MACTHT));
        return new ThongBao(true, "Xóa thành công hoạch toán "+ ctht.MACTHT);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
    
}
