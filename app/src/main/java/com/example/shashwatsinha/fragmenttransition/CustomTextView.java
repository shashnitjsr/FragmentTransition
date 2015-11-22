package com.example.shashwatsinha.fragmenttransition;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shashwatsinha on 29/07/15.
 */
public class CustomTextView extends View {

    String text;
    Paint paint;
    Bitmap bitmap;
    Rect FinalSize;
    Path p;


    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setText(String str) {
        text = str;
        requestLayout();
        invalidate();
    }

    @Override
    protected void onLayout(boolean b1, int x, int y, int a, int b) {
        super.onLayout(b1, x, y, a, b);
        Log.d("shashwat", "CustomTextView onLayoutChanged");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("shashwat", " onSizeChanged " + w);
        Log.d("shashwat", " onSizeChanged " + h);
        Log.d("shashwat", " onSizeChanged " + oldw);
        Log.d("shashwat", " onSizeChanged " + oldh);
    }

    @Override
    protected void onMeasure(int x, int y) {
        int y1;
        Log.d("shashwat", "Parent recommendation x width " + View.MeasureSpec.getSize(x));
        Log.d("shashwat", "Parent recommendation y height " + View.MeasureSpec.getSize(y));

        setMeasuredDimension(x, y);


    }

    @Override
    public void onAttachedToWindow() {
        paint = new Paint();
        // paint.setColor(Color.BLACK);
        // paint.setTextSize(100);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.airport_active);
        FinalSize = new Rect(100, 100, 500, 500);
        p = new Path();
        p.addCircle(300, 300, 200, Path.Direction.CCW);

    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        Log.d("shashwat", "CustomTextView onDraw");
        c.drawBitmap(bitmap, null, FinalSize, paint);

        //c.clipPath(p, Region.Op.REPLACE);
        //c.drawPath(p, new Paint());
    }


}
