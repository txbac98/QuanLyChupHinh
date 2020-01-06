/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 16520
 */
public class ChiTietHoachToanDTO {
    //    MACTHT VARCHAR(10) NOT NULL,
    //  MABHT VARCHAR(10) NOT NULL,
    //  NOIDUNG VARCHAR(1000),
    //  GIA LONG
    public String MABHT;
    public String MACTHT;   
    public String NOIDUNG;
    public String GIA;
    
    public ChiTietHoachToanDTO(){
        
    }
    
    public ChiTietHoachToanDTO( String MaBHT, String MaCTHT, String NoiDung, String Gia){      
        MABHT = MaBHT;
        MACTHT = MaCTHT;
        NOIDUNG = NoiDung;
        GIA = Gia;
    }
}
