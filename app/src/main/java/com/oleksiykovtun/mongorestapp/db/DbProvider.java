package com.oleksiykovtun.mongorestapp.db;

import com.oleksiykovtun.mongorestapp.model.Entry;

import java.util.Set;

/**
 * Implementations of DB providers must comply with this interface regardless of DB type
 */
public interface DbProvider {

    Set<Entry> getEntriesByType(Class classOfEntry) throws Throwable;

    Entry getEntryByIdAndType(String id, Class classOfEntry) throws Throwable;

    boolean entryExistsById(String id) throws Throwable;

    void addEntryIfNotExists(Entry entry) throws Throwable;

    boolean deleteEntryById(String id) throws Throwable;

}
