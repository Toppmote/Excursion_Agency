package ru.lab2.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.ExcursionRepository;

/**
 * Сервис с Crud операциями для экскурсий
 */
@Service
public class ExcursionCrudService {

    @Autowired
    ExcursionRepository excursionRepository;

}
