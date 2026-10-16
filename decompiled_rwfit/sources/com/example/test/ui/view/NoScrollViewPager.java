package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class NoScrollViewPager extends ViewPager {

    /* renamed from: c0, reason: collision with root package name */
    public boolean f8492c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f8493d0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoScrollViewPager(Context context) {
        super(context);
        kotlin.jvm.internal.e.c(context);
        this.f8492c0 = true;
        this.f8493d0 = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.e.f(ev, "ev");
        return this.f8492c0 && super.onInterceptTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.e.f(ev, "ev");
        return this.f8492c0 && super.onTouchEvent(ev);
    }

    public final void setCanScroll(boolean z5) {
        this.f8492c0 = z5;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        super.v(i3, this.f8493d0);
    }

    public final void setHasScrollAnim(boolean z5) {
        this.f8493d0 = z5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.e.c(context);
        this.f8492c0 = true;
        this.f8493d0 = true;
    }
}
