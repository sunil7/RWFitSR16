package com.haibin.calendarview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$styleable;
import md.d;
import md.e;
import md.r;
import md.t;

/* loaded from: classes.dex */
public class CalendarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f11305a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11306b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11307c;

    /* renamed from: d, reason: collision with root package name */
    public MonthViewPager f11308d;
    public CalendarView e;

    /* renamed from: f, reason: collision with root package name */
    public WeekViewPager f11309f;

    /* renamed from: g, reason: collision with root package name */
    public YearViewPager f11310g;

    /* renamed from: h, reason: collision with root package name */
    public ViewGroup f11311h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11312i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11313j;

    /* renamed from: k, reason: collision with root package name */
    public int f11314k;

    /* renamed from: l, reason: collision with root package name */
    public int f11315l;

    /* renamed from: m, reason: collision with root package name */
    public float f11316m;

    /* renamed from: n, reason: collision with root package name */
    public float f11317n;

    /* renamed from: o, reason: collision with root package name */
    public float f11318o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11319p;

    /* renamed from: q, reason: collision with root package name */
    public final int f11320q;
    public final VelocityTracker r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11321s;

    /* renamed from: t, reason: collision with root package name */
    public int f11322t;

    /* renamed from: u, reason: collision with root package name */
    public r f11323u;

    public CalendarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11315l = 0;
        this.f11319p = false;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CalendarLayout);
        this.f11320q = obtainStyledAttributes.getResourceId(R$styleable.CalendarLayout_calendar_content_view_id, 0);
        this.f11306b = obtainStyledAttributes.getInt(R$styleable.CalendarLayout_default_status, 0);
        this.f11313j = obtainStyledAttributes.getInt(R$styleable.CalendarLayout_calendar_show_mode, 0);
        this.f11312i = obtainStyledAttributes.getInt(R$styleable.CalendarLayout_gesture_mode, 0);
        obtainStyledAttributes.recycle();
        this.r = VelocityTracker.obtain();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        viewConfiguration.getScaledTouchSlop();
        this.f11321s = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public static void a(CalendarLayout calendarLayout) {
        if (calendarLayout.f11309f.getVisibility() != 0) {
            r rVar = calendarLayout.f11323u;
        }
        WeekViewPager weekViewPager = calendarLayout.f11309f;
        if (weekViewPager != null && weekViewPager.getAdapter() != null) {
            calendarLayout.f11309f.getAdapter().h();
            calendarLayout.f11309f.setVisibility(0);
        }
        calendarLayout.f11308d.setVisibility(4);
    }

    private int getCalendarViewHeight() {
        if (this.f11308d.getVisibility() == 0) {
            return this.f11308d.getHeight() + this.f11323u.f16054g0;
        }
        r rVar = this.f11323u;
        return rVar.f16054g0 + rVar.f16050e0;
    }

    public final boolean b(int i3) {
        int i10 = 0;
        if (this.f11319p || this.f11313j == 1 || this.f11311h == null) {
            return false;
        }
        if (this.f11308d.getVisibility() != 0) {
            this.f11309f.setVisibility(8);
            if (this.f11308d.getVisibility() != 0) {
                r rVar = this.f11323u;
            }
            this.f11307c = false;
            this.f11308d.setVisibility(0);
        }
        ViewGroup viewGroup = this.f11311h;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), 0.0f);
        ofFloat.setDuration(i3);
        ofFloat.addUpdateListener(new d(this, i10));
        ofFloat.addListener(new e(this, i10));
        ofFloat.start();
        return true;
    }

    public final boolean c() {
        ViewGroup viewGroup = this.f11311h;
        if (viewGroup instanceof RecyclerView) {
            return ((RecyclerView) viewGroup).computeVerticalScrollOffset() == 0;
        }
        if (!(viewGroup instanceof AbsListView)) {
            return viewGroup.getScrollY() == 0;
        }
        AbsListView absListView = (AbsListView) viewGroup;
        return absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() == 0;
    }

    public final boolean d(int i3) {
        ViewGroup viewGroup;
        int i10 = 1;
        if (this.f11312i == 2) {
            requestLayout();
        }
        if (this.f11319p || (viewGroup = this.f11311h) == null) {
            return false;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), -this.f11314k);
        ofFloat.setDuration(i3);
        ofFloat.addUpdateListener(new d(this, i10));
        ofFloat.addListener(new e(this, i10));
        ofFloat.start();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CalendarView calendarView;
        ViewGroup viewGroup;
        if (!this.f11319p && this.f11312i != 2) {
            if (this.f11310g == null || (calendarView = this.e) == null || calendarView.getVisibility() == 8 || (viewGroup = this.f11311h) == null || viewGroup.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int i3 = this.f11313j;
            if (i3 == 2 || i3 == 1) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.f11310g.getVisibility() == 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.f11323u.getClass();
            int action = motionEvent.getAction();
            float y4 = motionEvent.getY();
            if (action != 2 || y4 - this.f11317n <= 0.0f || this.f11311h.getTranslationY() != (-this.f11314k) || !c()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        this.f11308d.setTranslationY(this.f11315l * ((this.f11311h.getTranslationY() * 1.0f) / this.f11314k));
    }

    public final void f() {
        ViewGroup viewGroup;
        r rVar = this.f11323u;
        Calendar calendar = rVar.f16074r0;
        if (rVar.f16046c == 0) {
            this.f11314k = this.f11322t * 5;
        } else {
            this.f11314k = t.l(calendar.getYear(), calendar.getMonth(), this.f11322t, this.f11323u.f16044b) - this.f11322t;
        }
        if (this.f11309f.getVisibility() != 0 || (viewGroup = this.f11311h) == null) {
            return;
        }
        viewGroup.setTranslationY(-this.f11314k);
    }

    public final void g(int i3) {
        this.f11315l = (((i3 + 7) / 7) - 1) * this.f11322t;
    }

    public final void h(int i3) {
        this.f11315l = (i3 - 1) * this.f11322t;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f11308d = (MonthViewPager) findViewById(R$id.vp_month);
        this.f11309f = (WeekViewPager) findViewById(R$id.vp_week);
        if (getChildCount() > 0) {
            this.e = (CalendarView) getChildAt(0);
        }
        this.f11311h = (ViewGroup) findViewById(this.f11320q);
        this.f11310g = (YearViewPager) findViewById(R$id.selectLayout);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        CalendarView calendarView;
        ViewGroup viewGroup;
        if (this.f11319p) {
            return true;
        }
        if (this.f11312i == 2) {
            return false;
        }
        if (this.f11310g == null || (calendarView = this.e) == null || calendarView.getVisibility() == 8 || (viewGroup = this.f11311h) == null || viewGroup.getVisibility() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int i3 = this.f11313j;
        if (i3 == 2 || i3 == 1) {
            return false;
        }
        if (this.f11310g.getVisibility() == 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f11323u.getClass();
        int action = motionEvent.getAction();
        float y4 = motionEvent.getY();
        float x10 = motionEvent.getX();
        if (action == 0) {
            this.f11305a = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.f11316m = y4;
            this.f11317n = y4;
            this.f11318o = x10;
        } else if (action == 2) {
            float f2 = y4 - this.f11317n;
            float f10 = x10 - this.f11318o;
            if (f2 < 0.0f && this.f11311h.getTranslationY() == (-this.f11314k)) {
                return false;
            }
            if (f2 > 0.0f && this.f11311h.getTranslationY() == (-this.f11314k)) {
                r rVar = this.f11323u;
                if (y4 >= rVar.f16050e0 + rVar.f16054g0 && !c()) {
                    return false;
                }
            }
            if (f2 > 0.0f && this.f11311h.getTranslationY() == 0.0f && y4 >= t.e(getContext(), 98.0f)) {
                return false;
            }
            if (Math.abs(f2) > Math.abs(f10) && ((f2 > 0.0f && this.f11311h.getTranslationY() <= 0.0f) || (f2 < 0.0f && this.f11311h.getTranslationY() >= (-this.f11314k)))) {
                this.f11317n = y4;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        if (this.f11311h == null || this.e == null) {
            super.onMeasure(i3, i10);
            return;
        }
        int year = this.f11323u.f16074r0.getYear();
        int month = this.f11323u.f16074r0.getMonth();
        int e = t.e(getContext(), 1.0f);
        r rVar = this.f11323u;
        int i11 = e + rVar.f16054g0;
        int m10 = t.m(year, month, rVar.f16050e0, rVar.f16044b, rVar.f16046c) + i11;
        int size = View.MeasureSpec.getSize(i10);
        if (this.f11323u.f16052f0) {
            super.onMeasure(i3, i10);
            this.f11311h.measure(i3, View.MeasureSpec.makeMeasureSpec((size - i11) - this.f11323u.f16050e0, 1073741824));
            ViewGroup viewGroup = this.f11311h;
            viewGroup.layout(viewGroup.getLeft(), this.f11311h.getTop(), this.f11311h.getRight(), this.f11311h.getBottom());
            return;
        }
        if (m10 >= size && this.f11308d.getHeight() > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(m10 + i11 + this.f11323u.f16054g0, 1073741824);
            size = m10;
        } else if (m10 < size && this.f11308d.getHeight() > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        if (this.f11313j == 2 || this.e.getVisibility() == 8) {
            m10 = this.e.getVisibility() == 8 ? 0 : this.e.getHeight();
        } else if (this.f11312i != 2 || this.f11319p) {
            size -= i11;
            m10 = this.f11322t;
        } else if (this.f11308d.getVisibility() != 0) {
            size -= i11;
            m10 = this.f11322t;
        }
        int i12 = size - m10;
        super.onMeasure(i3, i10);
        this.f11311h.measure(i3, View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        ViewGroup viewGroup2 = this.f11311h;
        viewGroup2.layout(viewGroup2.getLeft(), this.f11311h.getTop(), this.f11311h.getRight(), this.f11311h.getBottom());
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("super");
        if (bundle.getBoolean("isExpand")) {
            post(new md.c(this, 0));
        } else {
            post(new md.c(this, 1));
        }
        super.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putBoolean("isExpand", this.f11308d.getVisibility() == 0);
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        if (r0 != 6) goto L87;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haibin.calendarview.CalendarLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setup(r rVar) {
        this.f11323u = rVar;
        this.f11322t = rVar.f16050e0;
        Calendar b3 = rVar.f16073q0.isAvailable() ? rVar.f16073q0 : rVar.b();
        g((b3.getDay() + t.o(b3, this.f11323u.f16044b)) - 1);
        f();
    }
}
