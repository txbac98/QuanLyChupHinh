/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.BangHoachToanDTO;
import DTO.ChiTietHoachToanDTO;
import DTO.ChuongTrinhUuDaiDTO;
import DTO.ThongBaoDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author 16520
 */
public class BaoCaoBUS {
    public static ThongBaoDTO XuatBaoCaoDoanhThu(Date ngayBD, Date ngayKT){
        if (ngayBD==null || ngayKT == null) return new ThongBaoDTO(false, "Chọn thời gian báo cáo");
        if (ngayBD.after(ngayKT)) return new ThongBaoDTO(false, "Ngày kết  phải ở sau ngày BD");
        
        String text= "Công ty ảnh kỹ thuật số Photography\n" +
                DateBUS.GetToDayString()+"\n\n"+
"                                                          BÁO CÁO DOANH THU\n" +
"                                                            "+DateBUS.GetDateString(ngayKT)+" - " + DateBUS.GetDateString(ngayKT) + "\n\n";
        
        
        
        ArrayList<BangHoachToanDTO> bht =BangHoachToanBUS.LayDanhSachBHTCoHieuLuc();
        if (bht!=null){
            for (int iBHT = 0; iBHT < bht.size(); iBHT++){
                ArrayList<ChiTietHoachToanDTO> ctht = ChiTietHoachToanBUS.LayDanhSachChiTietHoachToan(bht.get(iBHT).MABHT);
                if (ctht!=null){
                    for (int iCT=0; iCT< ctht.size(); iCT++){
                        text += "\n- " + bht.get(iBHT).TENBHT + "- " + ctht.get(iCT).NOIDUNG + ": "+PhieuThanhToanBUS.TongDoanhThuTheoCTHT(ngayBD, ngayKT, ctht.get(iCT).NOIDUNG, bht.get(iBHT).TENBHT);
                    }
                }
            }         
        }
        
       
        
        text+="\n"+"Tổng doanh thu: "+PhieuThanhToanBUS.TongDoanhThuTheoNgay(ngayBD, ngayKT)+"\n\n\n" +
"Người lập báo cáo\n" +
quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.LOAINV +
"\n" +
"\n" +
"\n" +
"\n" +
quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.TENNV;
        
        
        String nameFile = TaoMoiTenBC(System.getProperty("user.dir")+"/Data/BaoCao/DoanhThu");
        String path = System.getProperty("user.dir")+"/Data/BaoCao/DoanhThu/"+nameFile;
        PDFBUS.SavePDF(path, text);
        
        
        return new ThongBaoDTO(true, "Xuất báo cáo thành công");
    }
    
    public static ThongBaoDTO XuatBaoCaoCTUD(Date ngayBD, Date ngayKT){        
        if (ngayBD==null || ngayKT == null) return new ThongBaoDTO(false, "Chọn thời gian báo cáo");
        if (ngayBD.after(ngayKT)) return new ThongBaoDTO(false, "Ngày kết  phải ở sau ngày BD");
        
        String text= "Công ty ảnh kỹ thuật số Photography\n" +
DateBUS.GetToDayString()+"\n\n"+
"                                                BÁO CÁO HOẠT ĐỘNG CTUD\n" +
"                                                       "+DateBUS.GetDateString(ngayKT)+" - " + DateBUS.GetDateString(ngayKT)+"\n\n";
        
        ArrayList<ChuongTrinhUuDaiDTO> ctud = ChuongTrinhUuDaiBUS.LayDanhSachCTUDTheoThoiGian(ngayBD, ngayKT);
        if (ctud!=null){
            for (int iUD=0; iUD< ctud.size(); iUD++){
            try {  
                float giaTri = Float.parseFloat(ctud.get(iUD).GIATRIUUDAI);   
                System.err.println(giaTri);
                long tongTienUD = PhieuThanhToanBUS.TongDoanhThuTheoCTUD(ngayBD, ngayKT, ctud.get(iUD).TENCTUD);
                System.err.println("Tong tien: " +tongTienUD);
                tongTienUD =(long)((tongTienUD/(100-giaTri))*giaTri);
                System.err.println("Tien UD: "+tongTienUD);
                text+="\n-" + ctud.get(iUD).TENCTUD + " ("+ ctud.get(iUD).GIATRIUUDAI +"%) : "+ tongTienUD;
                } catch(NumberFormatException e){  

                }  
            }
        }
        text+="\n\n\n"+
"Người lập báo cáo\n" +
quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.LOAINV +
"\n" +
"\n" +
"\n" +
"\n" +
quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.TENNV;
        
        
        String nameFile = TaoMoiTenBC(System.getProperty("user.dir")+"/Data/BaoCao/CTUD");
        String path = System.getProperty("user.dir")+"/Data/BaoCao/CTUD/"+nameFile;
        PDFBUS.SavePDF(path, text);
        
        return new ThongBaoDTO(true, "Xuất báo cáo thành công");
    }

    private static String TaoMoiTenBC(String sou){
        File source = new File(sou);
        if (source==null) CreateFolder(sou);
         
        File[] listOfFiles =source.listFiles();
        if (listOfFiles.length==0) return "BC1.pdf";
        String maCuoi = listOfFiles[listOfFiles.length-1].getName();
        String soCuoi = maCuoi.substring(2, maCuoi.length() -4);
        System.err.println(soCuoi);
        long index =0;
        try {  
            index = Long.parseLong(soCuoi);             
        } catch(NumberFormatException e){  
            return "BC1.pdf";
        }  
        return "BC" + (index +1) + ".pdf";
    }

     private static void CreateFolder(String path){
        File file = new File(path);
        //Creating the directory
        boolean bool = file.mkdir();
        if(bool){
           System.out.println("Directory created successfully");
        }else{
           System.out.println("Sorry couldn’t create specified directory");
        }
        
    }
}
