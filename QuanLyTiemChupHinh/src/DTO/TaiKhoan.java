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
public class TaiKhoan {
    //     MANV VARCHAR(10) NOT NULL,
    // TENNV VARCHAR(50) NOT NULL,
    // MATKHAU VARCHAR(10) NOT NULL,
    // LOAINV VARCHAR(50) NOT NULL
    public String MANV;
    public String TENNV;
    public String MATKHAU;
    public String LOAINV;
    
    public TaiKhoan(){
        
    }
    public TaiKhoan(String MaNV, String TenNV, String MatKhau, String LoaiNV){
        MANV = MaNV;
        TENNV = TenNV;
        MATKHAU = MatKhau;
        LOAINV = LoaiNV;
    }
}
