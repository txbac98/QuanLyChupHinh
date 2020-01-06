/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PhieuThanhToanBUS;
import DTO.PhieuThanhToanDTO;
import DTO.ThongBaoDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 16520
 */
public class frmQuanLyPhieuThanhToan extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmQuanLyPhieuThanhToan
     */
    public frmQuanLyPhieuThanhToan() {
        initComponents();
    }

    public void Show(){
        this.setVisible(true);
        XoaThongBao();
        LoadDanhSachPTT();
        btnXoa.setEnabled(false);
        btnXuatPhieu.setEnabled(false);
    }
    
     private void XoaThongBao(){
        lbThongBao.setText("");
    }
    
    private void ShowThongBao(ThongBaoDTO thongBao){
        lbThongBao.setText(thongBao.ChuThich);
        if (thongBao.ThanhCong){
           lbThongBao.setForeground(Color.GREEN);
        }
        else{
            lbThongBao.setForeground(Color.RED);
        }
    }
    
    private void LoadDanhSachPTT(){
        ArrayList<PhieuThanhToanDTO> listPTT = PhieuThanhToanBUS.LayDanhSachPhieuThanhToan();
        ShowData(listPTT);            
    }
    
    private void ShowData(ArrayList<PhieuThanhToanDTO> listPTT){
        
        tablePTT.clearSelection(); //Xoa du lieu table
        
        String header[] = {"Mã PTT", "Mã PC", "Mã KH", "Mã NV", "Số ảnh", "Ngày tạo", "Số tiền"};
        DefaultTableModel tblModel = new DefaultTableModel(header, 0);
        
        tblModel.setRowCount(0);
        
        if (listPTT != null) 
        {       
            // Trong khi chưa hết dữ liệu
           for (int i=0; i< listPTT.size(); i++){
                Vector data = new Vector();           
                data.add(listPTT.get(i).MAPTT);
                data.add(listPTT.get(i).MAPC);
                data.add(listPTT.get(i).MAKH);
                data.add(listPTT.get(i).MANV);
                data.add(listPTT.get(i).SOANH);
                data.add(listPTT.get(i).NGAYTAO);
                data.add(listPTT.get(i).SOTIEN);
                // Thêm một dòng vào table model
                tblModel.addRow(data);
               }
        } 
        tablePTT.setModel(tblModel); // Thêm dữ liệu vào table     
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfMaPTT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMaPC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfMaNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNgayTao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfSoTien = new javax.swing.JTextField();
        lbThongBao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfSoAnh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCTHT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfCTUD = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfMaKH = new javax.swing.JTextField();
        btnXuatPhieu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePTT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Mã PTT:");

        tfMaPTT.setEditable(false);
        tfMaPTT.setBackground(new java.awt.Color(204, 204, 204));
        tfMaPTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMaPTTActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã PC:");

        tfMaPC.setEditable(false);
        tfMaPC.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Mã nhân viên:");

        tfMaNV.setEditable(false);
        tfMaNV.setBackground(new java.awt.Color(204, 204, 204));
        tfMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMaNVActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày tạo:");

        tfNgayTao.setEditable(false);
        tfNgayTao.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Số tiền:");

        tfSoTien.setEditable(false);
        tfSoTien.setBackground(new java.awt.Color(204, 204, 204));

        lbThongBao.setText("Thong bao");

        jLabel7.setText("Số ảnh:");

        tfSoAnh.setEditable(false);
        tfSoAnh.setBackground(new java.awt.Color(204, 204, 204));
        tfSoAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoAnhActionPerformed(evt);
            }
        });

        jLabel8.setText("Chi tiết hoạch toán:");

        tfCTHT.setEditable(false);
        tfCTHT.setBackground(new java.awt.Color(204, 204, 204));
        tfCTHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCTHTActionPerformed(evt);
            }
        });

        jLabel9.setText("Chương trình ưu đãi");

        tfCTUD.setEditable(false);
        tfCTUD.setBackground(new java.awt.Color(204, 204, 204));
        tfCTUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCTUDActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã KH:");

        tfMaKH.setEditable(false);
        tfMaKH.setBackground(new java.awt.Color(204, 204, 204));

        btnXuatPhieu.setText("Xuất phiếu");
        btnXuatPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPhieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfMaPTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(45, 45, 45))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(22, 22, 22)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(tfMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(tfSoAnh))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(171, 171, 171)))
                            .addComponent(tfCTUD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tfCTHT, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(btnXuatPhieu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfSoTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbThongBao, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(tfMaPTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSoAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCTHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCTUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbThongBao)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnXuatPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        tablePTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePTTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePTT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMaNVActionPerformed

    private void tfSoAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSoAnhActionPerformed

    private void tfCTHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCTHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCTHTActionPerformed

    private void tfCTUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCTUDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCTUDActionPerformed

    PhieuThanhToanDTO ptt;
    private void tablePTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePTTMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tablePTT.getModel();

        // get the selected row index
       int selectedRowIndex = tablePTT.getSelectedRow();
       
         ptt= PhieuThanhToanBUS.LayPTTTheoMa(model.getValueAt(selectedRowIndex, 0).toString());
        
        if (ptt!=null)      {
            tfMaPTT.setText(ptt.MAPTT);
            tfMaPC.setText(ptt.MAPC);
            tfMaKH.setText(ptt.MAKH);
            tfMaNV.setText(ptt.MANV);
            tfSoAnh.setText(ptt.SOANH);
            tfCTHT.setText(ptt.CTHT);
            tfCTUD.setText(ptt.CTUD);
            tfNgayTao.setText(ptt.NGAYTAO);
            tfSoTien.setText(ptt.SOTIEN);
            
            btnXoa.setEnabled(true);
            btnXuatPhieu.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_tablePTTMouseClicked

    private void tfMaPTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMaPTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMaPTTActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (ptt!=null){
            ThongBaoDTO tb = PhieuThanhToanBUS.XoaPTT(ptt);
            ShowThongBao(tb);
            LoadDanhSachPTT();
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPhieuActionPerformed
        // TODO add your handling code here:
       
        PhieuThanhToanBUS.XuatPhieuThanhToan(ptt);
        ShowThongBao(new ThongBaoDTO(true,"Xuất phiếu thanh toán thành công"));
    }//GEN-LAST:event_btnXuatPhieuActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLyPhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyPhieuThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatPhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tablePTT;
    private javax.swing.JTextField tfCTHT;
    private javax.swing.JTextField tfCTUD;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfMaPC;
    private javax.swing.JTextField tfMaPTT;
    private javax.swing.JTextField tfNgayTao;
    private javax.swing.JTextField tfSoAnh;
    private javax.swing.JTextField tfSoTien;
    // End of variables declaration//GEN-END:variables
}
