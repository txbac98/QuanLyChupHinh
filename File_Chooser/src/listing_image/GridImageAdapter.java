package listing_image;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

// this will manage the icons - it will
public class GridImageAdapter implements ComponentListener {
    
    private int cellWidth;
    private int panelWidth;
    
    private int columnCount = 5;
    
    private JPanel targetPanel;
    
    
    private GridLayout gridLayout;
    
    // need to be setted from the host
    private ArrayList<ImageItem> items;
    
    public GridImageAdapter() {
    }
    
    public GridImageAdapter setTarget(JPanel newTarget){
        this.targetPanel = newTarget;
        
        this.targetPanel.addComponentListener(this);
        this.gridLayout = new GridLayout(0, this.columnCount);
        this.targetPanel.setLayout(gridLayout);
        
        return this;
    }
    
    public GridImageAdapter setListItem(ArrayList<ImageItem> items){
        this.items = items;
        return this;
    }
    
    public GridImageAdapter setCellSize(int cellWidth){
        this.cellWidth = cellWidth;
        this.updateChildrenSize();
        this.refreshChildren();
        return this;
    }
    
    public GridImageAdapter addNewItem(ImageItem newItem) {
        this.targetPanel.add(newItem);
        newItem.setNewSize(this.cellWidth);
        return this;
    }
    
    
    private void updateChildrenSize() {
        int count = this.items.size();
        for(int i = 0; i < count; ++i) {
            this.items.get(i).setNewSize(this.cellWidth);
        }
    }
    
    private void refreshChildren() {
        this.panelWidth = this.targetPanel.getSize().width;
        
        this.columnCount = this.panelWidth / this.cellWidth;
        this.gridLayout.setColumns(this.columnCount);
        
//        if(this.items.size() > 0) {
//            int rowCount = this.items.size() / this.columnCount;
//            int panelHeight = rowCount * (this.cellWidth + 20);
//            this.targetPanel.setSize(this.panelWidth, panelHeight);
//        }
        
        
        this.targetPanel.revalidate();
        
        
    }
    
    // when the panel resized
    @Override
    public void componentResized(ComponentEvent e) {
        this.refreshChildren();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }
    
    
    
    
}