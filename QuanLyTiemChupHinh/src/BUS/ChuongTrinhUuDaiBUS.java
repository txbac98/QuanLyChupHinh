/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhUuDaiDAO;
import java.util.ArrayList;
import DTO.ChuongTrinhUuDai;
import DTO.ThongBao;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class ChuongTrinhUuDaiBUS {
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUD(){
        return ChuongTrinhUuDaiDAO.LayDanhSachCTUD();
    }
    public static ThongBao ThemCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDAO.ThemCTUD(ctud);
    }
    
    public static ThongBao SuaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDAO.SuaCTUD(ctud);
    }
    
    public static ThongBao XoaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDAO.XoaCTUD(ctud);
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDDangApDung(){
        return ChuongTrinhUuDaiDAO.LayDanhSachCTUDDangApDung();
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDTheoThoiGian(Date ngayTraCuuBD, Date ngayTraCuuKT){      
        if (ngayTraCuuBD==null || ngayTraCuuKT == null) return null;
        return ChuongTrinhUuDaiDAO.LayDanhSachCTUDTheoThoiGian(ngayTraCuuBD, ngayTraCuuKT);
    }
    
    public static String LayMaCTUDMoi(){
        ArrayList<ChuongTrinhUuDai> listCTUD = LayDanhSachCTUD();
        if (listCTUD==null) return "UD1";
        return "UD" + (listCTUD.size() +1);
    }
    
}
