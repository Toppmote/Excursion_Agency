package ru.lab2.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.CityRepository;

/**
 * Сервис с Crud операциями для городов
 */
@Service
public class CityCrudService {

    @Autowired
    CityRepository cityRepository;

}
