/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.KhachHang;
import SERVICE.KhachHangDao;
import Model.ThongBao;

/**
 *
 * @author 16520
 */
public class KhachHangCon {
    public static ArrayList<KhachHang> LayDanhSachKhachHang(){
        return KhachHangDao.LayDanhSachKhachHang();
    }
    
   
    public static ThongBao ThemKhachHang(KhachHang khachHang){
        return KhachHangDao.ThemKhachHang(khachHang);
    }
    
    public static ThongBao SuaKhachHang(KhachHang khachHang){
        return KhachHangDao.SuaKhachHang(khachHang);
    }
    
    public static ThongBao XoaKhachHang(KhachHang khachHang){
        return KhachHangDao.XoaKhachHang(khachHang);
    }
    
    public static ArrayList<KhachHang> LayDanhSachKhachHang(String MaKH, String TenKH){
        return KhachHangDao.LayDanhSachKhachHang(MaKH, TenKH);
    }
    
    public static String LayMaKhachHangMoi(){
        ArrayList<KhachHang> listKH = KhachHangDao.LayDanhSachKhachHang();
        if (listKH==null) return "KH1";
        return "KH" + (listKH.size() +1);
    }
}
