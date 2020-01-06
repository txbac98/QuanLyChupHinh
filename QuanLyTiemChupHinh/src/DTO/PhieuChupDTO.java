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
public class PhieuChupDTO {
    //     MAPC VARCHAR(10) NOT NULL,
    // MAKH VARCHAR(10) NOT NULL,
    // NGAYTAO DATE,
    // TRANGTHAI VARCHAR(20)
    public String MAPC;
    public String MAKH;
    public String NGAYTAO;
    public String TRANGTHAI;
    public PhieuChupDTO(){
        
    }
    public PhieuChupDTO(String MaPC, String MaKH, String ngayTao, String trangThai){
        MAPC = MaPC;
        MAKH = MaKH;
        NGAYTAO = ngayTao;
        TRANGTHAI = trangThai;
    }
    
    public PhieuChupDTO(PhieuChupDTO pc){
        MAPC = pc.MAPC;
        MAKH = pc.MAKH;
        NGAYTAO = pc.NGAYTAO;
        TRANGTHAI = pc.TRANGTHAI;
    }
    
    public void DaThanhToan(){
        TRANGTHAI = "Đã giao ảnh";
    }
}
