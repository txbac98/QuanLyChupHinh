/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiTietPhieuChupDao;
import Model.ChiTietPhieuChup;
import Model.ThongBao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 16520
 */
public class CapNhatPhieuChupCon {
    
    public static ArrayList<String> LoadListPathInFolder(String MaPC){
        
        String path = System.getProperty("user.dir") +"/Data/HinhAnh/" + MaPC ;
        File folder = new File(path);
        if (!folder.exists()){
            System.err.println("Khong co file");
            return null;
        }
        File[] listOfFiles = folder.listFiles();
        
        ArrayList<String> listPath = new ArrayList<String>();
        for (File file : listOfFiles){
            if (file.isFile()){
                System.err.println(file.getPath());
                listPath.add(file.getPath());
            }
        }
        return listPath;
    }
    
    public static void LuuHinhAnh(String MaPC, List<String> listPath){
        String newPath = System.getProperty("user.dir") +"/Data/HinhAnh/" + MaPC ;
        CreateFolder(newPath);
            
        System.out.print(newPath);
        
        for (int i =0; i<listPath.size(); i++){
            String MaHA= MaPC + "_" + (i+1);
            System.err.println(listPath.get(i) + " : " + newPath + "/" + MaHA);
            CopyFile(listPath.get(i), newPath + "/" + MaHA);
        }
        
        
    }

    public static ThongBao LuuCTPC(ChiTietPhieuChup ctpc){
        return ChiTietPhieuChupDao.LuuCTPC(ctpc);
    }
            
    
    private static String getFileExtension(File file) {
        String extension = "";
 
        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        } 
        return extension; 
    }
    
    public static void CopyFile(String sou, String des){             
        File source = new File(sou);
        File destination = new File(des + getFileExtension(source));
        
        if (source.getPath().equals(destination.getPath())) return;
        if (destination.isFile()) destination.delete(); //Nếu tồn tại file thì xóa
        try{
            Files.copy(source.toPath(), destination.toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
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
