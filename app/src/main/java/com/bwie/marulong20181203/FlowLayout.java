package com.bwie.marulong20181203;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class FlowLayout extends FrameLayout {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width = getWidth();
        int disWidth = 18;
        int row = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();
            if (disWidth+viewWidth>width){
                row++;
                disWidth = 18;
            }
            view.layout(disWidth,viewHeight*row,viewWidth+disWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }
    }
}
