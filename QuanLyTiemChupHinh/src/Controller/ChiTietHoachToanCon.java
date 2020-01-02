/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiTietHoachToanDao;
import java.util.ArrayList;
import Model.ChiTietHoachToan;
import Model.ThongBao;


/**
 *
 * @author 16520
 */
public class ChiTietHoachToanCon {
    public static ArrayList<ChiTietHoachToan> LayDanhSachChiTietHoachToan(String MaBHT){
        return ChiTietHoachToanDao.LayDanhSachCTHT(MaBHT);
    }
    
    
    public static String LayMaCTHTMoi(String MaBHT){
        ArrayList<ChiTietHoachToan> listCTHT = ChiTietHoachToanDao.LayDanhSachCTHT(MaBHT);
        if (listCTHT==null) return MaBHT +"CT1";
        return MaBHT + "CT" + (listCTHT.size() +1);
    }
    
    public static ThongBao ThemChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDao.ThemCTBHT(ctht);
    }
    
    public static ThongBao SuaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDao.SuaCTBHT(ctht);
    }
    
    public static ThongBao XoaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDao.XoaCTBHT(ctht);
    }
}
