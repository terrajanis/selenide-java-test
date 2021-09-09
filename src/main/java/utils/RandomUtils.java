package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomUtils {

    public static String getRandomEmail() {
        return String.format("tests%s@gmail.com", getDateNow());
    }

    public static String getDateNow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
        return LocalDateTime.now().format(formatter);
    }
}
