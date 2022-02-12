package ru.chupikov.service.crud;

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
        CityEntity city = CityMapper.formToEntity(cityForm);
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

    /**
     * Процедура обновления города в БД
     *
     * @param cityForm форма с новыми данными города
     * @throws IOException исключение в случае ошибки доступа (при сбое временного хранилища)
     */
    @Transactional
    public void update(CityForm cityForm) throws IOException {
        Optional<CityEntity> city = cityRepository.findById(cityForm.getId());
        if (city.isPresent()) {
            CityEntity updatedCity = CityMapper.formToEntity(cityForm);
            updatedCity.setId(cityForm.getId());
            if (cityForm.getPhoto().getSize() == 0)
                updatedCity.setPhoto(city.get().getPhoto());
            else
                updatedCity.setPhoto(cityForm.getPhoto().getBytes());
            cityRepository.save(updatedCity);
        }
    }

}
