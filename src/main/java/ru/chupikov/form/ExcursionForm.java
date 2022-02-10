package ru.chupikov.form;

import lombok.Getter;
import lombok.Setter;

/**
 * Форма для получения экскурсии с клинета
 */
@Getter
@Setter
public class ExcursionForm {

    /**
     * ID экскурсии
     */
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
     * Дата проведения
     */
    private String date;

    /**
     * ID города, в котором проводится экскурсия
     */
    private Long cityId;

    /**
     * ID экскурсовода
     */
    private Long guideId;

}
