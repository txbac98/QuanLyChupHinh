/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import Model.ThongBao;
import Model.ChiTietPhieuChup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 16520
 */
public class ChiTietPhieuChupDao {
    public static ChiTietPhieuChup LayCTPC(String MaPC){
        ChiTietPhieuChup resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM CHITIETPHIEUCHUP WHERE MAPC = '%s'",MaPC));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new ChiTietPhieuChup(rs.getString("MAPC"), 
                               rs.getString("SOANH"));

            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ThongBao XoaCTPC(ChiTietPhieuChup ctpc){
        try
       {
       Connection con = DBConnection.createConnection(); //establishing connection
       Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
       statement.executeUpdate(String.format("DELETE FROM `CHITIETPHIEUCHUP` WHERE MAPC='%s'", ctpc.MAPC));
       return new ThongBao(true, "Xóa thành công ctpc "+ ctpc.MAPC);
       }
      catch(SQLException e)
       {
       e.printStackTrace();
       return new ThongBao(false, "Không thể kết nối CSDL");
       }
    }
    
    public static ThongBao LuuCTPC(ChiTietPhieuChup ctpc){
        try
        {
        XoaCTPC(ctpc);    
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO CHITIETPHIEUCHUP VALUES ('%s','%s')",ctpc.MAPC,ctpc.SOANH));
        return new ThongBao(true,"Thêm thành công ctpc "+ ctpc.MAPC);

        }
       catch(SQLException e)
        {
            e.printStackTrace();
            return new ThongBao(false,"Không thể kết nối CSDL");
        } 
    }
}
