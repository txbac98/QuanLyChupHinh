/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DTO.KhachHang;
import DAO.KhachHangDAO;
import DTO.ThongBao;

/**
 *
 * @author 16520
 */
public class KhachHangBUS {
    public static ArrayList<KhachHang> LayDanhSachKhachHang(){
        return KhachHangDAO.LayDanhSachKhachHang();
    }
    
     public static String TongSoKH(){
        ArrayList<KhachHang> listKH = LayDanhSachKhachHang();
        if (listKH==null) return "0";
        return listKH.size()+"";
    }
   
    public static ThongBao ThemKhachHang(KhachHang khachHang){
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
        ArrayList<KhachHang> listKH = KhachHangDAO.LayDanhSachKhachHang();
        if (listKH==null) return "KH1";
        return "KH" + (listKH.size() +1);
    }
}
