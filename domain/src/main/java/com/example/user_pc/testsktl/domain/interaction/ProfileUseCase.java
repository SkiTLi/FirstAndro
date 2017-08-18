package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Created by USER-PC on 11.08.2017.
 */

//public class ProfileUseCase extends UseCase<Void,ProfileModel> {//вообще здесь должно быть потом не void
public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {


    //получаем здесь профиль и отдаем его
    @Override
//    protected ProfileModel buildUseCase() {
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {
        //получаем здесь профиль и отдаем его
        //тут делается запрос к слою data в котором дергается метод на сервере (REST)
        //создаем  объект Profile который лежит в data
        //это дляя теста , будущем этот объект будетиз слоя data
        Profile profile = new Profile();
        profile.setName("kola");
        profile.setSurname("pupkin");
        profile.setAge(55);


//        return profile;

        //сделать задержку в 3 секунды

        return RestService.getInstance().getProfile()
                .map(new Function<List<Profile>, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull List<Profile> profileList)
                            throws Exception {
                        Profile profileData = profileList.get(0);
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setName(profileData.getName());
                        profileModel.setSurname(profileData.getSurname());
                        profileModel.setAge(profileData.getAge());
                        return profileModel;
                    }
                });
    }
}
