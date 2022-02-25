package ru.chupikov.controller.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chupikov.dto.CityModel;
import ru.chupikov.form.CityForm;
import ru.chupikov.service.search.CitySearchService;

import java.util.List;

/**
 * Контроллер для операций поиска, связанных с городами
 */
@Controller
@Slf4j
public class CitySearchController {

    @Autowired
    CitySearchService citySearchService;

    /**
     * Метод загрузки страницы всех городов
     *
     * @param model модель для передачи данных на страницу
     * @return страница городов
     */
    @GetMapping("/cities")
    public String loadCitiesPage(Model model) {
        log.info("[GET - /cities]\tEntered loadCitiesPage method");
        List<CityModel> cities = citySearchService.findAll();
        model.addAttribute("cities", cities);
        model.addAttribute("cityForm", new CityForm());
        log.info("[GET - /cities]\tLoading cities page");
        return "cities";
    }

    /**
     * Метод загрузки страницу конкретного города с требуемым id
     *
     * @param id    id города
     * @param model модель для передачи данных на страницу
     * @return страница города
     */
    @GetMapping("/cities/{id}")
    public String loadCityDetailsPage(@PathVariable Long id, Model model) {
        log.info("[GET - /cities/" + id + "]\tEntered loadCitiesDetailsPage method");
        model.addAttribute("city", citySearchService.findById(id));
        model.addAttribute("cityForm", new CityForm());
        log.info("[GET - /cities/" + id + "]\tLoading city_details page");
        return "city_details";
    }

    /**
     * Метод обработки запроса на поиск городов по фрагменту имени
     *
     * @param nameFragmentJSON JSON с фрагментом имени
     * @return объект со статусом ответа на запрос и передаваемыми данными от сервера(список найденных городов)
     */
    @PostMapping("/cities/find")
    @ResponseBody
    public ResponseEntity<?> findCitiesByStringContaining(@RequestBody String nameFragmentJSON) {
        log.info("[POST - /cities/find]\tEntered findCitiesByStringContaining method");
        try {
            String nameFragment = new ObjectMapper()
                    .readValue(nameFragmentJSON, ObjectNode.class)
                    .get("text")
                    .textValue();
            List<CityModel> foundCities = citySearchService.findByNameContaining(nameFragment);
            log.info("[POST - /cities/find]\tReturning found cities by fragment " + nameFragment);
            return ResponseEntity.ok(foundCities);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
