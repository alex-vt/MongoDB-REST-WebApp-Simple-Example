package com.oleksiykovtun.mongorestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base model class (POJO)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Entry {

    protected String id;

    public final String getId() {
        return id;
    }

}
