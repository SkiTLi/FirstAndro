package com.example.user_pc.testsktl.classwork9_10;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.base.BaseActivity;

import io.reactivex.disposables.Disposable;

import com.example.user_pc.testsktl.databinding.ActivityClasswork9Binding;

import io.reactivex.annotations.NonNull;


import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by USER-PC on 26.07.2017.
 */


//продолжение темы mvvm
public class Classwork9Activity extends BaseActivity {

    //Subject - и поставщик инфы и подписчик
    public PublishSubject publishSubject = PublishSubject.create();//только после подписки
    public BehaviorSubject behaviorSubject = BehaviorSubject.create(); //сохраняет сохраненное значение (последний элемент)
    public ReplaySubject replaySubject = ReplaySubject.create();//хранит всю инфу
    Disposable disposable;

    //это для того чтобы его можно было вызвать в любом месте (для удбства)
    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork9Activity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Classwork9ViewModel viewModel = new Classwork9ViewModel();// дописали this и переписалитроху класворк8вьюмодел
        this.viewModel = viewModel;

        ActivityClasswork9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork9);

        binding.setViewModel(viewModel);//сгенерирована сама
        super.onCreate(savedInstanceState);

        replaySubject.onNext("один");
        replaySubject.onNext("два");
        replaySubject.onNext("три");
        replaySubject.onNext("четыре");
        disposable = (Disposable) replaySubject.subscribeWith(new DisposableObserver<String>() {

            //                replaySubject.subscribeWith(new DisposableObserver<String>() {//в этом мест подписываемся
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

        replaySubject.onNext("пять ");
        replaySubject.onNext("шесть");
        replaySubject.onNext("семмь");

        Button button = (Button) findViewById(R.id.just_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classwork9Activity.show(Classwork9Activity.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
