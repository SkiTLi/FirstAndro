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
    //возврощает все профили
    @GET("data/profile")
    Observable<List<Profile>> getProfiles();

    //в backendless должна появиться новая строка
    @POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile);
}
