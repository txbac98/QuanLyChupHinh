/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiemchuphinh;

import DTO.TaiKhoanDTO;
import GUI.frmDangNhap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author 16520
 */
public class QuanLyTiemChupHinh {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        frmDangNhap frmDN = new frmDangNhap();
        frmDN.Show();
    }
    
    public static TaiKhoanDTO taiKhoanDangNhap;
}
