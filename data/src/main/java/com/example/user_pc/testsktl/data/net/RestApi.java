package com.example.user_pc.testsktl.data.net;

import com.example.user_pc.testsktl.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by USER-PC on 16.08.2017.
 */

public interface RestApi {

    //иудет в {} подкидываться id из строки снизу
    //пока без параметров.<Profile> - тип данных в Observable
//    @GET("data/profile?where=\"id={id}\"")//это все
    @GET("data/profile")//это один
//    Observable<List<Profile>> getProfiles(@Path("id\") String id);//yt работает
//    Observable<List<Profile>> getProfiles(@Path("id") String id);//по их id //Query .s cltkfk
    Observable<List<Profile>> getProfiles();


    @POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile);//d backendless должна появиться новая строка

}
