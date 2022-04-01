package enums;

import constants.MenuMessages;
import constants.ShapeMessages;

public enum TypesShapesEnum {
    CIRCLE(ShapeMessages.CIRCLE,1),
    SQUARE(ShapeMessages.SQUARE, 2),
    RECTANGLE(ShapeMessages.RECTANGLE, 3),
    EQUILATERAL_TRIANGLE(ShapeMessages.EQUILATERAL_TRIANGLE, 4),
    ISOSCELES_TRIANGLE(ShapeMessages.ISOSCELES_TRIANGLE, 5);

    private final String optionName;
    private final int option;

    TypesShapesEnum(String optionName, int option) {
        this.optionName = optionName;
        this.option = option;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getOption() {
        return option;
    }
}
