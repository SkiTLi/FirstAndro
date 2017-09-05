package com.example.user_pc.testsktl.homework9_new_gallery;

import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.domain.entity.PhotoId;
import com.example.user_pc.testsktl.domain.entity.PhotoModel;
import com.example.user_pc.testsktl.domain.interaction.PhotoUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by USER-PC on 09.08.2017.
 */

public class HW9ViewModel implements BaseViewModel {

    public HW9ItemViewModel[] items = new HW9ItemViewModel[15];
    private PhotoUseCase photoUseCase = new PhotoUseCase();


    @Override
    public void resume() {
        for (int i = 0; i < 15; i++) {
            final PhotoId id = new PhotoId();
            id.setId(i);
            photoUseCase.execute(id, new DisposableObserver<PhotoModel>() {

                HW9ItemViewModel picture;
                int number = id.getId();

                @Override
                public void onNext(@NonNull PhotoModel photoModel) {
                    picture = new HW9ItemViewModel(photoModel.getUrl());
                    items[number] = picture;
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.e("ERROR!!!", "onExecute", e);
                }

                @Override
                public void onComplete() {
                }
            });
        }
    }


    @Override
    public void init() {
    }


    @Override
    public void release() {
    }

    @Override
    public void pause() {
    }
}