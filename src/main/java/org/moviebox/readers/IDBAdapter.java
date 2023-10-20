package org.moviebox.readers;

import org.moviebox.storages.MovieStorage;

public abstract class IDBAdapter {
    protected final String databaseName;
    protected final String tableName;

    public IDBAdapter(String databaseName, String tableName){
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    abstract public MovieStorage load();
}
