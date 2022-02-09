package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.CityRepository;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.form.CityForm;
import ru.chupikov.utils.ImgTransformationUtils;

import java.io.IOException;

/**
 * Сервис с Crud операциями для городов
 */
@Service
public class CityCrudService {

    @Autowired
    CityRepository cityRepository;

    /**
     * Процедура сохранения нового города
     *
     * @param cityForm форма нового города
     */
    @Transactional
    public void save(CityForm cityForm) throws IOException {
        CityEntity city = CityEntity.builder()
                .name(cityForm.getName())
                .description(cityForm.getDescription())
                .places(cityForm.getPlaces())
                .build();
        if (cityForm.getPhoto().getSize() == 0)
            city.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            city.setPhoto(cityForm.getPhoto().getBytes());
        cityRepository.save(city);
    }

    /**
     * Процедура удаления города по ID из БД
     *
     * @param id ID удаляемого города
     */
    @Transactional
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

}
