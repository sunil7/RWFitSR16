package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public class MapContainer extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public NestedScrollView f8489a;

    public MapContainer(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f8489a.requestDisallowInterceptTouchEvent(false);
        } else {
            this.f8489a.requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setScrollView(NestedScrollView nestedScrollView) {
        this.f8489a = nestedScrollView;
    }

    public MapContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
