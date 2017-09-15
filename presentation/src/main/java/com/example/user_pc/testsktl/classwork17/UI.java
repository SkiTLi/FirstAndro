package com.example.user_pc.testsktl.classwork17;

import com.example.user_pc.testsktl.SktlApplication;

import javax.inject.Inject;

/**
 * Created by USER-PC on 11.09.2017.
 */


//зачастую делают этот функциоал во вьюмоделе
public class UI {

    //этой аннотацией даггер все сам делает для переменной(делать нью не нужно)
    @Inject
    UseCase1 useCase1;

    public UI() {
        //( эту строчку нужно писать везде где хотим использовать  @Inject UseCase1 useCase1
        // , но на слое presentation;//в домейне и дата эту строчку не используют
        SktlApplication.appComponent.inject(this);
        //) эту строчку нужно писать везде где хотим использовать  @Inject UseCase1 useCase1;
    }

    //этот методод допустим лежит в вашей вьюмодели
    public void testUseCase1() {
        //по идее нужно сюда передавать параметры

        useCase1.getRestData();
    }


}
