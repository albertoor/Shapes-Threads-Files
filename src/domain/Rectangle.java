package domain;

import interfaces.Shape;
import java.text.NumberFormat;

import static constants.ShapeMessages.PROPS_RECTANGLE;
import static constants.ShapeMessages.UNIT;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return (width * 2) + (height * 2);
    }

    @Override
    public String getPropsMsg(String unit) {
        NumberFormat f = NumberFormat.getInstance();
        return String.format(PROPS_RECTANGLE, unit, f.format(width), f.format(height),
            f.format(calculatePerimeter()), f.format(calculateArea()));
    }
}
