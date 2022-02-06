package ru.lab2.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.lab2.service.crud.ExcursionCrudService;

/**
 * Контроллер для операций поиска, связанных с экскурсиями
 */
@RestController
public class ExcursionSearchController {

    @Autowired
    ExcursionCrudService excursionCrudService;

}
