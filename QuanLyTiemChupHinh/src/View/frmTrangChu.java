/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Controller.TrangChuCon;


/**
 *
 * @author 16520
 */
public class frmTrangChu extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTrangChu
     */
    public frmTrangChu() {
        initComponents();
    }

    public void Show(){
        this.setVisible(true);

        lbTongKH.setText(TrangChuCon.TongSoKH());
        lbSoPCTong.setText(TrangChuCon.TongSoPC());
        lbSoPCThang.setText(TrangChuCon.TongSoPCTuDauThang());
        lbDoanhThuTong.setText(TrangChuCon.TongDoanhThu());
        lbDoanhThuThang.setText(TrangChuCon.TongDoanhThuTuDauThang());
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbTongKH = new javax.swing.JLabel();
        lbSoPCThang = new javax.swing.JLabel();
        lbDoanhThuTong = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbDoanhThuThang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSoPCTong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/pngfuel.com.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Photography");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_User_27887.png"))); // NOI18N
        jLabel3.setText("Tổng số khách hàng:");

        lbTongKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTongKH.setText("50");

        lbSoPCThang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSoPCThang.setText("50");

        lbDoanhThuTong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDoanhThuTong.setText("50");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Paste_27862.png"))); // NOI18N
        jLabel6.setText("Tổng doanh thu:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Calendar_27835.png"))); // NOI18N
        jLabel7.setText("Doanh thu từ đầu tháng:");

        lbDoanhThuThang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDoanhThuThang.setText("50");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Flash Disk_27848.png"))); // NOI18N
        jLabel4.setText("Tổng số phiếu chụp:");

        lbSoPCTong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSoPCTong.setText("50");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Picture_27864.png"))); // NOI18N
        jLabel5.setText("Số phiếu chụp từ đầu tháng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTongKH)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(lbSoPCThang)
                    .addComponent(jLabel4)
                    .addComponent(lbSoPCTong)
                    .addComponent(jLabel7)
                    .addComponent(lbDoanhThuThang)
                    .addComponent(jLabel6)
                    .addComponent(lbDoanhThuTong))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbTongKH)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbSoPCThang)
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lbSoPCTong)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lbDoanhThuThang)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lbDoanhThuTong)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDoanhThuThang;
    private javax.swing.JLabel lbDoanhThuTong;
    private javax.swing.JLabel lbSoPCThang;
    private javax.swing.JLabel lbSoPCTong;
    private javax.swing.JLabel lbTongKH;
    // End of variables declaration//GEN-END:variables
}
