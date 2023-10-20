package org.moviebox;

import org.moviebox.readers.MongoAdapter;
import org.moviebox.readers.MovieReader;
import org.moviebox.storages.MovieStorage;

public class Main {
    public static void main(String[] args){
        MovieReader movieReader = new MovieReader(new MongoAdapter("mongodb://localhost:27017",
                "moviebox",
                "movies"));
        MovieStorage movieStorage = movieReader.read();

        movieStorage.get().forEach(movie -> System.out.println(movie.getTitle()));
    }
}
