package com.oleksiykovtun.mongorestapp.model;

/**
 * Base model class (POJO)
 */
public abstract class Entry {

    protected String id;

    public final String getId() {
        return id;
    }

    public abstract void setId(String id);

}
