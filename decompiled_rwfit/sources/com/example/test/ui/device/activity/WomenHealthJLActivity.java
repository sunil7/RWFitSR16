package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.JLWomenHealthBean;
import com.example.blesdk.bean.function.WomenHealthBean;
import com.example.test.R$string;
import com.example.test.presenter.device.m1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.tencent.open.apireq.BaseResp;
import f6.y2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class WomenHealthJLActivity extends XXBaseActivity<m1, y2> implements f7.c0, View.OnClickListener {
    public static final /* synthetic */ int K = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$womenHealthBean$2
        @Override // oh.a
        public final JLWomenHealthBean invoke() {
            return new JLWomenHealthBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(WomenHealthJLActivity.this);
            qVar.setOnDialogTimeSelectListener(new o0(WomenHealthJLActivity.this));
            return qVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$rangeDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 20;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 40) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthJLActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new n0(WomenHealthJLActivity.this, 1));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$mensDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 2;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 8) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthJLActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new n0(WomenHealthJLActivity.this, 0));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$periodDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 15) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthJLActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new m0(WomenHealthJLActivity.this));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthJLActivity$ovulateDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 15) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthJLActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new o0(WomenHealthJLActivity.this));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new m1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((y2) this.f7247z.getValue()).f13463a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return y2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((m1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((y2) bVar.getValue()).f13472k.setOnTitleListener(new m0(this));
        ((y2) bVar.getValue()).f13464b.setOnSwitchStatusChangListener(new y(this, 14));
        ((y2) bVar.getValue()).f13465c.setOnClickListener(this);
        ((y2) bVar.getValue()).f13469h.setOnClickListener(this);
        ((y2) bVar.getValue()).f13467f.setOnClickListener(this);
        ((y2) bVar.getValue()).f13471j.setOnClickListener(this);
        ((y2) bVar.getValue()).e.setOnClickListener(this);
        ((y2) bVar.getValue()).f13468g.setOnClickListener(this);
        S0();
    }

    @Override // f7.c0
    public final void N(JLWomenHealthBean womenHealthBean) {
        kotlin.jvm.internal.e.f(womenHealthBean, "womenHealthBean");
        R0().setOpen(womenHealthBean.isOpen());
        R0().setRangeDuration(womenHealthBean.getRangeDuration());
        R0().setPeriodDuration(womenHealthBean.getPeriodDuration());
        R0().setPeriodDays(womenHealthBean.getPeriodDays());
        R0().setOvulateDays(womenHealthBean.getOvulateDays());
        R0().setLastDays(womenHealthBean.getLastDays());
        R0().setRemindHour(womenHealthBean.getRemindHour());
        R0().setRemindMin(womenHealthBean.getRemindMin());
        S0();
    }

    public final JLWomenHealthBean R0() {
        return (JLWomenHealthBean) this.E.getValue();
    }

    public final void S0() {
        String str;
        String str2;
        eh.b bVar = this.f7247z;
        ((y2) bVar.getValue()).f13464b.setItemOpen(R0().isOpen());
        ((y2) bVar.getValue()).f13466d.setVisibility(R0().isOpen() ? 0 : 8);
        ActionItemView actionItemView = ((y2) bVar.getValue()).e;
        String string = getString(R$string.str_before_day, String.valueOf(R0().getPeriodDays()));
        kotlin.jvm.internal.e.e(string, "getString(...)");
        actionItemView.setHintStr(String.format(string, Arrays.copyOf(new Object[0], 0)));
        ActionItemView actionItemView2 = ((y2) bVar.getValue()).f13468g;
        String string2 = getString(R$string.str_before_day, String.valueOf(R0().getOvulateDays()));
        kotlin.jvm.internal.e.e(string2, "getString(...)");
        actionItemView2.setHintStr(String.format(string2, Arrays.copyOf(new Object[0], 0)));
        ((y2) bVar.getValue()).f13469h.setHintStr(String.valueOf(R0().getRangeDuration()));
        ((y2) bVar.getValue()).f13467f.setHintStr(String.valueOf(R0().getPeriodDuration()));
        Calendar calendar = Calendar.getInstance();
        String str3 = null;
        if (R0().getLastDays() > 0) {
            ActionItemView actionItemView3 = ((y2) bVar.getValue()).f13465c;
            long lastDays = R0().getLastDays() * 1000;
            try {
                str2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(lastDays));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(lastDays, " date translate error ", e.getMessage()));
                str2 = null;
            }
            actionItemView3.setHintStr(str2 != null ? str2 : "");
            calendar.setTimeInMillis(R0().getLastDays() * 1000);
        } else {
            ActionItemView actionItemView4 = ((y2) bVar.getValue()).f13465c;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis, " date translate error ", e10.getMessage()));
                str = null;
            }
            actionItemView4.setHintStr(str != null ? str : "");
            calendar.setTimeInMillis(System.currentTimeMillis());
        }
        R0().setLastPeriodY(calendar.get(1) + BaseResp.CODE_ERROR_PARAMS);
        R0().setLastPeriodM(calendar.get(2) + 1);
        R0().setLastPeriodD(calendar.get(5));
        if (DateFormat.is24HourFormat(this)) {
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(R0().getRemindHour()), Integer.valueOf(R0().getRemindMin())}, 2, Locale.ENGLISH, "%02d:%02d", ((y2) bVar.getValue()).f13471j);
            return;
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, R0().getRemindHour());
        calendar2.set(12, R0().getRemindMin());
        ActionItemView actionItemView5 = ((y2) bVar.getValue()).f13471j;
        Locale locale = Locale.ENGLISH;
        String str4 = calendar2.get(9) == 1 ? "PM" : "AM";
        long timeInMillis = calendar2.getTimeInMillis();
        try {
            str3 = new SimpleDateFormat("hh:mm", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e11) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e11.getMessage()));
        }
        android.support.v4.media.session.e.B(new Object[]{str4, str3}, 2, locale, "%s %s", actionItemView5);
    }

    @Override // f7.c0
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.c0
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0179, code lost:
    
        if (r0 == 0) goto L71;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.WomenHealthJLActivity.onClick(android.view.View):void");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDateEvent(EventBusBeans.DateValueEvent dateValueEvent) {
        kotlin.jvm.internal.e.f(dateValueEvent, "dateValueEvent");
        R0().setLastDays(dateValueEvent.getDate().getTime() / 1000);
        S0();
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @Override // f7.c0
    public final void t0(WomenHealthBean womenHealthBean) {
        kotlin.jvm.internal.e.f(womenHealthBean, "womenHealthBean");
    }
}
