package org.moviebox.storages;

import org.moviebox.models.Movie;

import java.util.ArrayList;

public class MovieStorage {
    private final ArrayList<Movie> models = new ArrayList<>();

    public ArrayList<Movie> get(){
        return models;
    }

    public void add(Movie model){
        models.add(model);
    }
}
