/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhUuDaiDAO;
import static DAO.ChuongTrinhUuDaiDAO.LayDanhSachCTUD;
import java.util.ArrayList;
import DTO.ChuongTrinhUuDaiDTO;
import DTO.ThongBaoDTO;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class ChuongTrinhUuDaiBUS {
    public static ArrayList<ChuongTrinhUuDaiDTO> LayDanhSachCTUD(){
        return ChuongTrinhUuDaiDAO.LayDanhSachCTUD();
    }
    public static ThongBaoDTO ThemCTUD(ChuongTrinhUuDaiDTO ctud){
        if (KiemTraBUS.KiemTraChuoiRong(ctud.TENCTUD)
                || KiemTraBUS.KiemTraChuoiRong(ctud.GIATRIUUDAI)) 
            return new ThongBaoDTO(false, "Thông tin nhập không đầy đủ");
                     
        if (ctud.NGAYBATDAU.equals(ctud.NGAYKETTHUC) 
                || DateBUS.GetDate(ctud.NGAYKETTHUC).before(DateBUS.GetDate(ctud.NGAYBATDAU))){
            return new ThongBaoDTO(false, "Ngày KT phải sau ngày BD");
        }
        
        if (!KiemTraBUS.KiemTraGiaTriUuDai(ctud.GIATRIUUDAI)){
            return new ThongBaoDTO(false, "Giá trị ưu đãi không hợp lệ");
        }
            
        return ChuongTrinhUuDaiDAO.ThemCTUD(ctud);
    }
    
    public static ThongBaoDTO SuaCTUD(ChuongTrinhUuDaiDTO ctud){
        return ChuongTrinhUuDaiDAO.SuaCTUD(ctud);
    }
    
    public static ThongBaoDTO XoaCTUD(ChuongTrinhUuDaiDTO ctud){
        return ChuongTrinhUuDaiDAO.XoaCTUD(ctud);
    }
    
    public static ArrayList<ChuongTrinhUuDaiDTO> LayDanhSachCTUDDangApDung(){
        ArrayList<ChuongTrinhUuDaiDTO> resuilt =LayDanhSachCTUD();
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
    
    public static ArrayList<ChuongTrinhUuDaiDTO> LayDanhSachCTUDTheoThoiGian(Date ngayTraCuuBD, Date ngayTraCuuKT){      
        if (ngayTraCuuBD==null || ngayTraCuuKT == null) return null;
     
        ArrayList<ChuongTrinhUuDaiDTO> resuilt =LayDanhSachCTUD();
        if (resuilt!=null){
                for (int i=0; i< resuilt.size(); i++){
                if (DateBUS.GetDate(resuilt.get(i).NGAYKETTHUC).before(ngayTraCuuBD)){
                    resuilt.remove(i);
                }
                else if (DateBUS.GetDate(resuilt.get(i).NGAYBATDAU).after(ngayTraCuuKT)){
                    resuilt.remove(i);
                };
            }
        }
        
        return resuilt;
    }
    
    public static String LayMaCTUDMoi(){
         
        ArrayList<ChuongTrinhUuDaiDTO> listCTUD = LayDanhSachCTUD();
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
