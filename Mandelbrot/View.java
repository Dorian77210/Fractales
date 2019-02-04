import javax.swing.JComponent;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class View extends JComponent {

    private BufferedImage bufferedImage;

    private int scale;

    public View() {
        super();
        this.scale = Constant.SCALE;
        this.bufferedImage = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);

        Controller controller = new Controller(this);
    }

    @Override 
    public void paintComponent(Graphics p) {
        Graphics  g = p.create();
        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        int color;

        for(int x = 0; x < Constant.WIDTH; x++) {
            for(int y = 0; y < Constant.HEIGHT; y++) {
                color = Model.calculateColor((x - Constant.WIDTH / 2.0f) / this.scale,
                                             (y - Constant.HEIGHT / 2.0f) / this.scale
                );

                this.bufferedImage.setRGB(x, y, color);
            }
        }

        g.drawImage(this.bufferedImage, 0, 0, null);

    }

    public int getScale() {
        return this.scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}