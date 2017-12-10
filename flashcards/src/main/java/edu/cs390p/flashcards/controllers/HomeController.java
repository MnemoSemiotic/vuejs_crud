package edu.cs390p.flashcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller for mapping to index.html home page.
 */
@Controller
class HomeController {

    /**
     * Maps the home page to index.html.
     *
     * @return the index string
     */
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
