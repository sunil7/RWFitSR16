package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import f6.w2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HrWatcherJlActivity extends XXBaseActivity<com.example.test.presenter.device.n0, w2> implements f7.k, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public boolean F;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherJlActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 10;
            if (y5.d.f20006c) {
                int i10 = 30;
                int a3 = od.a(30, 60, 10);
                if (30 <= a3) {
                    while (true) {
                        arrayList.add(String.valueOf(i10));
                        if (i10 == a3) {
                            break;
                        }
                        i10 += 10;
                    }
                }
            } else {
                int a10 = od.a(10, 60, 10);
                if (10 <= a10) {
                    while (true) {
                        arrayList.add(String.valueOf(i3));
                        if (i3 == a10) {
                            break;
                        }
                        i3 += 10;
                    }
                }
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(HrWatcherJlActivity.this, arrayList);
            lVar.setOnDialogDataListener(new y2.f(HrWatcherJlActivity.this, 19));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherJlActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(HrWatcherJlActivity.this);
            qVar.setOnDialogTimeSelectListener(new androidx.appcompat.app.t(HrWatcherJlActivity.this, 21));
            return qVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.HrWatcherJlActivity$drinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((w2) this.f7247z.getValue()).f13422a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return w2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.n0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((w2) bVar.getValue()).f13427g.setItemName(R$string.str_hr_watcher);
        TitleView titleView = ((w2) bVar.getValue()).e;
        String string = getString(R$string.str_hr_watcher);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        titleView.setTitle(string);
        ((w2) bVar.getValue()).e.setOnTitleListener(new a2.d(this, 19));
        ((w2) bVar.getValue()).f13423b.setOnClickListener(this);
        ((w2) bVar.getValue()).f13426f.setOnClickListener(this);
        ((w2) bVar.getValue()).f13425d.setOnClickListener(this);
        ((w2) bVar.getValue()).f13424c.setOnClickListener(this);
        ((w2) bVar.getValue()).f13427g.setOnSwitchStatusChangListener(new y(this, 8));
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((w2) bVar.getValue()).f13427g.setItemOpen(S0().isOpen());
        ((w2) bVar.getValue()).f13426f.setHintStr(S0().getRemindDuration() + " " + getString(R$string.str_mins));
        if (DateFormat.is24HourFormat(this)) {
            ActionItemView actionItemView = ((w2) bVar.getValue()).f13425d;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getStartHour()), Integer.valueOf(S0().getStartMin())}, 2, locale, "%02d:%02d", actionItemView);
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0().getEndHour()), Integer.valueOf(S0().getEndMin())}, 2, locale, "%02d:%02d", ((w2) bVar.getValue()).f13424c);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, S0().getStartHour());
        calendar.set(12, S0().getStartMin());
        ActionItemView actionItemView2 = ((w2) bVar.getValue()).f13425d;
        Locale locale2 = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", actionItemView2);
        calendar.set(11, S0().getEndHour());
        calendar.set(12, S0().getEndMin());
        android.support.v4.media.session.e.B(new Object[]{calendar.get(9) == 1 ? "PM" : "AM", ca.i(calendar.getTimeInMillis(), "hh:mm")}, 2, locale2, "%s %s", ((w2) bVar.getValue()).f13424c);
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
        S0().setRepeatModel(drinkReminderBean.getRepeatModel());
        S0().setStartHour(drinkReminderBean.getStartHour());
        S0().setStartMin(drinkReminderBean.getStartMin());
        S0().setEndHour(drinkReminderBean.getEndHour());
        S0().setEndMin(drinkReminderBean.getEndMin());
        R0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
    
        if (r0 == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0161, code lost:
    
        if (r0 == 0) goto L65;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.HrWatcherJlActivity.onClick(android.view.View):void");
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
}
