package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Photo;
import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.domain.entity.PhotoId;
import com.example.user_pc.testsktl.domain.entity.PhotoModel;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by USER-PC on 11.08.2017.
 */



//public class PhotoUseCase exte UseCase<PhotoId,Photo> {
public class PhotoUseCase extends UseCase<PhotoId,PhotoModel> {
//public class ProfileUseCase extends UseCase<Void,ProfileModel> {//вообще здесь должно быть потом не мщшв


    //получаем здесь профиль и отдаем его
    @Override
//    protected ProfileModel buildUseCase() {
    protected Observable<PhotoModel> buildUseCase() {
        //получаем здесь профиль и отдаем его
//тут делается запрос к слою data в котором дергается метод на сервере (REST)
//        создаем  объект Profile который лежит в data
        //это дляя теста , будущем этот объект будетиз слоя data

        Photo photo = new Photo();
        photo.setName("photo№001");
        photo.setUrl("https://static.comicvine.com/uploads/original/0/77/181095-150625-heroes-for-hire.jpg");


//        return profile;

//        сделать задержку в 3 секнды
        return Observable.just(photo)//горячий hot Observable
//                .doOnNext(new Consumer<Profile>() {
//                    @Override
//                    public void accept(Profile profile) throws Exception {
//
//                    }
//                })//для посмотреть с каким профайлом

                //        есть еще метод
                .filter(new Predicate<Photo>() {
                    @Override
                    public boolean test(@NonNull Photo photo) throws Exception {
                        return photo.getName() != null;
                    }
                })//метод фильтрации (если имя равно нал то не пройдет дальше)
//                .flatMap()//на примере другого Observable
//                .subscribeWith()
                .map(new Function<Photo, PhotoModel>() {//profile - входн данные бprofilemodel - вsходн данные
                    @Override
                    public PhotoModel apply(@NonNull Photo photo) throws Exception {
                        PhotoModel photoModel = new PhotoModel();
                        photoModel.setName(photo.getName());
                        photoModel.setUrl(photo.getUrl());
                        return photoModel;
                    }
                })//трансформируем в profileModel
//                .doOnNext(new Consumer<ProfileModel>() {
//                    @Override
//                    public void accept(ProfileModel profileModel) throws Exception {
//
//                    }
//                })//для посмотреть с каким профайлом
                .delay(3, TimeUnit.SECONDS);//just - непосредственно создает его


    }

}


