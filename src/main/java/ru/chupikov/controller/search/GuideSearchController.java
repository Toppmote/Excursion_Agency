package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.chupikov.service.search.GuideSearchService;

/**
 * Контроллер для операций поиска, связанных с экскурсоводами
 */
@RestController
public class GuideSearchController {

    @Autowired
    GuideSearchService guideSearchService;

}
