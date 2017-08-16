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
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by USER-PC on 09.08.2017.
 */


//плюс тема ПОТОКИ
public class HW10ViewModel implements BaseViewModel {


    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("паша");
    public ObservableField<String> url = new ObservableField<>("любимов");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    public Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
    private PhotoUseCase useCase = new PhotoUseCase();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }


    @Override
    public void resume() {




//        PhotoId photoId = new PhotoId();
//        photoId.setId("333");//это для теста как будто у нас есть id пользователя
////        useCase.execute(photoId, new DisposableObserver<Long>() );
//
//        buildUseCase()//билдюзкейс будет только сформирован,но не запущен (для запуска нужно подписаться на него)
//                .observeOn(AndroidSchedulers.mainThread())//здесь будет обработан ответ(конкретно здесь то что в UI-потоке)
//                .subscribeOn(Schedulers.newThread())//здесь будет выыполнен ответ (выполнение в другом потоке)
//                .subscribeWith(disposableObserver);//а вот здесь идет подписка (естественно и выполнятся начнет)
//
//
//            values.dispose(
//
//            @Override
//            public void onNext(@NonNull Long aLong) {
//                Log.e("sktl", "таймер " + aLong);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.e("sktl", "ошибка в onError");
//            }
//
//            @Override
//            public void onComplete() {
//            }
//            )
    }


    @Override
    public void pause() {
    }
}