package com.example.user_pc.testsktl.homework14_spinner;

import android.app.Activity;
import android.content.Context;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user_pc.testsktl.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by USER-PC on 26.07.2017.
 */

public class HW14Activity extends Activity {

    private ArrayList<String> stringArrayList;
    SharedPreferences preferences;
    private static final String SHARED_PREFERENCES = "SHARED_PREFERENCES_hw14";
    private static final String DEFAULT_TEXT = "0";

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw14_spinner);


        //(код как достать из json-строки
        String countriesJson = loadJSONFromAsset();
//        Log.d("Sktl", countriesJson);//увидим урезанный json
        JSONArray jsonArray;
        JSONObject jsonObject;
        try {
            //[или так:
            jsonArray = new JSONArray(countriesJson);
            //или так:
            //      jsonObject = new JSONObject(countriesJson);
            //      jsonArray = jsonObject.getJSONArray("cntr") ;
            //но тогда пишется название массива "cntr" данных в json
            //] т.е. добавляется "{cntr:" вначале и "}" вконце в json)

            stringArrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String code = jsonObject.getString("code");

                stringArrayList.add(name);
//                Log.d("Sktl", code + name);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("Sktl", "JSONException" + e);
        }
        //)код как достать из json-строки

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stringArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");

        // задаем параметры SharedPreferences
        preferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        int dataInt = 0;
        String data = "defaultSktl";
        try {
            data = preferences.getString(DEFAULT_TEXT, null);
            dataInt = Integer.parseInt(data);
        } catch (Exception e) {
            Log.d("Sktl", "Exception" + e);
        }
        Log.d("Sktl", "dataInt=" + dataInt + ", data=" + data);
        // выделяем элемент
        spinner.setSelection(dataInt);//spinner.setSelection(0);//-т.е. устанавливаем тот элемент на котором будет стоять выподающий список
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                //запоминаем то что выбрали в SharedPreferences
                preferences.edit()
                        .putString(DEFAULT_TEXT, String.valueOf(position))
                        .apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //метод который позволяет записать в строку json файл
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = HW14Activity.this.getAssets().open("countries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        //от yariko:
        //  Gson gson = new Gson();
        //  AssetCountry[] countries = gson.fromJson(jsonString, AssetCountry[].class);
        //  return new ArrayList<AssetCountry>(Arrays.asList(countries));

        return json;
    }

}
