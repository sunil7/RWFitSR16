package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.BreatheBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BreatheSettingActivity extends XXBaseActivity<com.example.test.presenter.device.l, f6.o> implements f7.c, View.OnClickListener {
    public static final /* synthetic */ int L = 0;
    public int E;
    public final int F = 1;
    public final int G = 2;
    public final int H = 3;
    public final int I = 4;
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.BreatheSettingActivity$breatheBean$2
        @Override // oh.a
        public final BreatheBean invoke() {
            return new BreatheBean();
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.BreatheSettingActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(BreatheSettingActivity.this);
            qVar.setOnDialogTimeSelectListener(new d(BreatheSettingActivity.this));
            return qVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.l(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.o) this.f7247z.getValue()).f13153a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_breathe_setting, (ViewGroup) null, false);
        int i3 = R$id.fifthTime;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.firstTime;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.fourTime;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.secTime;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.switchStatus;
                        ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView5 != null) {
                            i3 = R$id.thTime;
                            ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView6 != null) {
                                i3 = R$id.titleView;
                                TitleView titleView = (TitleView) he.a(i3, inflate);
                                if (titleView != null) {
                                    return new f6.o((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, actionItemView6, titleView);
                                }
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
        R0();
        ((com.example.test.presenter.device.l) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.o) bVar.getValue()).f13155c.setOnClickListener(this);
        ((f6.o) bVar.getValue()).e.setOnClickListener(this);
        ((f6.o) bVar.getValue()).f13158g.setOnClickListener(this);
        ((f6.o) bVar.getValue()).f13156d.setOnClickListener(this);
        ((f6.o) bVar.getValue()).f13154b.setOnClickListener(this);
        ((f6.o) bVar.getValue()).f13157f.setOnSwitchStatusChangListener(new y(this, 3));
        ((f6.o) bVar.getValue()).f13159h.setOnTitleListener(new y2.f(this, 12));
    }

    public final void R0() {
        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        eh.b bVar = this.f7247z;
        if (is24HourFormat) {
            ActionItemView actionItemView = ((f6.o) bVar.getValue()).f13155c;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 0)).getHour()), Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 0)).getMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 1)).getHour()), Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 1)).getMin())}, 2, locale, "%02d:%02d", ((f6.o) bVar.getValue()).e);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 2)).getHour()), Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 2)).getMin())}, 2, locale, "%02d:%02d", ((f6.o) bVar.getValue()).f13158g);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 3)).getHour()), Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 3)).getMin())}, 2, locale, "%02d:%02d", ((f6.o) bVar.getValue()).f13156d);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 4)).getHour()), Integer.valueOf(((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 4)).getMin())}, 2, locale, "%02d:%02d", ((f6.o) bVar.getValue()).f13154b);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 0)).getHour());
        calendar.set(12, S0().getBreatheTime().get(0).getMin());
        ActionItemView actionItemView2 = ((f6.o) bVar.getValue()).f13155c;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 1)).getHour());
        calendar.set(12, S0().getBreatheTime().get(1).getMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.o) bVar.getValue()).e);
        calendar.set(11, ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 2)).getHour());
        calendar.set(12, S0().getBreatheTime().get(2).getMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.o) bVar.getValue()).f13158g);
        calendar.set(11, ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 3)).getHour());
        calendar.set(12, S0().getBreatheTime().get(3).getMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.o) bVar.getValue()).f13156d);
        calendar.set(11, ((BreatheBean.TimeItem) android.support.v4.media.session.e.e(this, 4)).getHour());
        calendar.set(12, S0().getBreatheTime().get(4).getMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.o) bVar.getValue()).f13154b);
    }

    public final BreatheBean S0() {
        return (BreatheBean) this.J.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.K.getValue();
    }

    public final void U0(BreatheBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        S0().setBreatheTime(data.getBreatheTime());
        S0().setTimes(data.getTimes());
        S0().setOpen(data.isOpen());
        ((f6.o) this.f7247z.getValue()).f13157f.setItemOpen(S0().isOpen());
        R0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0079, code lost:
    
        if (r5 == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0103, code lost:
    
        if (r0 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x018e, code lost:
    
        if (r5 == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0219, code lost:
    
        if (r5 == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02a4, code lost:
    
        if (r5 == 0) goto L87;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.BreatheSettingActivity.onClick(android.view.View):void");
    }
}
