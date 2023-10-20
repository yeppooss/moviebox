package org.moviebox.models;

import java.util.ArrayList;

public class Movie extends Model{
    private String title;
    private String director;
    private Integer year;
    private ArrayList<String> genres;
    private Double rating;

    public Movie(String id, String title, String director, Integer year,
                 ArrayList<String> genres, Double rating){
        super(id);
        this.title = title;
        this.director = director;
        this.year = year;
        this.genres = genres;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
