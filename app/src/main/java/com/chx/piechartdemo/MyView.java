package com.chx.piechartdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chaohx on 2017/8/25.
 */

public class MyView extends View {


    private LinkedList<Entry> entries;

    private Paint paint;  //画笔


    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        entries = new LinkedList<>();
        paint = new Paint();
        paint.setTextSize(DensityUtils.sp2px(getContext(), 15));
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < entries.size(); i++) {
            canvas.drawText(entries.get(i).getStr(), entries.get(i).x, entries.get(i).y, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://按下
                Log.e("onTouchEvent", "onTouchEvent: ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE://移动
                Log.e("onTouchEvent", "onTouchEvent: ACTION_MOVE");
                if (entries.size() > 0) {
                    entries.getLast().setX(event.getX());
                    entries.getLast().setY(event.getY());
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP://松开
                Log.e("onTouchEvent", "onTouchEvent: ACTION_UP");
                break;
        }
        return true;
    }

    public void aDDEntry(String s) {
        entries.add(new Entry(s, 100, 100));
        invalidate();
    }


    /**
     * 每一条文字的对象
     */
    public static class Entry {
        private String str = "";
        private float x;
        private float y;


        public Entry(String str, float x, float y) {
            this.str = str;
            this.x = x;
            this.y = y;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }


}
