package com.example.test.ui.testui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingPCycleStatisticsActivity extends XXBaseActivity<com.example.test.presenter.device.n, f6.c1> implements p5.a {
    public static final /* synthetic */ int I = 0;
    public final String E = "TRingPCycleStatisticsActivity";
    public Integer F;
    public Integer G;
    public String H;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class WomenPeriodPhase {
        public static final WomenPeriodPhase Menstrual;
        public static final WomenPeriodPhase Ovulation;
        public static final WomenPeriodPhase Safe;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WomenPeriodPhase[] f8233a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ih.a f8234b;

        static {
            WomenPeriodPhase womenPeriodPhase = new WomenPeriodPhase("Menstrual", 0);
            Menstrual = womenPeriodPhase;
            WomenPeriodPhase womenPeriodPhase2 = new WomenPeriodPhase("Ovulation", 1);
            Ovulation = womenPeriodPhase2;
            WomenPeriodPhase womenPeriodPhase3 = new WomenPeriodPhase("Safe", 2);
            Safe = womenPeriodPhase3;
            WomenPeriodPhase[] womenPeriodPhaseArr = {womenPeriodPhase, womenPeriodPhase2, womenPeriodPhase3};
            f8233a = womenPeriodPhaseArr;
            f8234b = kotlin.enums.a.a(womenPeriodPhaseArr);
        }

        public static ih.a getEntries() {
            return f8234b;
        }

        public static WomenPeriodPhase valueOf(String str) {
            return (WomenPeriodPhase) Enum.valueOf(WomenPeriodPhase.class, str);
        }

        public static WomenPeriodPhase[] values() {
            return (WomenPeriodPhase[]) f8233a.clone();
        }
    }

    public static LinkedHashMap R0(int i3, int i10, String startDateStr, int i11, int i12) {
        WomenPeriodPhase womenPeriodPhase;
        kotlin.jvm.internal.e.f(startDateStr, "startDateStr");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        Date parse = simpleDateFormat.parse(startDateStr);
        kotlin.jvm.internal.e.c(parse);
        calendar.setTime(parse);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, i3);
        int i13 = i10 - 1;
        calendar2.set(2, i13);
        calendar2.set(5, 1);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, i3);
        calendar3.set(2, i13);
        calendar3.set(5, calendar3.getActualMaximum(5));
        Object clone = calendar2.clone();
        kotlin.jvm.internal.e.d(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar4 = (Calendar) clone;
        calendar4.set(11, 0);
        calendar4.set(12, 0);
        calendar4.set(13, 0);
        calendar4.set(14, 0);
        while (!calendar4.after(calendar3)) {
            int timeInMillis = (int) ((calendar4.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
            if (timeInMillis >= 0) {
                int i14 = timeInMillis % i11;
                if (i14 < i12) {
                    womenPeriodPhase = WomenPeriodPhase.Menstrual;
                } else {
                    womenPeriodPhase = (i14 >= i12 + 13 || i12 + 3 > i14) ? WomenPeriodPhase.Safe : WomenPeriodPhase.Ovulation;
                }
                String format = simpleDateFormat.format(calendar4.getTime());
                kotlin.jvm.internal.e.e(format, "format(...)");
                linkedHashMap.put(format, womenPeriodPhase);
            }
            calendar4.add(5, 1);
        }
        return linkedHashMap;
    }

    public static LinkedHashMap S0(LinkedHashMap linkedHashMap) {
        int i3;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            WomenPeriodPhase womenPeriodPhase = (WomenPeriodPhase) entry.getValue();
            List u10 = kotlin.text.m.u(str, new String[]{"/"});
            int parseInt = Integer.parseInt((String) u10.get(0));
            int parseInt2 = Integer.parseInt((String) u10.get(1));
            int parseInt3 = Integer.parseInt((String) u10.get(2));
            int i10 = n0.f8294a[womenPeriodPhase.ordinal()];
            if (i10 == 1) {
                i3 = -50113;
            } else if (i10 == 2) {
                i3 = -2720257;
            }
            com.haibin.calendarview.Calendar calendar = new com.haibin.calendarview.Calendar();
            calendar.setYear(parseInt);
            calendar.setMonth(parseInt2);
            calendar.setDay(parseInt3);
            calendar.setSchemeColor(i3);
            calendar.setScheme("●");
            String calendar2 = calendar.toString();
            kotlin.jvm.internal.e.e(calendar2, "toString(...)");
            linkedHashMap2.put(calendar2, calendar);
        }
        return linkedHashMap2;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 7);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.c1) this.f7247z.getValue()).f12758a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_pcyclestatistics, (ViewGroup) null, false);
        int i3 = R$id.calendar_layout;
        if (((CalendarLayout) he.a(i3, inflate)) != null) {
            i3 = R$id.calendarView;
            CalendarView calendarView = (CalendarView) he.a(i3, inflate);
            if (calendarView != null) {
                i3 = R$id.ll_period_style;
                if (((LinearLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.nsv_data;
                    if (((NestedScrollView) he.a(i3, inflate)) != null) {
                        i3 = R$id.toolbar;
                        TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                        if (tRingToolBarView != null) {
                            i3 = R$id.tv_month;
                            TextView textView = (TextView) he.a(i3, inflate);
                            if (textView != null) {
                                return new f6.c1((ConstraintLayout) inflate, calendarView, tRingToolBarView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        f6.c1 c1Var = (f6.c1) bVar.getValue();
        if (c1Var != null) {
            c1Var.f12760c.setOnViewChildListener(new a1(this, 7));
        }
        f6.c1 c1Var2 = (f6.c1) bVar.getValue();
        if (c1Var2 != null) {
            c1Var2.f12759b.d(2024, 2080, 1, 1);
        }
        ((f6.c1) bVar.getValue()).f12761d.setText(((f6.c1) bVar.getValue()).f12759b.getCurMonth() + getString(R$string.str_tab_month) + " " + ((f6.c1) bVar.getValue()).f12759b.getCurYear());
        com.example.test.utils.k a3 = y1.a();
        this.F = a3 != null ? Integer.valueOf(a3.t()) : null;
        com.example.test.utils.k a10 = y1.a();
        this.G = a10 != null ? Integer.valueOf(a10.u()) : null;
        com.example.test.utils.k a11 = y1.a();
        this.H = a11 != null ? a11.s() : null;
        ((f6.c1) bVar.getValue()).f12759b.setOnMonthChangeListener(new af.a(this, 12));
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.e(this.E, "onResume");
        com.example.test.utils.k a3 = y1.a();
        this.F = a3 != null ? Integer.valueOf(a3.t()) : null;
        com.example.test.utils.k a10 = y1.a();
        this.G = a10 != null ? Integer.valueOf(a10.u()) : null;
        com.example.test.utils.k a11 = y1.a();
        this.H = a11 != null ? a11.s() : null;
        eh.b bVar = this.f7247z;
        ((f6.c1) bVar.getValue()).f12759b.c();
        int curYear = ((f6.c1) bVar.getValue()).f12759b.getCurYear();
        int curMonth = ((f6.c1) bVar.getValue()).f12759b.getCurMonth();
        String str = this.H;
        kotlin.jvm.internal.e.c(str);
        Integer num = this.F;
        kotlin.jvm.internal.e.c(num);
        int intValue = num.intValue();
        Integer num2 = this.G;
        kotlin.jvm.internal.e.c(num2);
        ((f6.c1) bVar.getValue()).f12759b.setSchemeDate(S0(R0(curYear, curMonth, str, intValue, num2.intValue())));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncDataEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 6) {
            runOnUiThread(new com.example.blesdk.service.z(4));
        }
    }
}
