import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Controller implements MouseWheelListener, MouseListener {

    private View view;

    public Controller(View view) {
        this.view = view;
        this.view.addMouseWheelListener(this);
        this.view.addMouseListener(this);
    }

    @Override 
    public void mouseWheelMoved(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        if(rotation < 0) {
            this.view.setScale(this.view.getScale() + Constant.SCALE_ITERATION);
        } else {
            this.view.setScale(this.view.getScale() - Constant.SCALE_ITERATION);
        }

        this.view.repaint();
    }

    @Override 
    public void mouseClicked(MouseEvent event) {
        this.view.setPoint(event.getPoint());

        this.view.repaint();
    }

    @Override 
    public void mouseReleased(MouseEvent event) {

    }

    @Override 
    public void mousePressed(MouseEvent event) {

    }

    @Override 
    public void mouseEntered(MouseEvent event) {

    }

    @Override 
    public void mouseExited(MouseEvent event) {

    }
}