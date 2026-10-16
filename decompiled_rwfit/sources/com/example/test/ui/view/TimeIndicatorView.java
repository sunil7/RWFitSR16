package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.example.test.R$layout;

/* loaded from: classes.dex */
public class TimeIndicatorView extends LinearLayout {
    public TimeIndicatorView(Context context) {
        this(context, null);
    }

    public TimeIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R$layout.view_time_indicator, this);
    }
}
