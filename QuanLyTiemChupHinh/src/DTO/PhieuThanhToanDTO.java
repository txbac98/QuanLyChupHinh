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
public class PhieuThanhToanDTO {
    public String MAPTT;
    public String MAPC;
    public String MAKH;
    public String MANV;
    public String SOANH;
    public String BHT;
    public String CTHT;
    public String CTUD;
    public String NGAYTAO;
    public String SOTIEN;
    
    
    public PhieuThanhToanDTO(){
        
    }
    
    public PhieuThanhToanDTO(String MaPTT, String MaPC, String MaKH, String MaNV, String SoAnh, String MaBHT, String MaCTHT, String MaCTUD, String ngayTao, String soTien){
        MAPTT = MaPTT;
        MAPC = MaPC;
        MAKH = MaKH;
        MANV = MaNV;
        SOANH = SoAnh;
        BHT = MaBHT;
        CTHT = MaCTHT;
        CTUD = MaCTUD;
        NGAYTAO = ngayTao;
        SOTIEN = soTien;
    }
}
