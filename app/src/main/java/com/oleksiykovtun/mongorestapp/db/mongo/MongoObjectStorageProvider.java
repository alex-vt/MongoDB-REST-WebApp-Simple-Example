package com.oleksiykovtun.mongorestapp.db.mongo;

import com.mongodb.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Provides MongoDB storage of POJO objects
 */
abstract class MongoObjectStorageProvider {

    private static final String MONGODB_HOSTNAME = "localhost";
    private static final int MONGODB_PORT = 27017;

    private static final String DB_NAME = "db";
    private static final String OBJECT_COLLECTION_NAME = "collection";

    private static DBCollection dbCollection = null;

    static {
        try {
            MongoClient mongoClient = new MongoClient(MONGODB_HOSTNAME, MONGODB_PORT);
            DB db = mongoClient.getDB(DB_NAME);
            dbCollection = db.getCollection(OBJECT_COLLECTION_NAME);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void putObjectToDb(Object object) throws Throwable {
        DBObject document = MongoObjectConverter.getMongoDbObject(object);
        dbCollection.insert(document);
    }

    public static boolean deleteObjectFromDbById(String id) throws Throwable {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);
        dbCollection.remove(searchQuery);
        return true;
    }

    public static boolean objectExistsById(String id) throws Throwable {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);
        Cursor cursor = dbCollection.find(searchQuery);
        return cursor.hasNext();
    }

    public static <T> T getObjectFromDbById(String id, Class<T> objectClass) throws Throwable {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);
        DBObject result = dbCollection.findOne(searchQuery);
        return MongoObjectConverter.getPojo(result, objectClass);
    }

    public static Set<Object> getObjectSetFromDbByClass(Class objectClass) throws Throwable {
        Set<Object> objectSet = new LinkedHashSet<Object>();
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            DBObject dbObject = cursor.next();
            try {
                String objectId = (String) dbObject.get("id");
                if (objectId.startsWith(objectClass.getSimpleName() + "_")) {
                    Object object = getObjectFromDbById(objectId, objectClass);
                    objectSet.add(object);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return objectSet;
    }
}
