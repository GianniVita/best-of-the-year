package org.lessons.bestoftheyear.java.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class IndexController {
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("author","Richardson"); 
            return "index";
        }
    

    @GetMapping("/string/movies")
    public String moviesAsString(Model model) {
        String name = "";

        for(Movies movie : getBestMovies()) {
            names += movie.getTitle() + ", ";
        }

        names = names.substring(0, names.length() - 2);

        model.addAttribute("title", "Movies");
        model.addAttribute("names", names)
    }

    
}
