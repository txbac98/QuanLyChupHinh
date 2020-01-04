/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author 16520
 */
public class BangHoachToan {
    //     MABHT VARCHAR(10) NOT NULL,
    //  MANV VARCHAR(10) NOT NULL,
    //  TENBHT VARCHAR(100) NOT NULL,
    //  NGAYTAO DATE,
    //  HIEULUC BOOLEAN
    public String MABHT;
    public String MANV;
    public String TENBHT;
    public String NGAYTAO;
    public String HIEULUC;
    
    public BangHoachToan(){
        
    }
    
    public BangHoachToan(String MaBHT, String MaNV, String TenBHT, String NgayTao, String HieuLuc){
        MABHT = MaBHT;
        MANV = MaNV;
        TENBHT = TenBHT;
        NGAYTAO = NgayTao;
        HIEULUC = HieuLuc;
    }
}
