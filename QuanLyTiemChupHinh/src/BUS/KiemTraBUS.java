/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ThongBao;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

/**
 *
 * @author 16520
 */
public class KiemTraBUS {
    public static Boolean KiemTraSDT(String sdt){
        try {  
            Long.parseLong(sdt);  
            if (sdt.length() !=10) return false;
            return true;
        } catch(NumberFormatException e){  
            return  false;
        }  
    }
    
    
    
    public static Boolean KiemTraEmail(String email){
        if (!email.contains("@") || !email.contains(".")){
            return false;
        }
        return true;
    }
    
    public static ThongBao KiemTraGiaTriUuDai(String sGiaTri){
        try {  
            Float giaTri = Float.parseFloat(sGiaTri); 
            if (giaTri<0) return new ThongBao(false, "Giá trị ưu đãi phải lớn hơn 0");
            if (giaTri>100) return new ThongBao(false, "Giá trị ưu đãi phải bé hơn 100");
            return new ThongBao(true,"Giá trị ưu đãi hợp lệ");
        } catch(NumberFormatException e){  
            return  new ThongBao(false,"Giá trị ưu đãi phải là số thực");
        }  
    }
    
    public static Boolean KiemTraChuoiRong(String str){
        if (str.length()==0) return true;
        return false;
    }
    
    public static Boolean KiemTraChuaDauCach(String str){
        if (str.contains(" ")) return true;
        return false;
    }
}
