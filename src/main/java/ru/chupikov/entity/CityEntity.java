package ru.chupikov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность города
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Наименование города
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание города
     */
    @Column(name = "description")
    private String description;

    /**
     * Список необычных мест
     */
    @Column(name = "places_list", nullable = false)
    private String places;

    /**
     * Фото города
     */
    @Column(name = "photo")
    private byte[] photo;

    /**
     * Связь один-ко-многим с экскурсиями
     */
    @OneToMany(mappedBy = "city")
    List<ExcursionEntity> excursions;

}
