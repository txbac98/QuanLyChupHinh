/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 16520
 */
public class DateBUS {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static String GetDateString(JDateChooser dateChooser){       
        if (dateChooser.getDate()==null) return null;
        return sdf.format(dateChooser.getDate());
    }
    
    public static String GetDateString(Date date){
        return sdf.format(date);
    }
    
    public static Date GetDate(String dateString){
        try{
            return sdf.parse(dateString); 
        }
        catch (ParseException e) { 
            return null;
        }
    }
    
    public static Date GetToDay(){
        long millis=System.currentTimeMillis();  
        return new Date(millis);  
    }
    
    public static String GetToDayString(){
        Date today = GetToDay();
        return sdf.format(today);
    }
}
