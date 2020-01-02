package listing_image;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
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
    
    
    //private GridLayout gridLayout;
    
    // need to be setted from the host
    private ArrayList<ImageItem> items;
    
    public GridImageAdapter() {
    }
    
    public GridImageAdapter setTarget(JPanel newTarget){
        this.targetPanel = newTarget;
        
        //this.targetPanel.addComponentListener(this);
        //this.gridLayout = new GridLayout(0, this.columnCount);
        //this.targetPanel.setLayout(gridLayout);
        
        return this;
    }
    
    public GridImageAdapter setListItem(ArrayList<ImageItem> items){
        this.items = items;
        return this;
    }
    
    public GridImageAdapter setCellSize(int cellWidth){
        this.cellWidth = cellWidth;
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
        ImageItem tmpItem;
        Point p = new Point();
        
        int index = 0;
        
        for(int i = 0; i < count; ++i) {
            tmpItem = this.items.get(i);
            
            if(!tmpItem.isVisible())
            {
                continue;
            }
            
            tmpItem.setNewSize(this.cellWidth);
            p.x = index % this.columnCount * (this.cellWidth + 10);
            p.y = index / this.columnCount * (this.cellWidth + 30);
            tmpItem.setLocation(p);
            ++index;
        }
    }
    
    public void refreshChildren() {
        this.panelWidth = this.targetPanel.getSize().width;
        
        this.columnCount = this.panelWidth / (this.cellWidth + 10) - 1;
        //this.gridLayout.setColumns(this.columnCount);
        
        // set row count
        if(this.items.size() > 0) {
            int rowCount = this.items.size() / this.columnCount;
            int panelHeight = rowCount * (this.cellWidth + 30);
            this.targetPanel.setSize(this.panelWidth, panelHeight);
        }
        else
        {
            this.targetPanel.setSize(this.panelWidth, 0);
        }
        
        
        
        
        this.updateChildrenSize();
        
        
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
