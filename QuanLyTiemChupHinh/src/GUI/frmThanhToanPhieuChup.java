/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BangHoachToanBUS;
import BUS.ChiTietHoachToanBUS;
import BUS.ChuongTrinhUuDaiBUS;
import BUS.DateBUS;
import BUS.PhieuChupBUS;
import BUS.PhieuThanhToanBUS;
import DTO.BangHoachToanDTO;
import DTO.ChiTietHoachToanDTO;
import DTO.ChiTietPhieuChupDTO;
import DTO.ChuongTrinhUuDaiDTO;
import DTO.PhieuChupDTO;
import DTO.PhieuThanhToanDTO;
import DTO.ThongBaoDTO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
/**
 *
 * @author 16520
 */
public class frmThanhToanPhieuChup extends javax.swing.JFrame {

    /**
     * Creates new form frmThanhToanPhieuChup
     */
    public frmThanhToanPhieuChup() {
        initComponents();
        LoadData();  //test
    }

    
    
    public void Show(PhieuChupDTO phieuChup, frmQuanLyPhieuChup qlpc){
        this.setVisible(true);
        SERVICEFORM.Form.centreWindow(this);
        pc = phieuChup;
        frmQLPC= qlpc;
        LoadData();
        XoaThongBao();
    }
    
    frmQuanLyPhieuChup frmQLPC;
    PhieuChupDTO pc = new PhieuChupDTO();
    ChiTietPhieuChupDTO ctpc = new ChiTietPhieuChupDTO();
    ArrayList<ChuongTrinhUuDaiDTO> ctud;
    ArrayList<BangHoachToanDTO> bht;
    ArrayList<ChiTietHoachToanDTO> ctht;
    
    ChiTietHoachToanDTO cthtSelected = new ChiTietHoachToanDTO();
    ChuongTrinhUuDaiDTO ctudSelected = new ChuongTrinhUuDaiDTO();
    
    private void LoadData(){     
        
        tfMaPC.setText(pc.MAPC);
        tfMaKH.setText(pc.MAKH);
        tfMaNV.setText(quanlytiemchuphinh.QuanLyTiemChupHinh.taiKhoanDangNhap.MANV);
        ctpc = PhieuChupBUS.LayCTPC(pc.MAPC);
        if (ctpc!=null){
            tfSoLuongAnh.setText(ctpc.SOANH);
        }
        tfNgayThanhToan.setText(DateBUS.GetToDayString());
        
        tfMaPTT.setText(PhieuThanhToanBUS.LayMaMoi());
        
        LoadBHT();
        LoadCTHT();
        LoadCTUD();           
        TinhSoTien();
        
        if (ctht!=null && ctht.size() >0) btnThanhToan.setEnabled(true);
        else btnThanhToan.setEnabled(false);
    }
    
    
    double soTien=0;
    float uuDai=0;
    long soAnh=0;
    long gia=0;
    private void TinhSoTien(){      
        
        try{      
            if (ctht!=null && ctht.size()>0){
                cthtSelected = ctht.get(cbxCTHT.getSelectedIndex());
                gia = Long.parseLong(cthtSelected.GIA);
            }
            
            soAnh = Long.parseLong(tfSoLuongAnh.getText());
            
            if (ctud!=null && ctud.size()>0){
                if (cbxCTUD.getSelectedIndex()>0){
                    ctudSelected = ctud.get(cbxCTUD.getSelectedIndex()-1);
                    if (cthtSelected!=null){
                        uuDai = Float.parseFloat(ctudSelected.GIATRIUUDAI);
                    }
                    else {
                        uuDai =0;
                    }
                }
                else {
                        uuDai =0;
                }
            }               
            
         }
        catch(NumberFormatException e){  
        }
        
        soTien =  (double)gia* (double)soAnh;
        soTien = soTien - (soTien/100)*uuDai;
        
        tfTongSoTien.setText((long)soTien+"");
    }
    
    private void LoadBHT(){
        bht= BangHoachToanBUS.LayDanhSachBHTCoHieuLuc();
        ArrayList<String> strBHT = new ArrayList<>();
        if (bht!=null){
            for (int i=0; i< bht.size(); i++){
            strBHT.add(bht.get(i).TENBHT);
        }
        List<String> ls = new ArrayList<String>(strBHT); 
        cbxBHT.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
        }      
    }
    
    private void LoadCTHT(){      
        if (bht!=null && bht.size()>0){
            int indexBHT = cbxBHT.getSelectedIndex();
            ctht= ChiTietHoachToanBUS.LayDanhSachChiTietHoachToan(bht.get(indexBHT).MABHT);
            ArrayList<String> strCTHT = new ArrayList<>();
            if (ctht!=null)
            {                   
                for (int i=0; i< ctht.size(); i++){
                    strCTHT.add(ctht.get(i).NOIDUNG + ": " + ctht.get(i).GIA);
                }
                List<String> ls = new ArrayList<String>(strCTHT); 
                cbxCTHT.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
            }
        }     
    }
    
    private void LoadCTUD(){
        ctud= ChuongTrinhUuDaiBUS.LayDanhSachCTUDDangApDung();
        ArrayList<String> strCTUD = new ArrayList<>();
        if (ctud!=null && ctud.size()>0)
        {
            for (int i=0; i< ctud.size(); i++){
                strCTUD.add(ctud.get(i).TENCTUD +": "+ ctud.get(i).GIATRIUUDAI +" %");
            }
            List<String> ls = new ArrayList<String>(strCTUD); 
            ls.add(0, "Không áp dụng");
            cbxCTUD.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
            cbxCTUD.setSelectedIndex(0);
        }     
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        tfMaPTT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfMaPC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMaKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSoLuongAnh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxBHT = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbxCTHT = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbxCTUD = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfNgayThanhToan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTongSoTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel9.setText("Mã PTT:");

        tfMaPTT.setEditable(false);
        tfMaPTT.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Mã PC:");

        tfMaPC.setEditable(false);
        tfMaPC.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Mã KH:");

        tfMaKH.setEditable(false);
        tfMaKH.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setText("Mã NV:");

        tfMaNV.setEditable(false);
        tfMaNV.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Số lượng ảnh:");

        tfSoLuongAnh.setEditable(false);
        tfSoLuongAnh.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Bảng hoạch toán:");

        cbxBHT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBHTItemStateChanged(evt);
            }
        });

        jLabel5.setText("Chi tiết:");

        cbxCTHT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCTHTItemStateChanged(evt);
            }
        });

        jLabel6.setText("Chương trình ưu đãi:");

        cbxCTUD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Không áp dụng" }));
        cbxCTUD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCTUDItemStateChanged(evt);
            }
        });

        jLabel7.setText("Ngày thanh toán:");

        tfNgayThanhToan.setEditable(false);
        tfNgayThanhToan.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("Tổng số tiền:");

        tfTongSoTien.setEditable(false);
        tfTongSoTien.setBackground(new java.awt.Color(204, 204, 204));

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lbThongBao.setText("Thong bao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbThongBao)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbxBHT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(cbxCTHT, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCTUD, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnThanhToan)
                        .addComponent(tfTongSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfSoLuongAnh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(tfMaPTT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMaPTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfSoLuongAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxBHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbxCTHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbxCTUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(tfNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(tfTongSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbThongBao)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxBHTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBHTItemStateChanged
        // TODO add your handling code here:
        LoadCTHT();
        TinhSoTien();
    }//GEN-LAST:event_cbxBHTItemStateChanged

    private void cbxCTHTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCTHTItemStateChanged
        // TODO add your handling code here:
        TinhSoTien();
    }//GEN-LAST:event_cbxCTHTItemStateChanged

    private void cbxCTUDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCTUDItemStateChanged
        // TODO add your handling code here:
        TinhSoTien();
    }//GEN-LAST:event_cbxCTUDItemStateChanged

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        PhieuThanhToanDTO ptt = new PhieuThanhToanDTO(tfMaPTT.getText(), tfMaPC.getText(), tfMaKH.getText(), tfMaNV.getText(), tfSoLuongAnh.getText(), cbxBHT.getSelectedItem().toString(), cbxCTHT.getSelectedItem().toString(), cbxCTUD.getSelectedItem().toString(), tfNgayThanhToan.getText(), tfTongSoTien.getText());
        ThongBaoDTO thongBao = PhieuThanhToanBUS.ThemPTT(ptt);
        ShowThongBao(thongBao);
        
        if (thongBao.ThanhCong){
            frmQLPC.ThanhToanPhieuChup();
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(frmThanhToanPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThanhToanPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThanhToanPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThanhToanPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThanhToanPhieuChup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox cbxBHT;
    private javax.swing.JComboBox cbxCTHT;
    private javax.swing.JComboBox cbxCTUD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfMaPC;
    private javax.swing.JTextField tfMaPTT;
    private javax.swing.JTextField tfNgayThanhToan;
    private javax.swing.JTextField tfSoLuongAnh;
    private javax.swing.JTextField tfTongSoTien;
    // End of variables declaration//GEN-END:variables
}
