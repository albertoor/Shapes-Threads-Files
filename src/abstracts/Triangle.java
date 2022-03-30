package abstracts;

public abstract class Triangle {
    protected double height;
    public abstract double calculateHeight();
    public double calculateArea(double base, double height) {
        return (base * height) / 2;
    }
}
