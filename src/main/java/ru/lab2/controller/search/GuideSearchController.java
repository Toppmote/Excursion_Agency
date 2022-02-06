package ru.lab2.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.lab2.service.search.GuideSearchService;

/**
 * Контроллер для операций поиска, связанных с экскурсоводами
 */
@RestController
public class GuideSearchController {

    @Autowired
    GuideSearchService guideSearchService;

}
