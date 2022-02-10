package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.chupikov.entity.CityEntity;
import ru.chupikov.entity.ExcursionEntity;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.service.search.CitySearchService;
import ru.chupikov.service.search.ExcursionSearchService;
import ru.chupikov.service.search.GuideSearchService;
import ru.chupikov.utils.ImgTransformationUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Контроллер для операций поиска, связанных с экскурсиями
 */
@Controller
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
        List<ExcursionEntity> excursions = excursionSearchService.findAll();
        model.addAttribute("excursions", excursions);
        model.addAttribute("cities", citySearchService.findAll());
        model.addAttribute("guides", guideSearchService.findAll());
        model.addAttribute("imgConverter", ImgTransformationUtils.getInstance());
        model.addAttribute("excursionForm", new ExcursionForm());
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
        ExcursionEntity excursion = excursionSearchService.findById(id);
        model.addAttribute("excursion", excursion);
        model.addAttribute("imgConverter", ImgTransformationUtils.getInstance());
        model.addAttribute("excursionForm", new ExcursionForm());
        SimpleDateFormat prettyDate = new SimpleDateFormat("dd.MM.yyyy");
        model.addAttribute("prettyDate", prettyDate.format(excursion.getDate()));
        List<CityEntity> cities = citySearchService.findAll();
        cities.remove(excursion.getCity());
        cities.add(0, excursion.getCity());
        model.addAttribute("cities", cities);
        List<GuideEntity> guides = guideSearchService.findAll();
        guides.remove(excursion.getGuide());
        guides.add(0, excursion.getGuide());
        model.addAttribute("guides", guides);
        return "excursion_details";
    }

}
