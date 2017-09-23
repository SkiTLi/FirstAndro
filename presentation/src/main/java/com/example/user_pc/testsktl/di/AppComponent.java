package com.example.user_pc.testsktl.di;

import com.example.user_pc.testsktl.classwork17.UI;
import com.example.user_pc.testsktl.classwork21.RegisterPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by USER-PC on 11.09.2017.
 */

//этот пакет для даггера делается

//это связующее звено межно  аннотацией @inject и даггером (это мост)

    //это сугубо настроечный класс

    //здесь в этой аннотации прописываются все модули
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    //сюда потом можно запиать то что хотим инджектить
    public void inject(RegisterPresenter presenter);


    public void inject(UI ui);
}


//@Component(modules = {AppModule.class})
//@Singleton
//public interface AppComponent {
//
//    public void inject(UI ui);
//
//    public void inject(RegisterPresenter presenter);
//}
