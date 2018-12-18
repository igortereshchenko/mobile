package tereshchenko.igor.mobile.LessonActivity.DbHandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseNewsHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "android_db.db";
    public static final int VERSION = 1;

    public static final String TABLE = "news";
    public static final String NEWS_ID = "_id";
    public static final String NEWS_TITLE = "news_title";
    public static final String NEWS_CONTEXT = "news_context";
    public static final String NEWS_DATE = "news_date";
    public static final String NEWS_IMAGE = "news_image";

    public DatabaseNewsHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE \"news\" ( `_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `news_title` TEXT NOT NULL, `news_context` TEXT NOT NULL, `news_date` TEXT NOT NULL, `news_image` TEXT )";

        sqLiteDatabase.execSQL(query);

        //upload from server
        sqLiteDatabase.execSQL("INSERT INTO `news` (_id,news_title,news_context,news_date,news_image) VALUES (1,'title1','context1','10.10.2018',NULL);");
        sqLiteDatabase.execSQL("INSERT INTO `news` (_id,news_title,news_context,news_date,news_image) VALUES (2,'title2','context2','10.12.2018',NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists news");

        onCreate(sqLiteDatabase);


    }
}
