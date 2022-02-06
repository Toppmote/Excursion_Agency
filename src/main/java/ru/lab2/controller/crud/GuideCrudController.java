package ru.lab2.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.lab2.service.crud.GuideCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсоводами
 */
@RestController
public class GuideCrudController {

    @Autowired
    GuideCrudService guideCrudService;

}
