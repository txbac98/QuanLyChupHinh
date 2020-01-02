package listing_image;


import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class PopupListingImage extends JPopupMenu {
    
    
    private final ImageItemManager host;

    JMenuItem deleter;
    public PopupListingImage(ImageItemManager h) {
        this.host = h;
        
        deleter = new JMenuItem("Delete item");
        deleter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        deleter.addActionListener(event -> host.onMenuDeleteSelected());
        this.add(deleter);
    }
    
    
}
