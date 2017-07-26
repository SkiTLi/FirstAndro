/**
 * На основе HelloWorld, что мы сделали в классе создать экран на котором будет
 * * 2 элемента TextView и одна кнопка Button.
 * * По нажатию на кнопку нужно поменять местами текст в текстовых элементах
 * *(текст должен быть задан в xml strings - как это делать нужно изучить самостоятельно).
 * * Клик вам нужно повесить не только на кнопку но и на оба TextView и по нажатию также менять местами тексты в TextView
 * (что бы получить текст из TextView есть соответствующий метод getText, а setText для установки).
 * Повесьте клик плиз 3-мя разными способами:
 * * сделать имплемент OnClickListener на текущую активити,
 * * анонимным классом прямо впихивая его в аргумент
 * * и в виде переменной отдельно как делали в классе.
 * Т. е. ваша активити будет иметь след элементы:
 * TextView - 2 штуки
 * Button - 1 штука
 */

package com.example.user_pc.testsktl;

import android.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    private Button helloButton;
    private int i;

    private Button changeButton;
    private TextView firstTextView;
    private TextView secondTextView;
    private String str;

    private void change() {
        str = (String) firstTextView.getText();
        firstTextView.setText(secondTextView.getText());
        secondTextView.setText(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Log.d("Tag_Example", "Message_example");
        helloButton = (Button) findViewById(R.id.hello_button);

        helloButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i++;
                helloButton.setText("CounterSktl" + i);
            }
        });


        changeButton = (Button) findViewById(R.id.chenge_button2);
        firstTextView = findViewById(R.id.first_textView);
        secondTextView = findViewById(R.id.second_textView2);

        //через анонимный класс
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        };
        firstTextView.setOnClickListener(listener);


        //через сразу впихнуть в аргумент
        secondTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                change();
            }
        });


        //через имплемент интерфейса
        changeButton.setOnClickListener(this);
    }

    //через имплемент интерфейса
    @Override
    public void onClick(View view) {
        change();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {//может не вызываться
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
