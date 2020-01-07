/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.PhieuThanhToanDTO;
import DTO.ThongBaoDTO;
import DAO.PhieuThanhToanDAO;
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
    public static ArrayList<PhieuThanhToanDTO> LayDanhSachPhieuThanhToan(){
        return PhieuThanhToanDAO.LayDanhSachPTT();
    }
    
    public static void XuatPhieuThanhToan(PhieuThanhToanDTO ptt){
        String text= String.format(" Photography\n Mã PTT: %s\n Mã PC: %s\n Mã KH: %s\n Mã NV: %s\n Số ảnh: %s\n BHT: %s\n CTHT: %s\n CTUD: %s\n Ngày tạo: %s\n Số tiền: %s\n", ptt.MAPTT, ptt.MAPC, ptt.MAKH, ptt.MANV, ptt.SOANH, ptt.BHT, ptt.CTHT, ptt.CTUD, ptt.NGAYTAO, ptt.SOTIEN);
        String path = System.getProperty("user.dir")+"/Data/PhieuThanhToan/"+ptt.MAPTT+".pdf";
        PDFBUS.SavePDF(path, text);
    }

    private static ArrayList<PhieuThanhToanDTO> LayPTTTheoNgay(Date ngayBD, Date ngayKT){
        ArrayList<PhieuThanhToanDTO> listPTT = LayDanhSachPhieuThanhToan();
        
        if (listPTT== null) return null;
        ArrayList<PhieuThanhToanDTO> resuilt = new ArrayList<PhieuThanhToanDTO>();
        for (int i=0; i< listPTT.size(); i++){
            if (DateBUS.GetDate(listPTT.get(i).NGAYTAO).after(ngayBD)
                   && DateBUS.GetDate(listPTT.get(i).NGAYTAO).before(ngayKT))
            {
                resuilt.add(listPTT.get(i));
                continue;
            }
            if (DateBUS.GetDate(listPTT.get(i).NGAYTAO).equals(ngayBD)
                   && DateBUS.GetDate(listPTT.get(i).NGAYTAO).equals(ngayKT))
            {
                resuilt.add(listPTT.get(i));
                continue;
            }
        }
        return resuilt;
    }
    
    public static String TongDoanhThuTheoNgay(Date ngayBD, Date ngayKT){
        long sum=0;
         ArrayList<PhieuThanhToanDTO> listPTT = LayPTTTheoNgay(ngayBD, ngayKT);
         if (listPTT!=null){
             for (int i=0; i< listPTT.size(); i++){

                try {  
                       long soTien = Long.parseLong(listPTT.get(i).SOTIEN);
                       sum+=soTien;
                   } catch(NumberFormatException e){  

                   }  
             }
         }
         return sum+"";       
    }

    public static String TongDoanhThuTheoCTHT(Date ngayBD, Date ngayKT, String TenCTHT, String BHT){
        long sum=0;
         ArrayList<PhieuThanhToanDTO> listPTT = LayPTTTheoNgay(ngayBD, ngayKT);
         if (listPTT!=null){
             for (int i=0; i< listPTT.size(); i++){
                 if (listPTT.get(i).CTHT.contains(TenCTHT) && listPTT.get(i).BHT.contains(BHT)){
                     try {  
                            long soTien = Long.parseLong(listPTT.get(i).SOTIEN);
                            sum+=soTien;
                        } catch(NumberFormatException e){  

                        }  
                 }
             }
         }
         return sum+"";
    }
    
    public static Long TongDoanhThuTheoCTUD(Date ngayBD, Date ngayKT, String TenCTUD){
        long sum=0;
        ArrayList<PhieuThanhToanDTO> listPTT = LayPTTTheoNgay(ngayBD, ngayKT);
        if (listPTT!=null){
             for (int i=0; i< listPTT.size(); i++){
                 System.err.println("So tien PTT: "+listPTT.get(i).SOTIEN);
                 if (listPTT.get(i).CTUD.contains(TenCTUD)){
                     System.err.println("Có");
                     try {  
                            long soTien = Long.parseLong(listPTT.get(i).SOTIEN);                           
                            sum+=soTien;
                        } catch(NumberFormatException e){  

                        }  
                 }
             }
         }
         return sum;
    }
    
    
    public static String TongDoanhThu(){
        double sum=0;
         ArrayList<PhieuThanhToanDTO> listPTT = LayDanhSachPhieuThanhToan();
        if (listPTT==null) return "0";
        
        for (int i=0; i< listPTT.size(); i++){
             try {  
            double giaTri = Double.parseDouble(listPTT.get(i).SOTIEN); 
            sum+=giaTri;
            } catch(NumberFormatException e){  

            }  
        }
        return sum+"";
    }
    
    public static String TongDoanhThuTuDauThang(){
        double sum=0;
         ArrayList<PhieuThanhToanDTO> listPTT = LayDanhSachPhieuThanhToan();
        if (listPTT==null) return "0";
        
        Date today = DateBUS.GetToDay();
        for (int i=0; i< listPTT.size(); i++){
            if (DateBUS.GetDate(listPTT.get(i).NGAYTAO).getMonth() == today.getMonth() )
            {
                try {  
            double giaTri = Double.parseDouble(listPTT.get(i).SOTIEN); 
            sum+=giaTri;
            } catch(NumberFormatException e){  

            }  
            }
             
        }
        return sum+"";
    }
    
    public static PhieuThanhToanDTO LayPTTTheoMa(String MaPTT){
        return PhieuThanhToanDAO.LayPTTTheoMa(MaPTT);
    }
    
    public static ThongBaoDTO ThemPTT(PhieuThanhToanDTO ptt){
        return PhieuThanhToanDAO.ThemPTT(ptt);
    }
    
    public static ThongBaoDTO XoaPTT(PhieuThanhToanDTO ptt){
        return PhieuThanhToanDAO.XoaPTT(ptt);
    }
    
    public static String LayMaMoi(){              
        ArrayList<PhieuThanhToanDTO> listPTT = LayDanhSachPhieuThanhToan();
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
