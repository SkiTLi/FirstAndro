package com.example.user_pc.testsktl.homework10_timer;

import android.databinding.ObservableField;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.domain.entity.PhotoId;
import com.example.user_pc.testsktl.domain.entity.PhotoModel;
import com.example.user_pc.testsktl.domain.interaction.PhotoUseCase;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by USER-PC on 09.08.2017.
 */


//плюс тема ПОТОКИ
public class HW10ViewModel implements BaseViewModel {
    private Disposable disposable;
    public ObservableField<String> timer = new ObservableField<>();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        disposable = Observable
                .interval(1, 1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong % 2 == 0;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        timer.set(String.valueOf(aLong));
                    }
                });
    }

    @Override
    public void pause() {
        disposable.dispose();
    }
}