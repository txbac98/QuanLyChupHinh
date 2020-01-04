/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.PhieuThanhToan;
import DTO.ThongBao;
import DAO.PhieuThanhToanDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class PhieuThanhToanBUS {
    public static ArrayList<PhieuThanhToan> LayDanhSachPhieuThanhToan(){
        return PhieuThanhToanDAO.LayDanhSachPTT();
    }
    
    
    public static String TongDoanhThu(){
        double sum=0;
         ArrayList<PhieuThanhToan> listPC = LayDanhSachPhieuThanhToan();
        if (listPC==null) return "0";
        
        for (int i=0; i< listPC.size(); i++){
             try {  
            double giaTri = Double.parseDouble(listPC.get(i).SOTIEN); 
            sum+=giaTri;
            } catch(NumberFormatException e){  

            }  
        }
        return sum+"";
    }
    
    public static String TongDoanhThuTuDauThang(){
        double sum=0;
         ArrayList<PhieuThanhToan> listPC = LayDanhSachPhieuThanhToan();
        if (listPC==null) return "0";
        
        Date today = DateBUS.GetToDay();
        for (int i=0; i< listPC.size(); i++){
            if (DateBUS.GetDate(listPC.get(i).NGAYTAO).getMonth() == today.getMonth() )
            {
                try {  
            double giaTri = Double.parseDouble(listPC.get(i).SOTIEN); 
            sum+=giaTri;
            } catch(NumberFormatException e){  

            }  
            }
             
        }
        return sum+"";
    }
    
    public static PhieuThanhToan LayPTTTheoMa(String MaPTT){
        return PhieuThanhToanDAO.LayPTTTheoMa(MaPTT);
    }
    
    public static ThongBao ThemPTT(PhieuThanhToan ptt){
        return PhieuThanhToanDAO.ThemPTT(ptt);
    }
    
    public static ThongBao XoaPTT(PhieuThanhToan ptt){
        return PhieuThanhToanDAO.XoaPTT(ptt);
    }
    
    public static String LayMaMoi(){
        ArrayList<PhieuThanhToan> listPTT = LayDanhSachPhieuThanhToan();
        if (listPTT==null) return "PTT1";
        return "PTT" + (listPTT.size() +1);
    }
    
}
