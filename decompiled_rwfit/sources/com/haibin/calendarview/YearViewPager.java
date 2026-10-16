package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import md.r;
import md.w;

/* loaded from: classes.dex */
public final class YearViewPager extends ViewPager {

    /* renamed from: c0, reason: collision with root package name */
    public int f11369c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f11370d0;

    /* renamed from: e0, reason: collision with root package name */
    public r f11371e0;

    /* renamed from: f0, reason: collision with root package name */
    public w f11372f0;

    public YearViewPager(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11371e0.f16061k0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f11371e0.f16061k0 && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        v(i3, false);
    }

    public final void setOnMonthSelectedListener(w wVar) {
        this.f11372f0 = wVar;
    }

    public void setup(r rVar) {
        this.f11371e0 = rVar;
        this.f11369c0 = (rVar.X - rVar.W) + 1;
        setAdapter(new c(this));
        setCurrentItem(this.f11371e0.f16056h0.getYear() - this.f11371e0.W);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void v(int i3, boolean z5) {
        if (Math.abs(getCurrentItem() - i3) > 1) {
            super.v(i3, false);
        } else {
            super.v(i3, false);
        }
    }

    public YearViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
