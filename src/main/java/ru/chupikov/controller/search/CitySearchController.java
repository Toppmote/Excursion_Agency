package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.chupikov.dto.CityModel;
import ru.chupikov.form.CityForm;
import ru.chupikov.service.search.CitySearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с городами
 */
@Controller
public class CitySearchController {

    @Autowired
    CitySearchService citySearchService;

    /**
     * Метод загрузки страницы всех городов
     *
     * @param model модель для передачи данных на страницу
     * @return страница городов
     */
    @GetMapping("/cities")
    public String loadCitiesPage(Model model) {
        List<CityModel> cities = citySearchService.findAll();
        model.addAttribute("cities", cities);
        model.addAttribute("cityForm", new CityForm());
        return "cities";
    }

    /**
     * Метод загрузки страницу конкретного города с требуемым id
     *
     * @param id    id города
     * @param model модель для передачи данных на страницу
     * @return страница города
     */
    @GetMapping("/cities/{id}")
    public String loadCitiesDetailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("city", citySearchService.findById(id));
        model.addAttribute("cityForm", new CityForm());
        return "city_details";
    }

}
