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
public class KhachHangDTO {
//     MAKH VARCHAR(11) NOT NULL,
//    TENKH VARCHAR(50) NOT NULL,
//    NGAYSINH DATE NOT NULL,
//    SDT VARCHAR(20),
//    EMAIL VARCHAR(20)
     
     public String MAKH;
     public String TENKH;
     public String NGAYSINH;
     public String SDT;
     public String EMAIL;
     
     public KhachHangDTO(){
         
     }
     public KhachHangDTO(String maKH, String tenKH, String ngaySinh, String sdt, String email){
         this.MAKH = maKH;
         this.TENKH = tenKH;
         this.NGAYSINH = ngaySinh;
         this.SDT = sdt;
         this.EMAIL = email;
     }
}
