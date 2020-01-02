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
public class ChuongTrinhUuDai {
    //    MACTUD VARCHAR(10) NOT NULL,
    //  MANV VARCHAR(10) NOT NULL,
    //  TENCTUD VARCHAR(100) NOT NULL,
    //  NGAYBATDAU DATE,
    //  NGAYKETTHUC DATE,
    //  NOIDUNG VARCHAR(1000),
    //  GIATRIUUDAI FLOAT
    public String MACTUD;
    public String MANV;
    public String TENCTUD;
    public String NGAYBATDAU;
    public String NGAYKETTHUC;
    public String NOIDUNG;
    public String GIATRIUUDAI;
    
    public ChuongTrinhUuDai(){
        
    }
    public ChuongTrinhUuDai(String maCTUD, String maNV, String tenCTUD, String ngayBD, String ngayKT, String noiDung, String gtud){
        MACTUD = maCTUD;
        MANV = maNV;
        TENCTUD = tenCTUD;
        NGAYBATDAU = ngayBD;
        NGAYKETTHUC = ngayKT;
        NOIDUNG = noiDung;
        GIATRIUUDAI = gtud;
    }
}
