package org.moviebox.readers;

import org.moviebox.storages.MovieStorage;

public class MovieReader {
    final private IDBAdapter adapter;

    public MovieReader(IDBAdapter adapter) {
        this.adapter = adapter;
    }

    public MovieStorage read(){
        return adapter.load();
    }
}
