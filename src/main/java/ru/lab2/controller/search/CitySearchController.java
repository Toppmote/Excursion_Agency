package ru.lab2.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.lab2.service.search.CitySearchService;

/**
 * Контроллер для операций поиска, связанных с городами
 */
@RestController
public class CitySearchController {

    @Autowired
    CitySearchService citySearchService;

}
