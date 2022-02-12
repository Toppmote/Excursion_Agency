package ru.chupikov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Модель сущности экскурсовода для передачи данных на клиент
 */
@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class GuideModel {

    /**
     * ID экскурсовода
     */
    private long id;

    /**
     * Имя экскурсовода
     */
    private String name;

    /**
     * Фамилия экскурсовода
     */
    private String surname;

    /**
     * Описание экскурсовода
     */
    private String description;

    /**
     * Дата рождения экскурсовода
     */
    private String birthdate;

    /**
     * Дата рождения экскурсовода красивым форматом
     */
    private String prettyBirthdate;

    /**
     * Фотография экскурсовода
     */
    private String photo;

}
