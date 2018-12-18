package tereshchenko.igor.mobile.LessonActivity.DbHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import tereshchenko.igor.mobile.LessonActivity.CustomAdapter.News;

public class Handler {

    public static List<News> getNews(){

        return null;

    }


    public static void createTextTable(Context context){

        SQLiteDatabase db = ((AppCompatActivity)context).getBaseContext().openOrCreateDatabase("android_test_db.db",Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE text_table (" +
                "name TEXT, " +
                "age INTEGER" +
                ")");

        db.close();
    }


    public static void insertTestTable(Context context){

        SQLiteDatabase db = ((AppCompatActivity)context).getBaseContext().openOrCreateDatabase("android_test_db.db",Context.MODE_PRIVATE,null);

        db.execSQL("INSERT INTO text_table VALUES('Bob',20)");
        db.execSQL("INSERT INTO text_table VALUES('Boba',19)");

        db.close();
    }


    public static ArrayList<String> selectTestTable(Context context){

        ArrayList<String> list = new ArrayList<>();

        SQLiteDatabase db = ((AppCompatActivity)context).getBaseContext().openOrCreateDatabase("android_test_db.db",Context.MODE_PRIVATE,null);

        Cursor cursor = db.rawQuery("SELECT * FROM text_table",null);


        if (cursor.moveToFirst()){

            do{

                String row = cursor.getString(0) + " "+cursor.getInt(1);
                list.add(row);

            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }
}
