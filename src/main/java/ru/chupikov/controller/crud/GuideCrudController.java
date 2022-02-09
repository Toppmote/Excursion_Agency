package ru.chupikov.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.GuideForm;
import ru.chupikov.service.crud.GuideCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсоводами
 */
@RestController
public class GuideCrudController {

    @Autowired
    GuideCrudService guideCrudService;

    /**
     * Метод обработки запроса на сохранение нового экскурсовода
     *
     * @param guideForm данные о новом экскурсоводе
     * @param photoGuide фотография экскурсовода
     * @return редирект на страницу экскурсоводов
     */
    @PostMapping("/add_guide")
    public RedirectView addCity(@ModelAttribute GuideForm guideForm, @RequestParam("photoGuide") MultipartFile photoGuide) {
        try {
            guideForm.setPhoto(photoGuide);
            guideCrudService.save(guideForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("guides");
    }

}
