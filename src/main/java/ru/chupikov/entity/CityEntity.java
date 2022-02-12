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
    private Long id;

    /**
     * Наименование города
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Описание города
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * Список необычных мест
     */
    @Column(name = "places_list", nullable = false, columnDefinition = "TEXT")
    private String places;

    /**
     * Фото города
     */
    @Column(name = "photo")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;

    /**
     * Связь один-ко-многим с экскурсиями
     */
    @OneToMany(mappedBy = "city")
    List<ExcursionEntity> excursions;

}
