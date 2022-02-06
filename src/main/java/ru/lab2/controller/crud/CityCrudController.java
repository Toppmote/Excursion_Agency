package ru.lab2.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.lab2.service.crud.CityCrudService;

/**
 * Контроллер для Crud операций, связанных с городами
 */
@RestController
public class CityCrudController {

    @Autowired
    CityCrudService cityCrudService;


}
