package com.example.user_pc.testsktl.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.user_pc.testsktl.data.dbentity.Country;
import com.example.user_pc.testsktl.data.dbentity.User;

import java.util.List;

/**
 * Created by USER-PC on 06.09.2017.
 */
//будет работать непосредственно с dbhelper и здесь уже будет основная работа
public class DatabaseManager {
    Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase database;

//    sqlite потоко не безопасно тк выполняется в ui потоке

    public DatabaseManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    //open и close делать обязательно в одном и том же потоке

    //метод открытия  бд
    public void open(boolean isWritable) { //либо writable либо readable
        if (isWritable) {
            database = dbHelper.getWritableDatabase();

        } else {
            database = dbHelper.getReadableDatabase();
        }
    }

    //метод закрытия бд
    public void close() {
        if (database != null) {
            database.close();
        }
    }

    //    до этого момента в этом классе сделали инициализацию бд
//если энтити будет много то менеджер должен быть для каждой свой
    public void insertUser(User user) {


        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INtO user ('name', 'age', 'countryId')");
        sql.append("VALUES (");
        sql.append("'");
        sql.append(user.getName());
        sql.append("',");
        sql.append(user.getAge());
        sql.append("'");
        sql.append(user.getCountry().getId());
        sql.append(")");
        //gj итогу должно получиться:
        //INSERT INtO user ('name', ' age', 'countryId') Values ('Name', 25, 0)


        Log.e("DatabaseMAnager", "insertUsser()");
        database.execSQL(sql.toString());
    }

    public void updateUser() {

    }

    public List<User> getUsers() {
        return null;
    }

    public User getUserById(String id) {
//        Cursor - типа коллекции что-тоб в которой хранятся данныее которые мы выбрали из бд
                Cursor cursor = database.rawQuery("SELECT * FROM user INNER JOIN country ON "+
                        "user.countryId=country.id WHERE id = ?",
                new String[]{String.valueOf(id)});
//        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE id = ?",
//                new String[]{String.valueOf(id)});
//        Cursor cursor =  database.rawQuery("SELECT * FROM user WHERE id = " + id, null); //это то же самое (тоже правильно и будет работать)

        if (cursor != null) {

            User user = new User();

            //тк  каретка курсора остается всегда при записи на последнем элементе, то
            cursor.moveToFirst();
            //вытягиваем данные из курсора
            int userId = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);

            int countryId = cursor.getInt(3);
            String countryName = cursor.getString(4);
            //заполняе объект user
            user.setId(userId);
            user.setName(name);
            user.setAge(age);

            Country country  = new Country();
            //заполняе объект country
            country.setId(countryId);
            country.setName(countryName);

            //Добавляем объект Country в User
            user.setCountry(country);
            return user;

        } else {
            Log.e("DatabaseManager", "getUsrById() cursor is null");
        }

        return null;
    }

}
