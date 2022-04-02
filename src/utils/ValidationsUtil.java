package utils;

public class ValidationsUtil {
    public static boolean validateFileFormat (String str) {
        return str.matches("((?<!^,)\\d+(,(?!$)|$))+");
    }
}
