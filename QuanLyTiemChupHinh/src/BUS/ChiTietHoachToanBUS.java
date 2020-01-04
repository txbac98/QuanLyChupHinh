/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoachToanDAO;
import java.util.ArrayList;
import DTO.ChiTietHoachToan;
import DTO.ThongBao;


/**
 *
 * @author 16520
 */
public class ChiTietHoachToanBUS {
    public static ArrayList<ChiTietHoachToan> LayDanhSachChiTietHoachToan(String MaBHT){
        return ChiTietHoachToanDAO.LayDanhSachCTHT(MaBHT);
    }
    
    
    public static String LayMaCTHTMoi(String MaBHT){
        ArrayList<ChiTietHoachToan> listCTHT = ChiTietHoachToanDAO.LayDanhSachCTHT(MaBHT);
        if (listCTHT==null) return MaBHT +"CT1";
        return MaBHT + "CT" + (listCTHT.size() +1);
    }
    
    public static ThongBao ThemChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.ThemCTBHT(ctht);
    }
    
    public static ThongBao SuaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.SuaCTBHT(ctht);
    }
    
    public static ThongBao XoaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.XoaCTBHT(ctht);
    }
}
