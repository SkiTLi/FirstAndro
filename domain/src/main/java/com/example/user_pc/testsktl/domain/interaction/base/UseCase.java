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

    private Disposable disposable;

    //    protected abstract OutParam buildUseCase();
    protected abstract Observable<OutParam> buildUseCase();


    //    public OutParam execute(InParam param) {//сделали voidom
    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        buildUseCase()//билдюзкейс будет только сформирован,но не запущен (для запуска нужно подписаться на него)
                .observeOn(AndroidSchedulers.mainThread())//здесь будет обработан ответ(конкретно здесь то что в UI-потоке)
                .subscribeOn(Schedulers.newThread())//здесь будет выыполнен ответ (выполнение в другом потоке)
                .subscribeWith(disposableObserver);//а вот здесь идет подписка (естественно и выполнятся начнет)
    }

    public void dispose() { //делаем отписку
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
