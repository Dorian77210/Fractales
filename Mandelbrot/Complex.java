public class Complex {

    public float r;
    public float i;

    public Complex(float r, float i) {
        this.r = r;
        this.i = i;
    }

    public Complex mul(Complex z, float cr, float ci) {
        float r = (this.r * this.r) + (this.i * this.i) + cr;
        float i = 2 * (this.i * this.r) + ci;

        return new Complex(r, i);
    }

    public boolean isBorned() {
        return ((this.r * this.r) + (this.i * this.i) < 4);
    }
}