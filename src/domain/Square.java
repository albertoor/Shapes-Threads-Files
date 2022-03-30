package domain;

import interfaces.Shape;

import java.text.NumberFormat;
import static constants.ShapeMessages.PROPS_SQUARE;
import static constants.ShapeMessages.UNIT;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        NumberFormat f = NumberFormat.getInstance();
        return String.format(PROPS_SQUARE, UNIT, f.format(side),
            f.format(calculatePerimeter()), f.format(calculateArea()));
    }
}
