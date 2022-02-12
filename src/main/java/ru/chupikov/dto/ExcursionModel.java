package ru.chupikov.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * Модель сущности экскурсии для передачи данных на клиент
 */
@Builder
@Getter
public class ExcursionModel {

    private Long id;

    /**
     * Наименование экскурсии
     */
    private String name;

    /**
     * Описание экскурсии
     */
    private String description;

    /**
     * Дата проведения экскурсии
     */
    private String date;

    /**
     * Дата проведения экскурсии в красивом формате
     */
    private String prettyDate;

    /**
     * Экскурсовод
     */
    GuideModel guide;

    /**
     * Город
     */
    CityModel city;

}
