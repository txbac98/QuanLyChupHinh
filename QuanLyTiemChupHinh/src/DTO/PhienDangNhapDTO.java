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
public class PhienDangNhapDTO {
    public String TAIKHOAN;
    public String MATKHAU;
    public boolean GHINHO;
    public boolean TUDONG;
    
    public PhienDangNhapDTO(){
        
    }
    
    public PhienDangNhapDTO(String tk, String mk, boolean gn, boolean td){
        TAIKHOAN = tk;
        MATKHAU = mk;
        GHINHO = gn;
        TUDONG = td;
    }
}
