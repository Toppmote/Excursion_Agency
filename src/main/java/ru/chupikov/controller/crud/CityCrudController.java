package ru.chupikov.controller.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ru.chupikov.form.CityForm;
import ru.chupikov.service.crud.CityCrudService;

/**
 * Контроллер для Crud операций, связанных с городами
 */
@RestController
@Slf4j
public class CityCrudController {

    @Autowired
    CityCrudService cityCrudService;

    /**
     * Метод обработки запроса на сохранение нового города
     *
     * @param cityForm  данные о новом городе
     * @param photoCity фотография города
     * @return редирект на страницу городов
     */
    @PostMapping("/add_city")
    public RedirectView addCity(@ModelAttribute CityForm cityForm, @RequestParam("photoCity") MultipartFile photoCity) {
        log.info("[POST - /add_city]\tEntered addCity method");
        try {
            cityForm.setPhoto(photoCity);
            cityCrudService.save(cityForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[POST - /add_city]\tRedirecting to /cities page");
        return new RedirectView("/cities");
    }

    /**
     * Метод обработки запроса на удаление города по ID
     *
     * @param id ID удаляемого города
     * @return редирект на страницу городов
     */
    @GetMapping("/delete_city/{id}")
    public RedirectView deleteCityById(@PathVariable Long id) {
        log.info("[GET - /delete_city/" + id + "]\tEntered deleteCityById method");
        cityCrudService.deleteById(id);
        log.info("[GET - /delete_city/" + id + "]\tRedirecting to cities page");
        return new RedirectView("/cities");
    }

    /**
     * Метод обработки запроса на обновление города
     *
     * @param id        id города для обновления
     * @param cityForm  новые данные о городе
     * @param photoCity новое фото города
     * @return редирект на страницу того же города
     */
    @PostMapping("/update_city/{id}")
    public RedirectView updateCityById(@PathVariable Long id, @ModelAttribute CityForm cityForm,
                                   @RequestParam("photoCity") MultipartFile photoCity) {
        log.info("[POST - /update_city/" + id +"]\tEntered updateCityById method");
        try {
            cityForm.setId(id);
            cityForm.setPhoto(photoCity);
            cityCrudService.update(cityForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[POST - /update_city/" + id + "]\tRedirecting to city_details page");
        return new RedirectView("/cities/" + id);
    }

}
