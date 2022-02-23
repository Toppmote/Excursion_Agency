package ru.chupikov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Модель сущности города для передачи данных на клиент
 */
@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CityModel {

    /**
     * ID города
     */
    private Long id;

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
