package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return now.format(formatter);
    }
}
