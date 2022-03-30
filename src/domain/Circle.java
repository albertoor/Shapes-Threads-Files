package domain;

import interfaces.Shape;
import static constants.ShapeMessages.PROPS_CIRCLE;
import static constants.ShapeMessages.UNIT;
import java.text.NumberFormat;

public class Circle implements Shape {
    private double ratio;

    public Circle(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.ratio, 2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (ratio * 2);
    }

    @Override
    public String toString() {
        NumberFormat f = NumberFormat.getInstance();
        return String.format(PROPS_CIRCLE, UNIT, f.format(ratio),
            f.format(calculatePerimeter()), f.format(calculateArea()));
    }
}

