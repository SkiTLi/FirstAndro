package com.example.user_pc.testsktl.domain.interaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.user_pc.testsktl.domain.entity.AuthState;



import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.CompletableSubject;

/**
 * Created by USER-PC on 19.09.2017.
 */

//public class AuthService {
//
//    private static final String KEY_ACCESS_TOKEN = "AccessTOKEN";
//    private static final String SHARED_PREF_NAMED = "SHAREDPREFNAMED";
//
//    @Inject
//    public AuthService(Context context) {
//        this.context = context;
//        restoreAccessToken();
//    }
//
//    private Context context;
//
//    private BehaviorSubject<AuthState> state = BehaviorSubject
//            .createDefault(new AuthState(false));
//
////    public static AuthService getInstance() {
////        return instance;
////    }//сделаем даггером
//
//    private static AuthService instance = new AuthService();
//
//    private AuthService() {
//        restoreAccessToken();
//    }
//
//    public Observable<AuthState> observeState() {
//        return state;
//    }
//
//    void saveAccessToken(String accessToken) {
//        SharedPreferences sharedPreferences = context
//                .getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
//        sharedPreferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply();
//        //уведомл всех кто подписаны о том что мы залогенены
//        //точнее всех кто вызвал метод observeStoate()
//        state. onNext(new AuthState(true));
//    }
//
//    void removeAccessToken() {
//        SharedPreferences sharedPreferences = context
//                .getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
//        sharedPreferences.edit().remove(KEY_ACCESS_TOKEN).apply();
//        //уведомляем что мы разлогенены
//        state. onNext(new AuthState(false));
//    }
//
//    private void restoreAccessToken() {
//        SharedPreferences sharedPreferences = context
//                .getSharedPreferences(SHARED_PREF_NAMED, Context.MODE_PRIVATE);
//        sharedPreferences.edit().remove(KEY_ACCESS_TOKEN).apply();
//        //уведомляем что мы разлогенены
//        String token = sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
//        if(!TextUtils.isEmpty(token)){
//            state. onNext(new AuthState(true));
//        }else{
//            state. onNext(new AuthState(false));
//        }
//
//    }
//
//
//}
@Singleton
public class AuthService {

    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String SHARED_PREFS_NAME = "sharedPrefs";
    private Context context;
    private BehaviorSubject<AuthState> state = BehaviorSubject
            .createDefault(new AuthState(false));

    @Inject
    public AuthService(Context context) {
        this.context = context;
        restoreAccessToken();
    }

    public Observable<AuthState> observeState() {
        return state;
    }

    void saveAccesToken(String accessToken) {

        //сохраняем локально токен
        SharedPreferences preferences = context
                .getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        preferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply();

        //уведомляем всех подписчиков о том что мы залогинены (всех кто подписан к state,
        // точнее всех вто вызвал метод observeState())
        state.onNext(new AuthState(true));
    }

    void removeAccessToken() {
        //удаляем токен
        SharedPreferences preferences = context
                .getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        preferences.edit().remove(KEY_ACCESS_TOKEN).apply();

        //уведомляем о том что мы разлогинелись
        state.onNext(new AuthState(false));
    }

    private void restoreAccessToken() {

        //получаем токен
        SharedPreferences preferences = context
                .getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        String token = preferences.getString(KEY_ACCESS_TOKEN, null);

        //если токет не null - значит мы залогинены
        if(!TextUtils.isEmpty(token)) {
            state.onNext(new AuthState(true));
        } else {
            state.onNext(new AuthState(false));
        }
    }
}