package com.lvyerose.recordmoney.lib_widget.menu_add;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MenuAddView extends View {
    private int circleColor = 0xFFFECA2E;
    private int addColor = 0xFFFFFFFF;
    private float width;
    private float radius;
    private Paint circlePaint;
    private Paint addPaint;
    private float currentRadius = 0;
    private boolean isShow = false;

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
        radius = width / 2;
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
        addPaint.setStrokeWidth(currentRadius / 8);
        canvas.drawCircle(width / 2, width / 2, currentRadius, circlePaint);
        canvas.drawLine(width / 2 - currentRadius * 3 / 8, width / 2, width / 2 + currentRadius * 3 / 8, width / 2, addPaint);
        canvas.drawLine(width / 2, width / 2 - currentRadius * 3 / 8, width / 2, width / 2 + currentRadius * 3 / 8, addPaint);
    }

    public void setShow(boolean show) {
        if (isShow != show) {
            isShow = show;
            if (isShow) {
                //从无到有
                final ValueAnimator animator = ValueAnimator.ofFloat(0, radius);
                animator.setDuration(300);
                animator.setRepeatCount(0);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        currentRadius = (float) animation.getAnimatedValue();
                        invalidate();
                    }
                });
                animator.start();
            } else {
                //从显示到隐藏
                ValueAnimator animator = ValueAnimator.ofFloat(radius, 0);
                animator.setDuration(300);
                animator.setRepeatCount(0);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        currentRadius = (float) animation.getAnimatedValue();
                        invalidate();
                    }
                });
                animator.start();
            }
        }
    }

}
