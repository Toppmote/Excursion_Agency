package ru.chupikov.controller.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.GuideForm;
import ru.chupikov.service.crud.GuideCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсоводами
 */
@RestController
@Slf4j
public class GuideCrudController {

    @Autowired
    GuideCrudService guideCrudService;

    /**
     * Метод обработки запроса на сохранение нового экскурсовода
     *
     * @param guideForm  данные о новом экскурсоводе
     * @return редирект на страницу экскурсоводов
     */
    @PostMapping("/add_guide")
    public RedirectView addCity(@ModelAttribute GuideForm guideForm) {
        log.info("[POST - /add_guide]\tEntered addCity method");
        try {
            //guideForm.setPhoto(photoGuide);
            guideCrudService.save(guideForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[POST - /add_guide]\tRedirecting to /guides page");
        return new RedirectView("/guides");
    }

    /**
     * Метод обработки запроса на удаление экскурсовода по ID
     *
     * @param id ID удаляемого экскурсовода
     * @return редирект на страницу экскурсоводов
     */
    @GetMapping("/delete_guide/{id}")
    public RedirectView deleteGuideById(@PathVariable Long id) {
        log.info("[GET - /delete_guide/" + id + "]\tEntered deleteGuideById method");
        guideCrudService.deleteById(id);
        log.info("[GET - /delete_guide/" + id + "]\tRedirecting to /guides page");
        return new RedirectView("/guides");
    }

    /**
     * Метод обработки запроса на обновление экскурсовода
     *
     * @param id         id экскурсовода для обновления
     * @param guideForm  новые данные о экскурсоводе
     * @param photoGuide новое фото экскурсовода
     * @return редирект на страницу того же экскурсовода
     */
    @PostMapping("/update_guide/{id}")
    public RedirectView updateGuideById(@PathVariable Long id, @ModelAttribute GuideForm guideForm,
                                    @RequestParam("photoGuide") MultipartFile photoGuide) {
        log.info("[POST - /update_guide/" + id +"]\tEntered updateGuideById method");
        try {
            guideForm.setId(id);
            guideForm.setPhoto(photoGuide);
            guideCrudService.update(guideForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[POST - /update_guide/" + id +"]\tRedirecting to guide_details page");
        return new RedirectView("/guides/" + id);
    }

}
