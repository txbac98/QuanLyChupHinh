/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietPhieuChupBUS;
import BUS.PhieuChupBUS;
import DTO.ChiTietPhieuChupDTO;
import DTO.PhieuChupDTO;
import DTO.ThongBaoDTO;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import listing_image.*;

/**
 *
 * @author 16520
 */
public class frmCapNhatPhieuChup extends javax.swing.JFrame {

    private ImageItemManager manager;
    public ImageItemManager getManager(){
        return this.manager;
    }
    /**
     * Creates new form frmHoanThanhPhieuChup
     */
    public frmCapNhatPhieuChup() {
        initComponents();
        this.initImageGrid();
    }
    
    private frmQuanLyPhieuChup frmQLPC;
    public void Show(PhieuChupDTO phieuChup, frmQuanLyPhieuChup qlpc, boolean coThaHinh){
        tfMaPC.setText(phieuChup.MAPC);
        cbxTrangThai.setSelectedItem(phieuChup.TRANGTHAI);
        frmQLPC = qlpc;
        this.setVisible(true);
        
        XoaThongBao();
        SERVICEFORM.Form.centreWindow(this);
        LoadHinhAnhPhieuChup(phieuChup.MAPC);
        
        
        
        if (phieuChup.TRANGTHAI.equals("Đã giao ảnh")){
            cbxTrangThai.setEnabled(false);
            lbThaHinh.setVisible(false);
            btnXacNhan.setEnabled(false);
        }
        else{
           if (coThaHinh)        
            {
                this.modifyLbThaHinh();
            }
            else {
                lbThaHinh.setVisible(false);
            } 
        }
        
            
    }

    
    
    private void initImageGrid(){
        
        // create the manager 
        this.manager = new ImageItemManager();
        // manager register component
        this.manager.setTarget(this.panelImageList);
        this.manager.setCellSize(100);
        
        // get the selected item in run-time
        //ArrayList<Imageitem> selectedItems = this.manager.getSelectedItems();
        // customize `ImageItem` for further use

        // refresh the screen
        this.revalidate();
    }
    
    
    public void modifyLbThaHinh(){
        TransferHandler th = new TransferHandler(){

            @Override
            public boolean canImport(JComponent comp, DataFlavor[] transferFlavors){
                return true;
            }

            @Override
            public boolean importData(JComponent comp, Transferable t){

                try {             
                    
                    List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    AddFiles(files);
                    System.out.println(files.size());
                }catch (UnsupportedFlavorException ex){
                    System.out.print(ex);
                }catch (IOException ex){
                    System.out.print(ex);
                }
                ShowDatas();
                return true;
            }
        };
        lbThaHinh.setTransferHandler(th);
    }

    private ArrayList<String> listPath;
    
    private void AddFiles(List<File> files){
        if (files == null) return;
        
        for (File file : files){
            AddPath(file.getPath());
        }
    }
    
    private void AddPath(String path){
        if (listPath==null) listPath = new ArrayList<String>();
        if (listPath.contains(path)) return;
        listPath.add(path);       
    }
    
    
    
    private void LoadHinhAnhPhieuChup(String MaPC){
        listPath = ChiTietPhieuChupBUS.LoadListPathInFolder(MaPC);    
        if (listPath==null) return;               
        ShowDatas();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfMaPC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox();
        tfSoLuongAnh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();
        lbThaHinh = new javax.swing.JLabel();
        jScrollPanel = new javax.swing.JScrollPane();
        panelImageList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        panelInfo.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Mã phiếu chụp:");

        tfMaPC.setEditable(false);
        tfMaPC.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Trạng thái:");

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chưa có ảnh", "Chưa chỉnh sửa", "Sẵn sàng in", "Đã in", "Đã giao ảnh" }));

        tfSoLuongAnh.setEditable(false);
        tfSoLuongAnh.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Số lượng ảnh:");

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RES/iconfinder_Save_27876.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lbThongBao.setText("Thông báo");

        lbThaHinh.setText("           Thả hình ảnh tại đây");
        lbThaHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(tfSoLuongAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 6, Short.MAX_VALUE))
                        .addGroup(panelInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbThaHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMaPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSoLuongAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lbThaHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbThongBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        jScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelImageList.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelImageListLayout = new javax.swing.GroupLayout(panelImageList);
        panelImageList.setLayout(panelImageListLayout);
        panelImageListLayout.setHorizontalGroup(
            panelImageListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelImageListLayout.setVerticalGroup(
            panelImageListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        jScrollPanel.setViewportView(panelImageList);

        jLabel2.setText("Hình ảnh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:

        ArrayList<String> listNameDeleted = new ArrayList<String>();

        if (manager.deletedNames!=null)
        {
                for(String deletedName : manager.deletedNames )
                {
                listNameDeleted.add(deletedName);
            }
        }
        if (listPath!=null){
            listPath.clear();
        }
        listPath = new ArrayList<String>();
        
        if (manager.imageItems!=null)
        {
                for(ImageItem item : manager.imageItems )
                {
                listPath.add(item.model.fullPath);
            }
        }
        
        
        ChiTietPhieuChupBUS.XoaHinhAnh(tfMaPC.getText(), listNameDeleted);

        tfSoLuongAnh.setText(listPath.size() +"");
        
        if (listPath.size()==0) cbxTrangThai.setSelectedIndex(0);
        
        //ThongBao thongBao = PhieuChupBUS.SuaPhieuChup(new PhieuChup(tfMaPC.getText(), tfMaK))
        ThongBaoDTO thongBao = PhieuChupBUS.SuaTrangThaiPhieuChup(tfMaPC.getText(), cbxTrangThai.getSelectedItem().toString());
        
        ShowThongBao(thongBao);
        
        thongBao = ChiTietPhieuChupBUS.LuuCTPC(new ChiTietPhieuChupDTO(tfMaPC.getText(),tfSoLuongAnh.getText()));
        ShowThongBao(thongBao);
        
        ChiTietPhieuChupBUS.LuuHinhAnh(tfMaPC.getText(), listPath);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void ShowDatas(){
        String[] datas = new String[listPath.size()];
        datas = listPath.toArray(datas);
        tfSoLuongAnh.setText(datas.length+"");
        this.manager.processPath(datas);
        this.revalidate();
        
        if (cbxTrangThai.getSelectedIndex()==0){
            cbxTrangThai.setSelectedIndex(1);
        }
    }
    
    private void XoaThongBao(){
        lbThongBao.setText("");
    }
    
    private void ShowThongBao(ThongBaoDTO thongBao){
        lbThongBao.setText(thongBao.ChuThich);
        if (thongBao.ThanhCong){
            lbThongBao.setForeground(Color.GREEN);
            if (frmQLPC!=null)
                frmQLPC.LoadDanhSachPhieuChup();
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
            java.util.logging.Logger.getLogger(frmCapNhatPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatPhieuChup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCapNhatPhieuChup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JLabel lbThaHinh;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JPanel panelImageList;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JTextField tfMaPC;
    private javax.swing.JTextField tfSoLuongAnh;
    // End of variables declaration//GEN-END:variables
}
