package com.example.user_pc.testsktl.domain.interaction;


import com.example.user_pc.testsktl.data.database.DatabaseManager;
import com.example.user_pc.testsktl.domain.entity.AddUser;
import com.example.user_pc.testsktl.domain.entity.Country;
import com.example.user_pc.testsktl.domain.entity.User;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by USER-PC on 06.09.2017.
 */

public class AddUserToDatabaseUseCase extends UseCaseNew<AddUser,Void> {

    @Override
    protected Observable<Void> buildUseCase(final AddUser param) {

        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {

                DatabaseManager databaseManager = new DatabaseManager(param.getContext());
                databaseManager.open(true);
                databaseManager.insertUser(convert(param.getUser()));//записываем
                databaseManager.close();

            }
        }).just(null);
    }

    private com.example.user_pc.testsktl.data.dbentity.User convert(User user) {
        com.example.user_pc.testsktl.data.dbentity.User userData = new com.example.user_pc.testsktl.data.dbentity.User();
        userData.setName(user.getName());
        userData.setAge(user.getAge());
        userData.setCountry(convertryCountry(user.getCountry()));//+ еще конвертим кантри
        return userData;
    }

    private com.example.user_pc.testsktl.data.dbentity.Country convertryCountry(Country country) {
        com.example.user_pc.testsktl.data.dbentity.Country countryData = new com.example.user_pc.testsktl.data.dbentity.Country();
        countryData.setName(country.getName());
        countryData.setId(country.getId());
        return countryData;
    }


}
