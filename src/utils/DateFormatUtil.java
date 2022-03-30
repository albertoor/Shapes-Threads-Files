package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatUtil {
    public String getCurrentDate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateObj.format(formatter);
    }
}
