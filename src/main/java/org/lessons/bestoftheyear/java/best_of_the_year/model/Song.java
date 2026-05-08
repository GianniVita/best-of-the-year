package org.lessons.bestoftheyear.java.best_of_the_year.model;
public class Song {
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Song(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

}