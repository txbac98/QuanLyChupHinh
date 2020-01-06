/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.ThongBaoDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class TaiKhoanBUS {
    public static ThongBaoDTO KiemTraDangNhap(String MaNV, String MatKhau){
        return TaiKhoanDAO.KiemTraDangNhap(MaNV, MatKhau);
    }
    
    public static TaiKhoanDTO LayTaiKhoanTheoMa(String MaNV){
        return TaiKhoanDAO.LayTaiKhoanTheoMa(MaNV);
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTaiKhoan(){
        return TaiKhoanDAO.LayDanhSachTaiKhoan();
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTKTheoTen(String tenNV){
        return TaiKhoanDAO.LayDanhSachTKTheoTen(tenNV);
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTKTheoTenVaLoai(String tenNV, String loaiNV){
        return TaiKhoanDAO.LayDanhSachTKTheoTenVaLoai(tenNV, loaiNV);
    }
    
    public static ArrayList<TaiKhoanDTO> LayDanhSachTaiKhoanTheoLoai(String loaiNV){
        return TaiKhoanDAO.LayDanhSachTaiKhoanTheoLoai(loaiNV);
    }
    
    public static ThongBaoDTO ThemTaiKhoan(TaiKhoanDTO taiKhoan){
        return TaiKhoanDAO.ThemTaiKhoan(taiKhoan);
    }
    
    public static ThongBaoDTO SuaTaiKhoan(TaiKhoanDTO taiKhoan){
        return TaiKhoanDAO.SuaTaiKhoan(taiKhoan);
    }
    
    public static ThongBaoDTO DoiMatKhau(String MaNV, String mkCu, String mkMoi){
        return TaiKhoanDAO.DoiMatKhau(MaNV, mkCu, mkMoi);
    }
    
    public static ThongBaoDTO XoaTaiKhoan(TaiKhoanDTO taiKhoan){
        if (taiKhoan.MANV.equals("admin"))
            return new ThongBaoDTO(false, "Tài khoản này không thể xóa!!");
        return TaiKhoanDAO.XoaTaiKhoan(taiKhoan);
    }
}
