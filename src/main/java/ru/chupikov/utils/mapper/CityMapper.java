package ru.chupikov.utils.mapper;

import ru.chupikov.entity.CityEntity;
import ru.chupikov.dto.CityModel;
import ru.chupikov.form.CityForm;
import ru.chupikov.utils.ImgTransformationUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для преобразования сущностей города в модель и обратно
 */
public class CityMapper {

    /**
     * Статический метод преобразования сущности города в модель
     *
     * @param cityEntity сущность города
     * @return канальная модель города
     */
    public static CityModel entityToModel(CityEntity cityEntity) {
        ImgTransformationUtils imgTransformationUtils = ImgTransformationUtils.getInstance();
        return CityModel.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .description(cityEntity.getDescription())
                .places(cityEntity.getPlaces())
                .photo("data:image/jpeg;base64," + imgTransformationUtils.byteToBase64(cityEntity.getPhoto()))
                .build();
    }

    /**
     * Статический метод преобразования списка сущностей городов в список канальных моделей
     *
     * @param cityEntities список сущностей городов
     * @return список канальных моделей городов
     */
    public static List<CityModel> entityListToModel(List<CityEntity> cityEntities) {
        return cityEntities.stream().map(CityMapper::entityToModel).collect(Collectors.toList());
    }

    /**
     * Статический метод преобразования формы ввода города в сущность города
     *
     * @param cityForm форма ввода города
     * @return сущность города
     */
    public static CityEntity formToEntity(CityForm cityForm) {
        return CityEntity.builder()
                .id(cityForm.getId())
                .name(cityForm.getName())
                .description(cityForm.getDescription())
                .places(cityForm.getPlaces())
                .build();
    }

}
