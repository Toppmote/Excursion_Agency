package ru.chupikov.entity;

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
    private Long id;

    /**
     * Имя экскурсовода
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Фамилия экскурсовода
     */
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    /**
     * Дата рождения
     */
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    /**
     * Описание экскурсовода
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * Фото экскурсовода
     */
    @Column(name = "photo")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;

    /**
     * Связь один-ко-многим с экскурсиями
     */
    @OneToMany(mappedBy = "guide")
    List<ExcursionEntity> excursions;

}
