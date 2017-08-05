package com.example.user_pc.testsktl.classwork6;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.classwork5.MyIntentService;
import com.example.user_pc.testsktl.classwork5.MyServiceSktl;

import java.util.ArrayList;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class Classwork6Activity extends Activity {
    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private ArrayList<String> imageLinkArrayList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);//создается иерархия классов


        //это под вопросом
//        drawableArrayList.add(R.drawable.sova_anmation_1);
//        drawableArrayList.add(R.drawable.sova_anmation_2);
//        drawableArrayList.add(R.drawable.sova_anmation_3);


        stringArrayList.add("что-то 1");
        stringArrayList.add("что-то 2");
        stringArrayList.add("что-то 3");
        stringArrayList.add("что-то 4");
        stringArrayList.add("что-то 5");
        stringArrayList.add("что-то 6");
        stringArrayList.add("что-то 7");
        stringArrayList.add("что-то 8");
        stringArrayList.add("что-то 9");
        stringArrayList.add("что-то 10");
        stringArrayList.add("что-то 11");
        stringArrayList.add("что-то 12");
        stringArrayList.add("что-то 13");
        stringArrayList.add("что-то 14");
        stringArrayList.add("что-то 15");
        stringArrayList.add("что-то 16");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        //        один из менеджеров:
        // походу здесь задается прокрутка
//        GridLayoutManager
//        StaggeredGridLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //        можно горизонтально расположить
        //        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        ClassWork6Adapter adapter = new ClassWork6Adapter(stringArrayList);

        recyclerView.setAdapter(adapter);
    }
}