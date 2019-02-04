import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class Controller implements MouseWheelListener {

    private View view;

    public Controller(View view) {
        this.view = view;
        this.view.addMouseWheelListener(this);
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
}