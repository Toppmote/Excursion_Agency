package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.ExcursionRepository;

/**
 * Сервис с Crud операциями для экскурсий
 */
@Service
public class ExcursionCrudService {

    @Autowired
    ExcursionRepository excursionRepository;

}
