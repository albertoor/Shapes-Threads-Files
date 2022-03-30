package services.calculates;

import domain.*;
import enums.TypesShapesEnum;
import utils.ReadInputUtil;

public class AskingForValuesService  {
    public String askingValues(TypesShapesEnum typesShapesEnum, String str1, String str2) {
        String data = "";
        double value1 = ReadInputUtil.readDouble(str1, str2);
        switch (typesShapesEnum){
            case CIRCLE -> data = new Circle(value1).toString();
            case SQUARE -> data = new Square(value1).toString();
            case EQUILATERAL_TRIANGLE -> new EquilateralTriangle(value1).toString();
            default -> System.out.println("Shape not valid");
        }
        return data;
    }

    public String askingValues(TypesShapesEnum typesShapesEnum, String str1, String str2, String str3) {
        String data = "";
        double value1 = ReadInputUtil.readDouble(str1, str3);
        double value2 = ReadInputUtil.readDouble(str2, str3);
        switch (typesShapesEnum){
            case RECTANGLE:
                data = new Rectangle(value1, value2).toString();
                break;
            case ISOSCELES_TRIANGLE:
                data = new IsoscelesTriangle(value1, value2).toString();
                break;
            default: System.out.println("Shape not valid");
        }
        return data;
    }
}
