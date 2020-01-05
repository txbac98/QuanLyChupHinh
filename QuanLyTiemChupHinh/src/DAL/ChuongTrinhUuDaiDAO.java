/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.DateBUS;
import SERVICEDB.DBConnection;
import DTO.ChuongTrinhUuDai;
import DTO.ThongBao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class ChuongTrinhUuDaiDAO {
     public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUD(){
        ArrayList<ChuongTrinhUuDai> resuilt = new ArrayList<ChuongTrinhUuDai>();

        try
         {
         Connection con = DBConnection.createConnection(); //establishing connection
         Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet rs = statement.executeQuery("SELECT * FROM CHUONGTRINHUUDAI"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

        while(rs.next()) // Until next row is present otherwise it return false
         {
           ChuongTrinhUuDai ctud = new ChuongTrinhUuDai(rs.getString("MACTUD"), 
                            rs.getString("MANV"),
                            rs.getString("TENCTUD"), 
                            rs.getString("NGAYBATDAU"), 
                            rs.getString("NGAYKETTHUC"), 
                            rs.getString("NOIDUNG"),
                            rs.getString("GIATRIUUDAI"));
            resuilt.add(ctud);
         }
         }
         catch(SQLException e)
         {
         e.printStackTrace();
         }
         return resuilt;
    }
    public static ThongBao ThemCTUD(ChuongTrinhUuDai ctud){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("INSERT INTO CHUONGTRINHUUDAI VALUES ('%s','%s','%s','%s','%s','%s','%s')",ctud.MACTUD, ctud.MANV, ctud.TENCTUD, ctud.NGAYBATDAU, ctud.NGAYKETTHUC, ctud.NOIDUNG, ctud.GIATRIUUDAI));
        return new ThongBao(true,"Thêm thành công CTUD "+ ctud.MACTUD);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false,"Không thể truy vấn CSDL");
        }  
    }
    
    public static ThongBao SuaCTUD(ChuongTrinhUuDai ctud){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.   
        statement.executeUpdate(String.format("UPDATE `chuongtrinhuudai` SET `MACTUD`='%s',`MANV`='%s',`TENCTUD`='%s',`NGAYBATDAU`='%s',`NGAYKETTHUC`='%s',`NOIDUNG`='%s',`GIATRIUUDAI`='%s' WHERE `MACTUD`='%s'",ctud.MACTUD, ctud.MANV, ctud.TENCTUD, ctud.NGAYBATDAU, ctud.NGAYKETTHUC, ctud.NOIDUNG, ctud.GIATRIUUDAI, ctud.MACTUD));
        return new ThongBao(true,"Sửa thành công CTUD "+ ctud.MACTUD);

        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false,"Không thể truy vấn CSDL");
        }  
    }
    
    public static ThongBao XoaCTUD(ChuongTrinhUuDai ctud){
        try
        {
        Connection con = DBConnection.createConnection(); //establishing connection
        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        statement.executeUpdate(String.format("DELETE FROM `chuongtrinhuudai` WHERE MACTUD='%s'", ctud.MACTUD));
        return new ThongBao(true, "Xóa thành công khách hàng "+ ctud.MACTUD);
        }
       catch(SQLException e)
        {
        e.printStackTrace();
        return new ThongBao(false, "Không thể truy vấn CSDL");
        }
    }

}
