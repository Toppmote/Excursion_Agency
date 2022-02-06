package ru.lab2.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lab2.dao.GuideRepository;

/**
 * Сервис с Crud операциями для экскурсоводов
 */
@Service
public class GuideCrudService {

    @Autowired
    GuideRepository guideRepository;

}
