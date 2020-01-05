/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ChuongTrinhUuDaiDAO;
import static DAL.ChuongTrinhUuDaiDAO.LayDanhSachCTUD;
import java.util.ArrayList;
import DTO.ChuongTrinhUuDai;
import DTO.ThongBao;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class ChuongTrinhUuDaiBUS {
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUD(){
        return ChuongTrinhUuDaiDAO.LayDanhSachCTUD();
    }
    public static ThongBao ThemCTUD(ChuongTrinhUuDai ctud){
        if (KiemTraBUS.KiemTraChuoiRong(ctud.TENCTUD)
                || KiemTraBUS.KiemTraChuoiRong(ctud.GIATRIUUDAI)) 
            return new ThongBao(false, "Thông tin nhập không đầy đủ");
                     
        if (ctud.NGAYBATDAU.equals(ctud.NGAYKETTHUC) 
                || DateBUS.GetDate(ctud.NGAYKETTHUC).before(DateBUS.GetDate(ctud.NGAYBATDAU))){
            return new ThongBao(false, "Ngày KT phải sau ngày BD");
        }
        
        if (!KiemTraBUS.KiemTraGiaTriUuDai(ctud.GIATRIUUDAI)){
            return new ThongBao(false, "Giá trị ưu đãi không hợp lệ");
        }
            
        return ChuongTrinhUuDaiDAO.ThemCTUD(ctud);
    }
    
    public static ThongBao SuaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDAO.SuaCTUD(ctud);
    }
    
    public static ThongBao XoaCTUD(ChuongTrinhUuDai ctud){
        return ChuongTrinhUuDaiDAO.XoaCTUD(ctud);
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDDangApDung(){
        ArrayList<ChuongTrinhUuDai> resuilt =LayDanhSachCTUD();
        if (resuilt!=null){
                for (int i=0; i< resuilt.size(); i++){
                if (DateBUS.GetDate(resuilt.get(i).NGAYKETTHUC).before(DateBUS.GetToDay())){
                    resuilt.remove(i);
                };
                if (DateBUS.GetDate(resuilt.get(i).NGAYBATDAU).after(DateBUS.GetToDay())){
                    resuilt.remove(i);
                };
            }
        }      
        return resuilt;
    }
    
    public static ArrayList<ChuongTrinhUuDai> LayDanhSachCTUDTheoThoiGian(Date ngayTraCuuBD, Date ngayTraCuuKT){      
        if (ngayTraCuuBD==null || ngayTraCuuKT == null) return null;
     
        ArrayList<ChuongTrinhUuDai> resuilt =LayDanhSachCTUD();
        if (resuilt!=null){
                for (int i=0; i< resuilt.size(); i++){
                if (DateBUS.GetDate(resuilt.get(i).NGAYKETTHUC).before(ngayTraCuuBD)){
                    resuilt.remove(i);
                };
                if (DateBUS.GetDate(resuilt.get(i).NGAYBATDAU).after(ngayTraCuuKT)){
                    resuilt.remove(i);
                };
            }
        }
        
        return resuilt;
    }
    
    public static String LayMaCTUDMoi(){
         
        ArrayList<ChuongTrinhUuDai> listCTUD = LayDanhSachCTUD();
        if (listCTUD==null) return "UD1";
        if (listCTUD.size()==0) return "UD1";
        String maCuoi = listCTUD.get(listCTUD.size()-1).MACTUD;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(2, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return "UD" + (index +1);
    }
    
}
