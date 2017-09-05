package com.example.user_pc.testsktl.domain.interaction.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by USER-PC on 11.08.2017.
 */

//единица логики
//должен знать входной и исходящий параметры (и их типы)
public abstract class UseCase<InParam, OutParam> {
    protected abstract OutParam buildUseCase();
    public OutParam execute(InParam param) {
        return buildUseCase();
    }
}
