package com.example.historyproj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "your_database";
    private static final int DATABASE_VERSION = 2;


    //Tabela users
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Tabela posty
    public static final String TABLE_POSTS = "posts";
    public static final String COLUMN_POST_ID = "id";
    public static final String COLUMN_POST_NAME = "name";
    public static final String COLUMN_POST_PLACE = "place";
    public static final String COLUMN_POST_INFO = "info";

    // Konstruktor
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL)";
        db.execSQL(createTableQuery);

        String createPostsTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_POSTS + " (" +
                COLUMN_POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_POST_NAME + " TEXT NOT NULL," +
                COLUMN_POST_PLACE + " TEXT NOT NULL," +
                COLUMN_POST_INFO + " TEXT NOT NULL)";
        db.execSQL(createPostsTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Szczerze chuj go wie co tu dać
        //edit1 już wiem nie ruszać tego bez mojej wiedzy
    }
    public class Post {
        private int id;
        private String name;
        private String place;
        private String info;

        public Post(int id, String name, String place, String info) {
            this.id = id;
            this.name = name;
            this.place = place;
            this.info = info;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
    public void deletePost(int postId) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Użyj metody delete, aby usunąć post na podstawie ID
        db.delete(TABLE_POSTS, COLUMN_POST_ID + " = ?",
                new String[]{String.valueOf(postId)});
        db.close();
    }
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_POSTS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int postId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_POST_ID));
                String postName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POST_NAME));
                String postPlace = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POST_PLACE));
                String postInfo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POST_INFO));


                Post post = new Post(postId, postName, postPlace, postInfo);
                posts.add(post);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        for (Post post : posts) {
            Log.d("PostData", "ID: " + post.getId() + ", Name: " + post.getName());
        }

        return posts;
    }
}
