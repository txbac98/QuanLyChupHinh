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
public class ChiTietPhieuChupDTO {

    public String MAPC;
    public String SOANH;
    
    
    public ChiTietPhieuChupDTO(){
        
    }
    public ChiTietPhieuChupDTO(String maPC, String soAnh){
        MAPC = maPC;
        SOANH = soAnh;
    }
}
