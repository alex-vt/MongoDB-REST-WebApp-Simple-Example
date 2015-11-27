package com.oleksiykovtun.mongorestapp.db;

import com.oleksiykovtun.mongorestapp.model.Entry;
import com.oleksiykovtun.mongorestapp.model.Item;
import com.oleksiykovtun.mongorestapp.model.User;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A primitive data store with no persistence
 * TODO: replace with MongoDB example
 */
public class InMemorySimpleDb {

    private static Set<Entry> entries = new LinkedHashSet<Entry>();

    static {
        entries.add(new User("Default Test User 1", "password"));
        entries.add(new User("Default Test User 2", "12345678"));
        entries.add(new Item("Default Test Item 1"));
        entries.add(new Item("Default Test Item 2"));
    }

    public static Set<Entry> getEntriesByType(Class classOfEntry) {
        Set<Entry> selectedEntries = new LinkedHashSet<Entry>();
        for (Entry entry : entries) {
            if (entry.getClass().getName().equals(classOfEntry.getName())) {
                selectedEntries.add(entry);
            }
        }
        return selectedEntries;
    }

    public static Entry getEntryById(String id) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }
        return null;
    }

    public static void addEntry(Entry entry) {
        entries.add(entry);
    }

    public static boolean deleteEntryById(String id) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id)) {
                return entries.remove(entry);
            }
        }
        return false;
    }

}
