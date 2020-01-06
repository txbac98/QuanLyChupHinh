/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.PhieuThanhToan;
import DTO.ThongBao;
import DAL.PhieuThanhToanDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static void XuatPhieuThanhToan(PhieuThanhToan ptt){
        String text= String.format(" Photography\n Mã PTT: %s\n Mã PC: %s\n Mã KH: %s\n Mã NV: %s\n Số ảnh: %s\n BHT: %s\n CTHT: %s\n CTUD: %s\n Ngày tạo: %s\n Số tiền: %s\n", ptt.MAPTT, ptt.MAPC, ptt.MAKH, ptt.MANV, ptt.SOANH, ptt.BHT, ptt.CTHT, ptt.CTUD, ptt.NGAYTAO, ptt.SOTIEN);
        String path = System.getProperty("user.dir")+"/Data/PhieuThanhToan/"+ptt.MAPTT+".pdf";
        PDFBUS.SavePDF(path, text);
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
        if (listPTT.size()==0) return "PTT1";
        String maCuoi = listPTT.get(listPTT.size()-1).MAPTT;
        System.err.println(maCuoi);
        String soCuoi = maCuoi.substring(3, maCuoi.length());
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            
        }  
        return "PTT" + (index +1);
    }
    
    
}
