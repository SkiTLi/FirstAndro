package com.example.user_pc.testsktl.di;

import android.content.Context;

import com.example.user_pc.testsktl.classwork17.Gson;
import com.example.user_pc.testsktl.classwork17.OkHttp;
import com.example.user_pc.testsktl.classwork17.Rest;
import com.example.user_pc.testsktl.classwork17.SharedPrefs;
import com.example.user_pc.testsktl.classwork17.UseCase1;
import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.SaveProfileUseCase;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

/**
 * Created by USER-PC on 11.09.2017.
 */


//здесь набор методов которые создают объекты
@Module //из пакета dagger аннотация
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    //название методов в даггере совершенно не важны
    @Provides

//@Singleton если один раз уже делали инджект то создаваться не будет//использовать по необходимости

//    @Named("ASktlprovideUseCase1")
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs sharedPrefs) {
        return new UseCase1(rest, sharedPrefs);
    }
//можно именовать если одинаковый возвращаемый тип даннных
//    @Named("BSktlprovideUseCase123")
//    public UseCase1 provideUseCase123(Rest rest, SharedPrefs sharedPrefs) {
//        return new UseCase1(rest, sharedPrefs);
//    }
    //@Named нужно обязательно использвать для напримр возвращаемого типа String



    @Provides
    public OkHttp provideOkHttp() {
        return new OkHttp();
    }

    @Provides
    public Gson provideGson() {
        return new Gson();
    }


    //напоминаю что даггер на названия методов не смотрит а смотрит на входящие параметры
    @Provides
    @Singleton
//@Singleton если один раз уже делали инджект то создаваться не будет//использовать по необходимости
    public Rest provideRest(OkHttp okHttp, Gson gson) {
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPrefs provideSharedPrefs() {
        return new SharedPrefs();
    }

}

//
//@Module
//public class AppModule {
//
//    private Context context;
//
//    public AppModule(Context context) {
//        this.context = context;
//    }
//
//    @Provides
//    public Context provideContext() {
//        return context;
//    }
//
//    @Provides
//    public UseCase1 provideUseCase1(Rest rest, SharedPrefs sharedPrefs) {
//        return new UseCase1(rest, sharedPrefs);
//    }
//
//    @Provides
//    public OkHttp provideOkHttp() {
//        return new OkHttp();
//    }
//
//    @Provides
//    public Gson provideGson() {
//        return new Gson();
//    }
//
//    @Provides
//    @Singleton
//    public Rest provideRest(OkHttp okHttp, Gson gson) {
//        return new Rest(okHttp, gson);
//    }
//
//    @Provides
//    public SharedPrefs provideSharedPrefs() {
//        return new SharedPrefs();
//    }
//}