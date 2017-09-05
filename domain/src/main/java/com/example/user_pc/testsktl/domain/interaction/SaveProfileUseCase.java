package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;

import io.reactivex.Observable;

public class SaveProfileUseCase extends UseCaseNew<ProfileModel, Void> { //ProfileModel и domain . исходящий параметр Void  т.е. его не будет
    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {
        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());
        return RestService.getInstance().saveProfiles(profileData);
    }
}
