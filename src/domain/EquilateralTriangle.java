package domain;

import abstracts.Triangle;
import interfaces.Shape;

import java.text.NumberFormat;

import static constants.ShapeMessages.*;

public class EquilateralTriangle extends Triangle implements Shape {
    private double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double calculateHeight() {
        return height = (side * Math.sqrt(3)) / 2;
    }

    @Override
    public double calculateArea() {
        return super.calculateArea(this.side, height);
    }

    @Override
    public double calculatePerimeter() {
        return 3 * side;
    }

    @Override
    public String toString() {
        NumberFormat f = NumberFormat.getInstance();
        return String.format(PROPS_EQ_T, UNIT, f.format(side), f.format(calculateHeight()),
            f.format(calculatePerimeter()), f.format(calculateArea()));
    }
}
