/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listing_image;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.JLabel;


 
public class ImageItem extends JComponent {
    
    public class Model {
        
        public int id;
        public String name;
        public String fullPath;
        public BufferedImage image;
    }
    
    private Model model;
    public Model getModel() {
        return this.model;
    }
    
    private ImageItemManager manager;
    
    private ImageItemListener myListener;
    
    private int cellTextHeight = 60;
    private int cellPadding = 10;
    private int cellWidth = 50;
    private int cellHeight = cellWidth + cellTextHeight;
    private int cellInnerSize = cellWidth - (cellPadding * 2);
    
    
    
    private JLabel lbImage;
    private JLabel lbName;
    
    private JLabel top, down, left, right;
    
    Color transparent = new Color( 0, 0, 0, 0 );
    
    public ImageItem(){
        
        this.myListener = new ImageItemListener(this);
        this.addMouseListener(this.myListener);
        this.addComponentListener(this.myListener);
        
        this.model = new Model();
        
        this.lbImage = new JLabel();
        this.add(lbImage);
        this.lbImage.setLocation(this.cellPadding, this.cellPadding);
        this.lbName = new JLabel();
        this.add(lbName);
        this.lbName.setLocation(this.cellPadding / 2, this.cellPadding + this.cellInnerSize + this.cellPadding / 2);
        this.lbName.setHorizontalAlignment(JLabel.CENTER);
        this.lbName.setVerticalAlignment(JLabel.TOP);
        
        this.initBorder();
    }
    
    private void initBorder() {
        this.top = new JLabel();
        this.add(top);
        this.top.setOpaque(true);
        this.top.setBackground(Color.white);
        
        this.down = new JLabel();
        this.add(down);
        this.down.setOpaque(true);
        this.down.setBackground(Color.white);
        
        this.left = new JLabel();
        this.add(left);
        this.left.setOpaque(true);
        this.left.setBackground(Color.white);
        
        this.right = new JLabel();
        this.add(right);
        this.right.setOpaque(true);
        this.right.setBackground(Color.white);
    }
    
    public ImageItem setManager(ImageItemManager m){
        this.manager = m;
        return this;
    }
    
    public void setNewSize(int newWidth){
        this.cellWidth = newWidth;
        this.cellHeight = newWidth + this.cellTextHeight;
        
        this.cellInnerSize = this.cellWidth - (this.cellPadding * 2);
        
        this.setSize(this.cellWidth, this.cellHeight);
        
        this.lbImage.setSize(this.cellInnerSize, this.cellInnerSize);
        
        this.refreshImage();
    }
    
    public void onResized(){
        
        //Dimension d = this.getSize();
        //this.refreshImage();
    }
    
    public void refreshImage() {
        if(this.model.image == null)
            return;
        ImageIcon ico;
        
        float originalWidth = this.model.image.getWidth();
        float originalHeight = this.model.image.getHeight();
        float wPerH = originalWidth / originalHeight;
        
        float myW = this.cellInnerSize;
        float myH = this.cellInnerSize;
        
        if((myW/myH) > wPerH)// the original image has the height taller than me => cap the height
        {// new width
            originalWidth = originalWidth * (myH / originalHeight);
            
            ico =  new ImageIcon(this.model.image.getScaledInstance((int)originalWidth, (int)myH, 12));
            
            int morePadding = (this.cellInnerSize - (int)originalWidth) / 2;
            this.lbImage.setLocation(this.cellPadding + morePadding, this.cellPadding);
        }
        else// the original image has the width longer than me => cap the width
        {
            originalHeight = originalHeight * (myW / originalWidth);
            
            ico = new ImageIcon(this.model.image.getScaledInstance((int)myW, (int)originalHeight, 12));
            
            int morePadding = (this.cellInnerSize - (int)originalHeight) / 2;
            this.lbImage.setLocation(this.cellPadding, this.cellPadding);
        }
        
        this.lbImage.setIcon(ico);
        
        String text = "<html><p>" + this.model.name + "</p></html>";
        this.lbName.setText(text);
        this.lbName.setLocation(this.cellPadding / 2, this.cellPadding + this.cellInnerSize + this.cellPadding);
        this.lbName.setSize(this.cellInnerSize + this.cellPadding, this.cellTextHeight - this.cellPadding / 2);
        
        this.refreshBorderSize();
    }
    
    private void refreshBorderSize(){
        this.top.setSize(this.cellWidth, this.cellPadding);
        this.top.setLocation(0, 0);
        
        this.down.setSize(this.cellWidth, this.cellPadding);
        this.down.setLocation(0, this.cellInnerSize + this.cellPadding);
        
        
        this.left.setSize(this.cellPadding, this.cellInnerSize + this.cellPadding * 2);
        this.left.setLocation(0, 0);
        
        this.right.setSize(this.cellPadding, this.cellInnerSize + this.cellPadding * 2);
        this.right.setLocation(this.cellInnerSize + this.cellPadding, 0);
    }
    
    public void onLeftClick(){
        this.manager.onAnItemClicked(this);
    }
    
    public void onCtrlLeftClick(){
        
    }
    
    public void onShiftLeftClick(){
        
    }
    
    public void onRightClick() {
        
    }
    
    public void onCtrlRightClick(){
        
    }
    
    public void onMiddleClick() {
        
    }
    
    
    public void onSelected(){
        this.top.setBackground(Color.blue);
        this.down.setBackground(Color.blue);
        this.left.setBackground(Color.blue);
        this.right.setBackground(Color.blue);
    }
    
    public void onDeselected(){
        this.top.setBackground(Color.white);
        this.down.setBackground(Color.white);
        this.left.setBackground(Color.white);
        this.right.setBackground(Color.white);
    }
}
