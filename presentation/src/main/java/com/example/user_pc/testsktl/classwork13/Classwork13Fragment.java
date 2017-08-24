package com.example.user_pc.testsktl.classwork13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;//из supporta
import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 21.08.2017.
 */

public class Classwork13Fragment extends Fragment {


    public static final String TEXT_KEY = "TEXT_KEY";
//    private String text;//должно быть , но я сделал protected
    protected String text;

//   bundle //это типо hashmap


    //нужно gps через google play
    public static Classwork13Fragment newInstance(FragmentManager fragmentManager, String text) {

        Fragment fragment = fragmentManager
                .findFragmentByTag(Classwork13Fragment.class.getName());

        Classwork13Fragment classwork13Fragment;
        if (fragment != null && fragment instanceof Classwork13Fragment) {
            classwork13Fragment = (Classwork13Fragment) fragment;
        } else {
            classwork13Fragment = new Classwork13Fragment();
            Bundle bunde = new Bundle();
            bunde.putString(TEXT_KEY, text);
            classwork13Fragment.setArguments(bunde);
        }

        return classwork13Fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        getArguments()ю//выдираются аргументы
        Bundle bundle = getArguments();
        if (bundle != null) {
            text = bundle.getString(TEXT_KEY);
            //        если брать не activity а fragmen в основном то нужно брать getChildMAngerFragment
        }
    }

    //можно ли во фрагменте определить несколько конструкторов - от вет : создавать можно, но падаватьданные нельзя (те пользоваться можно только без ппапраметров)
//т.к. при востановлении андроид будет использовать конструктор по умолчанию (без параметров)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);//перепишем
        return inflater.inflate(R.layout.fragment_classwork13, container, false);


        //здесь биндинг binding.root
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity();
        //создавать вью в onCreateView нельзя, это не правильно
    }


    //этот метод создается только тогда когда ужесоздано активити
    //после этого метода можно использовать метод getActivity()
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

//
//    @Override
//    public void onStart() {
//        super.onStart();
//    }
//
//
//    @Override
//    public void onStop() {
//        super.onStop();
//    }


    //добавили к активити
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }

    //открепили к активити
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }

    //когда активити умерла вызовится в 99% случаев (во фрагменте на него можно рассчитывать)
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
}
