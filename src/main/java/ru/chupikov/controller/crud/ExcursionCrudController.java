package ru.chupikov.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.ExcursionForm;
import ru.chupikov.service.crud.ExcursionCrudService;

/**
 * Контроллер для Crud операций, связанных с экскурсиями
 */
@RestController
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
        excursionCrudService.save(excursionForm);
        return new RedirectView("/excursions");
    }

    /**
     * Метод обработки запроса на экскурсии города по ID
     *
     * @param id ID удаляемой экскурсии
     * @return редирект на страницу экскурсий
     */
    @GetMapping("/delete_excursion/{id}")
    public RedirectView deleteExcursion(@PathVariable Long id) {
        excursionCrudService.deleteById(id);
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
    public RedirectView updateExcursion(@PathVariable Long id, @ModelAttribute ExcursionForm excursionForm) {
        try {
            excursionForm.setId(id);
            excursionCrudService.update(excursionForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/excursions/" + id);
    }

}
