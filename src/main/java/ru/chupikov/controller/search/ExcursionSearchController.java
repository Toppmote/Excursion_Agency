package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.chupikov.service.crud.ExcursionCrudService;

/**
 * Контроллер для операций поиска, связанных с экскурсиями
 */
@RestController
public class ExcursionSearchController {

    @Autowired
    ExcursionCrudService excursionCrudService;

}
