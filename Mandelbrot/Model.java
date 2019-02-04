import java.awt.Color;

public class Model {

    public static final int calculateColor(float x, float y) {
        float cx = Constant.FLOWER_FRACTALE.r;
        float cy = Constant.FLOWER_FRACTALE.i;

        float nx, ny;
        int i;

        for(i = 0; i < Constant.MAX_ITERATIONS; i++) {
            nx = x * x - y * y + cx;
            ny = 2 * x * y + cy;
            x = nx;
            y = ny;

            if((x * x + y * y) > 4) break;
        }

        if(i == Constant.MAX_ITERATIONS) {
            return 0x00000000;
        }

        return Color.HSBtoRGB((float)i / Constant.MAX_ITERATIONS, 0.5f, 1);
    }
}