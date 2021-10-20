package vn.edu.poly.demoxmlparser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.demoxmlparser.model.News;

public class NewDAO extends SQLiteOpenHelper {

    public NewDAO(Context context) {
        super(context, "abc.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table news(id int primary key,title text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertNew(News news) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", news.guiid);
        contentValues.put("title", news.title);
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.insert("news", null, contentValues);
    }

    public List<News> getList() {
        List<News> newsList = new ArrayList<>();
        String query = "select * from news";
        Cursor cursor = getReadableDatabase().rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(0);
                String title = cursor.getString(1);
                News news = new News();
                news.title = title;
                news.guiid = id;
                newsList.add(news);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return newsList;
    }
}
