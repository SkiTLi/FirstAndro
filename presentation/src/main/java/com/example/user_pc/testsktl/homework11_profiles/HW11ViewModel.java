package com.example.user_pc.testsktl.homework11_profiles;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.user_pc.testsktl.base.BaseViewModel;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.ProfileUseCase;
import com.example.user_pc.testsktl.domain.interaction.SaveProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by USER-PC on 09.08.2017.
 */


//плюс тема ПОТОКИ
public class HW11ViewModel implements BaseViewModel {


    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("паша");
    public ObservableField<String> sername = new ObservableField<>("любимов");
    public ObservableInt age = new ObservableInt(11);
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);


    private ProfileUseCase useCase = new ProfileUseCase();
    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {
    }


    @Override
    public void resume() {


        ProfileModel profileModel = new ProfileModel();
        profileModel.setName("Стив");
        profileModel.setSurname("Роджерс");
        profileModel.setAge(26);
        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.d("AAA", "ОК");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("AAA", "error = ", e);
            }


//            в онкомплите может возвращать несколько значений
            @Override
            public void onComplete() {

            }
        });



        ProfileId profileId = new ProfileId();
        profileId.setId("333");//это для теста как будто у нас есть id пользователя
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {

                name.set(profile.getName());
                sername.set(profile.getSurname());
                age.set(profile.getAge());

                state.set(STATE.DATA);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "onError : " + e);
            }

            @Override
            public void onComplete() {

            }


        });//.prtqc - типизированный файл


    }

    @Override
    public void pause() {
        //натыкать везде логи
        saveProfileUseCase.dispose();
        useCase.dispose();//yt знаю нужно или нет
    }


}
