package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import md.r;
import md.t;
import md.u;

/* loaded from: classes.dex */
public final class WeekViewPager extends ViewPager {

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11344c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f11345d0;

    /* renamed from: e0, reason: collision with root package name */
    public r f11346e0;

    /* renamed from: f0, reason: collision with root package name */
    public CalendarLayout f11347f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11348g0;

    public WeekViewPager(Context context) {
        this(context, null);
    }

    public List<Calendar> getCurrentWeekCalendars() {
        r rVar = this.f11346e0;
        Calendar calendar = rVar.f16074r0;
        long timeInMillis = calendar.getTimeInMillis();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        int i3 = calendar2.get(7);
        int i10 = rVar.f16044b;
        if (i10 == 1) {
            i3--;
        } else if (i10 == 2) {
            i3 = i3 == 1 ? 6 : i3 - i10;
        } else if (i3 == 7) {
            i3 = 0;
        }
        long j4 = timeInMillis - (i3 * Const.DAY_IN_MILLIS);
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.setTimeInMillis(j4);
        Calendar calendar4 = new Calendar();
        calendar4.setYear(calendar3.get(1));
        calendar4.setMonth(calendar3.get(2) + 1);
        calendar4.setDay(calendar3.get(5));
        ArrayList x10 = t.x(calendar4, rVar);
        this.f11346e0.a(x10);
        return x10;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11346e0.f16059j0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f11346e0.f16050e0, 1073741824));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f11346e0.f16059j0 && super.onTouchEvent(motionEvent);
    }

    public void setup(r rVar) {
        this.f11346e0 = rVar;
        this.f11345d0 = t.s(rVar.W, rVar.Y, rVar.f16043a0, rVar.X, rVar.Z, rVar.f16045b0, rVar.f16044b);
        setAdapter(new u(this, 1));
        addOnPageChangeListener(new b7.a(this, 4));
    }

    public final void x() {
        r rVar = this.f11346e0;
        this.f11345d0 = t.s(rVar.W, rVar.Y, rVar.f16043a0, rVar.X, rVar.Z, rVar.f16045b0, rVar.f16044b);
        if (getAdapter() == null) {
            return;
        }
        getAdapter().h();
    }

    public final void y(Calendar calendar) {
        r rVar = this.f11346e0;
        int t8 = t.t(calendar, rVar.W, rVar.Y, rVar.f16043a0, rVar.f16044b) - 1;
        this.f11348g0 = getCurrentItem() != t8;
        v(t8, false);
        BaseWeekView baseWeekView = (BaseWeekView) findViewWithTag(Integer.valueOf(t8));
        if (baseWeekView != null) {
            baseWeekView.setSelectedCalendar(calendar);
            baseWeekView.invalidate();
        }
    }

    public WeekViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11348g0 = false;
    }
}
