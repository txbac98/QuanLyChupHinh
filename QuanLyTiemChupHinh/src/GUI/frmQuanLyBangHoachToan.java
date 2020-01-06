/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BangHoachToanBUS;
import BUS.DateBUS;
import DTO.BangHoachToanDTO;
import DTO.ThongBaoDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 16520
 */
public class frmQuanLyBangHoachToan extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmQuanLyBangHoachToan
     */
    public frmQuanLyBangHoachToan() {
        initComponents();
    }

    public void Show(){
        this.setVisible(true);
        XoaThongBao();
        LoadDanhSachBangHoachToan();
        btnChiTiet.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(false);
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
    
    private void LoadDanhSachBangHoachToan(){
        ArrayList<BangHoachToanDTO> listBHT = BangHoachToanBUS.LayDanhSachBHT();
        ShowDatas(listBHT);
    }
    
    private void ShowDatas(ArrayList<BangHoachToanDTO> listBHT){
        tableBHT.clearSelection(); //Xoa du lieu table
        
        String header[] = {"Mã BHT", "Mã NV", "Tên BHT", "Ngày tạo", "Hiệu lực"};
        DefaultTableModel tblModel = new DefaultTableModel(header, 0);
        
        tblModel.setRowCount(0);
        
        if (listBHT != null) 
        {       
            // Trong khi chưa hết dữ liệu
           for (int i=0; i< listBHT.size(); i++){
                Vector data = new Vector();           
                data.add(listBHT.get(i).MABHT);
                data.add(listBHT.get(i).MANV);
                data.add(listBHT.get(i).TENBHT);
                data.add(listBHT.get(i).NGAYTAO);
                data.add(listBHT.get(i).HIEULUC);
                // Thêm một dòng vào table model
                tblModel.addRow(data);
               }
        } 
        tableBHT.setModel(tblModel); // Thêm dữ liệu vào table    
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
        tfMaBHT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTenBHT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dcNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbxHieuLuc = new javax.swing.JCheckBox();
        lbThongBao = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBHT = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbxTraCuuHieuLuc = new javax.swing.JCheckBox();
        btnXoaTraCuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Mã bảng hoạch toán:");

        tfMaBHT.setEditable(false);
        tfMaBHT.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Mã nhân viên:");

        tfMaNV.setEditable(false);
        tfMaNV.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Tên bảng hoạch toán:");

        jLabel4.setText("Ngày tạo:");

        jLabel5.setText("Hiệu lực:");

        cbxHieuLuc.setText("Đang được áp dụng");
        cbxHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHieuLucActionPerformed(evt);
            }
        });

        lbThongBao.setText("Thong bao");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Check_27837.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Calendar_27835.png"))); // NOI18N
        btnChiTiet.setToolTipText("");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Edit_27845.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Delete_27842.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Add_27831.png"))); // NOI18N
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
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
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(14, 14, 14)
                        .addComponent(btnChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxHieuLuc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbThongBao)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dcNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(btnThemMoi))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaBHT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTenBHT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfMaBHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTenBHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxHieuLuc)
                .addGap(25, 25, 25)
                .addComponent(lbThongBao)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableBHT.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBHT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBHTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBHT);

        jLabel6.setText("Hiệu lực:");

        cbxTraCuuHieuLuc.setText("Đang được áp dụng");
        cbxTraCuuHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTraCuuHieuLucActionPerformed(evt);
            }
        });

        btnXoaTraCuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Escape_Search_27877.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbxTraCuuHieuLuc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaTraCuu)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTraCuuHieuLuc))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnXoaTraCuu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XoaDuLieuNhap(){
        tfMaBHT.setText("");
        tfMaNV.setText("");
        tfTenBHT.setText("");
        cbxHieuLuc.setSelected(false);
    }
    
    private void cbxHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHieuLucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHieuLucActionPerformed

    private void cbxTraCuuHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTraCuuHieuLucActionPerformed
        // TODO add your handling code here:
        ArrayList<BangHoachToanDTO> listBHT = BangHoachToanBUS.LayDanhSachBHTCoHieuLuc();
        ShowDatas(listBHT);
    }//GEN-LAST:event_cbxTraCuuHieuLucActionPerformed

    private void tableBHTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBHTMouseClicked
        // TODO add your handling code here:
        btnChiTiet.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
        
         DefaultTableModel model = (DefaultTableModel)tableBHT.getModel();

        // get the selected row index
       int selectedRowIndex = tableBHT.getSelectedRow();
       
        // set the selected row data into jtextfields
       tfMaBHT.setText(model.getValueAt(selectedRowIndex, 0).toString());
       tfMaNV.setText(model.getValueAt(selectedRowIndex, 1).toString());       
       tfTenBHT.setText(model.getValueAt(selectedRowIndex, 2).toString());
       dcNgayTao.setDate(DateBUS.GetDate(model.getValueAt(selectedRowIndex, 3).toString()));
       String hieuLuc = model.getValueAt(selectedRowIndex, 4).toString();
       if (hieuLuc.equals("Có")){
           cbxHieuLuc.setSelected(true);
       }
       else cbxHieuLuc.setSelected(false);
    }//GEN-LAST:event_tableBHTMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        XoaDuLieuNhap();
        tfMaBHT.setText(BangHoachToanBUS.LayMaBHTMoi());
        tfMaNV.setText(quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.MANV);
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnChiTiet.setEnabled(false);
        dcNgayTao.setDate(DateBUS.GetToDay());
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private String TextHieuLuu(){
        if (cbxHieuLuc.isSelected()) return "Có";
        return "Không";
    }
    
    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        frmChiTietHoachToan frmCTBHT = new frmChiTietHoachToan();
        frmCTBHT.Show(tfMaBHT.getText());
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        BangHoachToanDTO bht = new BangHoachToanDTO(tfMaBHT.getText(), tfMaNV.getText(), tfTenBHT.getText(), DateBUS.GetDateString(dcNgayTao), TextHieuLuu());
        ThongBaoDTO thongBao = BangHoachToanBUS.ThemBangHoachToan(bht);
        LoadDanhSachBangHoachToan();
        ShowThongBao(thongBao);
        if (thongBao.ThanhCong){
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        BangHoachToanDTO bht = new BangHoachToanDTO(tfMaBHT.getText(), tfMaNV.getText(), tfTenBHT.getText(), DateBUS.GetDateString(dcNgayTao), TextHieuLuu());
        ThongBaoDTO thongBao = BangHoachToanBUS.XoaBangHoachToan(bht);
        LoadDanhSachBangHoachToan();
        ShowThongBao(thongBao);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        BangHoachToanDTO bht = new BangHoachToanDTO(tfMaBHT.getText(), tfMaNV.getText(), tfTenBHT.getText(), DateBUS.GetDateString(dcNgayTao), TextHieuLuu());
        ThongBaoDTO thongBao = BangHoachToanBUS.SuaBangHoachToan(bht);
        LoadDanhSachBangHoachToan();
        ShowThongBao(thongBao);
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLyBangHoachToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyBangHoachToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyBangHoachToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyBangHoachToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyBangHoachToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTraCuu;
    private javax.swing.JCheckBox cbxHieuLuc;
    private javax.swing.JCheckBox cbxTraCuuHieuLuc;
    private com.toedter.calendar.JDateChooser dcNgayTao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tableBHT;
    private javax.swing.JTextField tfMaBHT;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfTenBHT;
    // End of variables declaration//GEN-END:variables
}
