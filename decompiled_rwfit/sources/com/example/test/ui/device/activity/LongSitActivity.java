package com.example.test.ui.device.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.test.R$string;
import com.example.test.presenter.device.p0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import f6.q0;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class LongSitActivity extends XXBaseActivity<p0, q0> implements f7.p, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public boolean E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 30;
            int a3 = od.a(30, 360, 30);
            if (30 <= a3) {
                while (true) {
                    arrayList.add(String.valueOf(i3));
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 30;
                }
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(LongSitActivity.this, arrayList);
            lVar.setOnDialogDataListener(new y2.f(LongSitActivity.this, 20));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(LongSitActivity.this);
            qVar.setOnDialogTimeSelectListener(new androidx.appcompat.app.t(LongSitActivity.this, 22));
            return qVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitActivity$sedentaryReminderBean$2
        @Override // oh.a
        public final SedentaryReminderBean invoke() {
            return new SedentaryReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new p0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((q0) this.f7247z.getValue()).f13249a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return q0.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((p0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((q0) bVar.getValue()).f13253f.setOnTitleListener(new a2.d(this, 20));
        ((q0) bVar.getValue()).f13250b.setOnClickListener(this);
        ((q0) bVar.getValue()).f13254g.setOnClickListener(this);
        ((q0) bVar.getValue()).e.setOnClickListener(this);
        ((q0) bVar.getValue()).f13251c.setOnClickListener(this);
        ((q0) bVar.getValue()).f13252d.setOnSwitchStatusChangListener(new y(this, 9));
        R0();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0() {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.LongSitActivity.R0():void");
    }

    public final SedentaryReminderBean S0() {
        return (SedentaryReminderBean) this.H.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.G.getValue();
    }

    @Override // f7.p
    public final void g() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.p
    public final void h() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.p
    public final void n(SedentaryReminderBean sedentaryReminderBean) {
        kotlin.jvm.internal.e.f(sedentaryReminderBean, "sedentaryReminderBean");
        S0().setOpen(sedentaryReminderBean.isOpen());
        S0().setRemindDuration(sedentaryReminderBean.getRemindDuration());
        S0().setRepeatModel(sedentaryReminderBean.getRepeatModel());
        S0().setStartHour(sedentaryReminderBean.getStartHour());
        S0().setStartMin(sedentaryReminderBean.getStartMin());
        S0().setEndHour(sedentaryReminderBean.getEndHour());
        S0().setEndMin(sedentaryReminderBean.getEndMin());
        R0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cc, code lost:
    
        if (r0 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0139, code lost:
    
        if (r0 == 0) goto L57;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.LongSitActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onOptionEvent(EventBusBeans.OptionEvent optionEvent) {
        kotlin.jvm.internal.e.f(optionEvent, "optionEvent");
        S0().setRepeatModel(optionEvent.getSelectValue());
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

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSedentaryEvent(EventBusBeans.DeviceSedentaryEvent sedentaryEvent) {
        kotlin.jvm.internal.e.f(sedentaryEvent, "sedentaryEvent");
        SedentaryReminderBean sedentaryReminderBean = sedentaryEvent.getSedentaryReminderBean();
        if (sedentaryReminderBean != null) {
            n(sedentaryReminderBean);
        }
    }
}
