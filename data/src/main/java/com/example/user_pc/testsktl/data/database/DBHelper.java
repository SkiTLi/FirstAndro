package com.example.user_pc.testsktl.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER-PC on 06.09.2017.
 */


//просто реализуем здесь абстрактные методы (наследуемые)
//здесь просто инициализируется бд
//делаем не public
class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test";
    private static final int VERSION = 1;//часто берут из градла версию

    public DBHelper(Context context) {//сонтекст либо активити либо апликейшн
        super(context, DATABASE_NAME, null, VERSION);
    }

    //вызовется если нет бд (например первый запуск)
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DBHelper", "onCreate()");

//по хорошему нужно ложить все в try  catch
        db.execSQL("CREATE TABLE user" +
                "('id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'name' TEXT," +
                "'age' INTEGER," +
                "'countryId' INTEGER)");
        db.execSQL("CREATE TABLE country" +
                "('id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'name' TEXT)");

        //  db.delete("user", "age=?" , "23"); например. т.о. можно избавиться от прямых скл запросов
        //очень удобно так использовать из-за того что в методах уже встроена проверка на вводимые значения


//        db.beginTransaction(); все что будет между этими строчками , при ошибке в любой из них ни одна не выполнится
//          ...
//        db.endTransaction();
    }

    //будетвызыватся если нужно обновить вашу бд
    //будет вызываться если изменилась версия бд
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("DBHelper", "onUpgrade()");
    }
}
