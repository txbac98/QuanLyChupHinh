/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import DTO.ThongBao;
import DTO.PhieuChup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class PhieuChupDAO {
    public static ThongBao ThemPhieuChup(PhieuChup phieuChup){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO PHIEUCHUP VALUES ('%s','%s','%s','%s')",phieuChup.MAPC, phieuChup.MAKH, phieuChup.NGAYTAO, phieuChup.TRANGTHAI));
        return new ThongBao(true,"Thêm thành công phiếu chụp "+ phieuChup.MAPC);

        }
       catch(SQLException e)
        {
            e.printStackTrace();
            return new ThongBao(false,"Không thể kết nối CSDL");
        } 
    }
    
    public static ThongBao SuaPhieuChup(PhieuChup phieuChup){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `PHIEUCHUP` SET `NGAYTAO`='%s',`TRANGTHAI`='%s' WHERE `MAPC`='%s'", phieuChup.NGAYTAO, phieuChup.TRANGTHAI, phieuChup.MAPC));
        return new ThongBao(true, "Cập nhật thành công phiếu chụp "+ phieuChup.MAPC);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
    
    public static ThongBao XoaPhieuChup(PhieuChup phieuChup){
      try
       {
       Connection con = DBConnection.createConnection(); //establishing connection
       Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
       statement.executeUpdate(String.format("DELETE FROM `PHIEUCHUP` WHERE MAPC='%s'", phieuChup.MAPC));
       return new ThongBao(true, "Xóa thành công phiếu chụp "+ phieuChup.MAPC);
       }
      catch(SQLException e)
       {
       e.printStackTrace();
       return new ThongBao(false, "Không thể kết nối CSDL");
       }
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChup(){
         ArrayList<PhieuChup> resuilt = new ArrayList<PhieuChup>();

        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUCHUP"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

       while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChup phieuChup = new PhieuChup(rs.getString("MAPC"), 
                           rs.getString("MAKH"), 
                           rs.getString("NGAYTAO"), 
                           rs.getString("TRANGTHAI"));
           resuilt.add(phieuChup);
        }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
        
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChupTheoKhachHang(String MaKH){
        ArrayList<PhieuChup> resuilt = new ArrayList<PhieuChup>();
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUCHUP WHERE MAKH = '%s'",MaKH));

       while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChup phieuChup = new PhieuChup(rs.getString("MAPC"), 
                           rs.getString("MAKH"), 
                           rs.getString("NGAYTAO"), 
                           rs.getString("TRANGTHAI"));
           resuilt.add(phieuChup);
        }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    
    public static PhieuChup LayPhieuChupTheoMa(String MaPC){
        PhieuChup resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUCHUP WHERE MAPC = '%s'",MaPC));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new PhieuChup(rs.getString("MAPC"), 
                               rs.getString("MAKH"), 
                               rs.getString("NGAYTAO"), 
                               rs.getString("TRANGTHAI"));

            }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ArrayList<PhieuChup> LayPhieuChupTheoMaPCvaMaKH(String MaPC, String MaKH){
        ArrayList<PhieuChup> resuilt = new ArrayList<PhieuChup>();
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUCHUP WHERE MAPC LIKE '%"+MaPC+"%' AND MAKH LIKE '%"+ MaKH + "%'");

        while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChup phieuChup = new PhieuChup(rs.getString("MAPC"), 
                           rs.getString("MAKH"), 
                           rs.getString("NGAYTAO"), 
                           rs.getString("TRANGTHAI"));
           resuilt.add(phieuChup);
        }
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return resuilt;
    }
    
    public static ThongBao SuaTrangThaiPhieuChup(String MaPC, String TrangThai){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `PHIEUCHUP` SET `TRANGTHAI`='%s' WHERE `MAPC`='%s'", TrangThai, MaPC));
        return new ThongBao(true, "Cập nhật thành công phiếu chụp "+ MaPC);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể kết nối CSDL");
        }
    }
}
