package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.CityRepository;

/**
 * Сервис с Crud операциями для городов
 */
@Service
public class CityCrudService {

    @Autowired
    CityRepository cityRepository;

}
