package org.lessons.bestoftheyear.java.best_of_the_year.controller;

import java.util.List;
import java.util.ArrayList;

import org.lessons.bestoftheyear.java.best_of_the_year.model.Movie;
import org.lessons.bestoftheyear.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("author", "Richardson");
        return "fragments/index";
    }

    @GetMapping("/string/movies")
    public String moviesAsString(Model model) {
        StringBuilder names = new StringBuilder();

        // I dati vengono presi dalla lista locale del controller
        for (Movie movie : getBestMovies()) {
            names.append(movie.getTitle()).append(", ");
        }

        if (names.length() >= 2) {
            names.setLength(names.length() - 2);
        }

        model.addAttribute("title", "Movies");
        model.addAttribute("names", names.toString());

        return "fragments/listAsString"; // Thymeleaf cerca il file in templates/fragments/listAsString.html
    }

    @GetMapping("/string/songs")
    public String songsAsString(Model model) {

        StringBuilder names = new StringBuilder();
        // I dati vengono presi dalla lista locale del controller
        for (Song song : getBestSongs()) {
            names.append(song.getTitle()).append(", ");
        }

        if (names.length() >= 2) {
            names.setLength(names.length() - 2);
        }

        model.addAttribute("title", "Songs");
        model.addAttribute("names", names.toString());

        return "fragments/listAsString"; // Thymeleaf cerca il file in templates/fragments/listAsString.html
    }

    // Lista dei migliori film dell'anno
    private List<Movie> getBestMovies() {
        List<Movie> list = new ArrayList<>();

        list.add(new Movie(1, "The Godfather"));
        list.add(new Movie(2, "Inception"));
        list.add(new Movie(3, "Interstellar"));
        list.add(new Movie(4, "The Dark Knight"));
        list.add(new Movie(5, "Pulp Fiction"));
        list.add(new Movie(6, "Fight Club"));
        list.add(new Movie(7, "Forrest Gump"));
        list.add(new Movie(8, "The Matrix"));

        return list;
    }

    // Lista delle migliori canzoni dell'anno
    private List<Song> getBestSongs() {
        List<Song> list = new ArrayList<>();
        list.add(new Song(1, "Bohemian Rhapsody - Queen"));
        list.add(new Song(2, "Hotel California - Eagles"));
        list.add(new Song(3, "Stairway to Heaven - Led Zeppelin"));
        list.add(new Song(4, "Imagine - John Lennon"));
        list.add(new Song(5, "Smells Like Teen Spirit - Nirvana"));
        list.add(new Song(6, "Billie Jean - Michael Jackson"));
        list.add(new Song(7, "Hey Jude - The Beatles"));
        list.add(new Song(8, "Like a Rolling Stone - Bob Dylan"));

        return list;
    }
}
