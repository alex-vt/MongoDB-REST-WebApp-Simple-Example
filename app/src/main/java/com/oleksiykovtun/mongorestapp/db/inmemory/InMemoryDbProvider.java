package com.oleksiykovtun.mongorestapp.db.inmemory;

import com.oleksiykovtun.mongorestapp.db.DbProvider;
import com.oleksiykovtun.mongorestapp.model.Entry;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  A primitive data storage with no persistence
 */
public class InMemoryDbProvider implements DbProvider {

    private Set<Entry> entries = new LinkedHashSet<Entry>();

    public Set<Entry> getEntriesByType(Class classOfEntry) {
        Set<Entry> selectedEntries = new LinkedHashSet<Entry>();
        for (Entry entry : entries) {
            if (entry.getClass().getName().equals(classOfEntry.getName())) {
                selectedEntries.add(entry);
            }
        }
        return selectedEntries;
    }

    public Entry getEntryByIdAndType(String id, Class classOfEntry) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id) && entry.getClass().getName().equals(classOfEntry.getName())) {
                return entry;
            }
        }
        return null;
    }

    public boolean entryExistsById(String id) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id)) {
                return true;
            }
        }
        return false;
    };

    public void addEntryIfNotExists(Entry entry) {
        entries.add(entry);
    }

    public boolean deleteEntryById(String id) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id)) {
                return entries.remove(entry);
            }
        }
        return false;
    }
}
