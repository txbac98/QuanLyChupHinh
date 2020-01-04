/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SERVICE.TaiKhoanDao;
import Model.ThongBao;
import Model.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class TaiKhoanCon {
    public static ThongBao KiemTraDangNhap(String MaNV, String MatKhau){
        return TaiKhoanDao.KiemTraDangNhap(MaNV, MatKhau);
    }
    
    public static TaiKhoan LayTaiKhoanTheoMa(String MaNV){
        return TaiKhoanDao.LayTaiKhoanTheoMa(MaNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTaiKhoan(){
        return TaiKhoanDao.LayDanhSachTaiKhoan();
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTKTheoTen(String tenNV){
        return TaiKhoanDao.LayDanhSachTKTheoTen(tenNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTKTheoTenVaLoai(String tenNV, String loaiNV){
        return TaiKhoanDao.LayDanhSachTKTheoTenVaLoai(tenNV, loaiNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTaiKhoanTheoLoai(String loaiNV){
        return TaiKhoanDao.LayDanhSachTaiKhoanTheoLoai(loaiNV);
    }
    
    public static ThongBao ThemTaiKhoan(TaiKhoan taiKhoan){
        return TaiKhoanDao.ThemTaiKhoan(taiKhoan);
    }
    
    public static ThongBao SuaTaiKhoan(TaiKhoan taiKhoan){
        return TaiKhoanDao.SuaTaiKhoan(taiKhoan);
    }
    
    public static ThongBao XoaTaiKhoan(TaiKhoan taiKhoan){
        if (taiKhoan.MANV.equals("admin"))
            return new ThongBao(false, "Tài khoản này không thể xóa!!");
        return null;
    }
}
