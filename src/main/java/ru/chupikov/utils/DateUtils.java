package ru.chupikov.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс утильных методов для работы с датами
 */
public class DateUtils {

    /**
     * Метод маппинга строки даты формата yyyy-MM-dd в объект даты
     *
     * @param date строка даты
     * @return объект даты
     */
    public static Date parseDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

}
