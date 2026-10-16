package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class DialLineaLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8405a;

    public DialLineaLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f8405a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f8405a || super.onTouchEvent(motionEvent);
    }

    public void setIntercept(boolean z5) {
        this.f8405a = z5;
    }

    public DialLineaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialLineaLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
