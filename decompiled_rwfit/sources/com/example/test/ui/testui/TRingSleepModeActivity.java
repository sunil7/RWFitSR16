package com.example.test.ui.testui;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.main.u1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.PointView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.x1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingSleepModeActivity extends XXBaseActivity<u1, x1> implements g7.a0, View.OnClickListener {
    public static final /* synthetic */ int J = 0;
    public a7.d E;
    public SwitchCompat F;
    public boolean G;
    public final eh.b H;
    public final eh.b I;

    public TRingSleepModeActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepModeActivity$remindDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.d invoke() {
                ArrayList arrayList = new ArrayList();
                TRingSleepModeActivity tRingSleepModeActivity = TRingSleepModeActivity.this;
                int i3 = TRingSleepModeActivity.J;
                com.example.test.ui.dialog.d dVar = new com.example.test.ui.dialog.d(tRingSleepModeActivity, arrayList, tRingSleepModeActivity.S0().getAdvanceIndex());
                dVar.setOnOptionSelectListener(new r0(TRingSleepModeActivity.this));
                return dVar;
            }
        });
        this.H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepModeActivity$timeDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.q invoke() {
                com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(TRingSleepModeActivity.this);
                qVar.setOnDialogTimeSelectListener(new s0(TRingSleepModeActivity.this));
                return qVar;
            }
        });
        this.I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepModeActivity$reminderBean$2
            @Override // oh.a
            public final BrightScreenTimeBean invoke() {
                return new BrightScreenTimeBean();
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new u1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((x1) this.f7247z.getValue()).f13444a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sleep_mode, (ViewGroup) null, false);
        int i3 = R$id.drinkAv;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.endTimeAv;
            ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
            if (actionItemView != null) {
                i3 = R$id.itemName;
                if (((TextView) he.a(i3, inflate)) != null) {
                    i3 = R$id.pointView;
                    if (((PointView) he.a(i3, inflate)) != null) {
                        i3 = R$id.remarkTv;
                        if (((TextView) he.a(i3, inflate)) != null) {
                            i3 = R$id.scBtn;
                            if (((SwitchCompat) he.a(i3, inflate)) != null) {
                                i3 = R$id.startTimeAv;
                                ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                                if (actionItemView2 != null) {
                                    i3 = R$id.titleView;
                                    TitleView titleView = (TitleView) he.a(i3, inflate);
                                    if (titleView != null) {
                                        return new x1((LinearLayout) inflate, linearLayout, actionItemView, actionItemView2, titleView);
                                    }
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
        ((u1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((x1) bVar.getValue()).e.setOnTitleListener(new s0(this));
        SwitchCompat switchCompat = (SwitchCompat) ((x1) bVar.getValue()).f13445b.findViewById(R$id.scBtn);
        this.F = switchCompat;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new q0(this, 0));
        }
        ((x1) bVar.getValue()).f13447d.setOnClickListener(this);
        ((x1) bVar.getValue()).f13446c.setOnClickListener(this);
        setOnSwitchStatusChangListener(new r0(this));
        R0();
    }

    public final void R0() {
        boolean isOpen = S0().isOpen();
        SwitchCompat switchCompat = this.F;
        if (switchCompat != null) {
            switchCompat.setChecked(isOpen);
        }
        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        eh.b bVar = this.f7247z;
        if (is24HourFormat) {
            ActionItemView actionItemView = ((x1) bVar.getValue()).f13447d;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getStartHour()), Integer.valueOf(S0().getStartMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getEndHour()), Integer.valueOf(S0().getEndMin())}, 2, locale, "%02d:%02d", ((x1) bVar.getValue()).f13446c);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, S0().getStartHour());
        calendar.set(12, S0().getStartMin());
        ActionItemView actionItemView2 = ((x1) bVar.getValue()).f13447d;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, S0().getEndHour());
        calendar.set(12, S0().getEndMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((x1) bVar.getValue()).f13446c);
    }

    public final BrightScreenTimeBean S0() {
        return (BrightScreenTimeBean) this.I.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.H.getValue();
    }

    public final void U0(BrightScreenTimeBean brightScreenTimeBean) {
        kotlin.jvm.internal.e.f(brightScreenTimeBean, "brightScreenTimeBean");
        S0().setOpen(brightScreenTimeBean.isOpen());
        S0().setStartHour(brightScreenTimeBean.getStartHour());
        S0().setStartMin(brightScreenTimeBean.getStartMin());
        S0().setEndHour(brightScreenTimeBean.getEndHour());
        S0().setEndMin(brightScreenTimeBean.getEndMin());
        R0();
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
            r6.G = r1
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getStartHour()
            r7.set(r3, r0)
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getStartMin()
            r7.set(r4, r0)
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getStartHour()
            com.example.blesdk.bean.function.BrightScreenTimeBean r5 = r6.S0()
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
            com.example.blesdk.bean.function.BrightScreenTimeBean r2 = r6.S0()
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
            r6.G = r7
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getEndHour()
            r7.set(r3, r0)
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getEndMin()
            r7.set(r4, r0)
            com.example.blesdk.bean.function.BrightScreenTimeBean r0 = r6.S0()
            int r0 = r0.getEndHour()
            com.example.blesdk.bean.function.BrightScreenTimeBean r5 = r6.S0()
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
            com.example.blesdk.bean.function.BrightScreenTimeBean r2 = r6.S0()
            int r2 = r2.getEndMin()
            r1.b(r7, r0, r2)
            com.example.test.ui.dialog.q r7 = r6.T0()
            r7.show()
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRingSleepModeActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDrinkEvent(EventBusBeans.BrightTimeEvent brightTimeEvent) {
        kotlin.jvm.internal.e.f(brightTimeEvent, "brightTimeEvent");
        BrightScreenTimeBean brightScreenTimeBean = brightTimeEvent.getBrightScreenTimeBean();
        if (brightScreenTimeBean != null) {
            U0(brightScreenTimeBean);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onOptionEvent(EventBusBeans.OptionEvent optionEvent) {
        kotlin.jvm.internal.e.f(optionEvent, "optionEvent");
        R0();
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

    public final void setOnSwitchStatusChangListener(a7.d onSwitchStatusChangListener) {
        kotlin.jvm.internal.e.f(onSwitchStatusChangListener, "onSwitchStatusChangListener");
        this.E = onSwitchStatusChangListener;
    }
}
