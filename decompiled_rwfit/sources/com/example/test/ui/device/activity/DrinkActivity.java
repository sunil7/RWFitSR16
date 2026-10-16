package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class DrinkActivity extends XXBaseActivity<com.example.test.presenter.device.c0, f6.a0> implements f7.k, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public boolean F;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DrinkActivity$selectSingleDialog$2
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
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(DrinkActivity.this, arrayList);
            lVar.setOnDialogDataListener(new y2.f(DrinkActivity.this, 16));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DrinkActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(DrinkActivity.this);
            qVar.setOnDialogTimeSelectListener(new androidx.appcompat.app.t(DrinkActivity.this, 18));
            return qVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DrinkActivity$drinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.c0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.a0) this.f7247z.getValue()).f12674a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return f6.a0.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.c0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.a0) bVar.getValue()).f12678f.setOnTitleListener(new a2.d(this, 16));
        ((f6.a0) bVar.getValue()).f12675b.setVisibility(8);
        ((f6.a0) bVar.getValue()).f12679g.setOnClickListener(this);
        ((f6.a0) bVar.getValue()).e.setOnClickListener(this);
        ((f6.a0) bVar.getValue()).f12677d.setOnClickListener(this);
        ((f6.a0) bVar.getValue()).f12676c.setOnSwitchStatusChangListener(new y(this, 6));
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((f6.a0) bVar.getValue()).f12676c.setItemOpen(S0().isOpen());
        ((f6.a0) bVar.getValue()).f12679g.setHintStr(S0().getRemindDuration() + " " + getString(R$string.str_mins));
        if (DateFormat.is24HourFormat(this)) {
            ActionItemView actionItemView = ((f6.a0) bVar.getValue()).e;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getStartHour()), Integer.valueOf(S0().getStartMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getEndHour()), Integer.valueOf(S0().getEndMin())}, 2, locale, "%02d:%02d", ((f6.a0) bVar.getValue()).f12677d);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, S0().getStartHour());
        calendar.set(12, S0().getStartMin());
        ActionItemView actionItemView2 = ((f6.a0) bVar.getValue()).e;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, S0().getEndHour());
        calendar.set(12, S0().getEndMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((f6.a0) bVar.getValue()).f12677d);
    }

    public final DrinkReminderBean S0() {
        return (DrinkReminderBean) this.H.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.G.getValue();
    }

    @Override // f7.k
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.k
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.k
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        S0().setOpen(drinkReminderBean.isOpen());
        S0().setRemindDuration(drinkReminderBean.getRemindDuration());
        S0().setStartHour(drinkReminderBean.getStartHour());
        S0().setStartMin(drinkReminderBean.getStartMin());
        S0().setEndHour(drinkReminderBean.getEndHour());
        S0().setEndMin(drinkReminderBean.getEndMin());
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
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.DrinkActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDrinkEvent(EventBusBeans.DeviceDrinkEvent drinkEvent) {
        kotlin.jvm.internal.e.f(drinkEvent, "drinkEvent");
        DrinkReminderBean drinkReminderBean = drinkEvent.getDrinkReminderBean();
        if (drinkReminderBean != null) {
            c(drinkReminderBean);
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
