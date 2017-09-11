package com.example.user_pc.testsktl.classwork16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user_pc.testsktl.R;

import io.realm.ObjectChangeSet;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObjectChangeListener;
import io.realm.RealmResults;

/**
 * Created by USER-PC on 26.07.2017.
 */


public class Classwork16Activity extends Activity {


    private Realm realm;
    private EditText editText;
    private Button button;
    private UserDb user;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork16Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);

        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        //вешаем кликлистнер
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //сохраняем текст из EditText в sharedprefernce
                saveData();
            }
        });


    }


    //здесь выплняется результат например по концу фотки (здесь важен резалткод)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getDefaultInstance(); //лучше здесь его открывать(реалм)
        loadData();
    }


    @Override
    protected void onPause() {
        super.onPause();
        realm.close();//лучше здесь его закрывать (реалм)
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void saveData() {
        if (user == null) {

//(позволяет выполнить в отдельном потоке: (это для примера часть кода)
//            realm.executeTransactionAsync(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//                    //to execute this code in new thread
//                }
//            });
//)позволяет выполнить в отдельном потоке: (это для примера часть кода)

            user = new UserDb();
            realm.beginTransaction();
            user.setId(13);
            user = realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();

            //( но так не работает:
            //user = realm.createObject(UserDb.class, user.getId());
            //realm.beginTransaction();
            //user.setId(13);
            //realm.commitTransaction();//обязательно здесь через транзкцию
            //)


        }

//схраняем юзера в бд реалм
        realm.beginTransaction();
        user.setName(String.valueOf(editText.getText()));
        realm.commitTransaction();//обязательно здесь через транзкцию
    }


    private void loadData() {

        user = realm.where(UserDb.class)
                .equalTo("id", 13)
                .findFirst();//здесь есть много всяких стандартных методов

        //(можно так для списка:
        //  RealmResults<UserDb> user = realm.where(UserDb.class)
        //          .equalTo("id", 13)
        //          .findAll();//здесь есть много всяких стандартных методов
        //)можно так для списка:

        if (user != null) {
            editText.setText(user.getName());

            //(rjulf мы не меняли а объект кто-то поменял (это для примера часть кода)
//            user.addChangeListener(new RealmObjectChangeListener<RealmModel>() {
//                @Override
//                public void onChange(RealmModel realmModel, ObjectChangeSet changeSet) {
//                    //кода объект  изменится на который мы повесили листенер
//                    Log.d("AAA", "user changed");
//                    editText.setText(user.getName());
//                }
//            });
            //)rjulf мы не меняли а объект кто-то поменял (это для примера часть кода)

        }
    }

}

