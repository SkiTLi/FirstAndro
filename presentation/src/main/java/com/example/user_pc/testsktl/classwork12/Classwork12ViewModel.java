package com.example.user_pc.testsktl.classwork12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.GetProfileListUseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;


/**
 * Created by USER-PC on 09.08.2017.
 */


//здесь нужно с github
public class Classwork12ViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public Activity activity;

    public Classwork12ViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileListUseCase getProfileListUseCase = new GetProfileListUseCase();

    public ProfileAdapter adapter = new ProfileAdapter();

    @Override
    public void init() {
    }

    @Override
    public void resume() {

        getProfileListUseCase.execute(null, new DisposableObserver<List<ProfileModel>>() {

            @Override
            public void onNext(List<ProfileModel> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAAA items = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA item", "onComplete");
            }
        });
    }

    @Override
    public void pause() {
        //getProfileListUseCase.dispose();
    }

    @Override
    public void release() {
    }
}