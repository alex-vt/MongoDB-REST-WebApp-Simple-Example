package com.oleksiykovtun.mongorestapp.db;

import com.oleksiykovtun.mongorestapp.model.Item;
import com.oleksiykovtun.mongorestapp.model.User;

/**
 * Writes initial values to DB
 */
abstract class Initializer {

    public static void initDb(DbProvider dbProvider) throws Throwable {
        dbProvider.addEntryIfNotExists(new User("Default Test User 1", "password"));
        dbProvider.addEntryIfNotExists(new User("Default Test User 2", "12345678"));
        dbProvider.addEntryIfNotExists(new Item("Default Test Item 1"));
        dbProvider.addEntryIfNotExists(new Item("Default Test Item 2"));
    }

}
