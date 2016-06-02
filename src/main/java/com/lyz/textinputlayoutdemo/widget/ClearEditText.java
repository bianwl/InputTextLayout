package com.lyz.textinputlayoutdemo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

import com.lyz.textinputlayoutdemo.R;

/**
 * author： bwl on 2016-06-01.
 * email: bxl049@163.com
 */
public class ClearEditText extends EditText implements OnFocusChangeListener, TextWatcher {

    //EditText右侧的删除图标
    private Drawable mClearDrawable;
    //EditText是否聚焦
    private boolean hasFocus;

    public ClearEditText(Context context) {
        this(context, null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mClearDrawable = getCompoundDrawables()[2];
        if (null == mClearDrawable) {
            mClearDrawable = getResources().getDrawable(R.mipmap.clear);
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }


    /**
     *  设置清除图标是否可见
     * @param visible
     */
    private void setClearIconVisible(boolean visible) {
        Drawable right = (visible ? mClearDrawable : null);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1],
                right, getCompoundDrawables()[3]);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (hasFocus) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_UP == event.getAction()) {
            if (null != getCompoundDrawables()[2]) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect rect = getCompoundDrawables()[2].getBounds();
                int height = rect.height();//清除图标高
                int distance = (getHeight() - height) / 2;//清除图标顶部到控件顶部的距离
                boolean w = (x < getWidth() - getPaddingRight()) && (x > getWidth() - getTotalPaddingRight());
                boolean h = (y > distance) && (y < distance + height);
                if (w && h) {
                    setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
