/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author 16520
 */
public class PhieuThanhToan {
    public String MATT;
    public String MAPC;
    public String MANV;
    public String SOANH;
    public String MABHT;
    public String MACTHT;
    public String MACTUD;
    public String NGAYTAO;
    public String SOTIEN;
    
    
    public PhieuThanhToan(){
        
    }
    
    public PhieuThanhToan(String MaTT, String MaPC, String MaNV, String SoAnh, String MaBHT, String MaCTHT, String MaCTUD, String ngayTao, String soTien){
        MATT = MaTT;
        MAPC = MaPC;
        MANV = MaNV;
        SOANH = SoAnh;
        MABHT = MaBHT;
        MACTHT = MaCTHT;
        MACTUD = MaCTUD;
        NGAYTAO = ngayTao;
        SOTIEN = soTien;
    }
}
