package listing_image;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class ImageItemListener extends MouseAdapter implements ComponentListener{

    private final ImageItem host;
    
    public ImageItemListener(ImageItem host){
        this.host = host;
    }
    
    
    @Override
    public void componentResized(ComponentEvent e) {
        host.onResized();
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
    
    @Override
    public void mouseClicked(MouseEvent e)  {

        if(SwingUtilities.isLeftMouseButton(e))
        {
            if(e.isShiftDown()){
                host.onShiftLeftClick();
            }
            else if(e.isControlDown()){
                host.onCtrlLeftClick();
            }
            else{
                host.onLeftClick();
            }
        }
        else if(SwingUtilities.isRightMouseButton(e))
        {
            if(e.isControlDown()){
                host.onCtrlRightClick();
            }
            else {
                host.onRightClick();
            }
        }
        else if(SwingUtilities.isMiddleMouseButton(e))
        {
            host.onMiddleClick();
        }
    }
    
}
