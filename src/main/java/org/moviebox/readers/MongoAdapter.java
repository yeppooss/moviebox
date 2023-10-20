package org.moviebox.readers;

import com.mongodb.client.*;
import org.bson.Document;
import org.moviebox.models.Movie;
import org.moviebox.storages.MovieStorage;

import java.util.ArrayList;

public class MongoAdapter extends IDBAdapter{
    final private MongoClient mongoClient;

    public MongoAdapter(String url, String databaseName, String tableName) {
        super(databaseName, tableName);
        this.mongoClient = MongoClients.create(url);
    }


    @Override
    public MovieStorage load() {
        MongoDatabase database = getMongoDataBase(databaseName);
        MongoCollection<Document> collection = database.getCollection(tableName);
        FindIterable<Document> cursor = collection.find();

        MovieStorage movieStorage = new MovieStorage();

        try(final MongoCursor<Document> cursorIterator = cursor.cursor()){
            while (cursorIterator.hasNext()){
                Document currentDocument = cursorIterator.next();

                movieStorage.add(buildMovie(currentDocument));
            }
        }

        return movieStorage;
    }

    private MongoDatabase getMongoDataBase(String databaseName){
        return mongoClient.getDatabase(databaseName);
    }

    private Movie buildMovie(Document document){
        String id = document.getObjectId("_id").toString();
        String title = document.getString("title");
        String director = document.getString("director");
        Integer year = document.getInteger("year");
        ArrayList<String> genres = (ArrayList<String>) document.get("genres");
        Double rating = document.getDouble("rating");

        return new Movie(id, title, director, year, genres, rating);
    }
}
