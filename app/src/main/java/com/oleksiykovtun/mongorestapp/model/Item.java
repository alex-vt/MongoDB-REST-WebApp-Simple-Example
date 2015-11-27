package com.oleksiykovtun.mongorestapp.model;

/**
 * Item model (POJO)
 */
public class Item extends Entry {

    private String name;

    public Item() { }

    public Item(String name) {
        setId(name);
        setName(name);
    }

    public void setId(String id) {
        this.id = Item.class.getSimpleName() + "_" + id.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
