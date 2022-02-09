package ru.chupikov.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.chupikov.entity.GuideEntity;
import ru.chupikov.service.search.GuideSearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с экскурсоводами
 */
@Controller
public class GuideSearchController {

    @Autowired
    GuideSearchService guideSearchService;

    /**
     * Метод загрузки страницы всех экскурсоводов
     *
     * @param model модель для передачи данных на страницу
     * @return страница экскурсоводов
     */
    @GetMapping("/guides")
    public String loadGuidesPage(Model model) {
        List<GuideEntity> guides = guideSearchService.findAll();
        model.addAttribute("guides", guides);
        return "guides";
    }

    /**
     * Метод загрузки страницу конкретного экскурсовода с требуемым id
     *
     * @param id id экскурсовода
     * @param model модель для передачи данных на страницу
     * @return страница экскурсовода
     */
    @GetMapping("/guides/{id}")
    public String loadGuideDetailsPage(@PathVariable Long id, Model model){
        model.addAttribute("guide", guideSearchService.findById(id));
        return "guide_details";
    }

}
