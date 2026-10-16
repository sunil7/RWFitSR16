package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.HrMonitorBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HrWatcherActivity extends XXBaseActivity<com.example.test.presenter.device.o0, f6.n0> implements f7.o, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public boolean E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherActivity$hrMonitor$2
        @Override // oh.a
        public final HrMonitorBean invoke() {
            return new HrMonitorBean();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 10;
            int a3 = od.a(10, 60, 10);
            if (10 <= a3) {
                while (true) {
                    arrayList.add(String.valueOf(i3));
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 10;
                }
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(HrWatcherActivity.this, arrayList);
            lVar.setOnDialogDataListener(new y2.f(HrWatcherActivity.this, 18));
            return lVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(HrWatcherActivity.this);
            qVar.setOnDialogTimeSelectListener(new androidx.appcompat.app.t(HrWatcherActivity.this, 20));
            return qVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.o0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.n0) this.f7247z.getValue()).f13133a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_hr_watcher, (ViewGroup) null, false);
        int i3 = R$id.endTimeAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.hrMonitorAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.startTimeAv;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.testAv;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            return new f6.n0((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, titleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.o0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.n0) bVar.getValue()).f13137f.setOnTitleListener(new a2.d(this, 18));
        ((f6.n0) bVar.getValue()).e.setOnClickListener(this);
        ((f6.n0) bVar.getValue()).f13136d.setOnClickListener(this);
        ((f6.n0) bVar.getValue()).f13134b.setOnClickListener(this);
        ((f6.n0) bVar.getValue()).f13135c.setOnSwitchStatusChangListener(new y(this, 7));
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((f6.n0) bVar.getValue()).f13135c.setItemOpen(S0().isOpen());
        ((f6.n0) bVar.getValue()).e.setHintStr(S0().getTestDuration() + " " + getString(R$string.str_mins));
        if (DateFormat.is24HourFormat(this)) {
            ActionItemView actionItemView = ((f6.n0) bVar.getValue()).f13136d;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getStartHour()), Integer.valueOf(S0().getStartMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getEndHour()), Integer.valueOf(S0().getEndMin())}, 2, locale, "%02d:%02d", ((f6.n0) bVar.getValue()).f13134b);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, S0().getStartHour());
        calendar.set(12, S0().getStartMin());
        ActionItemView actionItemView2 = ((f6.n0) bVar.getValue()).f13136d;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, S0().getEndHour());
        calendar.set(12, S0().getEndMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.n0) bVar.getValue()).f13134b);
    }

    public final HrMonitorBean S0() {
        return (HrMonitorBean) this.F.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.H.getValue();
    }

    public final void U0(HrMonitorBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        S0().setOpen(data.isOpen());
        S0().setTestDuration(data.getTestDuration());
        S0().setStartHour(data.getStartHour());
        S0().setStartMin(data.getStartMin());
        S0().setEndHour(data.getEndHour());
        S0().setEndMin(data.getEndMin());
        R0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        if (r0 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0106, code lost:
    
        if (r0 == 0) goto L47;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.HrWatcherActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onHrMonitorEvent(EventBusBeans.HrMonitorEvent hrMonitorEvent) {
        kotlin.jvm.internal.e.f(hrMonitorEvent, "hrMonitorEvent");
        HrMonitorBean hrMonitorBean = hrMonitorEvent.getHrMonitorBean();
        if (hrMonitorBean != null) {
            U0(hrMonitorBean);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (T0().isShowing()) {
            T0().dismiss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
