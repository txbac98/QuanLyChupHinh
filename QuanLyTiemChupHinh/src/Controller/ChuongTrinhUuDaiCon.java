/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChuongTrinhUuDaiDao;
import java.util.ArrayList;
import Model.ChuongTrinhUuDai;
import Model.ThongBao;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class ChuongTrinhUuDaiCon {
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUD(){
        return ChuongTrinhUuDaiDao.LayDanhSachCTUD();
    }
    public static ThongBao ThemCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDao.ThemCTUD(ctud);
    }
    
    public static ThongBao SuaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDao.SuaCTUD(ctud);
    }
    
    public static ThongBao XoaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDao.XoaCTUD(ctud);
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDDangApDung(){
        return ChuongTrinhUuDaiDao.LayDanhSachCTUDDangApDung();
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDTheoThoiGian(Date ngayTraCuuBD, Date ngayTraCuuKT){      
        if (ngayTraCuuBD==null || ngayTraCuuKT == null) return null;
        return ChuongTrinhUuDaiDao.LayDanhSachCTUDTheoThoiGian(ngayTraCuuBD, ngayTraCuuKT);
    }
    
    public static String LayMaCTUDMoi(){
        ArrayList<ChuongTrinhUuDai> listCTUD = LayDanhSachCTUD();
        if (listCTUD==null) return "UD1";
        return "UD" + (listCTUD.size() +1);
    }
    
}
