package com.example.user_pc.testsktl.data.net;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by USER-PC on 16.08.2017.
 */

public class RestService {
    private static final RestService instance = new RestService();

    private RestApi restApi;

    private RestService() {
        init();
    }

    public static RestService getInstance() {
        return instance;
    }

    private void init() {
        //         низкоуровневыйклиент для взаимодействия retrofit и http
        //в домашке нужно сделать 3 usecase

//        HttpLoggingInterceptor logging = new H //нужно добавить это ноне добавляется (это для того чтобы можно было смотеть логи)

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //                .addInterceptor(logging)//не могу создать
                .readTimeout(10, TimeUnit.SECONDS)//если в течении 10 сеунд ответа нет то запрос считать неправильным
                .connectTimeout(10, TimeUnit.SECONDS)//если в течении 10 секнд не можем подключиться к серверу
                .build();
        //библиотекадля парсинга
        Gson gson = new GsonBuilder().create();
        //создаем ретрофит
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")//повторяющаяс часть ссылки
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//говорит что делать через rx
                .addConverterFactory(GsonConverterFactory.create())//как конвертироватьданные
                .client(okHttpClient)//устанавливает клиент через который онбудет ломиться (через okhttp)
                .build();

        restApi = retrofit.create(RestApi.class); //через это будем дергать все данные
    }


    public Observable<List<Profile>> getProfile() {
        return restApi.getProfiles();
    }

    public Observable<Void> saveProfiles(Profile profile) {
        return restApi.saveProfile(profile);
    }
}
