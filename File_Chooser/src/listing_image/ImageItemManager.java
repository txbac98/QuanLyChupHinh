/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listing_image;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageItemManager {
    
    
    public JPanel targetPanel;
    
    public ArrayList<ImageItem> imageItems;
    public ArrayList<ImageItem> selectedItems;
    
    
    // list of the selected item
    public ArrayList<ImageItem> getSelectedItems(){
        return this.selectedItems;
    }
    
    private GridImageAdapter gridAdapter;
    
    public ImageItemManager() {
        this.initialize();
        
    }
    
    private void initialize() {
        this.imageItems = new ArrayList<>();
        this.selectedItems = new ArrayList<>();
        this.gridAdapter = new GridImageAdapter();
        
        this.gridAdapter.setListItem(imageItems);
    }
    
    
    // update cell size (you need to call revalidate() )
    public ImageItemManager setCellSize(int width) {
        this.gridAdapter.setCellSize(width);
        
        
        
        return this;
    }
    
    public ImageItemManager setTarget(JPanel newTarget){
        this.targetPanel = newTarget;
        this.gridAdapter.setTarget(newTarget);
        return this;
    }
    
    // --------- MAIN PROCESSING ----------------
    public ImageItemManager processPath(String[] datas) {
        
        if(this.targetPanel == null) {
            System.out.println("NO TARGET PANEL!");
            return this;
        }
        
        int count = datas.length;
        ImageItem tmpItem;
        
        int i;
        for(i = 0; i < count; ++i){
            if(i == this.imageItems.size()){
                
                tmpItem = new ImageItem();
                tmpItem.setManager(this);
                // TODO! add to the panel
                this.imageItems.add(tmpItem);
                
                this.gridAdapter.addNewItem(tmpItem);
                this.targetPanel.add(tmpItem);
            }
            else {
                tmpItem = this.imageItems.get(i);
            }
            
            this.processImageModel(tmpItem.getModel(), datas[i], i);
            tmpItem.refreshImage();
            tmpItem.setVisible(true);
        }
        
        count = this.imageItems.size();
        for(; i < count; ++i){
            tmpItem = this.imageItems.get(i);
            tmpItem.setVisible(false);
        }
        
        this.targetPanel.revalidate();
        return this;
    }
    
    
    private void processImageModel(ImageItem.Model selectedModel, String fullPath, int id) {
        
            File file = new File(fullPath);
            if(file.exists()){
                try {
                    selectedModel.image = ImageIO.read(file);
                } catch (IOException e) {
                    System.out.println(e);
                    selectedModel.image = null;
                }
            }
            else {
                System.out.println(Integer.toString(id) + " -Path not found: " + fullPath);
                selectedModel.image = null;
            }
            
            selectedModel.fullPath = fullPath;
            selectedModel.name = file.getName();
            selectedModel.id = id;
    }
    
    // called from the child
    public void onAnItemClicked(ImageItem theItem) {
        if(this.selectedItems.size() != 0){
            this.selectedItems.get(0).onDeselected();
            this.selectedItems.clear();
        }
        
        this.selectedItems.add(theItem);
        theItem.onSelected();
    }
}
