package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.chupikov.service.search.CitySearchService;

/**
 * Контроллер для операций поиска, связанных с городами
 */
@RestController
public class CitySearchController {

    @Autowired
    CitySearchService citySearchService;

}
