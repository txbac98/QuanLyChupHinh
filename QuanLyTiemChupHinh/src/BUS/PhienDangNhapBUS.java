/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import com.google.gson.Gson;
import DTO.PhienDangNhapDTO;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author 16520
 */
public class PhienDangNhapBUS {
    
    public static void LuuDangNhap(PhienDangNhapDTO dangNhap){
        if (!dangNhap.GHINHO && !dangNhap.TUDONG){
            SaveText("");
        }
        else{
            Gson gson = new Gson();
            String json = gson.toJson(dangNhap);
            SaveText(json);
        }
        
    }

   
    public static PhienDangNhapDTO CheckDangNhap(){
        
        String json = LoadText();
        
        if (json==null) return null;
        
        Gson gson = new Gson();
        PhienDangNhapDTO dangNhap = gson.fromJson(json, PhienDangNhapDTO.class);
        return dangNhap;
    }
    
    private static void SaveText(String json){
        try {
            FileWriter myWriter = new FileWriter(System.getProperty("user.dir")+"/"+"DangNhap.txt");
            myWriter.write(json);          
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    private static String LoadText(){
        try {
                        File file = new File(System.getProperty("user.dir")+"/"+"DangNhap.txt");
                        FileReader fileReader = new FileReader(file);
			StringBuffer stringBuffer = new StringBuffer();
			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = fileReader.read(charArray)) > 0) {
				stringBuffer.append(charArray, 0, numCharsRead);
			}
			fileReader.close();			
			return stringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
                        return null;
            }
        
    }
    
}
