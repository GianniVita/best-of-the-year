package org.lessons.bestoftheyear.java.best_of_the_year.controller;

import java.util.List;
import java.util.ArrayList;

import org.lessons.bestoftheyear.java.best_of_the_year.model.Movie;
import org.lessons.bestoftheyear.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("author", "Richardson");
        return "index";
    }

    @GetMapping("/string/movies")
    public String moviesAsString(Model model) {
        String names = "";

        // I dati vengono presi dalla lista locale del controller
        for (Movie movie : getBestMovies()) {
            names += movie.getTitle() + ", ";
        }

        names = names.substring(0, names.length() - 2);
        
        model.addAttribute("title", "Movies");
        model.addAttribute("names", names);

        return "listAsString"; 
    }


    @GetMapping("/string/songs")
    public String songsAsString(Model model) {

        String names = "";
        // I dati vengono presi dalla lista locale del controller
        for (Song song : getBestSongs()) {
            names += song.getTitle() + ", ";
        }

        names = names.substring(0, names.length() - 2);

        model.addAttribute("title", "Songs");
        model.addAttribute("names", names);

        return "listAsString";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("title", "Movies");
        model.addAttribute("list", getBestMovies());
        
        return "list";
    }
    
    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("title", "Songs");
        model.addAttribute("list", getBestSongs());

        return "list";
    }


    @GetMapping("/movies/{id}")
    public String movieDetails(Model model, @PathVariable("id") Integer movieId) {
        Movie movieFound = null;

        for (Movie movie : getBestMovies()) {
            if (movie.getId().equals(movieId)) {
                movieFound = movie;
                break;
            }
        }

        model.addAttribute("id", movieId);
        model.addAttribute("item", movieFound);
        
        return"details";
    }
    

    @GetMapping("/songs/{id}")
    public String songDetails(Model model, @PathVariable("id") Integer songId) {
        Song songFound = null;

        for (Song song : getBestSongs()) {
            if (song.getId().equals(songId)) {
                songFound = song;
                break;
            }
        }

        model.addAttribute("id", songId);
        model.addAttribute("item", songFound);

        return "details";
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
