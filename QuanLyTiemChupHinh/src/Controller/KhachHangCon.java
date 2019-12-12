/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.KhachHang;
import DAO.KhachHangDao;

/**
 *
 * @author 16520
 */
public class KhachHangCon {
    public static ArrayList<KhachHang> LayDanhSachKhachHang(){
        return KhachHangDao.LayDanhSachKhachHang();
    }
    
    public static Boolean ThemKhachHang(KhachHang khachHang){
        return KhachHangDao.ThemKhachHang(khachHang);
    }
    
    public static Boolean SuaKhachHang(KhachHang khachHang){
        return KhachHangDao.SuaKhachHang(khachHang);
    }
    
    public static Boolean XoaKhachHang(KhachHang khachHang){
        return KhachHangDao.XoaKhachHang(khachHang);
    }
    
}
