package ru.chupikov.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Форма для получения экскурсовода с клинета
 */
@Getter
@Setter
public class GuideForm {

    /**
     * ID экскурсовода
     */
    private Long id;

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
     * Фото экскурсовода
     */
    private MultipartFile photo;

    /**
     * Дата рождения
     */
    private String birthdate;

}
