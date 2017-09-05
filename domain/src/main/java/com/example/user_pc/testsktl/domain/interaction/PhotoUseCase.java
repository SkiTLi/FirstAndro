package com.example.user_pc.testsktl.domain.interaction;

import com.example.user_pc.testsktl.domain.entity.PhotoId;
import com.example.user_pc.testsktl.domain.entity.PhotoModel;
import com.example.user_pc.testsktl.domain.interaction.base.UseCase;
import com.example.user_pc.testsktl.domain.interaction.base.UseCaseNew;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;

/**
 * Created by USER-PC on 11.08.2017.
 */

public class PhotoUseCase extends UseCaseNew<PhotoId, PhotoModel> {
    private String[] contents = {
            "https://s-media-cache-ak0.pinimg.com/originals/96/bc/3b/96bc3bab279a8fcb527e60dec4e7b3e7.png",
            "https://efmonline.files.wordpress.com/2010/10/mvc3-black-widow.png",
            "http://xkmh.weebly.com/uploads/3/0/8/8/30881653/9076291_orig.png",
            "http://vignette2.wikia.nocookie.net/ironman/images/9/9f/Captain-america-civil-war-iron-man-xlvi-sixth-scale-marvel-silo-902708.png",
            "http://usercontent1.hubimg.com/8876420.png",
            "https://s-media-cache-ak0.pinimg.com/originals/96/bc/3b/96bc3bab279a8fcb527e60dec4e7b3e7.png",
            "https://efmonline.files.wordpress.com/2010/10/mvc3-black-widow.png",
            "http://xkmh.weebly.com/uploads/3/0/8/8/30881653/9076291_orig.png",
            "http://vignette2.wikia.nocookie.net/ironman/images/9/9f/Captain-america-civil-war-iron-man-xlvi-sixth-scale-marvel-silo-902708.png",
            "http://usercontent1.hubimg.com/8876420.png",
            "https://s-media-cache-ak0.pinimg.com/originals/96/bc/3b/96bc3bab279a8fcb527e60dec4e7b3e7.png",
            "https://efmonline.files.wordpress.com/2010/10/mvc3-black-widow.png",
            "http://xkmh.weebly.com/uploads/3/0/8/8/30881653/9076291_orig.png",
            "http://vignette2.wikia.nocookie.net/ironman/images/9/9f/Captain-america-civil-war-iron-man-xlvi-sixth-scale-marvel-silo-902708.png",
            "http://usercontent1.hubimg.com/8876420.png"
    };

    private static AtomicInteger i = new AtomicInteger(0);

    @Override
    protected Observable<PhotoModel> buildUseCase(PhotoId id) {
        PhotoModel item = new PhotoModel();
        item.setUrl(contents[i.getAndIncrement()]);
        return Observable.just(item);
    }
}
