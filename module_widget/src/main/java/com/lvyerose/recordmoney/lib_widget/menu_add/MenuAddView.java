package com.lvyerose.recordmoney.lib_widget.menu_add;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MenuAddView extends View {
    private int circleColor = 0xFFFECA2E;
    private int addColor = 0xFFFFFFFF;
    private int width;
    private int height;
    private float radius;
    private Paint circlePaint;
    private Paint addPaint;

    public MenuAddView(Context context) {
        super(context);
        init();
    }

    public MenuAddView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MenuAddView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        radius = ((float) width) / 2;
        if (addPaint != null) {
            addPaint.setStrokeWidth(radius / 8);
        }
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setColor(circleColor);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        addPaint = new Paint();
        addPaint.setColor(addColor);
        addPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        addPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(radius, radius, radius, circlePaint);
        canvas.drawLine(radius * 5 / 8, radius, width - radius * 5 / 8, radius, addPaint);
        canvas.drawLine(radius, radius * 5 / 8, radius, width - radius * 5 / 8, addPaint);
    }
}
