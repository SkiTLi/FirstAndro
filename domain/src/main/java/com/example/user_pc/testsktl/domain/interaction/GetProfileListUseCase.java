package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.data.entity.Profile;
import com.example.user_pc.testsktl.data.net.RestService;
import com.example.user_pc.testsktl.domain.entity.ProfileId;
import com.example.user_pc.testsktl.domain.entity.ProfileModel;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileListUseCase extends UseCaseNew<ProfileId, List<ProfileModel>> {

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(ProfileId param) {
        return RestService
                .getInstance()
                .getProfile()
                .map(new Function<List<Profile>, List<ProfileModel>>() {
                    @Override
                    public List<ProfileModel> apply(@NonNull List<Profile> profiles)
                            throws Exception {
                        List<ProfileModel> list = new ArrayList<>();
                        for (Profile profile : profiles) {
                            list.add(convert(profile));
                        }
                        return list;
                    }
                });
    }

    private ProfileModel convert(Profile dataModel) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}
