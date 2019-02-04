import javax.swing.JComponent;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class View extends JComponent {

    private BufferedImage bufferedImage;

    private int scale;
    private Point point;


    public View() {
        super();
        this.scale = Constant.SCALE;
        this.bufferedImage = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);

        Controller controller = new Controller(this);

        this.point = new Point(0, 0);
    }

    @Override 
    public void paintComponent(Graphics p) {
        Graphics  g = p.create();
        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        this.bufferedImage = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);
        int color;


        int i = 0, j = 0;

        for(int x = this.point.x; x < Constant.WIDTH + this.point.x; x++) {
            j = 0;
            for(int y = this.point.y; y < Constant.HEIGHT + this.point.y; y++) {
                color = Model.calculateColor((x - Constant.WIDTH / 2.0f) / this.scale,
                                             (y - Constant.HEIGHT / 2.0f) / this.scale
                );

                this.bufferedImage.setRGB(i, j, color);
                j++;
            }
            i++;
        }

        g.drawImage(this.bufferedImage, 0, 0, null);

    }

    public int getScale() {
        return this.scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setPoint(Point p) {
        this.point = p;
        this.point.x -= Constant.WIDTH * 0.5;
        this.point.y -= Constant.HEIGHT * 0.5;
    }
}