package ru.chupikov.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Форма регистрации нового города
 */
@Getter
@Setter
public class CityForm {

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
     * Фото города
     */
    private MultipartFile photo;

    /**
     * Список интересных мест
     */
    private String places;

}
