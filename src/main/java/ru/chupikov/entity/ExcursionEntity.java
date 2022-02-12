package ru.chupikov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность экскурсии
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "excursions")
public class ExcursionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование экскурсии
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Описание экскурсии
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * Дата проведения экскурсии
     */
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * Связь много-к-одному для экскурсовода
     */
    @ManyToOne
    @JoinColumn(name = "guide_id", nullable = false)
    GuideEntity guide;

    /**
     * Связь много-к-одному для города
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    CityEntity city;

}
