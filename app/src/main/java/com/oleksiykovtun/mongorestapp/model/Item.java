package com.oleksiykovtun.mongorestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oleksiykovtun.mongorestapp.util.Base64Converter;

/**
 * Item model (POJO)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends Entry {

    private String name;

    public Item() { }

    public Item(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.id = Item.class.getSimpleName() + "_" + Base64Converter.getBase64StringFromString(name);
    }
}
