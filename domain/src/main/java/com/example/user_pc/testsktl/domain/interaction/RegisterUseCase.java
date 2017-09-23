package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.AccessTokenData;
import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.entity.RegisterData;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.OkDomain;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.entity.RegisterDomain;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
public class RegisterUseCase extends UseCaseNew<RegisterDomain, OkDomain> {

    private AuthService authService;

    @Inject
    public RegisterUseCase(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected Observable<OkDomain> buildUseCase(RegisterDomain param) {

        return RestService.getInstance().register(convert(param))
                .doOnNext(new Consumer<AccessTokenData>() {
                    @Override
                    public void accept(AccessTokenData accessTokenData) throws Exception {

                        authService.saveAccesToken(accessTokenData.getAccessToken());

                    }
                })
                .map(new Function<AccessTokenData, OkDomain>() {
                    @Override
                    public OkDomain apply(@NonNull AccessTokenData accessTokenData)
                            throws Exception {
                        return new OkDomain();
                    }
                });
    }

    private RegisterData convert(RegisterDomain registerDomain) {

        RegisterData registerData = new RegisterData();
        registerData.setUsername(registerDomain.getUsername());
        registerData.setPassword(registerDomain.getPassword());

        return registerData;
    }

}
//public class RegisterUseCase extends UseCaseNew<RegisterDomain, OkDomain> {
//
//    private AuthService authService;
//
//    public RegisterUseCase(AuthService authService) {
//        this .authService = authService;
//
//    }
//
//    @Override
//    protected Observable<OkDomain> buildUseCase(RegisterDomain param) {//d регистре хранится логин и пароль
//
//
//        return RestService.getInstance().register(convert(param))
//                //тут допишем сохранение токена:
//                .doOnNext(new Consumer<AccessTokenData>() {
//                    @Override
//                    public void accept(AccessTokenData accessTokenData) throws Exception {
//                        AuthService.getInstance()
//                                .saveAccessToken(accessTokenData.getAccessToken());
//                    }
//                })
//
//                .map(new Function<AccessTokenData, OkDomain>() {
//                    @Override
//                    public OkDomain apply(@NonNull AccessTokenData accessTokenData) throws Exception {
//                        return new OkDomain();
//                    }
//                });
//
//
//    }
//
//
//        private RegisterData convert (RegisterDomain registerDomain){
//            RegisterData registerData = new RegisterData();
//            registerData.setUsername(registerDomain.getUsername());
//            registerData.setPassword(registerDomain.getPassword());
//            return registerData;
//        }
//
//
//}
