/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuChupDAO;
import DAO.PhieuChupDAO;
import DTO.ChiTietPhieuChupDTO;
import java.util.ArrayList;
import DTO.PhieuChupDTO;
import DTO.ThongBaoDTO;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class PhieuChupBUS {
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChup(){
        return PhieuChupDAO.LayDanhSachPhieuChup();
    }
    
    public static String TongSoPC(){
        ArrayList<PhieuChupDTO> listPC = LayDanhSachPhieuChup();
        if (listPC==null) return "0";
        return listPC.size()+"";
    }
    
    public static String TongSoPCTuDauThang(){
        ArrayList<PhieuChupDTO> listPC = LayDanhSachPhieuChup();
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
    
    public static ThongBaoDTO ThemPhieuChup(PhieuChupDTO phieuChup){
        return PhieuChupDAO.ThemPhieuChup(phieuChup);
    }
    
    public static ThongBaoDTO SuaPhieuChup(PhieuChupDTO phieuChup){
        return PhieuChupDAO.SuaPhieuChup(phieuChup);
    }
    
    public static ThongBaoDTO XoaPhieuChup(PhieuChupDTO phieuChup){
        return PhieuChupDAO.XoaPhieuChup(phieuChup);
    }
    
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChupTheoKhachHang(String MaKH){
        return PhieuChupDAO.LayDanhSachPhieuChupTheoKhachHang(MaKH);
    }
    
    public static ArrayList<PhieuChupDTO> LayDanhSachPhieuChupTheoKHVaTT(String MaKH, String TrangThai){
        return PhieuChupDAO.LayDanhSachPhieuChupTheoKHVaTT(MaKH, TrangThai);
    }
    
    public static PhieuChupDTO LayPhieuChupTheoMa(String MaPC){
        return PhieuChupDAO.LayPhieuChupTheoMa(MaPC);
    }
        
    public static ThongBaoDTO SuaTrangThaiPhieuChup(String MaPC, String TrangThai){
        return PhieuChupDAO.SuaTrangThaiPhieuChup(MaPC, TrangThai);
    }
    
    public static ChiTietPhieuChupDTO LayCTPC(String MaPC){
        return ChiTietPhieuChupDAO.LayCTPC(MaPC);
    }
    
    public static String LayMaPhieuChupMoi(String MaKH){
        
        ArrayList<PhieuChupDTO> listPC = PhieuChupDAO.LayDanhSachPhieuChupTheoKhachHang(MaKH);
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
