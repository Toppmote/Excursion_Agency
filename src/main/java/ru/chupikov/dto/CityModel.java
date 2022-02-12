package ru.chupikov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Модель сущности города для передачи данных на клиент
 */
@Builder
@Getter
@AllArgsConstructor
public class CityModel {

    /**
     * ID города
     */
    private long id;

    /**
     * Наименование города
     */
    private String name;

    /**
     * Описание города
     */
    private String description;

    /**
     * Список необычных мест
     */
    private String places;

    /**
     * Фото города
     */
    private String photo;

}
