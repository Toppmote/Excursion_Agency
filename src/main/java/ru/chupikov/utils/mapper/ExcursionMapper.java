package ru.chupikov.utils.mapper;

import ru.chupikov.dto.ExcursionModel;
import ru.chupikov.entity.ExcursionEntity;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для преобразования сущностей города в модель и обратно
 */
public class ExcursionMapper {

    /**
     * Статический метод преобразования сущности экскурсии в модель
     *
     * @param excursionEntity сущность экскурсии
     * @return канальная модель экскурсии
     */
    public static ExcursionModel entityToModel(ExcursionEntity excursionEntity) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(excursionEntity.getDate());
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String prettyBirthdate = simpleDateFormat.format(excursionEntity.getDate());
        return ExcursionModel.builder()
                .id(excursionEntity.getId())
                .name(excursionEntity.getName())
                .date(date)
                .prettyDate(prettyBirthdate)
                .description(excursionEntity.getDescription())
                .guide(GuideMapper.entityToModel(excursionEntity.getGuide()))
                .city(CityMapper.entityToModel(excursionEntity.getCity()))
                .build();
    }

    /**
     * Статический метод преобразования списка сущностей экскурсий в список канальных моделей
     *
     * @param excursionEntities список сущностей экскурсий
     * @return список канальных моделей экскурсий
     */
    public static List<ExcursionModel> entityListToModel(List<ExcursionEntity> excursionEntities) {
        return excursionEntities.stream().map(ExcursionMapper::entityToModel).collect(Collectors.toList());
    }

    /**
     * Статический метод преобразования формы ввода экскурсии в сущность экскурсии
     *
     * @param excursionForm форма ввода экскурсии
     * @return сущность экскурсии
     */
    public static ExcursionEntity formToEntity(ExcursionForm excursionForm) {
        return ExcursionEntity.builder()
                .id(excursionForm.getId())
                .name(excursionForm.getName())
                .description(excursionForm.getDescription())
                .date(DateUtils.parseDate(excursionForm.getDate()))
                .build();
    }

}
