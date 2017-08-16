package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


/**
 * Created by USER-PC on 11.08.2017.
 */


public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {
//public class ProfileUseCase extends UseCase<Void,ProfileModel> {//вообще здесь должно быть потом не мщшв


    //получаем здесь профиль и отдаем его
    @Override
//    protected ProfileModel buildUseCase() {
    protected Observable<ProfileModel> buildUseCase() {
        //получаем здесь профиль и отдаем его
//тут делается запрос к слою data в котором дергается метод на сервере (REST)
//        создаем  объект Profile который лежит в data
        //это дляя теста , будущем этот объект будетиз слоя data
        Profile profile = new Profile();
        profile.setName("kola");
        profile.setSername("pupkin");
        profile.setAge(55);


//        return profile;

//        сделать задержку в 3 секунды
        return Observable.just(profile)//горячий hot Observable
//                .doOnNext(new Consumer<Profile>() {
//                    @Override
//                    public void accept(Profile profile) throws Exception {
//                    }
//                })//для посмотреть с каким профайлом

                //        есть еще метод
                .filter(new Predicate<Profile>() {
                    @Override
                    public boolean test(@NonNull Profile profile) throws Exception {
                        return profile.getName() != null;
                    }
                })//метод фильтрации (если имя равно нал то не пройдет дальше)
//                .flatMap()//на примере другого Observable
//                .subscribeWith()
                .map(new Function<Profile, ProfileModel>() {//profile - входн данные бprofilemodel - вsходн данные
                    @Override
                    public ProfileModel apply(@NonNull Profile profile) throws Exception {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setName(profile.getName());
                        profileModel.setSername(profile.getSername());
                        profileModel.setAge(profile.getAge());
                        return profileModel;
                    }
                })//трансформируем в profileModel
//                .doOnNext(new Consumer<ProfileModel>() {
//                    @Override
//                    public void accept(ProfileModel profileModel) throws Exception {
//                    }
//                })//для посмотреть с каким профайлом
                .delay(3, TimeUnit.SECONDS);//just - непосредственно создает его


    }

}
