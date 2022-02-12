package ru.chupikov.controller.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.service.crud.ExcursionCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсиями
 */
@RestController
@Slf4j
public class ExcursionCrudController {

    @Autowired
    ExcursionCrudService excursionCrudService;

    /**
     * Метод обработки запроса на сохранение новой экскурсии
     *
     * @param excursionForm данные о новой экскурсии
     * @return редирект на страницу экскурсий
     */
    @PostMapping("/add_excursion")
    public RedirectView addExcursion(@ModelAttribute ExcursionForm excursionForm) {
        log.info("[POST - /add_excursion]\tEntered addExcursion method");
        excursionCrudService.save(excursionForm);
        log.info("[POST - /add_excursion]\tRedirecting to /excursions page");
        return new RedirectView("/excursions");
    }

    /**
     * Метод обработки запроса на экскурсии города по ID
     *
     * @param id ID удаляемой экскурсии
     * @return редирект на страницу экскурсий
     */
    @GetMapping("/delete_excursion/{id}")
    public RedirectView deleteExcursionById(@PathVariable Long id) {
        log.info("[GET - /delete_excursion/" + id + "]\tEntered deleteExcursionById method");
        excursionCrudService.deleteById(id);
        log.info("[GET - /delete_excursion/" + id + "]\tRedirecting to /excursions page");
        return new RedirectView("/excursions");
    }

    /**
     * Метод обработки запроса на обновление экскурсии
     *
     * @param id        id экскурсии для обновления
     * @param excursionForm  новые данные о экскурсии
     * @return редирект на страницу той же экскурсии
     */
    @PostMapping("/update_excursion/{id}")
    public RedirectView updateExcursionById(@PathVariable Long id, @ModelAttribute ExcursionForm excursionForm) {
        log.info("[POST - /update_excursion/" + id +"]\tEntered updateExcursionById method");
        try {
            excursionForm.setId(id);
            excursionCrudService.update(excursionForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[POST - /update_excursion/" + id +"]\tRedirecting to excursions_details page");
        return new RedirectView("/excursions/" + id);
    }

}
