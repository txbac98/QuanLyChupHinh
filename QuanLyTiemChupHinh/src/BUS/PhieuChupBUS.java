/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ChiTietPhieuChupDAO;
import DAL.PhieuChupDAO;
import DTO.ChiTietPhieuChup;
import java.util.ArrayList;
import DTO.PhieuChup;
import DTO.ThongBao;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class PhieuChupBUS {
    public static ArrayList<PhieuChup> LayDanhSachPhieuChup(){
        return PhieuChupDAO.LayDanhSachPhieuChup();
    }
    
    public static String TongSoPC(){
        ArrayList<PhieuChup> listPC = LayDanhSachPhieuChup();
        if (listPC==null) return "0";
        return listPC.size()+"";
    }
    
    public static String TongSoPCTuDauThang(){
        ArrayList<PhieuChup> listPC = LayDanhSachPhieuChup();
        if (listPC==null) return "0";
        
        int num=0;
        Date today = DateBUS.GetToDay();
        for (int i=0; i< listPC.size(); i++){
            if (DateBUS.GetDate(listPC.get(i).NGAYTAO).getMonth() == today.getMonth()){
                num++;
            }
        }
        return num+"";
    }
    
    public static ThongBao ThemPhieuChup(PhieuChup phieuChup){
        return PhieuChupDAO.ThemPhieuChup(phieuChup);
    }
    
    public static ThongBao SuaPhieuChup(PhieuChup phieuChup){
        return PhieuChupDAO.SuaPhieuChup(phieuChup);
    }
    
    public static ThongBao XoaPhieuChup(PhieuChup phieuChup){
        return PhieuChupDAO.XoaPhieuChup(phieuChup);
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChupTheoKhachHang(String MaKH){
        return PhieuChupDAO.LayDanhSachPhieuChupTheoKhachHang(MaKH);
    }
    
    public static PhieuChup LayPhieuChupTheoMa(String MaPC){
        return PhieuChupDAO.LayPhieuChupTheoMa(MaPC);
    }
        
    public static ThongBao SuaTrangThaiPhieuChup(String MaPC, String TrangThai){
        return PhieuChupDAO.SuaTrangThaiPhieuChup(MaPC, TrangThai);
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChupTheoMaPCvaMaKH(String MaPC, String MaKH){
        return PhieuChupDAO.LayPhieuChupTheoMaPCvaMaKH(MaPC, MaKH);
    }
    
    public static ChiTietPhieuChup LayCTPC(String MaPC){
        return ChiTietPhieuChupDAO.LayCTPC(MaPC);
    }
    
    public static String LayMaPhieuChupMoi(String MaKH){
        
        ArrayList<PhieuChup> listPC = PhieuChupDAO.LayDanhSachPhieuChup();
        if (listPC==null) return MaKH + "PC1";
        if (listPC.size()==0) return  MaKH + "PC1";
        String maCuoi = listPC.get(listPC.size()-1).MAPC;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(MaKH.length() + 2, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return MaKH + "PC" + (index +1);
    }
}
