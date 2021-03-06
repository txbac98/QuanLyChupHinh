/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import DTO.ThongBaoDTO;
import DTO.ChiTietPhieuChupDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 16520
 */
public class ChiTietPhieuChupDAO {
    public static ChiTietPhieuChupDTO LayCTPC(String MaPC){
        ChiTietPhieuChupDTO resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM CHITIETPHIEUCHUP WHERE MAPC = '%s'",MaPC));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new ChiTietPhieuChupDTO(rs.getString("MAPC"), 
                               rs.getString("SOANH"));

            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ThongBaoDTO XoaCTPC(ChiTietPhieuChupDTO ctpc){
        try
       {
       Connection con = DBConnection.createConnection(); //establishing connection
       Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
       statement.executeUpdate(String.format("DELETE FROM `CHITIETPHIEUCHUP` WHERE MAPC='%s'", ctpc.MAPC));
       return new ThongBaoDTO(true, "Xóa thành công ctpc "+ ctpc.MAPC);
       }
      catch(SQLException e)
       {
       e.printStackTrace();
       return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
       }
    }
    
    public static ThongBaoDTO LuuCTPC(ChiTietPhieuChupDTO ctpc){
        try
        {
        XoaCTPC(ctpc);    
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO CHITIETPHIEUCHUP VALUES ('%s','%s')",ctpc.MAPC,ctpc.SOANH));
        return new ThongBaoDTO(true,"Thêm thành công ctpc "+ ctpc.MAPC);

        }
       catch(SQLException e)
        {
            e.printStackTrace();
            return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
        } 
    }
}
