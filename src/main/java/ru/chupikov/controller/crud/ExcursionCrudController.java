package ru.chupikov.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.chupikov.service.crud.ExcursionCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсиями
 */
@RestController
public class ExcursionCrudController {

    @Autowired
    ExcursionCrudService excursionCrudService;

}
