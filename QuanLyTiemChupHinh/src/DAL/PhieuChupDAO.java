/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import SERVICEDB.DBConnection;
import DTO.ThongBaoDTO;
import DTO.PhieuChupDTO;
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
    public static ThongBaoDTO ThemPhieuChup(PhieuChupDTO phieuChup){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO PHIEUCHUP VALUES ('%s','%s','%s','%s')",phieuChup.MAPC, phieuChup.MAKH, phieuChup.NGAYTAO, phieuChup.TRANGTHAI));
        return new ThongBaoDTO(true,"Thêm thành công phiếu chụp "+ phieuChup.MAPC);

        }
       catch(SQLException e)
        {
            e.printStackTrace();
            return new ThongBaoDTO(false,"Lỗi truy vấn CSDL");
        } 
    }
    
    public static ThongBaoDTO SuaPhieuChup(PhieuChupDTO phieuChup){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `PHIEUCHUP` SET `NGAYTAO`='%s',`TRANGTHAI`='%s' WHERE `MAPC`='%s'", phieuChup.NGAYTAO, phieuChup.TRANGTHAI, phieuChup.MAPC));
        return new ThongBaoDTO(true, "Cập nhật thành công phiếu chụp "+ phieuChup.MAPC);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
    
    public static ThongBaoDTO XoaPhieuChup(PhieuChupDTO phieuChup){
      try
       {
       Connection con = DBConnection.createConnection(); //establishing connection
       Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
       statement.executeUpdate(String.format("DELETE FROM `PHIEUCHUP` WHERE MAPC='%s'", phieuChup.MAPC));
       return new ThongBaoDTO(true, "Xóa thành công phiếu chụp "+ phieuChup.MAPC);
       }
      catch(SQLException e)
       {
       e.printStackTrace();
       return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
       }
    }
    
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChup(){
         ArrayList<PhieuChupDTO> resuilt = new ArrayList<PhieuChupDTO>();

        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUCHUP"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

       while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChupDTO phieuChup = new PhieuChupDTO(rs.getString("MAPC"), 
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
    
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChupTheoKhachHang(String MaKH){
        ArrayList<PhieuChupDTO> resuilt = new ArrayList<PhieuChupDTO>();
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUCHUP WHERE MAKH = '%s'",MaKH));

       while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChupDTO phieuChup = new PhieuChupDTO(rs.getString("MAPC"), 
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
    
    
    public static PhieuChupDTO LayPhieuChupTheoMa(String MaPC){
        PhieuChupDTO resuilt = null;
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery(String.format("SELECT * FROM PHIEUCHUP WHERE MAPC = '%s'",MaPC));

        while(rs.next()) // Until next row is present otherwise it return false
            {
               resuilt = new PhieuChupDTO(rs.getString("MAPC"), 
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
       
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChupTheoKHVaTT(String MaKH, String TrangThai){
        ArrayList<PhieuChupDTO> resuilt = new ArrayList<PhieuChupDTO>();
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet rs = statement.executeQuery("SELECT * FROM PHIEUCHUP WHERE MAKH LIKE '%"+MaKH+"%' AND TRANGTHAI LIKE '%"+ TrangThai + "%'");

        while(rs.next()) // Until next row is present otherwise it return false
        {
           PhieuChupDTO phieuChup = new PhieuChupDTO(rs.getString("MAPC"), 
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
    
    public static ThongBaoDTO SuaTrangThaiPhieuChup(String MaPC, String TrangThai){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("UPDATE `PHIEUCHUP` SET `TRANGTHAI`='%s' WHERE `MAPC`='%s'", TrangThai, MaPC));
        return new ThongBaoDTO(true, "Cập nhật thành công phiếu chụp "+ MaPC);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBaoDTO(false, "Lỗi truy vấn CSDL");
        }
    }
}
