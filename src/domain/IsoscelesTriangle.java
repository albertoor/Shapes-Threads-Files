package domain;

import abstracts.Triangle;
import interfaces.Shape;
import java.text.NumberFormat;
import static constants.ShapeMessages.PROPS_IS_T;


public class IsoscelesTriangle extends Triangle implements Shape {
    private double sideA;
    private double sideB;

    public IsoscelesTriangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return super.calculateArea(this.sideB, height);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * sideA) + sideB;
    }

    @Override
    public double calculateHeight() {
        double left = Math.pow(sideA, 2);
        double right = Math.pow(sideB, 2) / 4;
        return height = Math.sqrt(left - right);
    }

    @Override
    public String getPropsMsg(String unit) {
        NumberFormat f = NumberFormat.getInstance();
        return String.format(PROPS_IS_T, unit, f.format(sideA), f.format(sideB), f.format(calculateHeight()),
            f.format(calculatePerimeter()), f.format(calculateArea()));
    }
}

