package listing_image;

import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class PopupListingImage extends JPopupMenu {
    
    
    private final ImageItemManager host;

    JMenuItem deleter;
    public PopupListingImage(ImageItemManager h) {
        this.host = h;
        
        deleter = new JMenuItem("Remove item from here");
        //deleter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        deleter.addActionListener(a -> host.onMenuDeleteSelected());
        this.add(deleter);
    }
    
    
}
