package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DateTimeUtils {

    // Định dạng chuẩn cho hệ thống (yyyy-MM-dd HH:mm:ss)
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String getDateTimePlusDays(int days) {
        return LocalDateTime.now().plusDays(days).format(FORMATTER);
    }

    public static String getDateTimePlusHours(int hours) {
        return LocalDateTime.now().plusHours(hours).format(FORMATTER);
    }

    public static String getDateTimePlusMinutes(int minutes) {
        return LocalDateTime.now().plusMinutes(minutes).format(FORMATTER);
    }


    public static String getDateTimePlusMonths(int months) {
        return LocalDateTime.now().plusMonths(months).format(FORMATTER);
    }
}
