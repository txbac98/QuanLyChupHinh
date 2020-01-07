/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DTO.KhachHangDTO;
import DAO.KhachHangDAO;
import DTO.ThongBaoDTO;

/**
 *
 * @author 16520
 */
public class KhachHangBUS {
    public static ArrayList<KhachHangDTO> LayDanhSachKhachHang(){
        return KhachHangDAO.LayDanhSachKhachHang();
    }
    
    public static KhachHangDTO LayKHTheoMa(String MaKH){
        return KhachHangDAO.LayKHTheoMa(MaKH);
    }
    
    
    
     public static String TongSoKH(){
        ArrayList<KhachHangDTO> listKH = LayDanhSachKhachHang();
        if (listKH==null) return "0";
        return listKH.size()+"";
    }
   
    public static ThongBaoDTO ThemKhachHang(KhachHangDTO khachHang){
        if (!KiemTraBUS.KiemTraChuaDauCach(khachHang.TENKH)){
            return new ThongBaoDTO(false, "Tên khách hàng không hợp lệ");
        }
        if (KiemTraBUS.KiemTraChuoiRong(khachHang.EMAIL)
                || KiemTraBUS.KiemTraChuoiRong(khachHang.TENKH)
                || KiemTraBUS.KiemTraChuoiRong(khachHang.SDT)){
            return new ThongBaoDTO(false, "Vui lòng nhập thông tin");
        }
        if (!KiemTraBUS.KiemTraSDT(khachHang.SDT)){
            return new ThongBaoDTO(false, "Số điện thoại gồm 10 ký tự số");
        }
        if (!KiemTraBUS.KiemTraEmail(khachHang.EMAIL)){
            return new ThongBaoDTO(false, "Email không hợp lệ");
        }
        return KhachHangDAO.ThemKhachHang(khachHang);
    }
    
    public static ThongBaoDTO SuaKhachHang(KhachHangDTO khachHang){
        return KhachHangDAO.SuaKhachHang(khachHang);
    }
    
    public static ThongBaoDTO XoaKhachHang(KhachHangDTO khachHang){
        return KhachHangDAO.XoaKhachHang(khachHang);
    }
    
    public static ArrayList<KhachHangDTO> LayDanhSachKhachHang(String MaKH, String TenKH){
        return KhachHangDAO.LayDanhSachKhachHang(MaKH, TenKH);
    }
    
    public static String LayMaKhachHangMoi(){
        ArrayList<KhachHangDTO> listKH = LayDanhSachKhachHang();
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
