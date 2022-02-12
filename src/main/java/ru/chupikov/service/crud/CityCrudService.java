package ru.chupikov.service.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupikov.dao.CityRepository;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.form.CityForm;
import ru.chupikov.utils.ImgTransformationUtils;
import ru.chupikov.utils.mapper.CityMapper;

import java.io.IOException;
import java.util.Optional;

/**
 * Сервис с Crud операциями для городов
 */
@Service
@Slf4j
public class CityCrudService {

    @Autowired
    CityRepository cityRepository;

    /**
     * Процедура сохранения нового города в БД
     *
     * @param cityForm форма с данными нового города
     * @throws IOException исключение в случае ошибки доступа (при сбое временного хранилища)
     */
    @Transactional
    public void save(CityForm cityForm) throws IOException {
        log.info("[CityCrudService]\tEntered save method");
        CityEntity city = CityMapper.formToEntity(cityForm);
        if (cityForm.getPhoto().getSize() == 0)
            city.setPhoto(ImgTransformationUtils.getInstance().getByteEmptyPicture());
        else
            city.setPhoto(cityForm.getPhoto().getBytes());
        cityRepository.save(city);
        log.info("[CityCrudService]\tSuccessfully saved city");
    }

    /**
     * Процедура удаления города по ID из БД
     *
     * @param id ID удаляемого города
     */
    @Transactional
    public void deleteById(Long id) {
        log.info("[CityCrudService]\tEntered deleteById method");
        cityRepository.deleteById(id);
        log.info("[CityCrudService]\tSuccessfully deleted city with id = " + id);
    }

    /**
     * Процедура обновления города в БД
     *
     * @param cityForm форма с новыми данными города
     * @throws IOException исключение в случае ошибки доступа (при сбое временного хранилища)
     */
    @Transactional
    public void update(CityForm cityForm) throws IOException {
        log.info("[CityCrudService]\tEntered update method");
        Optional<CityEntity> city = cityRepository.findById(cityForm.getId());
        if (city.isPresent()) {
            CityEntity updatedCity = CityMapper.formToEntity(cityForm);
            if (cityForm.getPhoto().getSize() == 0)
                updatedCity.setPhoto(city.get().getPhoto());
            else
                updatedCity.setPhoto(cityForm.getPhoto().getBytes());
            cityRepository.save(updatedCity);
            log.info("[CityCrudService]\tSuccessfully updated city with id = " + cityForm.getId());
        }
        log.info("[CityCrudService]\tExit update method");
    }

}
