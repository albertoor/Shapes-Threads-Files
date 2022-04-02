package services.files.read;

import java.io.*;
import java.util.Properties;

public class PropertyHandler {
    public static String readUnit() {
        String unit = null;
        try(InputStream input = new FileInputStream("./application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            unit = prop.getProperty("unit");
        } catch (IOException io) {
            io.printStackTrace();
        }
        return unit;
    }
}
