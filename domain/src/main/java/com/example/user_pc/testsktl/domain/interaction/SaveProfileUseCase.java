package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;

import io.reactivex.Observable;


/**
 * Created by USER-PC on 11.08.2017.
 */


public class SaveProfileUseCase extends UseCase<ProfileModel, Void> { //ProfileModel и domain . bc[jlzzobq параметр Void  т.е. его не будет
//public class ProfileUseCase extends UseCase<Void,ProfileModel> {//вообще здесь должно быть потом не мщшв


    //получаем здесь профиль и отдаем его
    @Override
//    protected ProfileModel buildUseCase() {
    protected Observable<Void> buildUseCase(ProfileModel param) {
        //получаем здесь профиль и отдаем его
//тут делается запрос к слою data в котором дергается метод на сервере (REST)
//        создаем  объект Profile который лежит в data
        //это дляя теста , будущем этот объект будетиз слоя data
        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());


        return RestService.getInstance().saveProfiles(profileData);



    }

}
