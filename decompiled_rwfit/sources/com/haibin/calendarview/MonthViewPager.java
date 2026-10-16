package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.List;
import md.r;
import md.t;
import md.u;

/* loaded from: classes.dex */
public final class MonthViewPager extends ViewPager {
    public boolean U0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11335c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f11336d0;

    /* renamed from: e0, reason: collision with root package name */
    public r f11337e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f11338f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f11339g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f11340h0;
    public CalendarLayout i0;

    /* renamed from: j0, reason: collision with root package name */
    public WeekViewPager f11341j0;

    /* renamed from: k0, reason: collision with root package name */
    public WeekBar f11342k0;

    public MonthViewPager(Context context) {
        this(context, null);
    }

    public final void A() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i3);
            baseMonthView.setSelectedCalendar(this.f11337e0.f16073q0);
            baseMonthView.invalidate();
        }
    }

    public List<Calendar> getCurrentMonthCalendars() {
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (baseMonthView == null) {
            return null;
        }
        return baseMonthView.f11298o;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11337e0.i0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f11337e0.i0 && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        v(i3, true);
    }

    public void setup(r rVar) {
        this.f11337e0 = rVar;
        y(rVar.f16056h0.getYear(), this.f11337e0.f16056h0.getMonth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f11340h0;
        setLayoutParams(layoutParams);
        r rVar2 = this.f11337e0;
        this.f11336d0 = (((rVar2.X - rVar2.W) * 12) - rVar2.Y) + 1 + rVar2.Z;
        setAdapter(new u(this, 0));
        addOnPageChangeListener(new b7.a(this, 3));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void v(int i3, boolean z5) {
        if (Math.abs(getCurrentItem() - i3) > 1) {
            super.v(i3, false);
        } else {
            super.v(i3, z5);
        }
    }

    public final void x() {
        r rVar = this.f11337e0;
        this.f11336d0 = (((rVar.X - rVar.W) * 12) - rVar.Y) + 1 + rVar.Z;
        if (getAdapter() == null) {
            return;
        }
        getAdapter().h();
    }

    public final void y(int i3, int i10) {
        r rVar = this.f11337e0;
        if (rVar.f16046c == 0) {
            this.f11340h0 = rVar.f16050e0 * 6;
            getLayoutParams().height = this.f11340h0;
            return;
        }
        if (this.i0 != null) {
            if (getVisibility() != 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                r rVar2 = this.f11337e0;
                layoutParams.height = t.m(i3, i10, rVar2.f16050e0, rVar2.f16044b, rVar2.f16046c);
                setLayoutParams(layoutParams);
            }
            this.i0.f();
        }
        r rVar3 = this.f11337e0;
        this.f11340h0 = t.m(i3, i10, rVar3.f16050e0, rVar3.f16044b, rVar3.f16046c);
        if (i10 == 1) {
            r rVar4 = this.f11337e0;
            this.f11339g0 = t.m(i3 - 1, 12, rVar4.f16050e0, rVar4.f16044b, rVar4.f16046c);
            r rVar5 = this.f11337e0;
            this.f11338f0 = t.m(i3, 2, rVar5.f16050e0, rVar5.f16044b, rVar5.f16046c);
            return;
        }
        r rVar6 = this.f11337e0;
        this.f11339g0 = t.m(i3, i10 - 1, rVar6.f16050e0, rVar6.f16044b, rVar6.f16046c);
        if (i10 == 12) {
            r rVar7 = this.f11337e0;
            this.f11338f0 = t.m(i3 + 1, 1, rVar7.f16050e0, rVar7.f16044b, rVar7.f16046c);
        } else {
            r rVar8 = this.f11337e0;
            this.f11338f0 = t.m(i3, i10 + 1, rVar8.f16050e0, rVar8.f16044b, rVar8.f16046c);
        }
    }

    public final void z() {
        Log.d("tong", "getchildCount = " + getChildCount());
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ((BaseMonthView) getChildAt(i3)).d();
        }
    }

    public MonthViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U0 = false;
    }
}
