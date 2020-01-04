/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.KhachHangCon.LayDanhSachKhachHang;
import static Controller.PhieuChupCon.LayDanhSachPhieuChup;
import static Controller.PhieuThanhToanCon.LayDanhSachPhieuThanhToan;
import Model.KhachHang;
import Model.PhieuChup;
import Model.PhieuThanhToan;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class TrangChuCon {
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
        
        Date today = DateCon.GetToDay();
        for (int i=0; i< listPC.size(); i++){
            if (DateCon.GetDate(listPC.get(i).NGAYTAO).getMonth() == today.getMonth() )
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
    
    public static String TongSoPC(){
        ArrayList<PhieuChup> listPC = LayDanhSachPhieuChup();
        if (listPC==null) return "0";
        return listPC.size()+"";
    }
    
    public static String TongSoPCTuDauThang(){
        ArrayList<PhieuChup> listPC = LayDanhSachPhieuChup();
        if (listPC==null) return "0";
        
        int num=0;
        Date today = DateCon.GetToDay();
        for (int i=0; i< listPC.size(); i++){
            if (DateCon.GetDate(listPC.get(i).NGAYTAO).getMonth() == today.getMonth()){
                num++;
            }
        }
        return num+"";
    }
    
     public static String TongSoKH(){
        ArrayList<KhachHang> listKH = LayDanhSachKhachHang();
        if (listKH==null) return "0";
        return listKH.size()+"";
    }

    
}
