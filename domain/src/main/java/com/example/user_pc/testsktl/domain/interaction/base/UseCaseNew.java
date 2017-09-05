package com.example.user_pc.testsktl.domain.interaction.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public abstract class UseCaseNew<InParam, OutParam> {

    private Disposable mDisposable;

    protected abstract Observable<OutParam> buildUseCase(InParam param);

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        mDisposable = buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(disposableObserver);
    }

    public void dispose() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
