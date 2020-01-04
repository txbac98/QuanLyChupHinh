/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.BangHoachToanDAO;
import java.util.ArrayList;
import DTO.BangHoachToan;
import DTO.ThongBao;

/**
 *
 * @author 16520
 */
public class BangHoachToanBUS {
    
    public static ArrayList<BangHoachToan> LayDanhSachBHT(){
        return BangHoachToanDAO.LayDanhSachBHT();
    }
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTCoHieuLuc(){
        return BangHoachToanDAO.LayDanhSachBHTCoHieuLuc();
    }
    
    public static ArrayList<BangHoachToan> LayDanhSachBHTTheoTenVaHieuLuc(String tenBHT, String hieuLuc){
        return BangHoachToanDAO.LayDanhSachBHTTheoTenVaHieuLuc(tenBHT, hieuLuc);
    }
    
    public static ThongBao ThemBangHoachToan(BangHoachToan bht){
        return BangHoachToanDAO.ThemBHT(bht);
    }
    
    public static ThongBao SuaBangHoachToan(BangHoachToan bht){
        return BangHoachToanDAO.SuaBHT(bht);
    }
    
    public static ThongBao XoaBangHoachToan(BangHoachToan bht){
        return BangHoachToanDAO.SuaBHT(bht);
    }
    
    public static String LayMaBHTMoi(){
        ArrayList<BangHoachToan> listBHT = BangHoachToanDAO.LayDanhSachBHT();
        if (listBHT==null) return "BHT1";
        return "BHT" + (listBHT.size() +1);
    }
}
