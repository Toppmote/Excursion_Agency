package ru.chupikov.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupikov.dao.GuideRepository;

/**
 * Сервис с Crud операциями для экскурсоводов
 */
@Service
public class GuideCrudService {

    @Autowired
    GuideRepository guideRepository;

}
