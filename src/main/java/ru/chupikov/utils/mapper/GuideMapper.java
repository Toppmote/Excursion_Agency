package ru.chupikov.utils.mapper;

import ru.chupikov.dto.GuideModel;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.GuideForm;
import ru.chupikov.utils.DateUtils;
import ru.chupikov.utils.ImgTransformationUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для преобразования сущностей объектов экскурсоводов в модель и обратно
 */
public class GuideMapper {

    /**
     * Статический метод преобразования сущности экскурсовода в модель
     *
     * @param guideEntity сущность экскурсовода
     * @return канальная модель экскурсовода
     */
    public static GuideModel entityToModel(GuideEntity guideEntity) {
        ImgTransformationUtils imgTransformationUtils = ImgTransformationUtils.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(guideEntity.getBirthdate());
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String prettyBirthdate = simpleDateFormat.format(guideEntity.getBirthdate());
        return GuideModel.builder()
                .id(guideEntity.getId())
                .name(guideEntity.getName())
                .surname(guideEntity.getSurname())
                .description(guideEntity.getDescription())
                .photo("data:image/jpeg;base64," + imgTransformationUtils.byteToBase64(guideEntity.getPhoto()))
                .birthdate(date)
                .prettyBirthdate(prettyBirthdate)
                .build();
    }

    /**
     * Статический метод преобразования списка сущностей экскурсоводов в список канальных моделей
     *
     * @param guideEntities список экскурсоводов города
     * @return список канальных моделей экскурсоводов
     */
    public static List<GuideModel> entityListToModel(List<GuideEntity> guideEntities) {
        return guideEntities.stream().map(GuideMapper::entityToModel).collect(Collectors.toList());
    }

    /**
     * Статический метод преобразования формы ввода экскурсовода в сущность экскурсовода
     *
     * @param guideForm форма ввода экскурсовода
     * @return сущность экскурсовода
     */
    public static GuideEntity formToEntity(GuideForm guideForm) {
        return GuideEntity.builder()
                .id(guideForm.getId())
                .name(guideForm.getName())
                .surname(guideForm.getSurname())
                .description(guideForm.getDescription())
                .birthdate(DateUtils.parseDate(guideForm.getBirthdate()))
                .build();
    }

}
