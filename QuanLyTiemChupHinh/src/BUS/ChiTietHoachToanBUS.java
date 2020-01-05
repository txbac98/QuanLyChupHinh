/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ChiTietHoachToanDAO;
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
    
    public static ThongBao ThemChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.ThemCTBHT(ctht);
    }
    
    public static ThongBao SuaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.SuaCTBHT(ctht);
    }
    
    public static ThongBao XoaChiTietHoachToan(ChiTietHoachToan ctht){
        return ChiTietHoachToanDAO.XoaCTBHT(ctht);
    }
    
     public static String LayMaCTHTMoi(String MaBHT){

        ArrayList<ChiTietHoachToan> listCTHT = LayDanhSachChiTietHoachToan(MaBHT);
        if (listCTHT==null) return MaBHT +"CT1";
        if (listCTHT.size()==0) return MaBHT + "CT1";
        String maCuoi = listCTHT.get(listCTHT.size()-1).MACTHT;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(MaBHT.length()+ 2, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return MaBHT + "CT" + (listCTHT.size() +1);
    }
}
