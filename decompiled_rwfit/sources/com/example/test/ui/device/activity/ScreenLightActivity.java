package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.BrightScreenBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.device.g1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.s1;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScreenLightActivity extends XXBaseActivity<g1, s1> implements f7.y, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public boolean E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLightActivity$brightScreenBean$2
        @Override // oh.a
        public final BrightScreenBean invoke() {
            return new BrightScreenBean();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLightActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(ScreenLightActivity.this);
            qVar.setOnDialogTimeSelectListener(new androidx.appcompat.app.t(ScreenLightActivity.this, 29));
            return qVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new g1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((s1) this.f7247z.getValue()).f13295a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_screen_light, (ViewGroup) null, false);
        int i3 = R$id.brightScreenAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.endTimeAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.startTimeAv;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        return new s1((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, titleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((g1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((s1) bVar.getValue()).e.setOnTitleListener(new y2.f(this, 29));
        ((s1) bVar.getValue()).f13298d.setOnClickListener(this);
        ((s1) bVar.getValue()).f13297c.setOnClickListener(this);
        ((s1) bVar.getValue()).f13296b.setOnSwitchStatusChangListener(new y(this, 12));
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((s1) bVar.getValue()).f13296b.setItemOpen(S0().isOpen());
        if (DateFormat.is24HourFormat(this)) {
            ActionItemView actionItemView = ((s1) bVar.getValue()).f13298d;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getStartHour()), Integer.valueOf(S0().getStartMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getEndHour()), Integer.valueOf(S0().getEndMin())}, 2, locale, "%02d:%02d", ((s1) bVar.getValue()).f13297c);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, S0().getStartHour());
        calendar.set(12, S0().getStartMin());
        ActionItemView actionItemView2 = ((s1) bVar.getValue()).f13298d;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, S0().getEndHour());
        calendar.set(12, S0().getEndMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((s1) bVar.getValue()).f13297c);
    }

    public final BrightScreenBean S0() {
        return (BrightScreenBean) this.F.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.G.getValue();
    }

    public final void U0(BrightScreenBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        S0().setOpen(data.isOpen());
        if (data.isHasData()) {
            S0().setStartHour(data.getStartHour());
            S0().setStartMin(data.getStartMin());
            S0().setEndHour(data.getEndHour());
            S0().setEndMin(data.getEndMin());
        }
        R0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onBrightScreenEvent(EventBusBeans.BrightScreenEvent brightScreenEvent) {
        kotlin.jvm.internal.e.f(brightScreenEvent, "brightScreenEvent");
        BrightScreenBean brightScreenBean = brightScreenEvent.getBrightScreenBean();
        if (brightScreenBean != null) {
            U0(brightScreenBean);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        if (r0 == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cd, code lost:
    
        if (r0 == 0) goto L36;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            if (r7 == 0) goto Lb
            int r7 = r7.getId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto Lc
        Lb:
            r7 = 0
        Lc:
            int r0 = com.example.test.R$id.startTimeAv
            r1 = 1
            r2 = 9
            r3 = 11
            r4 = 12
            if (r7 != 0) goto L18
            goto L80
        L18:
            int r5 = r7.intValue()
            if (r5 != r0) goto L80
            r6.E = r1
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getStartHour()
            r7.set(r3, r0)
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getStartMin()
            r7.set(r4, r0)
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getStartHour()
            com.example.blesdk.bean.function.BrightScreenBean r5 = r6.S0()
            int r5 = r5.getStartMin()
            java.util.Calendar r3 = android.support.v4.media.session.e.u(r3, r0, r4, r5)
            boolean r5 = android.text.format.DateFormat.is24HourFormat(r6)
            if (r5 != 0) goto L65
            int r3 = r3.get(r2)
            if (r3 != r1) goto L5f
            if (r0 <= r4) goto L62
            int r4 = r0 + (-12)
            goto L63
        L5f:
            if (r0 != 0) goto L62
            goto L63
        L62:
            r4 = r0
        L63:
            int r0 = r4 + (-1)
        L65:
            com.example.test.ui.dialog.q r1 = r6.T0()
            int r7 = r7.get(r2)
            com.example.blesdk.bean.function.BrightScreenBean r2 = r6.S0()
            int r2 = r2.getStartMin()
            r1.b(r7, r0, r2)
            com.example.test.ui.dialog.q r7 = r6.T0()
            r7.show()
            return
        L80:
            int r0 = com.example.test.R$id.endTimeAv
            if (r7 != 0) goto L85
            goto Led
        L85:
            int r7 = r7.intValue()
            if (r7 != r0) goto Led
            r7 = 0
            r6.E = r7
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getEndHour()
            r7.set(r3, r0)
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getEndMin()
            r7.set(r4, r0)
            com.example.blesdk.bean.function.BrightScreenBean r0 = r6.S0()
            int r0 = r0.getEndHour()
            com.example.blesdk.bean.function.BrightScreenBean r5 = r6.S0()
            int r5 = r5.getEndMin()
            java.util.Calendar r3 = android.support.v4.media.session.e.u(r3, r0, r4, r5)
            boolean r5 = android.text.format.DateFormat.is24HourFormat(r6)
            if (r5 != 0) goto Ld3
            int r3 = r3.get(r2)
            if (r3 != r1) goto Lcd
            if (r0 <= r4) goto Ld0
            int r4 = r0 + (-12)
            goto Ld1
        Lcd:
            if (r0 != 0) goto Ld0
            goto Ld1
        Ld0:
            r4 = r0
        Ld1:
            int r0 = r4 + (-1)
        Ld3:
            com.example.test.ui.dialog.q r1 = r6.T0()
            int r7 = r7.get(r2)
            com.example.blesdk.bean.function.BrightScreenBean r2 = r6.S0()
            int r2 = r2.getEndMin()
            r1.b(r7, r0, r2)
            com.example.test.ui.dialog.q r7 = r6.T0()
            r7.show()
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.ScreenLightActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
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
