/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PhieuThanhToan;
import Model.ThongBao;
import SERVICE.PhieuThanhToanDao;
import java.util.ArrayList;

/**
 *
 * @author 16520
 */
public class PhieuThanhToanCon {
    public static ArrayList<PhieuThanhToan> LayDanhSachPhieuThanhToan(){
        return PhieuThanhToanDao.LayDanhSachPTT();
    }
    
    public static PhieuThanhToan LayPTTTheoMa(String MaPTT){
        return PhieuThanhToanDao.LayPTTTheoMa(MaPTT);
    }
    
    public static ThongBao ThemPTT(PhieuThanhToan ptt){
        return PhieuThanhToanDao.ThemPTT(ptt);
    }
    
    public static ThongBao XoaPTT(PhieuThanhToan ptt){
        return PhieuThanhToanDao.XoaPTT(ptt);
    }
    
    public static String LayMaMoi(){
        ArrayList<PhieuThanhToan> listPTT = LayDanhSachPhieuThanhToan();
        if (listPTT==null) return "PTT1";
        return "PTT" + (listPTT.size() +1);
    }
    
}
