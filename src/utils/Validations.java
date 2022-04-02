package utils;

public class Validations {
    public static boolean validateFileFormat (String str) {
        return str.matches("((?<!^,)\\d+(,(?!$)|$))+");
    }
}
