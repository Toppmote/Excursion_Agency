package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.service.search.CitySearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с городами
 */
@Controller
public class CitySearchController {

    @Autowired
    CitySearchService citySearchService;

    @GetMapping("/cities")
    public String loadCitiesPage(Model model) {
        List<CityEntity> cities = citySearchService.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }


}
