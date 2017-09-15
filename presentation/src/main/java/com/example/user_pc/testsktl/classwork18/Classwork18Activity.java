package com.example.user_pc.testsktl.classwork18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 26.07.2017.
 */


//должно перемещаться на разный уровень слоев, но здесь не работает
//работает тодько на мобиле
public class Classwork18Activity extends AppCompatActivity {

    //если убрать код про меню то работает со слоями штука


    View view;
    Button button1;
    Button button2;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork18Activity.class);
        activity.startActivity(intent);
    }

    //что показывать в меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //создается меню в пакете menu (в ресурсах)
        getMenuInflater().inflate(R.menu.classwork18_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    //здесь ловим клики в меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18old);


//(часть кода для меню
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_error_black_24dp);
//)часть кода для меню

        //эта фигня про очередность слоей:

        view = findViewById(R.id.view1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        final View viewRoot = findViewById(R.id.root);

        view.setVisibility(View.VISIBLE);
        //это как альтернатива и оно работает
//        ViewCompat.setZ(view,50000);
//        ViewCompat.setZ(button1,60000);
        view.bringToFront();

        button1.bringToFront();
//        button2.invalidate();
        viewRoot.requestLayout();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //это как альтернатива и оно работает
//        ViewCompat.setZ(view,70000);
//        ViewCompat.setZ(button1,80000);

                view.bringToFront();
                button2.getParent().bringChildToFront(button2);
//                button1.invalidate();
                viewRoot.requestLayout();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.bringToFront();
                button1.getParent().bringChildToFront(button1);
//                button1.invalidate();
                viewRoot.requestLayout();
            }
        });
    }
}
