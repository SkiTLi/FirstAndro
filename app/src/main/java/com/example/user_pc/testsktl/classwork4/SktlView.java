package com.example.user_pc.testsktl.classwork4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.user_pc.testsktl.R;

/**
 * Created by USER-PC on 31.07.2017.
 */

public class SktlView extends View {


    private Paint sktlPaint = new Paint(); //типа кисти или карандаш
    private RectF arcRectF = new RectF();
    int cx;
    int cy;

    public SktlView(Context context) {
        super(context);
        initialize();
    }

    public SktlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    //    AttributeSet attrs набор атрибутов
    public SktlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SktlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();

    }


    private void initialize() {
        sktlPaint.setAntiAlias(true); // для сглаживния
        int color = ContextCompat.getColor(getContext(), R.color.buttonsText);
        sktlPaint.setColor(color);

//        sktlPaint.setStyle(Paint.Style.FILL); ///для заполнениия
        sktlPaint.setStyle(Paint.Style.STROKE); ///для обводки


        //ширина оконтовки но здесь в пикселях
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                33, r.getDisplayMetrics());
        sktlPaint.setStrokeWidth(strokeWidthInPx);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        //здесь можно инициализировть часть парметров при изменении размера
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //определяет начальные размеры вашего вью
        //нужен он когда wrapperent y задать конкретные размеры

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //нужно уточнить для чего
    }


    //вызывается часто поэтому не создавть тяжелые объекты лучше в   initialize() а хздесь просто использовать
    @Override
    protected void onDraw(Canvas canvas) { //канвас-лист бумаги
        super.onDraw(canvas);


        int radius = Math.min(getWidth(), getHeight()) / 7;
        canvas.drawCircle(cx, cy, radius, sktlPaint);

//        int cx = getWidth() / 2;
//        int cy = getWidth() / 2;
//
//
//        int startX = 0;
//        int startY = 0;
//        int stopX = getWidth();
//        int stopY = getHeight();
//        canvas.drawLine(startX, startY, stopX, stopY, sktlPaint);
//
//        arcRectF.left = 0;
//        arcRectF.top=0;
//        arcRectF.right=getWidth();
//        arcRectF.bottom=getHeight();
//        // от нуля до 30 градусов
//        canvas.drawArc(arcRectF,0,30,true, sktlPaint);


//        canvas.drawRect(200,200,400,400,sktlPaint);
    }

    //виджет=контрол

    @Override
    public boolean onTouchEvent(MotionEvent event) {


//        arcRectF.contains()ж//помогает отследить попал в область или нет

        //ппалец поднят события
        //опущен
        //перемещения по экрану


//        if (event.getAction() == MotionEvent.ACTION_MOVE) {//jy ved по перемещению по экрану
        cx = (int) event.getX();
        cy = (int) event.getY();
        invalidate();

//        }
//        else if (event.getAction() == MotionEvent.ACTION_DOWN) {
//
//        }
//        else if (event.getAction() == MotionEvent.ACTION_UP) {
//
//        }

        return true;//использовали клик или нет (использовали)


    }
}
