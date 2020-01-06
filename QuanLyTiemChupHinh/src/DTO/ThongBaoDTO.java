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
public class ThongBaoDTO {
    public Boolean ThanhCong;
    public String ChuThich;
    
    public ThongBaoDTO(){
        
    }
    public ThongBaoDTO(Boolean thanhCong, String chuThich){
        ThanhCong = thanhCong;
        ChuThich = chuThich;
    }
}
