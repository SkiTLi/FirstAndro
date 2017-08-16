package com.example.user_pc.testsktl.homework9_new_gallery;

import android.databinding.ObservableField;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.domain.entity.PhotoId;
import com.example.user_pc.testsktl.domain.entity.PhotoModel;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.PhotoUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by USER-PC on 09.08.2017.
 */


//плюс тема ПОТОКИ
public class HW9ViewModel implements BaseViewModel {


    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("паша");
    public ObservableField<String> url = new ObservableField<>("любимов");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);


    private PhotoUseCase useCase = new PhotoUseCase();

    @Override
    public void init() {

        //натыкать везде логи

    }

    @Override
    public void release() {
    }


    @Override
    public void resume() {
        PhotoId photoId = new PhotoId();
        photoId.setId("333");//это для теста как будто у нас есть id пользователя
       useCase.execute(photoId, new DisposableObserver<PhotoModel>() {
            @Override
            public void onNext(@NonNull PhotoModel photo) {
                name.set(photo.getName());
                url.set(photo.getUrl());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("sktl", "ошибка в onError");
            }

            @Override
            public void onComplete() {

            }


        });
    }

    @Override
    public void pause() {

    }
}