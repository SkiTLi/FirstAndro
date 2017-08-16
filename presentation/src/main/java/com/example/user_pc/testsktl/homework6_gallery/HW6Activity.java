/**
 * 4) Вам необходимо сделать галерею используя RecyclerView и Grid manager.
 * Примерно как тут:
 * http://blog.sqisland.com/2014/12/recyclerview-grid-with-header.html
 * Но в качестве элементов, задать ImageView.
 * Как все будет работать: у вас будет коллекция String
 * в которых будут ссылки на картинки (задать самостоятельно),
 * далее используя библиотеку для загрузки картинок (Picasso, Glide, Fresco или любую другую)
 * загружаете картинки и делаете так чтобы у вас был список с картинками.
 * Желательно также добавить progressBar,
 * чтобы пока картинка загрузится у вас в элементе отображалась крутелка progressBar.
 */

package com.example.user_pc.testsktl.homework6_gallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.homework3_glide.HW3Activity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class HW6Activity extends Activity {
    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private ArrayList<String> imageStringArrayList = new ArrayList<>();
    private ArrayList<Uri> imageLinkArrayList = new ArrayList<>();
    private String imageLinkString;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);//создается иерархия классов

        //это под вопросом
        for (int i = 0; i < 5; i++) {
            imageLinkString = "https://s-media-cache-ak0.pinimg.com/originals/96/bc/3b/96bc3bab279a8fcb527e60dec4e7b3e7.png";
            imageStringArrayList.add(imageLinkString);

            imageLinkString = "https://efmonline.files.wordpress.com/2010/10/mvc3-black-widow.png";
            imageStringArrayList.add(imageLinkString);

            imageLinkString = "http://xkmh.weebly.com/uploads/3/0/8/8/30881653/9076291_orig.png";
            imageStringArrayList.add(imageLinkString);

            imageLinkString = "http://vignette2.wikia.nocookie.net/ironman/images/9/9f/Captain-america-civil-war-iron-man-xlvi-sixth-scale-marvel-silo-902708.png";
            imageStringArrayList.add(imageLinkString);

            imageLinkString = "http://usercontent1.hubimg.com/8876420.png";
            imageStringArrayList.add(imageLinkString);
        }
        //заполняем текстом поля item
        for (int i = 0; i < 25; i++) {
            stringArrayList.add("hero " + i);
        }


        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        //        один из менеджеров:
        // походу здесь задается прокрутка
        //  GridLayoutManager
        //  StaggeredGridLayoutManager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//когда нужно в линеечку
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//а вот плитка как в дз (две колонки)
        //        можно горизонтально расположить
//                LinearLayoutManager layoutManager = new LinearLayoutManager(this, HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);

        HW6Adapter adapter = new HW6Adapter(stringArrayList, imageStringArrayList);

        adapter.setListener(new HW6Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Log.e("FFF", item);//попросился final item
            }
        });


        recyclerView.setAdapter(adapter);

    }
}