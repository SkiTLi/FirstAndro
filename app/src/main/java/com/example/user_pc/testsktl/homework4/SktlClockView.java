package com.example.user_pc.testsktl.homework4;

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
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import com.example.user_pc.testsktl.R;

import java.util.Date;

/**
 * Created by USER-PC on 01.08.2017.
 */

public class SktlClockView extends View {

    private Paint clockPaint = new Paint(); //типа кисти или карандаш
    private RectF arcRectF = new RectF();





long timeHour;
long timeMin;
long timeSec;

    int x = 400 / 2;
    int y = 400 / 2;

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//        //определяет начальные размеры вашего вью
//        //нужен он когда wrapperent y задать конкретные размеры
//
//    }

    private void initialize() {
        clockPaint.setAntiAlias(true); // для сглаживния
        int color = ContextCompat.getColor(getContext(), R.color.classworkBackground);
        clockPaint.setColor(color);


        // Для получения текущего системного времени достаточно выполнить:
        long curTime = System.currentTimeMillis();

        // Хотите значение типа Date, с этим временем?
        Date curDate = new Date(curTime);


//// Хотите строку в формате, удобном Вам?
//        String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
//
//
//// Хотите Date из строки, в которой дата с известным шаблоном?
//        Date parsedDate = new SimpleDateFormat("dd.MM.yyyy").parse("16.04.2004");
        timeHour=curDate.getHours();
        timeMin = curDate.getMinutes();
timeSec=curDate.getSeconds();


        Calendar c;

//        c = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

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
//        int radius = 200;
//        canvas.drawCircle(cx, cy, radius, clockPaint);


        for (int i = 0; i < 13; i++) {

            int startX = cx;
            int startY = cy - radius;
            int stopX = startX;
            int stopY = startY + 10;

//            canvas.drawLine(startX, startY, stopX, stopY, clockPaint);
            if (i != 0) {
                canvas.drawText(String.valueOf(i), startX, startY, clockPaint);
                int stopYLong=startY + 30;
                canvas.drawLine(startX, startY, stopX, stopYLong, clockPaint);
            }
            for (int j = 0; j < 5; j++) {
                canvas.rotate(6, cx, cy);
                canvas.drawLine(startX, startY, stopX, stopY, clockPaint);
            }
        }
//
//        arcRectF.left = 0;
//        arcRectF.top=0;
//        arcRectF.right=getWidth();
//        arcRectF.bottom=getHeight();
//        // от нуля до 30 градусов
//        canvas.drawArc(arcRectF,0,30,true, clockPaint);


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


    public SktlClockView(Context context) {
        super(context);
        initialize();

    }

    public SktlClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();

    }

    public SktlClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SktlClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();

    }
}
