/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_copy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author 16520
 */
public class FileCopy {
    
    public static void CopyFile(){
        File source = new File("D:\\abc.txt");
        File destination = new File("D:\\def.txt");
        if (destination.isFile()) destination.delete(); //Nếu tồn tại file thì xóa
        try{
            Files.copy(source.toPath(), destination.toPath());
        }catch (IOException e){
            e.printStackTrace();
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
    
    public static void CopyFile(String sou, String des){
        File source = new File(sou);
        File destination = new File(des + getFileExtension(source));
        if (destination.isFile()) destination.delete(); //Nếu tồn tại file thì xóa
        try{
            Files.copy(source.toPath(), destination.toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
