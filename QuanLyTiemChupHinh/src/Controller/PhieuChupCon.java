/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiTietPhieuChupDao;
import DAO.PhieuChupDao;
import Model.ChiTietPhieuChup;
import java.util.ArrayList;
import Model.PhieuChup;
import Model.ThongBao;

/**
 *
 * @author 16520
 */
public class PhieuChupCon {
    public static ArrayList<PhieuChup> LayDanhSachPhieuChup(){
        return PhieuChupDao.LayDanhSachPhieuChup();
    }
    
    public static ThongBao ThemPhieuChup(PhieuChup phieuChup){
        return PhieuChupDao.ThemPhieuChup(phieuChup);
    }
    
    public static ThongBao SuaPhieuChup(PhieuChup phieuChup){
        return PhieuChupDao.SuaPhieuChup(phieuChup);
    }
    
    public static ThongBao XoaPhieuChup(PhieuChup phieuChup){
        return PhieuChupDao.XoaPhieuChup(phieuChup);
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChupTheoKhachHang(String MaKH){
        return PhieuChupDao.LayDanhSachPhieuChupTheoKhachHang(MaKH);
    }
    
    public static PhieuChup LayPhieuChupTheoMa(String MaPC){
        return PhieuChupDao.LayPhieuChupTheoMa(MaPC);
    }
    
    public static String LayMaPhieuChupMoi(String MaKH){
        ArrayList<PhieuChup> listPC = PhieuChupDao.LayDanhSachPhieuChup();
        if (listPC==null) return "PC1";
        return MaKH+ "PC" + (LayDanhSachPhieuChupTheoKhachHang(MaKH).size() + 1);
    }
    
    public static ThongBao SuaTrangThaiPhieuChup(String MaPC, String TrangThai){
        return PhieuChupDao.SuaTrangThaiPhieuChup(MaPC, TrangThai);
    }
    
    public static ArrayList<PhieuChup> LayDanhSachPhieuChupTheoMaPCvaMaKH(String MaPC, String MaKH){
        return PhieuChupDao.LayPhieuChupTheoMaPCvaMaKH(MaPC, MaKH);
    }
    
    public static ChiTietPhieuChup LayCTPC(String MaPC){
        return ChiTietPhieuChupDao.LayCTPC(MaPC);
    }
}
