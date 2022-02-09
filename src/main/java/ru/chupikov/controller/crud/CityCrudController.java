package ru.chupikov.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.CityForm;
import ru.chupikov.service.crud.CityCrudService;

/**
 * Контроллер для Crud операций, связанных с городами
 */
@RestController
public class CityCrudController {

    @Autowired
    CityCrudService cityCrudService;

    /**
     * Метод обработки запроса на сохранение нового города
     *
     * @param cityForm данные о новом городе
     * @param photoCity фотография города
     * @return редирект на страницу
     */
    @PostMapping("/add_city")
    public RedirectView addCity(@ModelAttribute CityForm cityForm, @RequestParam("photoCity") MultipartFile photoCity) {
        try {
            cityForm.setPhoto(photoCity);
            cityCrudService.save(cityForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("cities");
    }

}
