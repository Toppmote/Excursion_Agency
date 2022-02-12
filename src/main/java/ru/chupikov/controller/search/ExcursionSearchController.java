package ru.chupikov.controller.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.chupikov.dto.CityModel;
import ru.chupikov.dto.ExcursionModel;
import ru.chupikov.dto.GuideModel;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.service.search.CitySearchService;
import ru.chupikov.service.search.ExcursionSearchService;
import ru.chupikov.service.search.GuideSearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с экскурсиями
 */
@Controller
@Slf4j
public class ExcursionSearchController {

    @Autowired
    ExcursionSearchService excursionSearchService;

    @Autowired
    CitySearchService citySearchService;

    @Autowired
    GuideSearchService guideSearchService;

    /**
     * Метод загрузки страницы всех экскурсий
     *
     * @param model модель для передачи данных на страницу
     * @return страница
     */
    @GetMapping("/excursions")
    public String loadExcursionsPage(Model model) {
        log.info("[GET - /excursions]\tEntered loadExcursionsPage method");
        List<ExcursionModel> excursions = excursionSearchService.findAll();
        model.addAttribute("excursions", excursions);
        model.addAttribute("cities", citySearchService.findAll());
        model.addAttribute("guides", guideSearchService.findAll());
        model.addAttribute("excursionForm", new ExcursionForm());
        log.info("[GET - /excursions]\tLoading excursions page");
        return "excursions";
    }

    /**
     * Метод загрузки страницу конкретной экскурсии с требуемым id
     *
     * @param id    id экскурсии
     * @param model модель для передачи данных на страницу
     * @return страница
     */
    @GetMapping("/excursions/{id}")
    public String loadExcursionDetailsPage(@PathVariable Long id, Model model) {
        log.info("[GET - /excursions/" + id + "]\tEntered loadExcursionDetailsPage method");
        ExcursionModel excursion = excursionSearchService.findById(id);
        model.addAttribute("excursion", excursion);
        model.addAttribute("excursionForm", new ExcursionForm());
        List<CityModel> cities = citySearchService.findAll();
        cities.remove(excursion.getCity());
        cities.add(0, excursion.getCity());
        model.addAttribute("cities", cities);
        List<GuideModel> guides = guideSearchService.findAll();
        guides.remove(excursion.getGuide());
        guides.add(0, excursion.getGuide());
        model.addAttribute("guides", guides);
        log.info("[GET - /excursions/" + id + "]\tLoading excursion_details page");
        return "excursion_details";
    }

}
