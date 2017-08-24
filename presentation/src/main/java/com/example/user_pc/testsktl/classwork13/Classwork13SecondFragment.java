package com.example.user_pc.testsktl.classwork13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 21.08.2017.
 */

public class Classwork13SecondFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getArguments()ю//выдираются аргументы
    }

    //можно ли во фрагменте определить несколько конструкторов - от вет : создавать можно, но падаватьданные нельзя (те пользоваться можно только без ппапраметров)
//т.к. при востановлении андроид будет использовать конструктор по умолчанию (без параметров)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);//перепишем
        return inflater.inflate(R.layout.fragment_classwork13_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getActivity();
        //создавать вью в onCreateView нельзя, это не правильно
    }


    //этот метод создается только тогда когда ужесоздано активити
    //после этого метода можно использовать метод getActivity()
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
