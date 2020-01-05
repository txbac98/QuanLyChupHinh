/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JInternalFrame;

/**
 *
 * @author 16520
 */
public class frmHome extends javax.swing.JFrame {

    /**
     * Creates new form frmHome
     */
    public frmHome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        destopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTrangChu = new javax.swing.JMenu();
        menuTraCuu = new javax.swing.JMenu();
        menuItemTraCuuPhieuChup = new javax.swing.JMenuItem();
        menuItemTraCuuKH = new javax.swing.JMenuItem();
        menuItemTraCuuCTUD = new javax.swing.JMenuItem();
        menuQuanLy = new javax.swing.JMenu();
        menuItemQuanLyPhieuChup = new javax.swing.JMenuItem();
        menuItemQuanLyKH = new javax.swing.JMenuItem();
        menuItemQuanLyCTUD = new javax.swing.JMenuItem();
        menuItemQuanLyPhieuThanhToan = new javax.swing.JMenuItem();
        menuItemQuanLyBangHoachToan = new javax.swing.JMenuItem();
        menuQuanLyTaiKhoan = new javax.swing.JMenu();
        menuTaiKhoan = new javax.swing.JMenu();
        menuItemDoiMatKhau = new javax.swing.JMenuItem();
        menuItemDangXuat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout destopPaneLayout = new javax.swing.GroupLayout(destopPane);
        destopPane.setLayout(destopPaneLayout);
        destopPaneLayout.setHorizontalGroup(
            destopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        destopPaneLayout.setVerticalGroup(
            destopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        menuTrangChu.setText("Trang chủ");
        menuTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTrangChuMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuTrangChu);

        menuTraCuu.setText("Tra cứu");

        menuItemTraCuuPhieuChup.setText("Tra cứu phiếu chụp");
        menuItemTraCuuPhieuChup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTraCuuPhieuChupActionPerformed(evt);
            }
        });
        menuTraCuu.add(menuItemTraCuuPhieuChup);

        menuItemTraCuuKH.setText("Tra cứu khách hàng");
        menuItemTraCuuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTraCuuKHActionPerformed(evt);
            }
        });
        menuTraCuu.add(menuItemTraCuuKH);

        menuItemTraCuuCTUD.setText("Tra cứu CTUD đang áp dụng");
        menuItemTraCuuCTUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTraCuuCTUDActionPerformed(evt);
            }
        });
        menuTraCuu.add(menuItemTraCuuCTUD);

        jMenuBar1.add(menuTraCuu);

        menuQuanLy.setText("Quản lý");

        menuItemQuanLyPhieuChup.setText("Quản lý phiếu chụp");
        menuItemQuanLyPhieuChup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyPhieuChupActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyPhieuChup);

        menuItemQuanLyKH.setText("Quản lý khách hàng");
        menuItemQuanLyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyKHActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyKH);

        menuItemQuanLyCTUD.setText("Quản lý chương trình ưu đãi");
        menuItemQuanLyCTUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyCTUDActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyCTUD);

        menuItemQuanLyPhieuThanhToan.setText("Quản lý phiếu thanh toán");
        menuItemQuanLyPhieuThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyPhieuThanhToanActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyPhieuThanhToan);

        menuItemQuanLyBangHoachToan.setText("Quản lý bảng hoạch toán");
        menuItemQuanLyBangHoachToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyBangHoachToanActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyBangHoachToan);

        jMenuBar1.add(menuQuanLy);

        menuQuanLyTaiKhoan.setText("Quản lý tài khoản");
        menuQuanLyTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyTaiKhoanMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuQuanLyTaiKhoan);

        menuTaiKhoan.setText("Tài khoản");

        menuItemDoiMatKhau.setText("Đổi mật khẩu");
        menuItemDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDoiMatKhauActionPerformed(evt);
            }
        });
        menuTaiKhoan.add(menuItemDoiMatKhau);

        menuItemDangXuat.setText("Đăng xuất");
        menuItemDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDangXuatActionPerformed(evt);
            }
        });
        menuTaiKhoan.add(menuItemDangXuat);

        jMenuBar1.add(menuTaiKhoan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(destopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(destopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowTrangChu(){
        SERVICEFORM.Form.centreWindow(this);
        this.CloseAllChildForm();
        frmTrangChu frmTC = new frmTrangChu();
        destopPane.add(frmTC);
        frmTC.Show();
    }
    
    public void ShowBanLanhDao(){
        this.setVisible(true);
        ShowTrangChu();
    }
    
    public void ShowBoPhanGiaoDich(){
        this.setVisible(true);
        menuQuanLyTaiKhoan.setVisible(false);
        menuTraCuu.setVisible(false);        
        ShowTrangChu();
    }
    
    public void ShowBoPhanTiepThi(){
        this.setVisible(true);
        menuQuanLyTaiKhoan.setVisible(false);
        menuQuanLy.setVisible(false);
        ShowTrangChu();
    }
    
    public void ShowBoPhanKyThuat(){
        frmKyThuatVien frmKTV = new frmKyThuatVien();
        frmKTV.Show();
    }
    
    private void CloseAllChildForm(){
        for (JInternalFrame frmChild : destopPane.getAllFrames()) {
        frmChild.dispose();
        }
    }
    
    public void ShowTaoPhieuChupVoiMaKH(String MaKH){
        this.CloseAllChildForm();
        frmQuanLyPhieuChup frmQLPC = new frmQuanLyPhieuChup();
        destopPane.add(frmQLPC);
        frmQLPC.ShowVoiMaKH(MaKH);
    }
    
    private void menuItemQuanLyBangHoachToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyBangHoachToanActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        
        frmQuanLyBangHoachToan frmQLBHT = new frmQuanLyBangHoachToan();
       
        //frmCTUD.setLocation(this.getWidth()/2 - frmCTUD.getWidth()/2,(this.getHeight()-20)/2 - frmCTUD.getHeight()/2 - 20);
        destopPane.add(frmQLBHT);
        frmQLBHT.Show();
    }//GEN-LAST:event_menuItemQuanLyBangHoachToanActionPerformed

    private void menuItemQuanLyPhieuChupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuChupActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyPhieuChup frmQLPC = new frmQuanLyPhieuChup();
        destopPane.add(frmQLPC);
        frmQLPC.Show();
    }//GEN-LAST:event_menuItemQuanLyPhieuChupActionPerformed

    private void menuItemQuanLyPhieuThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuThanhToanActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyPhieuThanhToan frmQLPTT= new frmQuanLyPhieuThanhToan();
        destopPane.add(frmQLPTT);
        frmQLPTT.Show();
    }//GEN-LAST:event_menuItemQuanLyPhieuThanhToanActionPerformed

    private void menuItemTraCuuPhieuChupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTraCuuPhieuChupActionPerformed
        // TODO add your handling code here:
        frmTraCuuPhieuChup frmTCPC = new frmTraCuuPhieuChup();
        frmTCPC.Show();
    }//GEN-LAST:event_menuItemTraCuuPhieuChupActionPerformed

    private void menuQuanLyTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyTaiKhoanMouseClicked
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyTaiKhoan frmQLTK = new frmQuanLyTaiKhoan();
        destopPane.add(frmQLTK);
        frmQLTK.Show();
    }//GEN-LAST:event_menuQuanLyTaiKhoanMouseClicked

    private void menuItemQuanLyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyKHActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyKhachHang frmQLKH = new frmQuanLyKhachHang();
        destopPane.add(frmQLKH);
        //frmQLKH.setd
        frmQLKH.Show(this);
        
    }//GEN-LAST:event_menuItemQuanLyKHActionPerformed

    private void menuItemQuanLyCTUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyCTUDActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        
        frmQuanLyChuongTrinhUuDai frmCTUD = new frmQuanLyChuongTrinhUuDai();
       
        //frmCTUD.setLocation(this.getWidth()/2 - frmCTUD.getWidth()/2,(this.getHeight()-20)/2 - frmCTUD.getHeight()/2 - 20);
        destopPane.add(frmCTUD);
        frmCTUD.Show();
        
    }//GEN-LAST:event_menuItemQuanLyCTUDActionPerformed

    private void menuItemDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDoiMatKhauActionPerformed
        // TODO add your handling code here:
        frmDoiMatKhau frmDMK = new frmDoiMatKhau();
        frmDMK.Show();
    }//GEN-LAST:event_menuItemDoiMatKhauActionPerformed

    private void menuItemDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDangXuatActionPerformed
        // TODO add your handling code here:
        frmDangNhap frmDN = new frmDangNhap();
        frmDN.ShowKhiDangXuat();
        this.setVisible(false);
    }//GEN-LAST:event_menuItemDangXuatActionPerformed

    private void menuTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTrangChuMouseClicked
        // TODO add your handling code here:
        ShowTrangChu();
    }//GEN-LAST:event_menuTrangChuMouseClicked

    private void menuItemTraCuuKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTraCuuKHActionPerformed
        // TODO add your handling code here:
        frmTraCuuKhachHang frmTCKH = new frmTraCuuKhachHang();
        frmTCKH.Show();
    }//GEN-LAST:event_menuItemTraCuuKHActionPerformed

    private void menuItemTraCuuCTUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTraCuuCTUDActionPerformed
        // TODO add your handling code here:
        frmCTUDDangApDung frmCTUD = new frmCTUDDangApDung();
        frmCTUD.Show();
    }//GEN-LAST:event_menuItemTraCuuCTUDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane destopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemDangXuat;
    private javax.swing.JMenuItem menuItemDoiMatKhau;
    private javax.swing.JMenuItem menuItemQuanLyBangHoachToan;
    private javax.swing.JMenuItem menuItemQuanLyCTUD;
    private javax.swing.JMenuItem menuItemQuanLyKH;
    private javax.swing.JMenuItem menuItemQuanLyPhieuChup;
    private javax.swing.JMenuItem menuItemQuanLyPhieuThanhToan;
    private javax.swing.JMenuItem menuItemTraCuuCTUD;
    private javax.swing.JMenuItem menuItemTraCuuKH;
    private javax.swing.JMenuItem menuItemTraCuuPhieuChup;
    private javax.swing.JMenu menuQuanLy;
    private javax.swing.JMenu menuQuanLyTaiKhoan;
    private javax.swing.JMenu menuTaiKhoan;
    private javax.swing.JMenu menuTraCuu;
    private javax.swing.JMenu menuTrangChu;
    // End of variables declaration//GEN-END:variables
}
