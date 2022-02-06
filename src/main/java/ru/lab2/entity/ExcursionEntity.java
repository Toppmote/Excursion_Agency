package ru.lab2.entity;

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
@Table(name = "guide")
public class ExcursionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Наименование экскурсии
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание экскурсии
     */
    @Column(name = "description")
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
    @JoinColumn(name="guide_id", nullable=false)
    GuideEntity guide;

    /**
     * Связь много-к-одному для города
     */
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    CityEntity city;

}
