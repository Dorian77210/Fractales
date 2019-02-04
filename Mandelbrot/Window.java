import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Window extends JFrame {

    public Window() {
        super();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new View(), BorderLayout.CENTER);


        this.setSize(Constant.WIDTH, Constant.HEIGHT);
    }
}