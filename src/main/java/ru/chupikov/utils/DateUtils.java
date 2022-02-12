package ru.chupikov.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс утильных методов для работы с датами
 */
@Slf4j
public class DateUtils {

    /**
     * Метод маппинга строки даты формата yyyy-MM-dd в объект даты
     *
     * @param date строка даты
     * @return объект даты
     */
    public static Date parseDate(String date) {
        log.info("[DateUtils]\tEntered parseDate method");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateObj = simpleDateFormat.parse(date);
            log.info("[DateUtils]\tReturning date object");
            return dateObj;
        } catch (Exception e) {
            log.error(e.getMessage());
            return new Date();
        }
    }

}
