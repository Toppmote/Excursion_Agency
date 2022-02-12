package ru.chupikov.controller.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.chupikov.dto.GuideModel;
import ru.chupikov.form.GuideForm;
import ru.chupikov.service.search.GuideSearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с экскурсоводами
 */
@Controller
@Slf4j
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
        log.info("[GET - /guides]\tEntered loadGuidesPage method");
        List<GuideModel> guides = guideSearchService.findAll();
        model.addAttribute("guides", guides);
        model.addAttribute("guideForm", new GuideForm());
        log.info("[GET - /guides]\tLoading guides page");
        return "guides";
    }

    /**
     * Метод загрузки страницу конкретного экскурсовода с требуемым id
     *
     * @param id    id экскурсовода
     * @param model модель для передачи данных на страницу
     * @return страница экскурсовода
     */
    @GetMapping("/guides/{id}")
    public String loadGuideDetailsPage(@PathVariable Long id, Model model) {
        log.info("[GET - /guides/" + id + "]\tEntered loadGuideDetailsPage method");
        GuideModel guide = guideSearchService.findById(id);
        model.addAttribute("guide", guide);
        model.addAttribute("guideForm", new GuideForm());
        log.info("[GET - /guides/" + id + "]\tLoading guide_details page");
        return "guide_details";
    }

}
