package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;
import com.google.android.material.timepicker.TimeModel;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.WeekViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public final class e extends Dialog implements View.OnClickListener, md.k {

    /* renamed from: a, reason: collision with root package name */
    public String f7953a;

    /* renamed from: b, reason: collision with root package name */
    public t6.a f7954b;

    /* renamed from: c, reason: collision with root package name */
    public final CalendarView f7955c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context, R$style.bottom_dialog);
        kotlin.jvm.internal.e.f(context, "context");
        setContentView(R$layout.dialog_date);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        Calendar calendar = Calendar.getInstance();
        View findViewById = findViewById(R$id.calendarView);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        CalendarView calendarView = (CalendarView) findViewById;
        this.f7955c = calendarView;
        calendarView.d(1900, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        CalendarView calendarView2 = this.f7955c;
        if (calendarView2 == null) {
            kotlin.jvm.internal.e.m("mCalendarView");
            throw null;
        }
        md.r rVar = calendarView2.f11324a;
        if (rVar != null && calendarView2.f11325b != null && calendarView2.f11326c != null) {
            if (calendarView2.getCurDay() != Calendar.getInstance().get(5)) {
                Date date = new Date();
                rVar.f16056h0.setYear(md.t.h("yyyy", date));
                rVar.f16056h0.setMonth(md.t.h("MM", date));
                rVar.f16056h0.setDay(md.t.h("dd", date));
                md.s.c(rVar.f16056h0);
                MonthViewPager monthViewPager = calendarView2.f11325b;
                for (int i3 = 0; i3 < monthViewPager.getChildCount(); i3++) {
                    BaseMonthView baseMonthView = (BaseMonthView) monthViewPager.getChildAt(i3);
                    ArrayList arrayList = baseMonthView.f11298o;
                    if (arrayList != null) {
                        if (arrayList.contains(baseMonthView.f11285a.f16056h0)) {
                            ArrayList arrayList2 = baseMonthView.f11298o;
                            int size = arrayList2.size();
                            int i10 = 0;
                            while (i10 < size) {
                                Object obj = arrayList2.get(i10);
                                i10++;
                                ((com.haibin.calendarview.Calendar) obj).setCurrentDay(false);
                            }
                            ((com.haibin.calendarview.Calendar) baseMonthView.f11298o.get(baseMonthView.f11298o.indexOf(baseMonthView.f11285a.f16056h0))).setCurrentDay(true);
                        }
                        baseMonthView.invalidate();
                    }
                }
                WeekViewPager weekViewPager = calendarView2.f11326c;
                for (int i11 = 0; i11 < weekViewPager.getChildCount(); i11++) {
                    BaseWeekView baseWeekView = (BaseWeekView) weekViewPager.getChildAt(i11);
                    ArrayList arrayList3 = baseWeekView.f11298o;
                    if (arrayList3 != null) {
                        if (arrayList3.contains(baseWeekView.f11285a.f16056h0)) {
                            ArrayList arrayList4 = baseWeekView.f11298o;
                            int size2 = arrayList4.size();
                            int i12 = 0;
                            while (i12 < size2) {
                                Object obj2 = arrayList4.get(i12);
                                i12++;
                                ((com.haibin.calendarview.Calendar) obj2).setCurrentDay(false);
                            }
                            ((com.haibin.calendarview.Calendar) baseWeekView.f11298o.get(baseWeekView.f11298o.indexOf(baseWeekView.f11285a.f16056h0))).setCurrentDay(true);
                        }
                        baseWeekView.invalidate();
                    }
                }
            }
        }
        CalendarView calendarView3 = this.f7955c;
        if (calendarView3 == null) {
            kotlin.jvm.internal.e.m("mCalendarView");
            throw null;
        }
        calendarView3.c();
        CalendarView calendarView4 = this.f7955c;
        if (calendarView4 == null) {
            kotlin.jvm.internal.e.m("mCalendarView");
            throw null;
        }
        calendarView4.setOnCalendarSelectListener(this);
        TextView textView = (TextView) findViewById(R$id.tvCancel);
        TextView textView2 = (TextView) findViewById(R$id.tvSure);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.f7953a = "";
    }

    @Override // md.k
    public final void o(com.haibin.calendarview.Calendar calendar) {
        if (calendar != null) {
            this.f7953a = calendar.getYear() + "/" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getMonth())}, 1)) + "/" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getDay())}, 1));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvSure;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i10 = R$id.tvCancel;
            if (valueOf != null && valueOf.intValue() == i10) {
                dismiss();
                return;
            }
            return;
        }
        dismiss();
        t6.a aVar = this.f7954b;
        if (aVar != null) {
            if (this.f7953a.length() == 0) {
                CalendarView calendarView = this.f7955c;
                if (calendarView == null) {
                    kotlin.jvm.internal.e.m("mCalendarView");
                    throw null;
                }
                int curYear = calendarView.getCurYear();
                CalendarView calendarView2 = this.f7955c;
                if (calendarView2 == null) {
                    kotlin.jvm.internal.e.m("mCalendarView");
                    throw null;
                }
                String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendarView2.getCurMonth())}, 1));
                CalendarView calendarView3 = this.f7955c;
                if (calendarView3 == null) {
                    kotlin.jvm.internal.e.m("mCalendarView");
                    throw null;
                }
                str = curYear + "/" + format + "/" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendarView3.getCurDay())}, 1));
            } else {
                str = this.f7953a;
            }
            aVar.v(str);
        }
    }

    public final void setOnDialogDataListener(t6.a onDialogDataListener) {
        kotlin.jvm.internal.e.f(onDialogDataListener, "onDialogDataListener");
        this.f7954b = onDialogDataListener;
    }
}
