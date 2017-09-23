package com.example.user_pc.testsktl.classwork21;

import com.example.user_pc.testsktl.SktlApplication;
import com.example.user_pc.testsktl.domain.entity.AuthState;
import com.example.user_pc.testsktl.domain.entity.OkDomain;
import com.example.user_pc.testsktl.domain.entity.RegisterDomain;
import com.example.user_pc.testsktl.domain.interaction.AuthService;
import com.example.user_pc.testsktl.domain.interaction.RegisterUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class RegisterPresenter implements RegisterBasePresenter{

    @Inject
    public RegisterUseCase useCase;

    @Inject
    public AuthService authService;

    private Disposable authDisposable;

    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        SktlApplication.appComponent.inject(this);
        this.view = view;
    }

    @Override
    public void onRegisterButtonClick(String username, String password) {

        view.showProgress();

        RegisterDomain register = new RegisterDomain();
        register.setUsername(username);
        register.setPassword(password);

        useCase.execute(register, new DisposableObserver<OkDomain>() {
            @Override
            public void onNext(@NonNull OkDomain okDomain) {
                view.dismissProgress();
                view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError("error");
            }

            @Override
            public void onComplete() {
            }
        });

    }

    @Override
    public void onResume() {

        authDisposable = authService.observeState().subscribeWith(new DisposableObserver<AuthState>() {
            @Override
            public void onNext(@NonNull AuthState authState) {
                //проверяем состояние авторизации
                if(authState.isSigned()) {
                    view.goToMainActivity();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {}
            @Override
            public void onComplete() {}
        });

    }

    @Override
    public void onPause() {
        if(authDisposable != null && !authDisposable.isDisposed()) {
            authDisposable.dispose();
        }
    }
}
