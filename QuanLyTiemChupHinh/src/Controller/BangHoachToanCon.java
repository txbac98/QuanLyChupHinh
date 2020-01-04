/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SERVICE.BangHoachToanDao;
import java.util.ArrayList;
import Model.BangHoachToan;
import Model.ThongBao;

/**
 *
 * @author 16520
 */
public class BangHoachToanCon {
    
    public static ArrayList<BangHoachToan> LayDanhSachBHT(){
        return BangHoachToanDao.LayDanhSachBHT();
    }
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTCoHieuLuc(){
        return BangHoachToanDao.LayDanhSachBHTCoHieuLuc();
    }
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTTheoTenVaHieuLuc(String tenBHT, String hieuLuc){
        return BangHoachToanDao.LayDanhSachBHTTheoTenVaHieuLuc(tenBHT, hieuLuc);
    }
    
    public static ThongBao ThemBangHoachToan(BangHoachToan bht){
        return BangHoachToanDao.ThemBHT(bht);
    }
    
    public static ThongBao SuaBangHoachToan(BangHoachToan bht){
        return BangHoachToanDao.SuaBHT(bht);
    }
    
    public static ThongBao XoaBangHoachToan(BangHoachToan bht){
        return BangHoachToanDao.SuaBHT(bht);
    }
    
    public static String LayMaBHTMoi(){
        ArrayList<BangHoachToan> listBHT = BangHoachToanDao.LayDanhSachBHT();
        if (listBHT==null) return "BHT1";
        return "BHT" + (listBHT.size() +1);
    }
}
