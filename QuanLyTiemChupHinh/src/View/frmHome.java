/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
        jMenu2 = new javax.swing.JMenu();
        menuQuanLy = new javax.swing.JMenu();
        menuItemQuanLyPhieuChup = new javax.swing.JMenuItem();
        menuItemTraCuuPhieuChup = new javax.swing.JMenuItem();
        menuItemQuanLyPhieuThanhToan = new javax.swing.JMenuItem();
        menuItemQuanLyBangHoachToan = new javax.swing.JMenuItem();
        menuItemQuanLyBaoCao = new javax.swing.JMenuItem();
        menuKhachHang = new javax.swing.JMenu();
        menuChuongTrinhUuDai = new javax.swing.JMenu();
        menuTaiKhoan = new javax.swing.JMenu();
        menuItemDoiTaiKhoan = new javax.swing.JMenuItem();
        menuItemDangXuat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jMenu2.setText("Trang chủ");
        jMenuBar1.add(jMenu2);

        menuQuanLy.setText("Quản lý");

        menuItemQuanLyPhieuChup.setText("Quản lý phiếu chụp");
        menuItemQuanLyPhieuChup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemQuanLyPhieuChupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItemQuanLyPhieuChupMouseEntered(evt);
            }
        });
        menuItemQuanLyPhieuChup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyPhieuChupActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyPhieuChup);

        menuItemTraCuuPhieuChup.setText("Tra cứu phiếu chụp");
        menuItemTraCuuPhieuChup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTraCuuPhieuChupActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemTraCuuPhieuChup);

        menuItemQuanLyPhieuThanhToan.setText("Quản lý phiếu thanh toán");
        menuItemQuanLyPhieuThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyPhieuThanhToanActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyPhieuThanhToan);

        menuItemQuanLyBangHoachToan.setText("Quản lý bảng hoạch toán");
        menuItemQuanLyBangHoachToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemQuanLyBangHoachToanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItemQuanLyBangHoachToanMouseEntered(evt);
            }
        });
        menuItemQuanLyBangHoachToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyBangHoachToanActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyBangHoachToan);

        menuItemQuanLyBaoCao.setText("Quản lý báo cáo");
        menuItemQuanLyBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQuanLyBaoCaoActionPerformed(evt);
            }
        });
        menuQuanLy.add(menuItemQuanLyBaoCao);

        jMenuBar1.add(menuQuanLy);

        menuKhachHang.setText("Khách hàng");
        menuKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKhachHangMouseClicked(evt);
            }
        });
        menuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKhachHangActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuKhachHang);

        menuChuongTrinhUuDai.setText("Chương trình ưu đãi");
        menuChuongTrinhUuDai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuChuongTrinhUuDaiMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuChuongTrinhUuDai);

        menuTaiKhoan.setText("Tài khoản");

        menuItemDoiTaiKhoan.setText("Đổi mật khẩu");
        menuTaiKhoan.add(menuItemDoiTaiKhoan);

        menuItemDangXuat.setText("Đăng xuất");
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

    
    private void CloseAllChildForm(){
        for (JInternalFrame frmChild : destopPane.getAllFrames()) {
        frmChild.dispose();
        }
    }
    
    private void menuChuongTrinhUuDaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuChuongTrinhUuDaiMouseClicked
        // TODO add your handling code here:
        
        this.CloseAllChildForm();
        
        frmQuanLyChuongTrinhUuDai frmCTUD = new frmQuanLyChuongTrinhUuDai();
       
        //frmCTUD.setLocation(this.getWidth()/2 - frmCTUD.getWidth()/2,(this.getHeight()-20)/2 - frmCTUD.getHeight()/2 - 20);
        destopPane.add(frmCTUD);
        frmCTUD.setVisible(true);
    }//GEN-LAST:event_menuChuongTrinhUuDaiMouseClicked

    private void menuItemQuanLyBangHoachToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemQuanLyBangHoachToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemQuanLyBangHoachToanMouseClicked

    private void menuItemQuanLyBangHoachToanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemQuanLyBangHoachToanMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuItemQuanLyBangHoachToanMouseEntered

    private void menuItemQuanLyBangHoachToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyBangHoachToanActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        
        frmQuanLyBangHoachToan frmQLBHT = new frmQuanLyBangHoachToan();
       
        //frmCTUD.setLocation(this.getWidth()/2 - frmCTUD.getWidth()/2,(this.getHeight()-20)/2 - frmCTUD.getHeight()/2 - 20);
        destopPane.add(frmQLBHT);
        frmQLBHT.setVisible(true);
    }//GEN-LAST:event_menuItemQuanLyBangHoachToanActionPerformed

    private void menuItemQuanLyPhieuChupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuChupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemQuanLyPhieuChupMouseClicked

    private void menuItemQuanLyPhieuChupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuChupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemQuanLyPhieuChupMouseEntered

    private void menuItemQuanLyPhieuChupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuChupActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyPhieuChup frmQLPC = new frmQuanLyPhieuChup();
        destopPane.add(frmQLPC);
        frmQLPC.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_menuItemQuanLyPhieuChupActionPerformed

    private void menuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKhachHangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuKhachHangActionPerformed

    private void menuKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhachHangMouseClicked
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyKhachHang frmQLKH = new frmQuanLyKhachHang();
        destopPane.add(frmQLKH);
        //frmQLKH.setd
        frmQLKH.Show();
    }//GEN-LAST:event_menuKhachHangMouseClicked

    private void menuItemQuanLyPhieuThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyPhieuThanhToanActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyPhieuThanhToan frmQLPTT= new frmQuanLyPhieuThanhToan();
        destopPane.add(frmQLPTT);
        frmQLPTT.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_menuItemQuanLyPhieuThanhToanActionPerformed

    private void menuItemTraCuuPhieuChupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTraCuuPhieuChupActionPerformed
        // TODO add your handling code here:
        frmTraCuuPhieuChup frmTCPC = new frmTraCuuPhieuChup();
        frmTCPC.setVisible(true);
    }//GEN-LAST:event_menuItemTraCuuPhieuChupActionPerformed

    private void menuItemQuanLyBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQuanLyBaoCaoActionPerformed
        // TODO add your handling code here:
        this.CloseAllChildForm();
        frmQuanLyBaoCao frmQLBC = new frmQuanLyBaoCao();
        destopPane.add(frmQLBC);
        frmQLBC.setVisible(true);
    }//GEN-LAST:event_menuItemQuanLyBaoCaoActionPerformed

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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuChuongTrinhUuDai;
    private javax.swing.JMenuItem menuItemDangXuat;
    private javax.swing.JMenuItem menuItemDoiTaiKhoan;
    private javax.swing.JMenuItem menuItemQuanLyBangHoachToan;
    private javax.swing.JMenuItem menuItemQuanLyBaoCao;
    private javax.swing.JMenuItem menuItemQuanLyPhieuChup;
    private javax.swing.JMenuItem menuItemQuanLyPhieuThanhToan;
    private javax.swing.JMenuItem menuItemTraCuuPhieuChup;
    private javax.swing.JMenu menuKhachHang;
    private javax.swing.JMenu menuQuanLy;
    private javax.swing.JMenu menuTaiKhoan;
    // End of variables declaration//GEN-END:variables
}