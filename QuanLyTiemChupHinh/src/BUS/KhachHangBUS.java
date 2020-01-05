/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DTO.KhachHang;
import DAL.KhachHangDAO;
import DTO.ThongBao;

/**
 *
 * @author 16520
 */
public class KhachHangBUS {
    public static ArrayList<KhachHang> LayDanhSachKhachHang(){
        return KhachHangDAO.LayDanhSachKhachHang();
    }
    
    public static KhachHang LayKHTheoMa(String MaKH){
        return KhachHangDAO.LayKHTheoMa(MaKH);
    }
    
    
    
     public static String TongSoKH(){
        ArrayList<KhachHang> listKH = LayDanhSachKhachHang();
        if (listKH==null) return "0";
        return listKH.size()+"";
    }
   
    public static ThongBao ThemKhachHang(KhachHang khachHang){
        if (!KiemTraBUS.KiemTraChuaDauCach(khachHang.TENKH)){
            return new ThongBao(false, "Tên khách hàng không hợp lệ");
        }
        if (KiemTraBUS.KiemTraChuoiRong(khachHang.EMAIL)
                || KiemTraBUS.KiemTraChuoiRong(khachHang.TENKH)
                || KiemTraBUS.KiemTraChuoiRong(khachHang.SDT)){
            return new ThongBao(false, "Vui lòng nhập thông tin");
        }
        if (!KiemTraBUS.KiemTraSDT(khachHang.SDT)){
            return new ThongBao(false, "Số điện thoại gồm 10 ký tự số");
        }
        if (!KiemTraBUS.KiemTraEmail(khachHang.EMAIL)){
            return new ThongBao(false, "Email không hợp lệ");
        }
        return KhachHangDAO.ThemKhachHang(khachHang);
    }
    
    public static ThongBao SuaKhachHang(KhachHang khachHang){
        return KhachHangDAO.SuaKhachHang(khachHang);
    }
    
    public static ThongBao XoaKhachHang(KhachHang khachHang){
        return KhachHangDAO.XoaKhachHang(khachHang);
    }
    
    public static ArrayList<KhachHang> LayDanhSachKhachHang(String MaKH, String TenKH){
        return KhachHangDAO.LayDanhSachKhachHang(MaKH, TenKH);
    }
    
    public static String LayMaKhachHangMoi(){
        ArrayList<KhachHang> listKH = LayDanhSachKhachHang();
        if (listKH==null) return "KH1";
        if (listKH.size()==0) return "KH1";
        String maCuoi = listKH.get(listKH.size()-1).MAKH;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(2, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return "KH" + (index +1);
    }
}
