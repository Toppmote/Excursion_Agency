package ru.chupikov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для запросов, не связанных с БД
 */
@Controller
public class MainController {

    /**
     * Метод загрузки Начальной станицы
     *
     * @return страницу index
     */
    @GetMapping("/")
    public String loadStartPage() {
        return "index";
    }

    /**
     * Метод загрузки Начальной станицы
     *
     * @return страницу about
     */
    @GetMapping("/about")
    public String loadAboutPage() {
        return "about";
    }

}
