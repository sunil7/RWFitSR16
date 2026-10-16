package com.haibin.calendarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.baselibrary.R$array;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$layout;
import com.example.baselibrary.R$styleable;
import com.example.test.ui.device.activity.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import md.g;
import md.h;
import md.i;
import md.j;
import md.k;
import md.l;
import md.m;
import md.n;
import md.o;
import md.p;
import md.q;
import md.r;
import md.s;
import md.t;

/* loaded from: classes.dex */
public class CalendarView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final r f11324a;

    /* renamed from: b, reason: collision with root package name */
    public final MonthViewPager f11325b;

    /* renamed from: c, reason: collision with root package name */
    public final WeekViewPager f11326c;

    /* renamed from: d, reason: collision with root package name */
    public final View f11327d;
    public final YearViewPager e;

    /* renamed from: f, reason: collision with root package name */
    public WeekBar f11328f;

    /* renamed from: g, reason: collision with root package name */
    public CalendarLayout f11329g;

    public CalendarView(Context context) {
        this(context, null);
    }

    private void setShowMode(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            r rVar = this.f11324a;
            if (rVar.f16046c == i3) {
                return;
            }
            rVar.f16046c = i3;
            WeekViewPager weekViewPager = this.f11326c;
            int i10 = 0;
            for (int i11 = 0; i11 < weekViewPager.getChildCount(); i11++) {
                ((BaseWeekView) weekViewPager.getChildAt(i11)).invalidate();
            }
            MonthViewPager monthViewPager = this.f11325b;
            while (true) {
                int i12 = 6;
                if (i10 >= monthViewPager.getChildCount()) {
                    break;
                }
                BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.getChildAt(i10);
                int i13 = baseMonthView.f11282x;
                int i14 = baseMonthView.f11283y;
                r rVar2 = baseMonthView.f11285a;
                int i15 = rVar2.f16044b;
                if (rVar2.f16046c != 0) {
                    i12 = ((t.j(i13, i14) + t.n(i13, i14, i15)) + t.k(i13, i14, t.j(i13, i14), i15)) / 7;
                }
                baseMonthView.f11284z = i12;
                int i16 = baseMonthView.f11282x;
                int i17 = baseMonthView.f11283y;
                int i18 = baseMonthView.f11299p;
                r rVar3 = baseMonthView.f11285a;
                baseMonthView.A = t.m(i16, i17, i18, rVar3.f16044b, rVar3.f16046c);
                baseMonthView.invalidate();
                baseMonthView.requestLayout();
                i10++;
            }
            r rVar4 = monthViewPager.f11337e0;
            if (rVar4.f16046c == 0) {
                int i19 = rVar4.f16050e0 * 6;
                monthViewPager.f11340h0 = i19;
                monthViewPager.f11338f0 = i19;
                monthViewPager.f11339g0 = i19;
            } else {
                monthViewPager.y(rVar4.f16073q0.getYear(), monthViewPager.f11337e0.f16073q0.getMonth());
            }
            ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
            layoutParams.height = monthViewPager.f11340h0;
            monthViewPager.setLayoutParams(layoutParams);
            CalendarLayout calendarLayout = monthViewPager.i0;
            if (calendarLayout != null) {
                calendarLayout.f();
            }
            this.f11326c.x();
        }
    }

    private void setWeekStart(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 7) {
            r rVar = this.f11324a;
            if (i3 == rVar.f16044b) {
                return;
            }
            rVar.f16044b = i3;
            this.f11328f.c(i3);
            this.f11328f.b(rVar.f16073q0, i3);
            WeekViewPager weekViewPager = this.f11326c;
            if (weekViewPager.getAdapter() != null) {
                int c9 = weekViewPager.getAdapter().c();
                r rVar2 = weekViewPager.f11346e0;
                int s7 = t.s(rVar2.W, rVar2.Y, rVar2.f16043a0, rVar2.X, rVar2.Z, rVar2.f16045b0, rVar2.f16044b);
                weekViewPager.f11345d0 = s7;
                if (c9 != s7) {
                    weekViewPager.f11344c0 = true;
                    weekViewPager.getAdapter().h();
                }
                for (int i10 = 0; i10 < weekViewPager.getChildCount(); i10++) {
                    BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i10);
                    int intValue = ((Integer) baseWeekView.getTag()).intValue();
                    r rVar3 = baseWeekView.f11285a;
                    Calendar i11 = t.i(rVar3.W, rVar3.Y, rVar3.f16043a0, intValue + 1, rVar3.f16044b);
                    baseWeekView.setSelectedCalendar(baseWeekView.f11285a.f16073q0);
                    baseWeekView.setup(i11);
                }
                weekViewPager.f11344c0 = false;
                weekViewPager.y(weekViewPager.f11346e0.f16073q0);
            }
            MonthViewPager monthViewPager = this.f11325b;
            for (int i12 = 0; i12 < monthViewPager.getChildCount(); i12++) {
                BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.getChildAt(i12);
                baseMonthView.g();
                int i13 = baseMonthView.f11282x;
                int i14 = baseMonthView.f11283y;
                int i15 = baseMonthView.f11299p;
                r rVar4 = baseMonthView.f11285a;
                baseMonthView.A = t.m(i13, i14, i15, rVar4.f16044b, rVar4.f16046c);
                baseMonthView.requestLayout();
            }
            monthViewPager.y(monthViewPager.f11337e0.f16073q0.getYear(), monthViewPager.f11337e0.f16073q0.getMonth());
            ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
            layoutParams.height = monthViewPager.f11340h0;
            monthViewPager.setLayoutParams(layoutParams);
            if (monthViewPager.i0 != null) {
                r rVar5 = monthViewPager.f11337e0;
                monthViewPager.i0.h(t.u(rVar5.f16073q0, rVar5.f16044b));
            }
            monthViewPager.A();
            YearViewPager yearViewPager = this.e;
            for (int i16 = 0; i16 < yearViewPager.getChildCount(); i16++) {
                YearRecyclerView yearRecyclerView = (YearRecyclerView) yearViewPager.getChildAt(i16);
                ArrayList arrayList = yearRecyclerView.f11350m1.f11374a;
                int size = arrayList.size();
                int i17 = 0;
                while (i17 < size) {
                    Object obj = arrayList.get(i17);
                    i17++;
                    Month month = (Month) obj;
                    month.setDiff(t.n(month.getYear(), month.getMonth(), yearRecyclerView.f11349l1.f16044b));
                }
                if (yearRecyclerView.getAdapter() != null) {
                    yearRecyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    public final boolean a(Calendar calendar) {
        r rVar = this.f11324a;
        return rVar != null && t.y(calendar, rVar);
    }

    public final void b(int i3, int i10, int i11) {
        Calendar calendar = new Calendar();
        calendar.setYear(i3);
        calendar.setMonth(i10);
        calendar.setDay(i11);
        if (calendar.isAvailable() && a(calendar)) {
            this.f11324a.getClass();
            if (this.f11326c.getVisibility() == 0) {
                WeekViewPager weekViewPager = this.f11326c;
                weekViewPager.f11348g0 = true;
                Calendar calendar2 = new Calendar();
                calendar2.setYear(i3);
                calendar2.setMonth(i10);
                calendar2.setDay(i11);
                calendar2.setCurrentDay(calendar2.equals(weekViewPager.f11346e0.f16056h0));
                s.c(calendar2);
                r rVar = weekViewPager.f11346e0;
                rVar.f16074r0 = calendar2;
                rVar.f16073q0 = calendar2;
                rVar.f();
                weekViewPager.y(calendar2);
                f0 f0Var = weekViewPager.f11346e0.f16069o0;
                if (f0Var != null) {
                    f0Var.x(calendar2, false);
                }
                k kVar = weekViewPager.f11346e0.f16067n0;
                if (kVar != null) {
                    kVar.o(calendar2);
                }
                weekViewPager.f11347f0.h(t.u(calendar2, weekViewPager.f11346e0.f16044b));
                return;
            }
            MonthViewPager monthViewPager = this.f11325b;
            monthViewPager.U0 = true;
            Calendar calendar3 = new Calendar();
            calendar3.setYear(i3);
            calendar3.setMonth(i10);
            calendar3.setDay(i11);
            calendar3.setCurrentDay(calendar3.equals(monthViewPager.f11337e0.f16056h0));
            s.c(calendar3);
            r rVar2 = monthViewPager.f11337e0;
            rVar2.f16074r0 = calendar3;
            rVar2.f16073q0 = calendar3;
            rVar2.f();
            int month = (calendar3.getMonth() + ((calendar3.getYear() - monthViewPager.f11337e0.W) * 12)) - monthViewPager.f11337e0.Y;
            if (monthViewPager.getCurrentItem() == month) {
                monthViewPager.U0 = false;
            }
            monthViewPager.v(month, false);
            BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.findViewWithTag(Integer.valueOf(month));
            if (baseMonthView != null) {
                baseMonthView.setSelectedCalendar(monthViewPager.f11337e0.f16074r0);
                baseMonthView.invalidate();
                CalendarLayout calendarLayout = monthViewPager.i0;
                if (calendarLayout != null) {
                    calendarLayout.g(baseMonthView.f11298o.indexOf(monthViewPager.f11337e0.f16074r0));
                }
            }
            if (monthViewPager.i0 != null) {
                monthViewPager.i0.h(t.u(calendar3, monthViewPager.f11337e0.f16044b));
            }
            k kVar2 = monthViewPager.f11337e0.f16067n0;
            if (kVar2 != null) {
                kVar2.o(calendar3);
            }
            f0 f0Var2 = monthViewPager.f11337e0.f16069o0;
            if (f0Var2 != null) {
                f0Var2.q(calendar3, false);
            }
            monthViewPager.A();
        }
    }

    public final void c() {
        r rVar = this.f11324a;
        if (a(rVar.f16056h0)) {
            rVar.b();
            Calendar b3 = rVar.b();
            rVar.f16073q0 = b3;
            rVar.f16074r0 = b3;
            rVar.f();
            this.f11328f.b(rVar.f16073q0, rVar.f16044b);
            if (this.f11325b.getVisibility() == 0) {
                MonthViewPager monthViewPager = this.f11325b;
                monthViewPager.U0 = true;
                int year = monthViewPager.f11337e0.f16056h0.getYear();
                r rVar2 = monthViewPager.f11337e0;
                int month = (rVar2.f16056h0.getMonth() + ((year - rVar2.W) * 12)) - monthViewPager.f11337e0.Y;
                if (monthViewPager.getCurrentItem() == month) {
                    monthViewPager.U0 = false;
                }
                monthViewPager.v(month, false);
                BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.findViewWithTag(Integer.valueOf(month));
                if (baseMonthView != null) {
                    baseMonthView.setSelectedCalendar(monthViewPager.f11337e0.f16056h0);
                    baseMonthView.invalidate();
                    CalendarLayout calendarLayout = monthViewPager.i0;
                    if (calendarLayout != null) {
                        calendarLayout.g(baseMonthView.f11298o.indexOf(monthViewPager.f11337e0.f16056h0));
                    }
                }
                if (monthViewPager.f11337e0.f16067n0 != null && monthViewPager.getVisibility() == 0) {
                    r rVar3 = monthViewPager.f11337e0;
                    rVar3.f16067n0.o(rVar3.f16073q0);
                }
                this.f11326c.y(rVar.f16074r0);
            } else {
                WeekViewPager weekViewPager = this.f11326c;
                weekViewPager.f11348g0 = true;
                r rVar4 = weekViewPager.f11346e0;
                int t8 = t.t(rVar4.f16056h0, rVar4.W, rVar4.Y, rVar4.f16043a0, rVar4.f16044b) - 1;
                if (weekViewPager.getCurrentItem() == t8) {
                    weekViewPager.f11348g0 = false;
                }
                weekViewPager.v(t8, false);
                BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.findViewWithTag(Integer.valueOf(t8));
                if (baseWeekView != null) {
                    baseWeekView.h(weekViewPager.f11346e0.f16056h0, false);
                    baseWeekView.setSelectedCalendar(weekViewPager.f11346e0.f16056h0);
                    baseWeekView.invalidate();
                }
                if (weekViewPager.f11346e0.f16067n0 != null && weekViewPager.getVisibility() == 0) {
                    r rVar5 = weekViewPager.f11346e0;
                    rVar5.f16067n0.o(rVar5.f16073q0);
                }
                if (weekViewPager.getVisibility() == 0) {
                    r rVar6 = weekViewPager.f11346e0;
                    rVar6.f16069o0.x(rVar6.f16056h0, false);
                }
                r rVar7 = weekViewPager.f11346e0;
                weekViewPager.f11347f0.h(t.u(rVar7.f16056h0, rVar7.f16044b));
            }
            YearViewPager yearViewPager = this.e;
            yearViewPager.v(rVar.f16056h0.getYear() - yearViewPager.f11371e0.W, false);
        }
    }

    public final void d(int i3, int i10, int i11, int i12) {
        Calendar calendar = new Calendar();
        calendar.setYear(i3);
        calendar.setMonth(1);
        calendar.setDay(1);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(i10);
        calendar2.setMonth(i11);
        calendar2.setDay(i12);
        if (calendar.compareTo(calendar2) > 0) {
            return;
        }
        r rVar = this.f11324a;
        rVar.W = i3;
        rVar.Y = 1;
        rVar.f16043a0 = 1;
        rVar.X = i10;
        rVar.Z = i11;
        rVar.f16045b0 = i12;
        if (i12 == -1) {
            rVar.f16045b0 = t.j(i10, i11);
        }
        rVar.f16063l0 = (rVar.f16056h0.getMonth() + ((rVar.f16056h0.getYear() - rVar.W) * 12)) - rVar.Y;
        this.f11326c.x();
        YearViewPager yearViewPager = this.e;
        r rVar2 = yearViewPager.f11371e0;
        yearViewPager.f11369c0 = (rVar2.X - rVar2.W) + 1;
        if (yearViewPager.getAdapter() != null) {
            yearViewPager.getAdapter().h();
        }
        this.f11325b.x();
        if (!a(rVar.f16073q0)) {
            rVar.f16073q0 = rVar.d();
            rVar.f();
            rVar.f16074r0 = rVar.f16073q0;
        }
        WeekViewPager weekViewPager = this.f11326c;
        weekViewPager.f11344c0 = true;
        weekViewPager.x();
        weekViewPager.f11344c0 = false;
        if (weekViewPager.getVisibility() == 0) {
            weekViewPager.f11348g0 = true;
            Calendar calendar3 = weekViewPager.f11346e0.f16073q0;
            weekViewPager.y(calendar3);
            f0 f0Var = weekViewPager.f11346e0.f16069o0;
            if (f0Var != null) {
                f0Var.x(calendar3, false);
            }
            k kVar = weekViewPager.f11346e0.f16067n0;
            if (kVar != null) {
                kVar.o(calendar3);
            }
            weekViewPager.f11347f0.h(t.u(calendar3, weekViewPager.f11346e0.f16044b));
        }
        MonthViewPager monthViewPager = this.f11325b;
        monthViewPager.f11335c0 = true;
        monthViewPager.x();
        monthViewPager.f11335c0 = false;
        if (monthViewPager.getVisibility() == 0) {
            monthViewPager.U0 = false;
            Calendar calendar4 = monthViewPager.f11337e0.f16073q0;
            int month = (calendar4.getMonth() + ((calendar4.getYear() - monthViewPager.f11337e0.W) * 12)) - monthViewPager.f11337e0.Y;
            monthViewPager.v(month, false);
            BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.findViewWithTag(Integer.valueOf(month));
            if (baseMonthView != null) {
                baseMonthView.setSelectedCalendar(monthViewPager.f11337e0.f16074r0);
                baseMonthView.invalidate();
                CalendarLayout calendarLayout = monthViewPager.i0;
                if (calendarLayout != null) {
                    calendarLayout.g(baseMonthView.f11298o.indexOf(monthViewPager.f11337e0.f16074r0));
                }
            }
            if (monthViewPager.i0 != null) {
                monthViewPager.i0.h(t.u(calendar4, monthViewPager.f11337e0.f16044b));
            }
            f0 f0Var2 = monthViewPager.f11337e0.f16069o0;
            if (f0Var2 != null) {
                f0Var2.q(calendar4, false);
            }
            k kVar2 = monthViewPager.f11337e0.f16067n0;
            if (kVar2 != null) {
                kVar2.o(calendar4);
            }
            monthViewPager.A();
        }
        YearViewPager yearViewPager2 = this.e;
        yearViewPager2.f11370d0 = true;
        r rVar3 = yearViewPager2.f11371e0;
        yearViewPager2.f11369c0 = (rVar3.X - rVar3.W) + 1;
        if (yearViewPager2.getAdapter() != null) {
            yearViewPager2.getAdapter().h();
        }
        yearViewPager2.f11370d0 = false;
    }

    public final void e() {
        r rVar = this.f11324a;
        if (rVar.f16048d == 1) {
            return;
        }
        rVar.f16048d = 1;
        WeekViewPager weekViewPager = this.f11326c;
        for (int i3 = 0; i3 < weekViewPager.getChildCount(); i3++) {
            BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i3);
            baseWeekView.setSelectedCalendar(weekViewPager.f11346e0.f16073q0);
            baseWeekView.invalidate();
        }
        this.f11325b.A();
    }

    public final void f(int i3, int i10, int i11, int i12, int i13) {
        MonthViewPager monthViewPager;
        r rVar = this.f11324a;
        if (rVar == null || (monthViewPager = this.f11325b) == null || this.f11326c == null) {
            return;
        }
        rVar.e = i3;
        rVar.f16058j = i11;
        rVar.f16060k = i10;
        rVar.f16066n = i12;
        rVar.f16068o = i13;
        for (int i14 = 0; i14 < monthViewPager.getChildCount(); i14++) {
            BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.getChildAt(i14);
            baseMonthView.f();
            baseMonthView.invalidate();
        }
        WeekViewPager weekViewPager = this.f11326c;
        for (int i15 = 0; i15 < weekViewPager.getChildCount(); i15++) {
            BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i15);
            baseWeekView.f();
            baseWeekView.invalidate();
        }
    }

    public final void g(int i3) {
        WeekBar weekBar = this.f11328f;
        if (weekBar == null) {
            return;
        }
        weekBar.setBackgroundColor(0);
        this.f11328f.setTextColor(i3);
    }

    public int getCurDay() {
        return this.f11324a.f16056h0.getDay();
    }

    public int getCurMonth() {
        return this.f11324a.f16056h0.getMonth();
    }

    public int getCurYear() {
        return this.f11324a.f16056h0.getYear();
    }

    public List<Calendar> getCurrentMonthCalendars() {
        return this.f11325b.getCurrentMonthCalendars();
    }

    public List<Calendar> getCurrentWeekCalendars() {
        return this.f11326c.getCurrentWeekCalendars();
    }

    public final int getMaxMultiSelectSize() {
        return this.f11324a.f16078t0;
    }

    public Calendar getMaxRangeCalendar() {
        return this.f11324a.c();
    }

    public final int getMaxSelectRange() {
        return this.f11324a.f16086x0;
    }

    public Calendar getMinRangeCalendar() {
        return this.f11324a.d();
    }

    public final int getMinSelectRange() {
        return this.f11324a.f16084w0;
    }

    public MonthViewPager getMonthViewPager() {
        return this.f11325b;
    }

    public final List<Calendar> getMultiSelectCalendars() {
        ArrayList arrayList = new ArrayList();
        r rVar = this.f11324a;
        if (rVar.f16076s0.size() == 0) {
            return arrayList;
        }
        arrayList.addAll(rVar.f16076s0.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public final List<Calendar> getSelectCalendarRange() {
        r rVar = this.f11324a;
        if (rVar.f16048d != 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (rVar.f16080u0 != null && rVar.f16082v0 != null) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.set(rVar.f16080u0.getYear(), rVar.f16080u0.getMonth() - 1, rVar.f16080u0.getDay());
            calendar.set(rVar.f16082v0.getYear(), rVar.f16082v0.getMonth() - 1, rVar.f16082v0.getDay());
            long timeInMillis = calendar.getTimeInMillis();
            for (long timeInMillis2 = calendar.getTimeInMillis(); timeInMillis2 <= timeInMillis; timeInMillis2 += Const.DAY_IN_MILLIS) {
                calendar.setTimeInMillis(timeInMillis2);
                Calendar calendar2 = new Calendar();
                calendar2.setYear(calendar.get(1));
                calendar2.setMonth(calendar.get(2) + 1);
                calendar2.setDay(calendar.get(5));
                s.c(calendar2);
                rVar.e(calendar2);
                arrayList.add(calendar2);
            }
            rVar.a(arrayList);
        }
        return arrayList;
    }

    public Calendar getSelectedCalendar() {
        return this.f11324a.f16073q0;
    }

    public WeekViewPager getWeekViewPager() {
        return this.f11326c;
    }

    public final void h() {
        Log.d("tong", "update-->");
        this.f11328f.c(this.f11324a.f16044b);
        YearViewPager yearViewPager = this.e;
        for (int i3 = 0; i3 < yearViewPager.getChildCount(); i3++) {
            YearRecyclerView yearRecyclerView = (YearRecyclerView) yearViewPager.getChildAt(i3);
            if (yearRecyclerView.getAdapter() != null) {
                yearRecyclerView.getAdapter().notifyDataSetChanged();
            }
        }
        this.f11325b.z();
        WeekViewPager weekViewPager = this.f11326c;
        for (int i10 = 0; i10 < weekViewPager.getChildCount(); i10++) {
            ((BaseWeekView) weekViewPager.getChildAt(i10)).d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() == null || !(getParent() instanceof CalendarLayout)) {
            return;
        }
        CalendarLayout calendarLayout = (CalendarLayout) getParent();
        this.f11329g = calendarLayout;
        this.f11325b.i0 = calendarLayout;
        this.f11326c.f11347f0 = calendarLayout;
        calendarLayout.getClass();
        this.f11329g.setup(this.f11324a);
        CalendarLayout calendarLayout2 = this.f11329g;
        int i3 = calendarLayout2.f11313j;
        if ((calendarLayout2.f11306b != 1 && i3 != 1) || i3 == 2) {
            calendarLayout2.f11323u.getClass();
        } else if (calendarLayout2.f11311h != null) {
            calendarLayout2.post(new md.c(calendarLayout2, 2));
        } else {
            calendarLayout2.f11309f.setVisibility(0);
            calendarLayout2.f11308d.setVisibility(8);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int size = View.MeasureSpec.getSize(i10);
        r rVar = this.f11324a;
        if (rVar == null || !rVar.f16052f0) {
            super.onMeasure(i3, i10);
        } else {
            setCalendarItemHeight((size - rVar.f16054g0) / 6);
            super.onMeasure(i3, i10);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("super");
        Calendar calendar = (Calendar) bundle.getSerializable("selected_calendar");
        r rVar = this.f11324a;
        rVar.f16073q0 = calendar;
        rVar.f16074r0 = (Calendar) bundle.getSerializable("index_calendar");
        k kVar = rVar.f16067n0;
        if (kVar != null) {
            kVar.o(rVar.f16073q0);
        }
        Calendar calendar2 = rVar.f16074r0;
        if (calendar2 != null) {
            b(calendar2.getYear(), rVar.f16074r0.getMonth(), rVar.f16074r0.getDay());
        }
        h();
        super.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        r rVar = this.f11324a;
        if (rVar == null) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putSerializable("selected_calendar", rVar.f16073q0);
        bundle.putSerializable("index_calendar", rVar.f16074r0);
        return bundle;
    }

    public final void setCalendarItemHeight(int i3) {
        r rVar = this.f11324a;
        if (rVar.f16050e0 == i3) {
            return;
        }
        rVar.f16050e0 = i3;
        MonthViewPager monthViewPager = this.f11325b;
        for (int i10 = 0; i10 < monthViewPager.getChildCount(); i10++) {
            BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.getChildAt(i10);
            baseMonthView.e();
            baseMonthView.requestLayout();
        }
        int year = monthViewPager.f11337e0.f16074r0.getYear();
        int month = monthViewPager.f11337e0.f16074r0.getMonth();
        r rVar2 = monthViewPager.f11337e0;
        monthViewPager.f11340h0 = t.m(year, month, rVar2.f16050e0, rVar2.f16044b, rVar2.f16046c);
        if (month == 1) {
            r rVar3 = monthViewPager.f11337e0;
            monthViewPager.f11339g0 = t.m(year - 1, 12, rVar3.f16050e0, rVar3.f16044b, rVar3.f16046c);
            r rVar4 = monthViewPager.f11337e0;
            monthViewPager.f11338f0 = t.m(year, 2, rVar4.f16050e0, rVar4.f16044b, rVar4.f16046c);
        } else {
            r rVar5 = monthViewPager.f11337e0;
            monthViewPager.f11339g0 = t.m(year, month - 1, rVar5.f16050e0, rVar5.f16044b, rVar5.f16046c);
            if (month == 12) {
                r rVar6 = monthViewPager.f11337e0;
                monthViewPager.f11338f0 = t.m(year + 1, 1, rVar6.f16050e0, rVar6.f16044b, rVar6.f16046c);
            } else {
                r rVar7 = monthViewPager.f11337e0;
                monthViewPager.f11338f0 = t.m(year, month + 1, rVar7.f16050e0, rVar7.f16044b, rVar7.f16046c);
            }
        }
        ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
        layoutParams.height = monthViewPager.f11340h0;
        monthViewPager.setLayoutParams(layoutParams);
        WeekViewPager weekViewPager = this.f11326c;
        for (int i11 = 0; i11 < weekViewPager.getChildCount(); i11++) {
            BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i11);
            baseWeekView.e();
            baseWeekView.requestLayout();
        }
        CalendarLayout calendarLayout = this.f11329g;
        if (calendarLayout == null) {
            return;
        }
        r rVar8 = calendarLayout.f11323u;
        calendarLayout.f11322t = rVar8.f16050e0;
        if (calendarLayout.f11311h == null) {
            return;
        }
        Calendar calendar = rVar8.f16074r0;
        calendarLayout.h(t.u(calendar, rVar8.f16044b));
        if (calendarLayout.f11323u.f16046c == 0) {
            calendarLayout.f11314k = calendarLayout.f11322t * 5;
        } else {
            calendarLayout.f11314k = t.l(calendar.getYear(), calendar.getMonth(), calendarLayout.f11322t, calendarLayout.f11323u.f16044b) - calendarLayout.f11322t;
        }
        calendarLayout.e();
        if (calendarLayout.f11309f.getVisibility() == 0) {
            calendarLayout.f11311h.setTranslationY(-calendarLayout.f11314k);
        }
    }

    public void setCalendarPadding(int i3) {
        r rVar = this.f11324a;
        if (rVar == null) {
            return;
        }
        rVar.f16081v = i3;
        rVar.f16083w = i3;
        rVar.f16085x = i3;
        h();
    }

    public void setCalendarPaddingLeft(int i3) {
        r rVar = this.f11324a;
        if (rVar == null) {
            return;
        }
        rVar.f16083w = i3;
        h();
    }

    public void setCalendarPaddingRight(int i3) {
        r rVar = this.f11324a;
        if (rVar == null) {
            return;
        }
        rVar.f16085x = i3;
        h();
    }

    public final void setMaxMultiSelectSize(int i3) {
        this.f11324a.f16078t0 = i3;
    }

    public final void setMonthView(Class<?> cls) {
        if (cls == null) {
            return;
        }
        r rVar = this.f11324a;
        if (rVar.Q.equals(cls)) {
            return;
        }
        rVar.Q = cls;
        MonthViewPager monthViewPager = this.f11325b;
        monthViewPager.f11335c0 = true;
        if (monthViewPager.getAdapter() != null) {
            monthViewPager.getAdapter().h();
        }
        monthViewPager.f11335c0 = false;
    }

    public final void setMonthViewScrollable(boolean z5) {
        this.f11324a.i0 = z5;
    }

    public final void setOnCalendarInterceptListener(g gVar) {
        r rVar = this.f11324a;
        if (gVar == null) {
            rVar.getClass();
        }
        if (gVar == null || rVar.f16048d == 0 || !gVar.a()) {
            return;
        }
        rVar.f16073q0 = new Calendar();
    }

    public void setOnCalendarLongClickListener(h hVar) {
        this.f11324a.getClass();
    }

    public final void setOnCalendarMultiSelectListener(i iVar) {
        this.f11324a.getClass();
    }

    public final void setOnCalendarRangeSelectListener(j jVar) {
        this.f11324a.getClass();
    }

    public void setOnCalendarSelectListener(k kVar) {
        r rVar = this.f11324a;
        rVar.f16067n0 = kVar;
        if (kVar != null && rVar.f16048d == 0 && a(rVar.f16073q0)) {
            rVar.f();
        }
    }

    public final void setOnClickCalendarPaddingListener(l lVar) {
        r rVar = this.f11324a;
        if (lVar == null) {
            rVar.getClass();
        }
        if (lVar == null) {
            return;
        }
        rVar.getClass();
    }

    public void setOnMonthChangeListener(m mVar) {
        this.f11324a.f16071p0 = mVar;
    }

    public void setOnViewChangeListener(n nVar) {
        this.f11324a.getClass();
    }

    public void setOnWeekChangeListener(o oVar) {
        this.f11324a.getClass();
    }

    public void setOnYearChangeListener(p pVar) {
        this.f11324a.getClass();
    }

    public void setOnYearViewChangeListener(q qVar) {
        this.f11324a.getClass();
    }

    public final void setSchemeDate(Map<String, Calendar> map) {
        r rVar = this.f11324a;
        rVar.f16065m0 = map;
        rVar.f();
        YearViewPager yearViewPager = this.e;
        for (int i3 = 0; i3 < yearViewPager.getChildCount(); i3++) {
            YearRecyclerView yearRecyclerView = (YearRecyclerView) yearViewPager.getChildAt(i3);
            if (yearRecyclerView.getAdapter() != null) {
                yearRecyclerView.getAdapter().notifyDataSetChanged();
            }
        }
        this.f11325b.z();
        WeekViewPager weekViewPager = this.f11326c;
        for (int i10 = 0; i10 < weekViewPager.getChildCount(); i10++) {
            ((BaseWeekView) weekViewPager.getChildAt(i10)).d();
        }
    }

    public final void setSelectEndCalendar(Calendar calendar) {
        Calendar calendar2;
        r rVar = this.f11324a;
        int i3 = rVar.f16048d;
        if (i3 == 2 && (calendar2 = rVar.f16080u0) != null && i3 == 2 && calendar != null) {
            rVar.getClass();
            rVar.getClass();
            int differ = calendar.differ(calendar2);
            if (differ >= 0 && a(calendar2) && a(calendar)) {
                int i10 = rVar.f16084w0;
                if (i10 == -1 || i10 <= differ + 1) {
                    int i11 = rVar.f16086x0;
                    if (i11 == -1 || i11 >= differ + 1) {
                        if (i10 == -1 && differ == 0) {
                            rVar.f16080u0 = calendar2;
                            rVar.f16082v0 = null;
                            b(calendar2.getYear(), calendar2.getMonth(), calendar2.getDay());
                        } else {
                            rVar.f16080u0 = calendar2;
                            rVar.f16082v0 = calendar;
                            b(calendar2.getYear(), calendar2.getMonth(), calendar2.getDay());
                        }
                    }
                }
            }
        }
    }

    public final void setSelectStartCalendar(Calendar calendar) {
        Log.d("tong", "---===setSelectStartCalendar===---");
        r rVar = this.f11324a;
        if (rVar.f16048d != 2) {
            Log.d("tong", "!= CalendarViewDelegate.SELECT_MODE_RANGE");
            return;
        }
        if (calendar == null) {
            Log.d("tong", "startCalendar == null");
            return;
        }
        if (!a(calendar)) {
            Log.d("tong", "!isInRange(startCalendar)");
            return;
        }
        rVar.getClass();
        Log.d("tong", "---===end setSelectStartCalendar===---");
        rVar.f16082v0 = null;
        rVar.f16080u0 = calendar;
        b(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }

    public final void setWeekBar(Class<?> cls) {
        if (cls == null) {
            return;
        }
        r rVar = this.f11324a;
        if (rVar.U.equals(cls)) {
            return;
        }
        rVar.U = cls;
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.frameContent);
        frameLayout.removeView(this.f11328f);
        try {
            this.f11328f = (WeekBar) cls.getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frameLayout.addView(this.f11328f, 2);
        this.f11328f.setup(rVar);
        this.f11328f.c(rVar.f16044b);
        MonthViewPager monthViewPager = this.f11325b;
        WeekBar weekBar = this.f11328f;
        monthViewPager.f11342k0 = weekBar;
        weekBar.b(rVar.f16073q0, rVar.f16044b);
    }

    public final void setWeekView(Class<?> cls) {
        if (cls == null) {
            return;
        }
        r rVar = this.f11324a;
        if (rVar.U.equals(cls)) {
            return;
        }
        rVar.R = cls;
        WeekViewPager weekViewPager = this.f11326c;
        weekViewPager.f11344c0 = true;
        if (weekViewPager.getAdapter() != null) {
            weekViewPager.getAdapter().h();
        }
        weekViewPager.f11344c0 = false;
    }

    public final void setWeekViewScrollable(boolean z5) {
        this.f11324a.f16059j0 = z5;
    }

    public final void setYearViewScrollable(boolean z5) {
        this.f11324a.f16061k0 = z5;
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls;
        Class cls2;
        r rVar = new r();
        rVar.f16076s0 = new HashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CalendarView);
        if (s.f16089a == null) {
            if (t.f16115v == null) {
                t.f16115v = context.getResources().getStringArray(R$array.trunk_string_array);
                context.getResources().getStringArray(R$array.branch_string_array);
            }
            t.f16098c = context.getResources().getStringArray(R$array.solar_term);
            s.f16089a = context.getResources().getStringArray(R$array.lunar_first_of_month);
            s.f16090b = context.getResources().getStringArray(R$array.tradition_festival);
            s.f16091c = context.getResources().getStringArray(R$array.lunar_str);
            s.f16092d = context.getResources().getStringArray(R$array.special_festivals);
            s.f16093f = context.getResources().getStringArray(R$array.solar_festival);
        }
        rVar.f16081v = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding, 0.0f);
        rVar.f16083w = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding_left, 0.0f);
        rVar.f16085x = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding_right, 0.0f);
        int i3 = rVar.f16081v;
        if (i3 != 0) {
            rVar.f16083w = i3;
            rVar.f16085x = i3;
        }
        rVar.f16055h = obtainStyledAttributes.getColor(R$styleable.CalendarView_scheme_text_color, -1);
        rVar.f16057i = obtainStyledAttributes.getColor(R$styleable.CalendarView_scheme_lunar_text_color, -1973791);
        int color = obtainStyledAttributes.getColor(R$styleable.CalendarView_scheme_theme_color, 1355796431);
        rVar.O = color;
        String string = obtainStyledAttributes.getString(R$styleable.CalendarView_month_view);
        String string2 = obtainStyledAttributes.getString(R$styleable.CalendarView_year_view);
        rVar.S = string2;
        String string3 = obtainStyledAttributes.getString(R$styleable.CalendarView_week_view);
        String string4 = obtainStyledAttributes.getString(R$styleable.CalendarView_week_bar_view);
        rVar.N = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_week_text_size, t.e(context, 12.0f));
        rVar.f16054g0 = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_week_bar_height, t.e(context, 40.0f));
        rVar.M = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_week_line_margin, t.e(context, 0.0f));
        String string5 = obtainStyledAttributes.getString(R$styleable.CalendarView_scheme_text);
        rVar.V = string5;
        if (TextUtils.isEmpty(string5)) {
            rVar.V = "记";
        }
        rVar.i0 = obtainStyledAttributes.getBoolean(R$styleable.CalendarView_month_view_scrollable, true);
        rVar.f16059j0 = obtainStyledAttributes.getBoolean(R$styleable.CalendarView_week_view_scrollable, true);
        rVar.f16061k0 = obtainStyledAttributes.getBoolean(R$styleable.CalendarView_year_view_scrollable, true);
        rVar.f16042a = obtainStyledAttributes.getInt(R$styleable.CalendarView_month_view_auto_select_day, 0);
        rVar.f16046c = obtainStyledAttributes.getInt(R$styleable.CalendarView_month_view_show_mode, 0);
        rVar.f16044b = obtainStyledAttributes.getInt(R$styleable.CalendarView_week_start_with, 1);
        rVar.f16048d = obtainStyledAttributes.getInt(R$styleable.CalendarView_select_mode, 0);
        rVar.f16078t0 = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_multi_select_size, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        rVar.f16084w0 = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_select_range, -1);
        int i10 = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_select_range, -1);
        rVar.f16086x0 = i10;
        int i11 = rVar.f16084w0;
        if (i11 <= i10 || i10 <= 0) {
            if (i11 <= 0) {
                rVar.f16084w0 = -1;
            } else {
                rVar.f16084w0 = i11;
            }
            if (i10 <= 0) {
                rVar.f16086x0 = -1;
            } else {
                rVar.f16086x0 = i10;
            }
        } else {
            rVar.f16086x0 = i11;
            rVar.f16084w0 = i11;
        }
        rVar.L = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_background, -1);
        rVar.J = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_line_background, 0);
        rVar.K = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_background, -1);
        rVar.f16053g = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_text_color, -13421773);
        rVar.e = obtainStyledAttributes.getColor(R$styleable.CalendarView_current_day_text_color, -65536);
        rVar.f16051f = obtainStyledAttributes.getColor(R$styleable.CalendarView_current_day_lunar_text_color, -65536);
        rVar.P = obtainStyledAttributes.getColor(R$styleable.CalendarView_selected_theme_color, 1355796431);
        rVar.f16062l = obtainStyledAttributes.getColor(R$styleable.CalendarView_selected_text_color, -15658735);
        rVar.f16064m = obtainStyledAttributes.getColor(R$styleable.CalendarView_selected_lunar_text_color, -15658735);
        rVar.f16060k = obtainStyledAttributes.getColor(R$styleable.CalendarView_current_month_text_color, -15658735);
        rVar.f16058j = obtainStyledAttributes.getColor(R$styleable.CalendarView_other_month_text_color, -1973791);
        rVar.f16066n = obtainStyledAttributes.getColor(R$styleable.CalendarView_current_month_lunar_text_color, -1973791);
        rVar.f16068o = obtainStyledAttributes.getColor(R$styleable.CalendarView_other_month_lunar_text_color, -1973791);
        rVar.W = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year, 1971);
        rVar.X = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year, GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL);
        rVar.Y = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year_month, 1);
        rVar.Z = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year_month, 12);
        rVar.f16043a0 = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year_day, 1);
        rVar.f16045b0 = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year_day, -1);
        rVar.f16047c0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_day_text_size, t.e(context, 16.0f));
        rVar.f16049d0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_lunar_text_size, t.e(context, 10.0f));
        rVar.f16050e0 = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_height, t.e(context, 56.0f));
        rVar.f16052f0 = obtainStyledAttributes.getBoolean(R$styleable.CalendarView_calendar_match_parent, false);
        rVar.f16087y = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_year_view_month_text_size, t.e(context, 18.0f));
        rVar.f16088z = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_year_view_day_text_size, t.e(context, 7.0f));
        rVar.D = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_month_text_color, -15658735);
        rVar.E = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_day_text_color, -15658735);
        rVar.F = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_scheme_color, color);
        rVar.I = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_week_text_color, -13421773);
        rVar.H = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_current_day_text_color, rVar.e);
        rVar.G = obtainStyledAttributes.getColor(R$styleable.CalendarView_year_view_select_text_color, -13421773);
        rVar.A = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_year_view_week_text_size, t.e(context, 8.0f));
        rVar.B = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_year_view_month_height, t.e(context, 32.0f));
        rVar.C = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_year_view_week_height, t.e(context, 0.0f));
        int dimension = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_padding, t.e(context, 12.0f));
        rVar.f16070p = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_padding_left, t.e(context, 12.0f));
        rVar.f16072q = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_padding_right, t.e(context, 12.0f));
        if (dimension != 0) {
            rVar.f16070p = dimension;
            rVar.f16072q = dimension;
        }
        rVar.f16077t = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_month_padding_top, t.e(context, 4.0f));
        rVar.f16079u = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_month_padding_bottom, t.e(context, 4.0f));
        rVar.r = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_month_padding_left, t.e(context, 4.0f));
        rVar.f16075s = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_year_view_month_padding_right, t.e(context, 4.0f));
        if (rVar.W <= 1900) {
            rVar.W = 1900;
        }
        if (rVar.X >= 2099) {
            rVar.X = 2099;
        }
        obtainStyledAttributes.recycle();
        rVar.f16056h0 = new Calendar();
        Date date = new Date();
        rVar.f16056h0.setYear(t.h("yyyy", date));
        rVar.f16056h0.setMonth(t.h("MM", date));
        rVar.f16056h0.setDay(t.h("dd", date));
        rVar.f16056h0.setCurrentDay(true);
        s.c(rVar.f16056h0);
        int i12 = rVar.W;
        int i13 = rVar.Y;
        int i14 = rVar.X;
        int i15 = rVar.Z;
        rVar.W = i12;
        rVar.Y = i13;
        rVar.X = i14;
        rVar.Z = i15;
        if (i14 < rVar.f16056h0.getYear()) {
            rVar.X = rVar.f16056h0.getYear();
        }
        if (rVar.f16045b0 == -1) {
            rVar.f16045b0 = t.j(rVar.X, rVar.Z);
        }
        rVar.f16063l0 = (rVar.f16056h0.getMonth() + ((rVar.f16056h0.getYear() - rVar.W) * 12)) - rVar.Y;
        try {
            if (TextUtils.isEmpty(string4)) {
                cls2 = WeekBar.class;
                rVar.U = cls2;
            } else {
                cls2 = Class.forName(string4);
            }
            rVar.U = cls2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (TextUtils.isEmpty(string2)) {
                cls = DefaultYearView.class;
                rVar.T = cls;
            } else {
                cls = Class.forName(string2);
            }
            rVar.T = cls;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            rVar.Q = TextUtils.isEmpty(string) ? DefaultMonthView.class : Class.forName(string);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            rVar.R = TextUtils.isEmpty(string3) ? DefaultWeekView.class : Class.forName(string3);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        this.f11324a = rVar;
        LayoutInflater.from(context).inflate(R$layout.cv_layout_calendar_view, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.frameContent);
        WeekViewPager weekViewPager = (WeekViewPager) findViewById(R$id.vp_week);
        this.f11326c = weekViewPager;
        weekViewPager.setup(rVar);
        try {
            this.f11328f = (WeekBar) rVar.U.getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        frameLayout.addView(this.f11328f, 2);
        this.f11328f.setup(rVar);
        this.f11328f.c(rVar.f16044b);
        View findViewById = findViewById(R$id.line);
        this.f11327d = findViewById;
        findViewById.setBackgroundColor(rVar.J);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11327d.getLayoutParams();
        int i16 = rVar.M;
        layoutParams.setMargins(i16, rVar.f16054g0, i16, 0);
        this.f11327d.setLayoutParams(layoutParams);
        MonthViewPager monthViewPager = (MonthViewPager) findViewById(R$id.vp_month);
        this.f11325b = monthViewPager;
        monthViewPager.f11341j0 = this.f11326c;
        monthViewPager.f11342k0 = this.f11328f;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) monthViewPager.getLayoutParams();
        layoutParams2.setMargins(0, t.e(context, 1.0f) + rVar.f16054g0, 0, 0);
        this.f11326c.setLayoutParams(layoutParams2);
        YearViewPager yearViewPager = (YearViewPager) findViewById(R$id.selectLayout);
        this.e = yearViewPager;
        yearViewPager.setPadding(rVar.f16070p, 0, rVar.f16072q, 0);
        this.e.setBackgroundColor(rVar.K);
        this.e.addOnPageChangeListener(new b7.a(this, 2));
        rVar.f16069o0 = new f0(this, 28);
        if (rVar.f16048d != 0) {
            rVar.f16073q0 = new Calendar();
        } else if (a(rVar.f16056h0)) {
            rVar.f16073q0 = rVar.b();
        } else {
            rVar.f16073q0 = rVar.d();
        }
        Calendar calendar = rVar.f16073q0;
        rVar.f16074r0 = calendar;
        this.f11328f.b(calendar, rVar.f16044b);
        this.f11325b.setup(rVar);
        this.f11325b.setCurrentItem(rVar.f16063l0);
        this.e.setOnMonthSelectedListener(new mc.g(this, 1));
        this.e.setup(rVar);
        this.f11326c.y(rVar.b());
    }
}
