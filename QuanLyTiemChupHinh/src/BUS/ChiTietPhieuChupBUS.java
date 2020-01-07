/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuChupDAO;
import DTO.ChiTietPhieuChupDTO;
import DTO.ThongBaoDTO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 16520
 */
public class ChiTietPhieuChupBUS {
    
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
            if (!KiemTraTonTai(listPath.get(i),  newPath))
                CopyFile(listPath.get(i), newPath );
            
            
        }              
    }
    public static void CopyFile(String sou, String des){             
             
            File source = new File(sou);
            File destination = new File(des + "/"+ source.getName());
             
            if (destination.isFile()) destination.delete(); //Nếu tồn tại file thì xóa
            try{
                Files.copy(source.toPath(), destination.toPath());
            }catch (IOException e){
                e.printStackTrace();
            }
        
    }
  
    public static ThongBaoDTO LuuCTPC(ChiTietPhieuChupDTO ctpc){
        return ChiTietPhieuChupDAO.LuuCTPC(ctpc);
    }
    
    private static boolean KiemTraTonTai(String sou, String des){
        
        File source = new File(sou);
        File destination = new File(des);
        File[] listOfFiles = destination.listFiles();
        for (File file : listOfFiles){
            if (source.getName().equals(file.getName())){
                return true;
            }
        }
        return false;
    }
    
    public static void XoaHinhAnh(String MaPC, ArrayList<String> listName){
        String newPath = System.getProperty("user.dir") +"/Data/HinhAnh/" + MaPC ;
        for (int i =0; i<listName.size(); i++){
            DeleteImageFile(newPath+ "/" + listName.get(i));
        }     
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
    
    private static void DeleteImageFile(String path){
        File file = new File(path);     
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
    }

}
