package org.moviebox.models;

public abstract class Model {
    final private String id;

    protected Model(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
