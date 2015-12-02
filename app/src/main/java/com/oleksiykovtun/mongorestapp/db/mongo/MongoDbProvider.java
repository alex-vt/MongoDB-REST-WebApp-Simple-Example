package com.oleksiykovtun.mongorestapp.db.mongo;

import com.oleksiykovtun.mongorestapp.db.DbProvider;
import com.oleksiykovtun.mongorestapp.model.Entry;
import com.oleksiykovtun.mongorestapp.model.Item;
import com.oleksiykovtun.mongorestapp.model.User;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A raw MongoDB storage of Entry objects
 */
public class MongoDbProvider implements DbProvider {

    public Set<Entry> getEntriesByType(Class classOfEntry) throws Throwable {
        Set<Object> entryObjectSet = MongoObjectStorageProvider.getObjectSetFromDbByClass(classOfEntry);
        Set<Entry> entrySet = new LinkedHashSet<Entry>();
        for (Object entryObject : entryObjectSet) {
            entrySet.add((Entry) entryObject);
        }
        return entrySet;
    }

    public Entry getEntryByIdAndType(String id, Class classOfEntry) throws Throwable {
        return (Entry) MongoObjectStorageProvider.getObjectFromDbById(id, classOfEntry);
    }

    public boolean entryExistsById(String id) throws Throwable {
        return MongoObjectStorageProvider.objectExistsById(id);
    }

    public void addEntryIfNotExists(Entry entry) throws Throwable {
        if (!MongoObjectStorageProvider.objectExistsById(entry.getId())) {
            MongoObjectStorageProvider.putObjectToDb(entry);
        }
    }

    public boolean deleteEntryById(String id) throws Throwable {
        return MongoObjectStorageProvider.deleteObjectFromDbById(id);
    }
}
