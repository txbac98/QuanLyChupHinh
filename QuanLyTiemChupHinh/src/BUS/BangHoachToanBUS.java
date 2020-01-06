/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.BangHoachToanDAO;
import java.util.ArrayList;
import DTO.BangHoachToanDTO;
import DTO.ThongBaoDTO;

/**
 *
 * @author 16520
 */
public class BangHoachToanBUS {
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHT(){
        return BangHoachToanDAO.LayDanhSachBHT();
    }
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHTCoHieuLuc(){
        return BangHoachToanDAO.LayDanhSachBHTCoHieuLuc();
    }
    
    public static ArrayList<BangHoachToanDTO> LayDanhSachBHTTheoTenVaHieuLuc(String tenBHT, String hieuLuc){
        return BangHoachToanDAO.LayDanhSachBHTTheoTenVaHieuLuc(tenBHT, hieuLuc);
    }
    
    public static ThongBaoDTO ThemBangHoachToan(BangHoachToanDTO bht){
        return BangHoachToanDAO.ThemBHT(bht);
    }
    
    public static ThongBaoDTO SuaBangHoachToan(BangHoachToanDTO bht){
        return BangHoachToanDAO.SuaBHT(bht);
    }
    
    public static ThongBaoDTO XoaBangHoachToan(BangHoachToanDTO bht){       
        ThongBaoDTO tb = BangHoachToanDAO.XoaBHT(bht);
        if (tb.ThanhCong) ChiTietHoachToanBUS.XoaCTHTVoiMa(bht.MABHT);
        return tb;
    }
    
    public static String LayMaBHTMoi(){
        
        ArrayList<BangHoachToanDTO> listBHT = BangHoachToanDAO.LayDanhSachBHT();
        if (listBHT==null) return "BHT1";
        if (listBHT.size()==0) return "BHT1";
        String maCuoi = listBHT.get(listBHT.size()-1).MABHT;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(3, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return "BHT" + (index +1);
    }
}
