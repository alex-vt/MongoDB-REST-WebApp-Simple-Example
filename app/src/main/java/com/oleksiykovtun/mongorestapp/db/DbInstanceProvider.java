package com.oleksiykovtun.mongorestapp.db;

import com.oleksiykovtun.mongorestapp.db.inmemory.InMemoryDbProvider;
import com.oleksiykovtun.mongorestapp.db.mongo.MongoDbProvider;

/**
 * Provides a instance of implementation of DB adapter defined by interface DomainSpecificDbProvider.
 * Switch used DB implementations here
 */
public abstract class DbInstanceProvider {

    private static DbProvider instance = null;

    public static DbProvider getDb() {
        if (instance == null) {
            // Switch used DB implementations here

            //instance = new InMemoryDbProvider();
            instance = new MongoDbProvider();

            initDb();
        }
        return instance;
    }

    private static void initDb() {
        try {
            Initializer.initDb(instance);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
