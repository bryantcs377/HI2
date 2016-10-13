package com.example.chrisbennett.handlinginput;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chris.bennett on 10/13/16.
 */
public class MyView extends View  {

    private Context c;
    private Paint p;
    private Canvas canvas;
    private Bitmap bitmap;
    private float x,y;
    private int radius;

    private long lastMove=0;

    private long delay = 1000 / 30;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        c = context;
        p = new Paint();
        p.setColor(Color.BLUE);
        x = 100;
        y = 100;
        radius = 50;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        // your Canvas will draw onto the defined Bitmap
        bitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,radius, p);
    }

/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

    }
*/


    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }

    protected void startTouch(float x, float y) {
        this.x = x;
        this.y = y;
    }




}
