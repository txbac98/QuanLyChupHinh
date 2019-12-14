/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listing_image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


 
public class ImageItem extends JLabel {
    
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
    
    
    private int w, h;
    
    public ImageItem(){
        
        this.myListener = new ImageItemListener(this);
        this.addMouseListener(this.myListener);
        this.addComponentListener(this.myListener);
        
        this.model = new Model();
        
        //this.setHorizontalTextPosition(JLabel.CENTER);
        //this.setVerticalTextPosition(JLabel.BOTTOM);
    }
    
    public ImageItem setManager(ImageItemManager m){
        this.manager = m;
        return this;
    }
    
    
    
    public void onResized(){
        
        Dimension d = this.getSize();
        this.refreshImage();
    }
    
    public void refreshImage() {
        if(this.model.image == null)
            return;
        ImageIcon ico;
        
        float originalWidth = this.model.image.getWidth();
        float originalHeight = this.model.image.getHeight();
        float wPerH = originalHeight / originalHeight;
        
        float myW = this.getWidth();
        float myH = this.getHeight();
        
        if((myW/myH) > wPerH)// the original image has the height taller than me => cap the height
        {// new width
            originalWidth = originalWidth * (myH / originalHeight);
            
            ico =  new ImageIcon(this.model.image.getScaledInstance((int)originalWidth, (int)myH, 12));
        }
        else// the original image has the width longer than me => cap the width
        {
            originalHeight = originalHeight * (myW / originalWidth);
            
            ico = new ImageIcon(this.model.image.getScaledInstance((int)myW, (int)originalHeight, 12));
        }
        
        this.setIcon(ico);
        this.setText(this.model.name);
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
        this.setForeground(Color.red);
    }
    
    public void onDeselected(){
        this.setForeground(Color.black);
    }
}
