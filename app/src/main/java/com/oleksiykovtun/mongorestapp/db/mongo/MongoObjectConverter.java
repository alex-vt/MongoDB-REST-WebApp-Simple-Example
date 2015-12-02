package com.oleksiykovtun.mongorestapp.db.mongo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.mongodb.BasicDBObject;
import com.mongodb.DBEncoder;
import com.mongodb.DBObject;
import com.mongodb.DefaultDBEncoder;
import com.mongodb.LazyWriteableDBObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.bson.LazyBSONCallback;
import org.bson.io.BasicOutputBuffer;
import org.bson.io.OutputBuffer;
import org.jongo.marshall.jackson.bson4jackson.MongoBsonFactory;

/**
 * Converts objects between MongoDB and POJO
 */
abstract class MongoObjectConverter {

    private final static ObjectMapper mapper = new ObjectMapper(MongoBsonFactory.createFactory());

    static {
        mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(
                JsonAutoDetect.Visibility.ANY));
    }

    public static DBObject getMongoDbObject(Object object) throws IOException {
        ObjectWriter writer = mapper.writer();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        writer.writeValue(stream, object);
        DBObject dbo = new LazyWriteableDBObject(stream.toByteArray(), new LazyBSONCallback());
        //turn it into a proper DBObject otherwise it can't be edited.
        DBObject result = new BasicDBObject();
        result.putAll(dbo);
        return result;
    }

    public static <T> T getPojo(DBObject dbObject, Class<T> clazz) throws IOException {
        ObjectReader reader = mapper.reader(clazz);
        DBEncoder dbEncoder = DefaultDBEncoder.FACTORY.create();
        OutputBuffer buffer = new BasicOutputBuffer();
        dbEncoder.writeObject(buffer, dbObject);
        return reader.readValue(buffer.toByteArray());
    }
}
