package ru.chupikov.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для запросов, не связанных с БД
 */
@Controller
@Slf4j
public class MainController {

    /**
     * Метод загрузки Начальной станицы
     *
     * @return страницу index
     */
    @GetMapping("/")
    public String loadStartPage() {
        log.info("[GET - /]\tLoaded index page");
        return "index";
    }

    /**
     * Метод загрузки Начальной станицы
     *
     * @return страницу about
     */
    @GetMapping("/about")
    public String loadAboutPage() {
        log.info("[GET - /about]\tLoaded About page");
        return "about";
    }

}
