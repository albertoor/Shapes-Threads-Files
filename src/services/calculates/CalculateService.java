package services.calculates;

import config.UnitSetting;
import domain.*;
import enums.TypesShapesEnum;
import services.files.read.PropertyHandler;
import utils.ReadInputUtil;

public class CalculateService {
    private static UnitSetting unitSetting;

    public CalculateService(UnitSetting unitSetting) {
        this.unitSetting = unitSetting;
    }

    public String calculate(TypesShapesEnum typesShapesEnum, String str1) {
        String data = "";
        double value1 = ReadInputUtil.readDouble(str1, unitSetting.getUnit());
        double valUnit = getValueUnit(value1);
        switch (typesShapesEnum){
            case CIRCLE :
                data = new Circle(valUnit).getPropsMsg(unitSetting.getUnit());
                break;
            case SQUARE :
                data = new Square(valUnit).getPropsMsg(unitSetting.getUnit());
                break;
            case EQUILATERAL_TRIANGLE :
                data = new EquilateralTriangle(valUnit).getPropsMsg(unitSetting.getUnit());
                break;
            default : System.out.println("Shape not valid");
        }
        return data;
    }

    public String calculate(TypesShapesEnum typesShapesEnum, String str1, String str2) {
        String data = "";
        double value1 = ReadInputUtil.readDouble(str1, unitSetting.getUnit());
        double value2 = ReadInputUtil.readDouble(str2, unitSetting.getUnit());
        double valUnit1 = getValueUnit(value1);
        double valUnit2 = getValueUnit(value2);
        switch (typesShapesEnum){
            case RECTANGLE:
                data = new Rectangle(valUnit1, valUnit2).getPropsMsg(unitSetting.getUnit());
                break;
            case ISOSCELES_TRIANGLE:
                data = new IsoscelesTriangle(valUnit1, valUnit2).getPropsMsg(unitSetting.getUnit());
                break;
            default: System.out.println("Shape not valid");
        }
        return data;
    }

    public static double getValueUnit(double value) {
        String unitProp = PropertyHandler.readUnit();
        unitSetting.unit(unitProp);
        return unitSetting.getValueWithUnit(value, unitSetting.getUnit());
    }
}
