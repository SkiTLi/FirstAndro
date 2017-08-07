package com.example.user_pc.testsktl.homework4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.LayerDrawable;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import com.example.user_pc.testsktl.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by USER-PC on 01.08.2017.
 */

public class SktlClockView extends View {
    private Paint clockPaint = new Paint(); //типа кисти или карандаш
    private RectF arcRectF = new RectF();
    int timeHour;
    int timeMin;
    int timeSec;
    float rotateHour;
    float rotateMin;
    float rotateSec;
    int x = 400 / 2;
    int y = 400 / 2;

    //    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        //определяет начальные размеры вашего вью
//        //нужен он когда wrapperent y задать конкретные размеры
//    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initialize() {


        clockPaint.setAntiAlias(true); // для сглаживния
        int color = ContextCompat.getColor(getContext(), R.color.classworkBackground);
        clockPaint.setColor(color);

        // Для получения текущего системного времени достаточно выполнить:
        long curTime = System.currentTimeMillis();
        Date curDate = new Date(curTime);
        SimpleDateFormat formatForDateNowHour = new SimpleDateFormat("h");
        SimpleDateFormat formatForDateNowMin = new SimpleDateFormat("m");
        SimpleDateFormat formatForDateNowSec = new SimpleDateFormat("s");
        timeHour = Integer.valueOf(formatForDateNowHour.format(curDate)) + 3;
        timeMin = Integer.valueOf(formatForDateNowMin.format(curDate));
        timeSec = Integer.valueOf(formatForDateNowSec.format(curDate));


//        clockPaint.setStyle(Paint.Style.FILL); ///для заполнениия
        clockPaint.setStyle(Paint.Style.STROKE); ///для обводки

        //ширина оконтовки но здесь в пикселях
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                3, r.getDisplayMetrics());
        clockPaint.setStrokeWidth(strokeWidthInPx);
        clockPaint.setTextSize(100);//размер текста



    }

    //вызывается часто поэтому не создавть тяжелые объекты.
    // лучше в   initialize() а здесь просто использовать
    @Override
    protected void onDraw(Canvas canvas) { //канвас-лист бумаги
        super.onDraw(canvas);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int startX = cx;
        int startY = cy - radius;
        int stopX = startX;
        int stopY = startY + 10;


//        int radius = 200;
//        canvas.drawCircle(cx, cy, radius, clockPaint);


        //рисуем циферблат
        for (int i = 0; i < 13; i++) {
            if (i != 0) {
                canvas.drawText(String.valueOf(i), startX, startY, clockPaint);
                int stopYLong = startY + 30;
                canvas.drawLine(startX, startY, stopX, stopYLong, clockPaint);
            }
            for (int j = 0; j < 5; j++) {
                canvas.rotate(6, cx, cy);
                canvas.drawLine(startX, startY, stopX, stopY, clockPaint);
            }
        }
        canvas.rotate(-30, cx, cy);//возвращаем канву в ноль



        //рисуем часовую стрелку:
        rotateHour = 30 * timeHour + 0.5f * timeMin + (30f / 3600f) * timeSec;
        canvas.rotate(rotateHour, cx, cy);
        canvas.drawLine(cx, cy - radius / 9 * 4, stopX, cy + radius / 9, clockPaint);
        canvas.rotate(360 - rotateHour, cx, cy);//возвращаем канву в ноль

        //рисуем минутную стрелку:
        rotateMin = 6 * timeMin + 0.1f * timeSec;
        canvas.rotate(rotateMin, cx, cy);
        canvas.drawLine(cx, cy - radius / 9 * 6, stopX, cy + radius / 9, clockPaint);
        canvas.rotate(360 - rotateMin, cx, cy);//возвращаем канву в ноль

        //рисуем секундную  стрелку:
        rotateSec = 6 * timeSec;
        canvas.rotate(rotateSec, cx, cy);
        canvas.drawLine(cx, cy - radius / 9 * 8, stopX, cy + radius / 9 * 2, clockPaint);
        canvas.rotate(360 - rotateSec, cx, cy);//возвращаем канву в ноль




    }

    //виджет=контрол

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x = (int) event.getX();
            y = (int) event.getY();
            invalidate();

        }
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public SktlClockView(Context context) {
        super(context);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public SktlClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.N)
    public SktlClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SktlClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();

    }
}
