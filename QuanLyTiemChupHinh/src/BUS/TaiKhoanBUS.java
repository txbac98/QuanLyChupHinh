/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.TaiKhoanDAO;
import DTO.ThongBao;
import DTO.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class TaiKhoanBUS {
    public static ThongBao KiemTraDangNhap(String MaNV, String MatKhau){
        return TaiKhoanDAO.KiemTraDangNhap(MaNV, MatKhau);
    }
    
    public static TaiKhoan LayTaiKhoanTheoMa(String MaNV){
        return TaiKhoanDAO.LayTaiKhoanTheoMa(MaNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTaiKhoan(){
        return TaiKhoanDAO.LayDanhSachTaiKhoan();
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTKTheoTen(String tenNV){
        return TaiKhoanDAO.LayDanhSachTKTheoTen(tenNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTKTheoTenVaLoai(String tenNV, String loaiNV){
        return TaiKhoanDAO.LayDanhSachTKTheoTenVaLoai(tenNV, loaiNV);
    }
    
    public static ArrayList<TaiKhoan> LayDanhSachTaiKhoanTheoLoai(String loaiNV){
        return TaiKhoanDAO.LayDanhSachTaiKhoanTheoLoai(loaiNV);
    }
    
    public static ThongBao ThemTaiKhoan(TaiKhoan taiKhoan){
        return TaiKhoanDAO.ThemTaiKhoan(taiKhoan);
    }
    
    public static ThongBao SuaTaiKhoan(TaiKhoan taiKhoan){
        return TaiKhoanDAO.SuaTaiKhoan(taiKhoan);
    }
    
    public static ThongBao DoiMatKhau(String MaNV, String mkCu, String mkMoi){
        return TaiKhoanDAO.DoiMatKhau(MaNV, mkCu, mkMoi);
    }
    
    public static ThongBao XoaTaiKhoan(TaiKhoan taiKhoan){
        if (taiKhoan.MANV.equals("admin"))
            return new ThongBao(false, "Tài khoản này không thể xóa!!");
        return TaiKhoanDAO.XoaTaiKhoan(taiKhoan);
    }
}
