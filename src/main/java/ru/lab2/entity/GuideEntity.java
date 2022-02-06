package ru.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Сущность экскурсовода
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "guide")
public class GuideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Имя экскурсовода
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Фамилия экскурсовода
     */
    @Column(name = "surname", nullable = false)
    private String surname;

    /**
     * Дата рождения
     */
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    /**
     * Описание экскурсовода
     */
    @Column(name = "description")
    private String description;

    /**
     * Фото экскурсовода
     */
    @Column(name = "photo")
    private byte[] photo;

    /**
     * Связь один-ко-многим с экскурсиями
     */
    @OneToMany(mappedBy = "guide")
    List<ExcursionEntity> excursions;

}
